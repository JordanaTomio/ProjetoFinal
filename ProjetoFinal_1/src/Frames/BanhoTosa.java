package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import DAO.AgendaDAO;
import Utilidades.ExcluiCaracteres;
import net.proteanit.sql.DbUtils;
import javax.swing.JFormattedTextField;

public class BanhoTosa extends JFrame {

	private JPanel contentPane;
	private JTable tblAGENDA;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final JRadioButton rdbtnPequeno;
	private final JRadioButton rdbtnMedio;
	private final JRadioButton rdbtnGrande;
	private final JRadioButton rdbtnBanho;
	private final JRadioButton rdbtnBanhoETosa;
	private JTextField txtCLIENTE;
	private JLabel lblDATA;
	private JLabel lblHORA;
	private JLabel lblCLIENTE;
	private JLabel background;
	private JLabel lblVoltar;
	private JLabel flor;
	private JLabel lblInformaoesObrigtorias;
	private JFormattedTextField txtData;
	private MaskFormatter data;
	private JFormattedTextField txtHORA;
	private MaskFormatter hora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanhoTosa frame = new BanhoTosa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BanhoTosa() {
		setTitle("Banho e Tosa");

		setIconImage(Toolkit.getDefaultToolkit().getImage(BanhoTosa.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		try{
			data = new MaskFormatter("##/##");
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		try{
			hora = new MaskFormatter("##:##");
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		
		txtHORA = new JFormattedTextField(hora);
		txtHORA.setBounds(104, 134, 49, 20);
		contentPane.add(txtHORA);
		
		txtData = new JFormattedTextField(data);
		txtData.setBounds(23, 134, 52, 20);
		contentPane.add(txtData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 121, 283, 188);
		contentPane.add(scrollPane);

		tblAGENDA = new JTable();
		tblAGENDA.setEnabled(false);
		scrollPane.setViewportView(tblAGENDA);
		tblAGENDA
				.setModel(new DefaultTableModel(
						// https://www.guj.com.br/t/gravar-dados-direto-no-jtable/56176/3
						// use isso
						new Object[][] { { "00/00", "08:30", null }, { "00/00", "09:30", null },
								{ "00/00", "10:30", null }, { "00/00", "11:30", null }, { "00/00", "13:30", null },
								{ "00/00", "14:30", null }, { "00/00", "15:30", null }, { "00/00", "16:30", null },
								{ "00/00", "17:30", null }, { "00/00", "18:00", null }, },
						new String[] { "Data", "Hora", "Cliente" }));
		tblAGENDA.getColumnModel().getColumn(0).setPreferredWidth(38);
		tblAGENDA.getColumnModel().getColumn(1).setPreferredWidth(46);

		// puxa a informaÃ§Ã£o tabelha quando carrega Jframe
		tblAGENDA.setModel(DbUtils.resultSetToTableModel(AgendaDAO.Atualizar()));

		txtCLIENTE = new JTextField();
		txtCLIENTE.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtCLIENTE.setColumns(10);
		txtCLIENTE.setBounds(184, 134, 100, 20);
		contentPane.add(txtCLIENTE);

		JRadioButton rdbtnGato = new JRadioButton("Gato");
		buttonGroup_1.add(rdbtnGato);
		rdbtnGato.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnGato.setBackground(new Color(176, 224, 230));
		rdbtnGato.setBorderPainted(false);
		rdbtnGato.setContentAreaFilled(false);
		rdbtnGato.setFocusPainted(false);
		rdbtnGato.setOpaque(false);
		rdbtnGato.setBounds(15, 176, 80, 23);
		contentPane.add(rdbtnGato);

		JRadioButton rdbtnCachorro = new JRadioButton("Cachorro");
		buttonGroup_1.add(rdbtnCachorro);
		rdbtnCachorro.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnCachorro.setBackground(new Color(176, 224, 230));
		rdbtnCachorro.setBorderPainted(false);
		rdbtnCachorro.setContentAreaFilled(false);
		rdbtnCachorro.setFocusPainted(false);
		rdbtnCachorro.setOpaque(false);
		rdbtnCachorro.setBounds(114, 176, 130, 23);
		contentPane.add(rdbtnCachorro);

		rdbtnPequeno = new JRadioButton("Pequeno");
		buttonGroup.add(rdbtnPequeno);
		rdbtnPequeno.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnPequeno.setBorderPainted(false);
		rdbtnPequeno.setContentAreaFilled(false);
		rdbtnPequeno.setFocusPainted(false);
		rdbtnPequeno.setBounds(15, 202, 100, 23);
		rdbtnPequeno.setOpaque(false);

		contentPane.add(rdbtnPequeno);

		rdbtnMedio = new JRadioButton("M\u00E9dio");
		buttonGroup.add(rdbtnMedio);
		rdbtnMedio.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnMedio.setBackground(new Color(176, 224, 230));
		rdbtnMedio.setBorderPainted(false);
		rdbtnMedio.setContentAreaFilled(false);
		rdbtnMedio.setFocusPainted(false);
		rdbtnMedio.setOpaque(false);
		rdbtnMedio.setBounds(114, 202, 100, 23);
		contentPane.add(rdbtnMedio);

		rdbtnGrande = new JRadioButton("Grande");
		buttonGroup.add(rdbtnGrande);
		rdbtnGrande.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnGrande.setBackground(new Color(176, 224, 230));
		rdbtnGrande.setBorderPainted(false);
		rdbtnGrande.setContentAreaFilled(false);
		rdbtnGrande.setFocusPainted(false);
		rdbtnGrande.setOpaque(false);
		rdbtnGrande.setBounds(214, 201, 81, 23);
		contentPane.add(rdbtnGrande);

		rdbtnBanho = new JRadioButton("Banho");
		buttonGroup_2.add(rdbtnBanho);
		rdbtnBanho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanho.setBackground(new Color(176, 224, 230));
		rdbtnBanho.setBorderPainted(false);
		rdbtnBanho.setContentAreaFilled(false);
		rdbtnBanho.setFocusPainted(false);
		rdbtnBanho.setOpaque(false);
		rdbtnBanho.setBounds(15, 230, 80, 23);
		contentPane.add(rdbtnBanho);

		rdbtnBanhoETosa = new JRadioButton("Banho e tosa");
		buttonGroup_2.add(rdbtnBanhoETosa);
		rdbtnBanhoETosa.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanhoETosa.setBackground(new Color(176, 224, 230));
		rdbtnBanhoETosa.setBorderPainted(false);
		rdbtnBanhoETosa.setContentAreaFilled(false);
		rdbtnBanhoETosa.setFocusPainted(false);
		rdbtnBanhoETosa.setOpaque(false);
		rdbtnBanhoETosa.setBounds(114, 230, 119, 23);
		contentPane.add(rdbtnBanhoETosa);

		JButton btnCarregar = new JButton("Atualizar");
		btnCarregar.setForeground(new Color(0, 100, 0));
		btnCarregar.setBackground(new Color(255, 255, 255));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblAGENDA.setModel(DbUtils.resultSetToTableModel(AgendaDAO.Atualizar()));
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(0, 100, 0));
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int variavel = 0;
				int Confi = 0;

				// Missing Informations

				if (txtData.getText().isEmpty() || txtHORA.getText().isEmpty() || txtCLIENTE.getText().isEmpty()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnPequeno.isSelected() && !rdbtnMedio.isSelected() && !rdbtnGrande.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnBanho.isSelected() && !rdbtnBanhoETosa.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnCachorro.isSelected() && !rdbtnGato.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				}

				// -------------------------------------------------------------------

				else {
					if (rdbtnPequeno.isSelected() && rdbtnBanho.isSelected()) {

						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 15,00", "Gostaria de confirmar Horário?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 1;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}
					} else if (rdbtnPequeno.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 25,00", "Gostaria de confirmar Horário?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário  confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 2;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}

					} else if (rdbtnMedio.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 20,00", "Gostaria de confirmar Horário?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 3;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}
					} else if (rdbtnMedio.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar Horário ?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário  confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 4;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar Horário ?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário  confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 5;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirmar", "Cancelar" };
						Confi = JOptionPane.showOptionDialog(null, "Valor: R$ 40,00", "Gostaria de confirmar Horário ?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Horário  confirmado! Favor chegar com 15 minutos de antecedência!");
							variavel = 6;
						} else {
							JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
						}
					}
					if ((Confi == 0))
						AgendaDAO.Confirmar(txtData.getText(), txtHORA.getText(), txtCLIENTE.getText(), variavel);
				}
			}
		});
		btnConfirmar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnConfirmar.setBounds(49, 281, 113, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu psm = new Menu();
				psm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnVoltar.setBounds(15, 333, 48, 52);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		contentPane.add(btnVoltar);
		btnCarregar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnCarregar.setBounds(177, 281, 113, 23);
		contentPane.add(btnCarregar);

		lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(15, 333, 52, 57);
		contentPane.add(lblVoltar);

		lblDATA = new JLabel("Data");
		lblDATA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblDATA.setBounds(35, 112, 37, 14);
		contentPane.add(lblDATA);

		lblHORA = new JLabel("Hora");
		lblHORA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblHORA.setBounds(112, 112, 35, 14);
		contentPane.add(lblHORA);

		lblCLIENTE = new JLabel("Cliente");
		lblCLIENTE.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCLIENTE.setBounds(205, 112, 55, 14);
		contentPane.add(lblCLIENTE);

		JLabel lblBanhoETosa = new JLabel("Banho e Tosa");
		lblBanhoETosa.setFont(new Font("Broadway", Font.BOLD, 30));
		lblBanhoETosa.setBounds(187, 11, 251, 51);
		contentPane.add(lblBanhoETosa);

		flor = new JLabel("New label");
		flor.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/230588225055212(1).png")));
		flor.setBounds(277, 144, 429, 328);
		contentPane.add(flor);

		lblInformaoesObrigtorias = new JLabel("*Informa\u00E7\u00F5es obrig\u00E1torias*");
		lblInformaoesObrigtorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformaoesObrigtorias.setForeground(Color.RED);
		lblInformaoesObrigtorias.setBounds(21, 85, 193, 23);
		contentPane.add(lblInformaoesObrigtorias);
		lblInformaoesObrigtorias.setVisible(false);

		background = new JLabel("New label");
		background.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 654, 411);
		contentPane.add(background);

	}
}
