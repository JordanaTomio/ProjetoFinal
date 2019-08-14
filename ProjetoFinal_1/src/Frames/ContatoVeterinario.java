package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.idog.Configuration.MySQLConfiguration;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class ContatoVeterinario extends JFrame {

	private JPanel contentPane;
	private JTextField txtBAIRRO;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoVeterinario frame = new ContatoVeterinario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContatoVeterinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Broadway", Font.PLAIN, 11));
		btnVoltar.setBounds(10, 340, 43, 50);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(ContatoVeterinario.class.getResource("/imagens/clip-art-veterinarian-2(1).png")));
		label.setBounds(477, 32, 137, 132);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Veterin\u00E1rio");
		lblNewLabel.setFont(new Font("Broadway", Font.PLAIN, 30));
		lblNewLabel.setBounds(226, 31, 203, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(ContatoVeterinario.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(13, 327, 65, 76);
		contentPane.add(lblVoltar);
		
		JLabel lblBAIRRO = new JLabel("Digite o seu bairro:");
		lblBAIRRO.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblBAIRRO.setBounds(158, 105, 162, 26);
		contentPane.add(lblBAIRRO);
		
		txtBAIRRO = new JTextField();
		txtBAIRRO.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtBAIRRO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				MySQLConfiguration c = new MySQLConfiguration();
				
				String q = "";
				String w = "";
				//-------------------------------------------------------------\\
				q = "SELECT NM_Veterinario, TL_Veterinario, LC_Veterinario"
						+ " FROM contato_veterinario";
				if (!txtBAIRRO.getText().isEmpty()){
					if (w.isEmpty()){
						w = "BR_Veterinario like '%" + txtBAIRRO.getText() + "%' ";
					}else{
						w += "and BR_Veterinario like '%" + txtBAIRRO.getText() + "%' ";
					}
				}
				//-------------------------------------------------------------\\
				if (!w.isEmpty()){
					q += " WHERE " + w;
				}
				//-------------------------------------------------------------\\
				q += " order by CD_Veterinario";
					try{
						PreparedStatement ps = c.conn.prepareStatement(q);
						ResultSet rs = ps.executeQuery();		
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						rs.close();
						ps.close();
						
					} catch (Exception ex) {
					System.err.println("ERRO NO 'SQL'");
					System.err.println(q);
					ex.printStackTrace();
					}
				
				
			}
		});
		txtBAIRRO.setBounds(158, 135, 344, 20);
		contentPane.add(txtBAIRRO);
		txtBAIRRO.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 163, 521, 173);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(ContatoVeterinario.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 644, 401);
		contentPane.add(background);
		
		
		
	}
}
