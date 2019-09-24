package FramesEN;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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

import com.toedter.calendar.JDateChooser;

import DAO.AgendaDAO;

public class BanhoTosaEN extends JFrame {

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
	private MaskFormatter data;
	private MaskFormatter hora;
	JDateChooser txtDataChooser_1 = new JDateChooser();
	private JTextField txtHORA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanhoTosaEN frame = new BanhoTosaEN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BanhoTosaEN() {
		setTitle("Bath and Grooming");

		setIconImage(Toolkit.getDefaultToolkit().getImage(BanhoTosaEN.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		try {
			data = new MaskFormatter("##/##");
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		try {
			hora = new MaskFormatter("##:##");
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		txtHORA = new JFormattedTextField(hora);
		txtHORA.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		txtHORA.setBounds(104, 134, 49, 20);
		contentPane.add(txtHORA);

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

		// puxa a informacao tabela quando carrega Jframe
		tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarEN()));

		txtCLIENTE = new JTextField();
		txtCLIENTE.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		txtCLIENTE.setColumns(10);
		txtCLIENTE.setBounds(184, 134, 100, 20);
		contentPane.add(txtCLIENTE);

		JRadioButton rdbtnGato = new JRadioButton("Cat");
		rdbtnGato.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_1.add(rdbtnGato);
		rdbtnGato.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnGato.setBackground(new Color(176, 224, 230));
		rdbtnGato.setBorderPainted(false);
		rdbtnGato.setContentAreaFilled(false);
		rdbtnGato.setFocusPainted(false);
		rdbtnGato.setOpaque(false);
		rdbtnGato.setBounds(15, 176, 80, 23);
		contentPane.add(rdbtnGato);

		JRadioButton rdbtnCachorro = new JRadioButton("Dog");
		rdbtnCachorro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_1.add(rdbtnCachorro);
		rdbtnCachorro.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnCachorro.setBackground(new Color(176, 224, 230));
		rdbtnCachorro.setBorderPainted(false);
		rdbtnCachorro.setContentAreaFilled(false);
		rdbtnCachorro.setFocusPainted(false);
		rdbtnCachorro.setOpaque(false);
		rdbtnCachorro.setBounds(114, 176, 130, 23);
		contentPane.add(rdbtnCachorro);

		rdbtnPequeno = new JRadioButton("Small");
		rdbtnPequeno.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnPequeno);
		rdbtnPequeno.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnPequeno.setBorderPainted(false);
		rdbtnPequeno.setContentAreaFilled(false);
		rdbtnPequeno.setFocusPainted(false);
		rdbtnPequeno.setBounds(15, 202, 100, 23);
		rdbtnPequeno.setOpaque(false);

		contentPane.add(rdbtnPequeno);

		rdbtnMedio = new JRadioButton("Medium");
		rdbtnMedio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnMedio);
		rdbtnMedio.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnMedio.setBackground(new Color(176, 224, 230));
		rdbtnMedio.setBorderPainted(false);
		rdbtnMedio.setContentAreaFilled(false);
		rdbtnMedio.setFocusPainted(false);
		rdbtnMedio.setOpaque(false);
		rdbtnMedio.setBounds(114, 202, 100, 23);
		contentPane.add(rdbtnMedio);

		rdbtnGrande = new JRadioButton("Large");
		rdbtnGrande.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnGrande);
		rdbtnGrande.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnGrande.setBackground(new Color(176, 224, 230));
		rdbtnGrande.setBorderPainted(false);
		rdbtnGrande.setContentAreaFilled(false);
		rdbtnGrande.setFocusPainted(false);
		rdbtnGrande.setOpaque(false);
		rdbtnGrande.setBounds(214, 201, 81, 23);
		contentPane.add(rdbtnGrande);

		rdbtnBanho = new JRadioButton("Bath");
		rdbtnBanho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_2.add(rdbtnBanho);
		rdbtnBanho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanho.setBackground(new Color(176, 224, 230));
		rdbtnBanho.setBorderPainted(false);
		rdbtnBanho.setContentAreaFilled(false);
		rdbtnBanho.setFocusPainted(false);
		rdbtnBanho.setOpaque(false);
		rdbtnBanho.setBounds(15, 230, 80, 23);
		contentPane.add(rdbtnBanho);

		rdbtnBanhoETosa = new JRadioButton("Bath and grooming");
		rdbtnBanhoETosa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_2.add(rdbtnBanhoETosa);
		rdbtnBanhoETosa.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanhoETosa.setBackground(new Color(176, 224, 230));
		rdbtnBanhoETosa.setBorderPainted(false);
		rdbtnBanhoETosa.setContentAreaFilled(false);
		rdbtnBanhoETosa.setFocusPainted(false);
		rdbtnBanhoETosa.setOpaque(false);
		rdbtnBanhoETosa.setBounds(114, 230, 170, 23);
		contentPane.add(rdbtnBanhoETosa);

