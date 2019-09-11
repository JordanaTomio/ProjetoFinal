package FramesDE;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Beans.Animal;
import DAO.AnimalDAO;
import java.awt.Toolkit;

public class PetAdotarDE extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePet;
	private JTextField txtAno;
	private JTextField txtTamanho;
	private JTextField txtRaca;
	private JTextArea txtDesc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton btnMacho = new JRadioButton("M\u00E4nn");
	JRadioButton btnCao = new JRadioButton("Hund");
	JRadioButton btnGato = new JRadioButton("Katze");
	JRadioButton btnFemea = new JRadioButton("Weib");
	JCheckBox vacinadodb = new JCheckBox("Geimpft");
	JCheckBox castradodb = new JCheckBox("Kastriert");
	JLabel lblNigmviu = new JLabel("0");
	Animal ani = new Animal();
	// int one = -1;
	// 1

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetAdotarDE frame = new PetAdotarDE();
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
	public PetAdotarDE() {
		setTitle("Adoptieren");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PetAdotarDE.class.getResource("/imagens/3775232-16.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtNomePet = new JTextField();
		txtNomePet.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtNomePet.setEditable(false);
		txtNomePet.setBounds(124, 92, 182, 20);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);

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

		btnMacho.setBounds(469, 241, 72, 23);
		btnMacho.setBorderPainted(false);
		btnMacho.setContentAreaFilled(false);
		btnMacho.setFocusPainted(false);
		btnMacho.setOpaque(false);
		btnMacho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		buttonGroup.add(btnMacho);
		contentPane.add(btnMacho);
		btnMacho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnFemea.setBounds(553, 241, 78, 23);
		btnFemea.setBorderPainted(false);
		btnFemea.setContentAreaFilled(false);
		btnFemea.setFocusPainted(false);
		btnFemea.setOpaque(false);
		btnFemea.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		buttonGroup.add(btnFemea);
		contentPane.add(btnFemea);
		btnFemea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnCao.setBounds(470, 273, 64, 16);
		btnCao.setBorderPainted(false);
		btnCao.setContentAreaFilled(false);
		btnCao.setFocusPainted(false);
		btnCao.setOpaque(false);
		btnCao.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		buttonGroup_1.add(btnCao);
		contentPane.add(btnCao);
		btnCao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(new Color(230, 230, 250));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDE mnu = new MenuDE();
				mnu.setVisible(true);
				dispose();
			}
		});

		btnGato.setBounds(554, 273, 64, 16);
		btnGato.setBorderPainted(false);
		btnGato.setContentAreaFilled(false);
		btnGato.setFocusPainted(false);
		btnGato.setOpaque(false);
		btnGato.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		buttonGroup_1.add(btnGato);
		contentPane.add(btnGato);
		btnGato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnAnterior = new JButton("");
		btnAnterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnterior.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = AnimalDAO.BuscaAnimalMenor(lblNigmviu.getText());

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
						int Cd = rs.getInt("CD_Animal");

						String CD = "" + Cd;

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
						lblNigmviu.setText(CD);

					}
					else{
						lblNigmviu.setText("99999999999999999999");
						ResultSet rs1 = AnimalDAO.BuscaAnimalMenor(lblNigmviu.getText());
						if (rs.next()) {
							String nome = rs1.getString("NM_Animal");
							String ano = rs1.getString("ANO_Animal");
							String raca = rs1.getString("RC_Animal");
							String tamanho = rs1.getString("TM_Animal");
							String tipo = rs1.getString("TP_Animal");
							String sexo = rs1.getString("SX_Animal");
							String vacinas = rs1.getString("VC_Animal");
							String castrado = rs1.getString("CS_Animal");
							String desc = rs1.getString("DS_Animal");
							int Cd = rs1.getInt("CD_Animal");

							String CD = "" + Cd;

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
							lblNigmviu.setText(CD);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});

		JButton btnProximo = new JButton("");
		btnProximo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = AnimalDAO.BuscaAnimalMaior(lblNigmviu.getText());
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
						int Cd = rs.getInt("CD_Animal");

						String CD = "" + Cd;

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
						lblNigmviu.setText(CD);
					} else {
						lblNigmviu.setText("0");
						ResultSet rs1 = AnimalDAO.BuscaAnimalMaior(lblNigmviu.getText());
							if (rs1.next()) {
								String nome = rs1.getString("NM_Animal");
								String ano = rs1.getString("ANO_Animal");
								String raca = rs1.getString("RC_Animal");
								String tamanho = rs1.getString("TM_Animal");
								String tipo = rs1.getString("TP_Animal");
								String sexo = rs1.getString("SX_Animal");
								String vacinas = rs1.getString("VC_Animal");
								String castrado = rs1.getString("CS_Animal");
								String desc = rs1.getString("DS_Animal");
								int Cd = rs1.getInt("CD_Animal");

								String CD = "" + Cd;

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
								lblNigmviu.setText(CD);
							}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		txtDesc = new JTextArea();
		txtDesc.setEditable(false);
		txtDesc.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtDesc.setBounds(387, 99, 210, 115);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		vacinadodb.setBounds(25, 298, 97, 23);
		vacinadodb.setBackground(new Color(224, 255, 255));
		vacinadodb.setContentAreaFilled(false);
		vacinadodb.setFocusPainted(false);
		vacinadodb.setOpaque(false);
		vacinadodb.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(vacinadodb);
		vacinadodb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		castradodb.setBounds(127, 298, 97, 23);
		castradodb.setContentAreaFilled(false);
		castradodb.setFocusPainted(false);
		castradodb.setOpaque(false);
		castradodb.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(castradodb);
		castradodb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNigmviu = new JLabel("0");
		lblNigmviu.setBounds(25, 44, -17, 14);
		contentPane.add(lblNigmviu);
		lblNigmviu.setVisible(false);
		btnProximo.setIcon(new ImageIcon(PetAdotarDE.class.getResource("/imagens/3847912-128(2).png")));
		btnProximo.setBounds(519, 324, 46, 44);
		btnProximo.setFocusPainted(false);
		btnProximo.setOpaque(false);
		btnProximo.setBorderPainted(false);
		btnProximo.setContentAreaFilled(false);
		contentPane.add(btnProximo);
		btnProximo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnAnterior.setIcon(new ImageIcon(PetAdotarDE.class.getResource("/imagens/3847912-128(1).png")));
		btnAnterior.setBounds(432, 324, 46, 44);
		btnAnterior.setBorderPainted(false);
		btnAnterior.setContentAreaFilled(false);
		btnAnterior.setFocusPainted(false);
		btnAnterior.setOpaque(false);
		contentPane.add(btnAnterior);
		btnVoltar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnVoltar.setBounds(14, 343, 46, 50);
		contentPane.add(btnVoltar);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnAdotar = new JButton("Adoptieren");
		btnAdotar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdotar.setForeground(new Color(0, 100, 0));
		btnAdotar.setBackground(new Color(255, 255, 255));
		btnAdotar.setBounds(163, 336, 117, 31);
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null,
						"Herzlichen Glückwunsch! Sie sind sehr nahe daran, ein Haustier zu adoptieren."+ "\n" 
						+ " Wir werden uns mit Ihnen in Verbindung setzen, um den Probebesuch zu vereinbaren,"+ "\n" 
						+ " damit Sie Ihren neuen Freund mitbringen können!");

				int passe;
				passe = Integer.parseInt(lblNigmviu.getText());
				AnimalDAO.InsertAdotado(passe);
				AnimalDAO.AdotarAnimal(txtNomePet.getText());
				ResultSet rs = AnimalDAO.BuscaAnimalUpdate(passe);
				System.out.println(rs);

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
						int Cd = rs.getInt("CD_Animal");

						String CD = "" + Cd;

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
						lblNigmviu.setText(CD);
					} else {
						txtTamanho.setText("");
						txtRaca.setText("");
						txtAno.setText("");
						txtNomePet.setText("");
						txtDesc.setText("");
						lblNigmviu.setText("");
						vacinadodb.setSelected(false);
						castradodb.setSelected(false);
						btnFemea.setSelected(false);
						btnMacho.setSelected(false);
						btnCao.setSelected(false);
						btnGato.setSelected(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdotar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		contentPane.add(btnAdotar);

		JLabel lblPetInformacoes = new JLabel("Haustierinformationen");
		lblPetInformacoes.setBounds(141, 23, 356, 44);
		lblPetInformacoes.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		contentPane.add(lblPetInformacoes);

		JLabel lblNomePet = new JLabel("Name von pet:");
		lblNomePet.setBounds(25, 94, 107, 18);
		lblNomePet.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblNomePet);

		JLabel lblAno = new JLabel("Jahre Alt:");
		lblAno.setBounds(25, 148, 89, 14);
		lblAno.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblAno);

		JLabel lblTipo = new JLabel("Haustiere:");
		lblTipo.setBounds(388, 268, 76, 17);
		lblTipo.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblTipo);

		JLabel lblRaca = new JLabel("Hunderasse:");
		lblRaca.setBounds(25, 204, 89, 18);
		lblRaca.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblRaca);

		JLabel lblTamanho = new JLabel("Gr\u00F6\u00DFe:");
		lblTamanho.setBounds(24, 255, 72, 14);
		lblTamanho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblTamanho);

		JLabel lblGenero = new JLabel("Tiere genre:");
		lblGenero.setBounds(387, 241, 91, 14);
		lblGenero.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(lblGenero);

		JLabel Flor_icon = new JLabel("New label");
		Flor_icon.setIcon(new ImageIcon(PetAdotarDE.class.getResource("/imagens/302319657031211(1).png")));
		Flor_icon.setBounds(469, -27, 202, 198);
		contentPane.add(Flor_icon);

		JLabel btnVoltar_icon = new JLabel("");
		btnVoltar_icon.setIcon(new ImageIcon(PetAdotarDE.class.getResource("/imagens/3209260-128(1).png")));
		btnVoltar_icon.setBounds(14, 344, 46, 50);
		contentPane.add(btnVoltar_icon);

		JLabel Background_icon = new JLabel("New label");
		Background_icon.setIcon(new ImageIcon(PetAdotarDE.class.getResource("/imagens/Background.jpg")));
		Background_icon.setBounds(0, 0, 660, 440);
		contentPane.add(Background_icon);
	}
}
