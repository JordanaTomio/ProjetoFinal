package FramesDE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.ClienteDAO;

public class ConsultarClientesDE extends JFrame {

	private static final long serialVersionUID = -4029146897243358982L;
	
	private JPanel contentPane;
	public JTextField txtNome;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ConsultarClientesDE() {
		setTitle("Kunden befragen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarClientesDE.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Name:");
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblNome.setBounds(193, 124, 62, 20);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ResultSet rs = ClienteDAO.findAllTypedDE(txtNome.getText());
				table.setModel(Utilis.DbUtils.resultSetTable(rs));
			}
		});
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ResultSet rs = ClienteDAO.findAllTypedDE(txtNome.getText());
				table.setModel(Utilis.DbUtils.resultSetTable(rs));
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
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdmDE adm = new AdmDE();
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
		
		JLabel lblConsultarClientes = new JLabel("Kunden befragen");
		lblConsultarClientes.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblConsultarClientes.setBounds(169, 21, 325, 66);
		contentPane.add(lblConsultarClientes);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(ConsultarClientesDE.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(8, 336, 50, 57);
		contentPane.add(lblVoltar);
		
		JLabel Backgroubd = new JLabel("New label");
		Backgroubd.setIcon(new ImageIcon(ConsultarClientesDE.class.getResource("/imagens/Background.jpg")));
		Backgroubd.setBounds(0, 0, 654, 411);
		contentPane.add(Backgroubd);
	}
}
