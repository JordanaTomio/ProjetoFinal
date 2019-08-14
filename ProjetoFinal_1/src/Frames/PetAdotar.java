package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import Beans.Animal;
import DAO.AnimalDAO;
import javax.swing.SwingConstants;

public class PetAdotar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePet;
	private JTextField txtAno;
	private JTextField txtTamanho;
	private JTextField txtRaca;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtDesc;
	JRadioButton btnMacho = new JRadioButton("Macho");
	JRadioButton btnCao = new JRadioButton("C\u00E3o");
	JRadioButton btnGato = new JRadioButton("Gato");
	JRadioButton btnFemea = new JRadioButton("F\u00EAmea");
	JCheckBox vacinadodb = new JCheckBox("Vacinado");
	JCheckBox castradodb = new JCheckBox("Castrado");
	Animal ani = new Animal();
	int one = -1;

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
		setLocationRelativeTo(null);

		JLabel lblPetInformacoes = new JLabel("Pet Informa\u00E7\u00F5es");
		lblPetInformacoes.setBounds(184, 23, 258, 44);
		lblPetInformacoes.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		contentPane.add(lblPetInformacoes);

		JLabel lblNomePet = new JLabel("Nome do pet:");
		lblNomePet.setBounds(10, 94, 107, 14);
		lblNomePet.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNomePet);

		JButton btnProximo = new JButton("");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				one++;
				ResultSet rs = AnimalDAO.BuscaAnimal(one);

				try {
					if (rs.next()) {
						String nome = rs.getString("NM_Animal");
						String ano = rs.getString("ANO_Animal");
						String raca = rs.getString("RC_Animal");
						String tamanho = rs.getString("TM_Animal");
						String tipo = rs.getString("TP_Animal");
						String sexo = rs.getString("SX_Animal");
						String vacinas = rs.getString("VC_Animal");
						String castrado = rs.getString("CS_Animal");
						String desc = rs.getString("DS_Animal");

						if (tipo.equals("Cachorro")) {
							btnCao.setSelected(true);
						} else {
							btnGato.setSelected(true);
						}

						if (sexo.equals("Macho")) {
							btnMacho.setSelected(true);
						} else {
							btnFemea.setSelected(true);
						}

						if (castrado.equals("Sim")) {
							castradodb.setSelected(true);
						} else {
							castradodb.setSelected(false);
						}

						if (vacinas.equals("Sim")) {
							vacinadodb.setSelected(true);
						} else {
							vacinadodb.setSelected(false);
						}

						txtTamanho.setText(tamanho);
						txtRaca.setText(raca);
						txtAno.setText(ano);
						txtNomePet.setText(nome);
						txtDesc.setText(desc);
					} else {
						one = -1;

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnProximo.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/3847912-128(2).png")));
		btnProximo.setBounds(519, 324, 46, 44);
		btnProximo.setFocusPainted(false);
		btnProximo.setOpaque(false);
		btnProximo.setBorderPainted(false);
		btnProximo.setContentAreaFilled(false);
		contentPane.add(btnProximo);

		txtNomePet = new JTextField();
		txtNomePet.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtNomePet.setEditable(false);
		txtNomePet.setBounds(124, 92, 182, 20);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 148, 46, 14);
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblAno);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(388, 268, 56, 17);
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
		lblGenero.setBounds(387, 241, 56, 14);
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblGenero);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtAno.setEditable(false);
		txtAno.setBounds(124, 146, 182, 20);
		txtAno.setColumns(10);
		contentPane.add(txtAno);

		txtTamanho = new JTextField();
		txtTamanho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtTamanho.setEditable(false);
		txtTamanho.setBounds(124, 253, 182, 20);
		txtTamanho.setColumns(10);
		contentPane.add(txtTamanho);

		txtRaca = new JTextField();
		txtRaca.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtRaca.setEditable(false);
		txtRaca.setBounds(124, 203, 182, 20);
		txtRaca.setColumns(10);
		contentPane.add(txtRaca);

		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				one--;
				ResultSet rs = AnimalDAO.BuscaAnimal(one);

				try {
					if (rs.next()) {
						String nome = rs.getString("NM_Animal");
						String ano = rs.getString("ANO_Animal");
						String raca = rs.getString("RC_Animal");
						String tamanho = rs.getString("TM_Animal");
						String tipo = rs.getString("TP_Animal");
						String sexo = rs.getString("SX_Animal");
						String vacinas = rs.getString("VC_Animal");
						String castrado = rs.getString("CS_Animal");
						String desc = rs.getString("DS_Animal");

						if (tipo.equals("Cachorro")) {
							btnCao.setSelected(true);
						} else {
							btnGato.setSelected(true);
						}

						if (sexo.equals("Macho")) {
							btnMacho.setSelected(true);
						} else {
							btnFemea.setSelected(true);
						}

						if (castrado.equals("Sim")) {
							castradodb.setSelected(true);
						} else {
							castradodb.setSelected(false);
						}

						if (vacinas.equals("Sim")) {
							vacinadodb.setSelected(true);
						} else {
							vacinadodb.setSelected(false);
						}

						txtTamanho.setText(tamanho);
						txtRaca.setText(raca);
						txtAno.setText(ano);
						txtNomePet.setText(nome);
						txtDesc.setText(desc);
						

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});
		btnAnterior.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/3847912-128(1).png")));
		btnAnterior.setBounds(432, 324, 46, 44);
		btnAnterior.setBorderPainted(false);
		btnAnterior.setContentAreaFilled(false);
		btnAnterior.setFocusPainted(false);
		btnAnterior.setOpaque(false);
		contentPane.add(btnAnterior);

		btnMacho.setBounds(449, 237, 72, 23);
		btnMacho.setBorderPainted(false);
		btnMacho.setContentAreaFilled(false);
		btnMacho.setFocusPainted(false);
		btnMacho.setOpaque(false);
		btnMacho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup.add(btnMacho);
		contentPane.add(btnMacho);

		btnFemea.setBounds(533, 237, 78, 23);
		btnFemea.setBorderPainted(false);
		btnFemea.setContentAreaFilled(false);
		btnFemea.setFocusPainted(false);
		btnFemea.setOpaque(false);
		btnFemea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup.add(btnFemea);
		contentPane.add(btnFemea);

		btnCao.setBounds(450, 269, 64, 16);
		btnCao.setBorderPainted(false);
		btnCao.setContentAreaFilled(false);
		btnCao.setFocusPainted(false);
		btnCao.setOpaque(false);
		btnCao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup_1.add(btnCao);
		contentPane.add(btnCao);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/302319657031211(1).png")));
		lblNewLabel_1.setBounds(469, -27, 202, 198);
		contentPane.add(lblNewLabel_1);

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(230, 230, 250));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnVoltar.setBounds(14, 343, 46, 50);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel_2.setBounds(14, 344, 46, 50);
		contentPane.add(lblNewLabel_2);

		btnGato.setBounds(534, 269, 64, 16);
		btnGato.setBorderPainted(false);
		btnGato.setContentAreaFilled(false);
		btnGato.setFocusPainted(false);
		btnGato.setOpaque(false);
		btnGato.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonGroup_1.add(btnGato);
		contentPane.add(btnGato);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesc.setBounds(387, 99, 210, 115);
		txtDesc.setEditable(false);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		vacinadodb.setBounds(10, 301, 97, 23);
		vacinadodb.setBackground(new Color(224, 255, 255));
		vacinadodb.setContentAreaFilled(false);
		vacinadodb.setFocusPainted(false);
		vacinadodb.setOpaque(false);
		vacinadodb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(vacinadodb);

		castradodb.setBounds(112, 301, 97, 23);
		castradodb.setContentAreaFilled(false);
		castradodb.setFocusPainted(false);
		castradodb.setOpaque(false);
		castradodb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(castradodb);

		JButton btnAdotar = new JButton("Adotar ");
		btnAdotar.setBackground(new Color(230, 230, 250));
		btnAdotar.setBounds(163, 336, 117, 31);
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null,
						"Parab�ns! Voc� est� perto de adotar um Pet." + "\n"
								+ "Entraremos em contato para agendar a visita" + "\n"
								+ "de avalia��o e levar seu novo amigo!");
			}
		});
		btnAdotar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		contentPane.add(btnAdotar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PetAdotar.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}
}