		JButton btnCarregar = new JButton("Update");
		btnCarregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCarregar.setForeground(new Color(0, 100, 0));
		btnCarregar.setBackground(new Color(255, 255, 255));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarEN()));
			}
		});
		
		JDateChooser txtDataChooser_1 = new JDateChooser();
		txtDataChooser_1.setBackground(new Color(240, 248, 255));
		txtDataChooser_1.setDateFormatString("dd-MM-yyyy");
		txtDataChooser_1.setBounds(15, 134, 87, 20);
		contentPane.add(txtDataChooser_1);

		JButton btnConfirmar = new JButton("Confirm");
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(new Color(0, 100, 0));
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int variavel = 0;
				int Confi = 0;
				//confere e valida a data
				String daata = ((JTextField) txtDataChooser_1.getDateEditor().getUiComponent()).getText();
				java.util.Date d = new Date();
				String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

				System.out.println(dStr);
				System.out.println(daata);

				String[] sprdAtual = dStr.split("/");
				String jntAtual = sprdAtual[0] + sprdAtual[1] + sprdAtual[2];

				String[] sprdValida = daata.split("-");
				String jntValida = sprdValida[0] + sprdValida[1] + sprdValida[2];

				System.out.println(jntAtual);
				System.out.println(jntValida);

				int Valida = Integer.parseInt(jntValida);
				int atual = Integer.parseInt(jntAtual);

				if (daata.isEmpty() || txtHORA.getText().isEmpty() || txtCLIENTE.getText().isEmpty()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnPequeno.isSelected() && !rdbtnMedio.isSelected() && !rdbtnGrande.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnBanho.isSelected() && !rdbtnBanhoETosa.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnCachorro.isSelected() && !rdbtnGato.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (Valida < atual) {
					JOptionPane.showMessageDialog(null, "Invalid date!");
				}

				// -------------------------------------------------------------------

				else {
					if (rdbtnPequeno.isSelected() && rdbtnBanho.isSelected()) {

						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 15,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 1;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}
					} else if (rdbtnPequeno.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 25,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 2;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}

					} else if (rdbtnMedio.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 20,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 3;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}
					} else if (rdbtnMedio.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 30,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 4;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 30,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 5;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "Confirm", "Cancel" };
						Confi = JOptionPane.showOptionDialog(null, "Total: R$ 40,00", "Would you like to schedule an appointment?",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Appointment scheduled! Please arrive in advance!");
							variavel = 6;
						} else {
							JOptionPane.showMessageDialog(null, "We are sorry we can't help you, thanks for the preference!");
						}
					}
					if ((Confi == 0))
						AgendaDAO.ConfirmarEN(daata, txtHORA.getText(), txtCLIENTE.getText(), variavel);
				}
				tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarEN()));
			}
		});
		btnConfirmar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnConfirmar.setBounds(49, 281, 113, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuEN psm = new MenuEN();
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
		lblVoltar.setIcon(new ImageIcon(BanhoTosaEN.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(15, 333, 52, 57);
		contentPane.add(lblVoltar);

		lblDATA = new JLabel("Date");
		lblDATA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblDATA.setBounds(35, 112, 37, 14);
		contentPane.add(lblDATA);

		lblHORA = new JLabel("Hour");
		lblHORA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblHORA.setBounds(112, 112, 41, 14);
		contentPane.add(lblHORA);

		lblCLIENTE = new JLabel("Client");
		lblCLIENTE.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCLIENTE.setBounds(205, 112, 55, 14);
		contentPane.add(lblCLIENTE);

		JLabel lblBanhoETosa = new JLabel("Bath and Grooming");
		lblBanhoETosa.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
		lblBanhoETosa.setBounds(149, 23, 386, 51);
		contentPane.add(lblBanhoETosa);

		flor = new JLabel("New label");
		flor.setIcon(new ImageIcon(BanhoTosaEN.class.getResource("/imagens/230588225055212(1).png")));
		flor.setBounds(277, 144, 429, 328);
		contentPane.add(flor);

		lblInformaoesObrigtorias = new JLabel("*Obligatory informations*");
		lblInformaoesObrigtorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformaoesObrigtorias.setForeground(Color.RED);
		lblInformaoesObrigtorias.setBounds(21, 85, 193, 23);
		contentPane.add(lblInformaoesObrigtorias);
		lblInformaoesObrigtorias.setVisible(false);

		background = new JLabel("New label");
		background.setIcon(new ImageIcon(BanhoTosaEN.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 654, 411);
		contentPane.add(background);

	}
}
