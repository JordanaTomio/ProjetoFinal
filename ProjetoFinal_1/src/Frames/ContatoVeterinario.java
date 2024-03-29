package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import DAO.VeterinariosDAO;

public class ContatoVeterinario extends JFrame {

	//Frame com os contatos de veterinários da região de blumenau
	private JPanel contentPane;
	private JTextField txtBAIRRO;
	private JTable table;

	
	public ContatoVeterinario() {
		setTitle("Veterin�rios");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ContatoVeterinario.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {

			// Retorna ao Jframe Menu

			public void actionPerformed(ActionEvent arg0) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});

		txtBAIRRO = new JTextField();
		txtBAIRRO.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtBAIRRO.addKeyListener(new KeyAdapter() {

			// Faz a busca dos Veterinarios no Database

			@Override
			public void keyTyped(KeyEvent e) {
				ResultSet rs = VeterinariosDAO.VeterinariosDAO(txtBAIRRO.getText());
				table.setModel(Utilis.DbUtils.resultSetTable(rs));
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

		JLabel lblNewLabel = new JLabel("Veterin�rio");
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
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

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(ContatoVeterinario.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 440);
		contentPane.add(background);

	}
}
