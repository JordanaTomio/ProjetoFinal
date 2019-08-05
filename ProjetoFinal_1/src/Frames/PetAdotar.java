package Frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PetAdotar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePet;
	private JTextField txtAno;
	private JTextField txtTamanho;
	private JTextField txtRaca;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetAdotar frame = new PetAdotar();
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
	public PetAdotar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetInformacoes = new JLabel("Pet Informa\u00E7\u00F5es");
		lblPetInformacoes.setBounds(184, 23, 258, 44);
		lblPetInformacoes.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		contentPane.add(lblPetInformacoes);
		
		JLabel lblNomePet = new JLabel("Nome do pet:");
		lblNomePet.setBounds(10, 94, 107, 14);
		lblNomePet.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNomePet);
		
		txtNomePet = new JTextField();
		txtNomePet.setBounds(124, 92, 182, 20);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 148, 46, 14);
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblAno);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(386, 306, 56, 12);
		lblTipo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblTipo);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setBounds(10, 205, 51, 14);
		lblRaca.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblRaca);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(9, 255, 72, 14);
		lblTamanho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblTamanho);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setBounds(386, 256, 56, 14);
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblGenero);
		
		txtAno = new JTextField();
		txtAno.setBounds(124, 146, 182, 20);
		txtAno.setColumns(10);
		contentPane.add(txtAno);
		
		txtTamanho = new JTextField();
		txtTamanho.setBounds(124, 253, 182, 20);
		txtTamanho.setColumns(10);
		contentPane.add(txtTamanho);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(124, 203, 182, 20);
		txtRaca.setColumns(10);
		contentPane.add(txtRaca);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 352, 107, 31);
		btnBuscar.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		contentPane.add(btnBuscar);
		
		JRadioButton rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.setBounds(448, 252, 72, 23);
		rdbtnMacho.setBorderPainted(false);
		rdbtnMacho.setContentAreaFilled(false);
		rdbtnMacho.setFocusPainted(false);
		rdbtnMacho.setOpaque(false);
		rdbtnMacho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup.add(rdbtnMacho);
		contentPane.add(rdbtnMacho);
		
		JRadioButton rdbtnFemea = new JRadioButton("F\u00EAmea");
		rdbtnFemea.setBounds(532, 252, 78, 23);
		rdbtnFemea.setBorderPainted(false);
		rdbtnFemea.setContentAreaFilled(false);
		rdbtnFemea.setFocusPainted(false);
		rdbtnFemea.setOpaque(false);
		rdbtnFemea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup.add(rdbtnFemea);
		contentPane.add(rdbtnFemea);
		
		JRadioButton rdbtnCao = new JRadioButton("C\u00E3o");
		rdbtnCao.setBounds(448, 302, 64, 16);
		rdbtnCao.setBorderPainted(false);
		rdbtnCao.setContentAreaFilled(false);
		rdbtnCao.setFocusPainted(false);
		rdbtnCao.setOpaque(false);
		rdbtnCao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup_1.add(rdbtnCao);
		contentPane.add(rdbtnCao);
		
		JRadioButton rdbtnGato = new JRadioButton("Gato");
		rdbtnGato.setBounds(532, 302, 64, 16);
		rdbtnGato.setBorderPainted(false);
		rdbtnGato.setContentAreaFilled(false);
		rdbtnGato.setFocusPainted(false);
		rdbtnGato.setOpaque(false);
		rdbtnGato.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup_1.add(rdbtnGato);
		contentPane.add(rdbtnGato);
		
		txtImagem = new JTextField();
		txtImagem.setBounds(386, 94, 210, 140);
		txtImagem.setEditable(false);
		contentPane.add(txtImagem);
		txtImagem.setColumns(10);
		
		JCheckBox chckbxVacinado = new JCheckBox("Vacinado");
		chckbxVacinado.setBounds(10, 301, 97, 23);
		chckbxVacinado.setBackground(new Color(224, 255, 255));
		chckbxVacinado.setBorderPainted(false);
		chckbxVacinado.setContentAreaFilled(false);
		chckbxVacinado.setFocusPainted(false);
		chckbxVacinado.setOpaque(false);
		chckbxVacinado.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(chckbxVacinado);
		
		JCheckBox chckbxCastrado = new JCheckBox("Castrado");
		chckbxCastrado.setBounds(112, 301, 97, 23);
		chckbxCastrado.setBorderPainted(false);
		chckbxCastrado.setContentAreaFilled(false);
		chckbxCastrado.setFocusPainted(false);
		chckbxCastrado.setOpaque(false);
		chckbxCastrado.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(chckbxCastrado);
		
		JButton btnAdotar = new JButton("Adotar <3 ");
		btnAdotar.setBounds(127, 352, 107, 31);
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Parabéns! Você está perto de adotar um Pet." +"\n"+ "Entraremos em contato para agendar a visita" +"\n"+ "de avaliação e levar seu novo amigo!");
			}
		});
		btnAdotar.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		contentPane.add(btnAdotar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnVoltar.setBounds(244, 352, 107, 31);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}
}
