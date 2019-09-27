package FramesDE;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Utilis.Data;

public class BanhoTosaDE extends JFrame {

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
	private JRadioButton rdbtnGato;
	private JRadioButton rdbtnCachorro;
	JDateChooser txtDataChooser_1 = new JDateChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanhoTosaDE frame = new BanhoTosaDE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BanhoTosaDE() {
		setTitle("Duschen und Scheren");

		setIconImage(Toolkit.getDefaultToolkit().getImage(BanhoTosaDE.class.getResource("/imagens/3775232-16.png")));
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
						new String[] { "Datum", "Uhr", "Kunde" }));
		tblAGENDA.getColumnModel().getColumn(0).setPreferredWidth(38);
		tblAGENDA.getColumnModel().getColumn(1).setPreferredWidth(46);

		// puxa a informacao tabela quando carrega Jframe
		tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarDE()));

		txtCLIENTE = new JTextField();
		txtCLIENTE.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		txtCLIENTE.setColumns(10);
		txtCLIENTE.setBounds(184, 134, 100, 20);
		contentPane.add(txtCLIENTE);
		
		JComboBox<String> cbox = new JComboBox<String>();
		cbox.setBounds(114, 135, 52, 19);
		cbox.addItem("08:30");
		cbox.addItem("09:00");
		cbox.addItem("09:30");
		cbox.addItem("10:00");
		cbox.addItem("10:30");
		cbox.addItem("11:00");
		cbox.addItem("11:30");
		cbox.addItem("13:00");
		cbox.addItem("13:30");
		cbox.addItem("14:00");
		cbox.addItem("14:30");
		cbox.addItem("15:00");
		cbox.addItem("15:30");
		cbox.addItem("16:00");
		cbox.addItem("16:30");
		cbox.addItem("17:00");
		cbox.addItem("17:30");
		cbox.addItem("18:00");
		contentPane.add(cbox);

		String txtH = cbox.getSelectedItem().toString();
		

		rdbtnGato = new JRadioButton("Katze");
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

		rdbtnCachorro = new JRadioButton("Hund");
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

		rdbtnPequeno = new JRadioButton("Klein");
		rdbtnPequeno.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnPequeno);
		rdbtnPequeno.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnPequeno.setBorderPainted(false);
		rdbtnPequeno.setContentAreaFilled(false);
		rdbtnPequeno.setFocusPainted(false);
		rdbtnPequeno.setBounds(15, 202, 100, 23);
		rdbtnPequeno.setOpaque(false);

		contentPane.add(rdbtnPequeno);

		rdbtnMedio = new JRadioButton("MittelgroÃƒÅ¸");
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

		rdbtnGrande = new JRadioButton("GroÃƒÅ¸");
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

		rdbtnBanho = new JRadioButton("Duschen");
		rdbtnBanho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_2.add(rdbtnBanho);
		rdbtnBanho.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanho.setBackground(new Color(176, 224, 230));
		rdbtnBanho.setBorderPainted(false);
		rdbtnBanho.setContentAreaFilled(false);
		rdbtnBanho.setFocusPainted(false);
		rdbtnBanho.setOpaque(false);
		rdbtnBanho.setBounds(15, 230, 100, 23);
		contentPane.add(rdbtnBanho);

		rdbtnBanhoETosa = new JRadioButton("Duschen und scheren");
		rdbtnBanhoETosa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGroup_2.add(rdbtnBanhoETosa);
		rdbtnBanhoETosa.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		rdbtnBanhoETosa.setBackground(new Color(176, 224, 230));
		rdbtnBanhoETosa.setBorderPainted(false);
		rdbtnBanhoETosa.setContentAreaFilled(false);
		rdbtnBanhoETosa.setFocusPainted(false);
		rdbtnBanhoETosa.setOpaque(false);
		rdbtnBanhoETosa.setBounds(114, 230, 181, 23);
		contentPane.add(rdbtnBanhoETosa);

		JButton btnCarregar = new JButton("Aktualisieren");
		btnCarregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCarregar.setForeground(new Color(0, 100, 0));
		btnCarregar.setBackground(new Color(255, 255, 255));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarDE()));
			}
		});

		JDateChooser txtDataChooser_1 = new JDateChooser();
		txtDataChooser_1.setBackground(new Color(240, 248, 255));
		txtDataChooser_1.setDateFormatString("dd-MM-yyyy");
		txtDataChooser_1.setBounds(15, 134, 87, 20);
		contentPane.add(txtDataChooser_1);
		
		JButton btnConfirmar = new JButton("Best\u00E4tigen");
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(new Color(0, 100, 0));
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {

			//Insere no database o agendamento
			
			public void actionPerformed(ActionEvent e) {
				int variavel = 0;
				int Confi = 0;
				//confere e valida a data
				String daata = ((JTextField) txtDataChooser_1.getDateEditor().getUiComponent()).getText();

				String[] sprdValida = daata.split("-");
				String Valida = sprdValida[0] + "/" + sprdValida[1];

				if (daata.isEmpty() || txtH.isEmpty() || txtCLIENTE.getText().isEmpty()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnPequeno.isSelected() && !rdbtnMedio.isSelected() && !rdbtnGrande.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnBanho.isSelected() && !rdbtnBanhoETosa.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (!rdbtnCachorro.isSelected() && !rdbtnGato.isSelected()) {
					lblInformaoesObrigtorias.setVisible(true);
				} else if (Data.validaDataTraco(daata)) {
					JOptionPane.showMessageDialog(null, "UngÃ¼ltiges Datum!");
				}

				// -------------------------------------------------------------------

				else {
					if (rdbtnPequeno.isSelected() && rdbtnBanho.isSelected()) {

						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 15,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 1;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}
					} else if (rdbtnPequeno.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 25,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 2;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}

					} else if (rdbtnMedio.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 20,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 3;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}
					} else if (rdbtnMedio.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 30,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 4;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanho.isSelected()) {
						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 30,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 5;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}
					} else if (rdbtnGrande.isSelected() && rdbtnBanhoETosa.isSelected()) {
						Object[] options = { "BestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen", "Absagen" };
						Confi = JOptionPane.showOptionDialog(null, "Wert: R$ 40,00",
								"MÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶chten Sie die Uhrzeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigen?", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (Confi == 0) {
							JOptionPane.showMessageDialog(null,
									"Zeit bestÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤tigt! Bitte kommen Sie 15 Minuten im Voraus an!");
							variavel = 6;
						} else {
							JOptionPane.showMessageDialog(null,
									"Es tut uns leid, dass wir nicht anders konnten, danke fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼rs schauen!");
						}
					}
					String passe = null;
					if ((Confi == 0))
						passe = (String) cbox.getSelectedItem();

					AgendaDAO.Confirmar(Valida, passe, txtCLIENTE.getText(), variavel);
				}
				tblAGENDA.setModel(Utilis.DbUtils.resultSetTable(AgendaDAO.AtualizarDE()));
			}
		});
		btnConfirmar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnConfirmar.setBounds(23, 281, 113, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuDE psm = new MenuDE();
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
		btnCarregar.setBounds(146, 281, 138, 23);
		contentPane.add(btnCarregar);

		lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(BanhoTosaDE.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(15, 333, 52, 57);
		contentPane.add(lblVoltar);

		lblDATA = new JLabel("Datum");
		lblDATA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblDATA.setBounds(26, 112, 49, 14);
		contentPane.add(lblDATA);

		lblHORA = new JLabel("Uhr");
		lblHORA.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblHORA.setBounds(118, 112, 35, 14);
		contentPane.add(lblHORA);

		lblCLIENTE = new JLabel("Kunde");
		lblCLIENTE.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCLIENTE.setBounds(213, 112, 55, 14);
		contentPane.add(lblCLIENTE);

		JLabel lblBanhoETosa = new JLabel("Duschen und Scheren");
		lblBanhoETosa.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
		lblBanhoETosa.setBounds(113, 23, 423, 51);
		contentPane.add(lblBanhoETosa);

		flor = new JLabel("New label");
		flor.setIcon(new ImageIcon(BanhoTosaDE.class.getResource("/imagens/230588225055212(1).png")));
		flor.setBounds(277, 144, 429, 328);
		contentPane.add(flor);

		lblInformaoesObrigtorias = new JLabel("* Erforderliche Informationen *");
		lblInformaoesObrigtorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformaoesObrigtorias.setForeground(Color.RED);
		lblInformaoesObrigtorias.setBounds(21, 85, 211, 23);
		contentPane.add(lblInformaoesObrigtorias);
		lblInformaoesObrigtorias.setVisible(false);

		background = new JLabel("New label");
		background.setIcon(new ImageIcon(BanhoTosaDE.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 654, 411);
		contentPane.add(background);

	}
}
