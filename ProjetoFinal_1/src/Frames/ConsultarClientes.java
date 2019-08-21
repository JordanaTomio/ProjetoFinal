package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.idog.Configuration.MySQLConfiguration;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class ConsultarClientes extends JFrame {

	private static final long serialVersionUID = -4029146897243358982L;
	
	private JPanel contentPane;
	public JTextField txtNome;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ConsultarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblNome.setBounds(193, 124, 62, 20);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ResultSet rs = findAllTyped();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ResultSet rs = findAllTyped();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(275, 124, 189, 21);
		contentPane.add(txtNome);

		JScrollPane tblClientes = new JScrollPane();
		tblClientes.setBounds(116, 167, 408, 153);
		contentPane.add(tblClientes);

		table = new JTable();
		tblClientes.setViewportView(table);
		table.setFont(new Font("Lucida Bright", Font.PLAIN, 10));
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Adm adm = new Adm();
			adm.setVisible(true);
			dispose();
			}
		});
		btnVoltar.setBounds(5, 338, 56, 55);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		contentPane.add(btnVoltar);
		
		JLabel lblConsultarClientes = new JLabel("Consultar Clientes");
		lblConsultarClientes.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblConsultarClientes.setBounds(162, 25, 367, 66);
		contentPane.add(lblConsultarClientes);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(ConsultarClientes.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(8, 336, 50, 57);
		contentPane.add(lblVoltar);
		
		JLabel Backgroubd = new JLabel("New label");
		Backgroubd.setIcon(new ImageIcon(ConsultarClientes.class.getResource("/imagens/Background.jpg")));
		Backgroubd.setBounds(0, 0, 654, 411);
		contentPane.add(Backgroubd);
	}
	public ResultSet findAllTyped() {
		String q = "SELECT CD_Cliente, PN_Cliente, SN_Cliente FROM cliente where PN_Cliente like '%" + txtNome.getText() + "%'";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Clientes aren't found.");
			e.printStackTrace();
			return null;
		}
	}
}
