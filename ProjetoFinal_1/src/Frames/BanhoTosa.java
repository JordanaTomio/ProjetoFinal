package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
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

import br.com.idog.Configuration.MySQLConfiguration;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel;
	private JTextField txtDATA;
	private JTextField txtHORA;
	private JTextField txtCLIENTE;
	private JLabel lblDATA;
	private JLabel lblHORA;
	private JLabel lblCLIENTE;
	private JLabel background;
	private JLabel lblVoltar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel flor;

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

	/**
	 * Create the frame.
	 */
	public BanhoTosa() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Alunos\\Downloads\\iconfinder_43_Duck_River_Canada_4783009.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBanhoETosa = new JLabel("Banho e Tosa");
		lblBanhoETosa.setFont(new Font("Broadway", Font.BOLD, 30));
		lblBanhoETosa.setBounds(187, 11, 251, 51);
		contentPane.add(lblBanhoETosa);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/230588225055212(1).png")));
		lblNewLabel_1.setBounds(403, 376, 213, -124);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/230588225055212(1).png")));
		lblNewLabel_2.setBounds(69, 376, 198, -177);
		contentPane.add(lblNewLabel_2);

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

		rdbtnPequeno = new JRadioButton("Pequeno");
		buttonGroup.add(rdbtnPequeno);
		rdbtnPequeno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnPequeno.setBorderPainted(false);
		rdbtnPequeno.setContentAreaFilled(false);
		rdbtnPequeno.setFocusPainted(false);
		rdbtnPequeno.setBounds(15, 202, 100, 23);
		rdbtnPequeno.setOpaque(false);

		contentPane.add(rdbtnPequeno);

		rdbtnMedio = new JRadioButton("M\u00E9dio");
		buttonGroup.add(rdbtnMedio);
		rdbtnMedio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnMedio.setBackground(new Color(176, 224, 230));
		rdbtnMedio.setBorderPainted(false);
		rdbtnMedio.setContentAreaFilled(false);
		rdbtnMedio.setFocusPainted(false);
		rdbtnMedio.setOpaque(false);
		rdbtnMedio.setBounds(114, 202, 100, 23);
		contentPane.add(rdbtnMedio);

		rdbtnGrande = new JRadioButton("Grande");
		buttonGroup.add(rdbtnGrande);
		rdbtnGrande.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnGrande.setBackground(new Color(176, 224, 230));
		rdbtnGrande.setBorderPainted(false);
		rdbtnGrande.setContentAreaFilled(false);
		rdbtnGrande.setFocusPainted(false);
		rdbtnGrande.setOpaque(false);
		rdbtnGrande.setBounds(214, 201, 81, 23);
		contentPane.add(rdbtnGrande);

		JRadioButton rdbtnGato = new JRadioButton("Gato");
		buttonGroup_1.add(rdbtnGato);
		rdbtnGato.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnGato.setBackground(new Color(176, 224, 230));
		rdbtnGato.setBorderPainted(false);
		rdbtnGato.setContentAreaFilled(false);
		rdbtnGato.setFocusPainted(false);
		rdbtnGato.setOpaque(false);
		rdbtnGato.setBounds(15, 176, 80, 23);
		contentPane.add(rdbtnGato);

		JRadioButton rdbtnCachorro = new JRadioButton("Cachorro");
		buttonGroup_1.add(rdbtnCachorro);
		rdbtnCachorro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnCachorro.setBackground(new Color(176, 224, 230));
		rdbtnCachorro.setBorderPainted(false);
		rdbtnCachorro.setContentAreaFilled(false);
		rdbtnCachorro.setFocusPainted(false);
		rdbtnCachorro.setOpaque(false);
		rdbtnCachorro.setBounds(114, 176, 130, 23);
		contentPane.add(rdbtnCachorro);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmar();
			}
		});
		
		lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(13, 333, 52, 57);
		contentPane.add(lblVoltar);
		btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 13));
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
		btnVoltar.setBounds(9, 335, 48, 52);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		contentPane.add(btnVoltar);

		rdbtnBanho = new JRadioButton("Banho");
		buttonGroup_2.add(rdbtnBanho);
		rdbtnBanho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnBanho.setBackground(new Color(176, 224, 230));
		rdbtnBanho.setBorderPainted(false);
		rdbtnBanho.setContentAreaFilled(false);
		rdbtnBanho.setFocusPainted(false);
		rdbtnBanho.setOpaque(false);
		rdbtnBanho.setBounds(15, 230, 80, 23);
		contentPane.add(rdbtnBanho);

		rdbtnBanhoETosa = new JRadioButton("Banho e tosa");
		buttonGroup_2.add(rdbtnBanhoETosa);
		rdbtnBanhoETosa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnBanhoETosa.setBackground(new Color(176, 224, 230));
		rdbtnBanhoETosa.setBorderPainted(false);
		rdbtnBanhoETosa.setContentAreaFilled(false);
		rdbtnBanhoETosa.setFocusPainted(false);
		rdbtnBanhoETosa.setOpaque(false);
		rdbtnBanhoETosa.setBounds(214, 228, 119, 23);
		contentPane.add(rdbtnBanhoETosa);

		txtDATA = new JTextField();
		txtDATA.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtDATA.setBounds(46, 137, 48, 20);
		contentPane.add(txtDATA);
		txtDATA.setColumns(10);

		txtHORA = new JTextField();
		txtHORA.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtHORA.setColumns(10);
		txtHORA.setBounds(114, 137, 52, 20);
		contentPane.add(txtHORA);

		txtCLIENTE = new JTextField();
		txtCLIENTE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		txtCLIENTE.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtCLIENTE.setColumns(10);
		txtCLIENTE.setBounds(190, 136, 100, 20);
		contentPane.add(txtCLIENTE);

		lblDATA = new JLabel("Data");
		lblDATA.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDATA.setBounds(55, 115, 37, 14);
		contentPane.add(lblDATA);

		lblHORA = new JLabel("Hora");
		lblHORA.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHORA.setBounds(121, 114, 35, 14);
		contentPane.add(lblHORA);

		lblCLIENTE = new JLabel("Cliente");
		lblCLIENTE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCLIENTE.setBounds(212, 112, 55, 14);
		contentPane.add(lblCLIENTE);
		
				JButton btnCarregar = new JButton("Atualizar");
				btnCarregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Atualizar();
					}
				});
				btnCarregar.setFont(new Font("Times New Roman", Font.BOLD, 13));
				btnCarregar.setBounds(177, 281, 113, 23);
				contentPane.add(btnCarregar);
		
		JRadioButton btnTosa = new JRadioButton("Tosa");
		buttonGroup_2.add(btnTosa);
		btnTosa.setOpaque(false);
		btnTosa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTosa.setFocusPainted(false);
		btnTosa.setContentAreaFilled(false);
		btnTosa.setBorderPainted(false);
		btnTosa.setBackground(new Color(176, 224, 230));
		btnTosa.setBounds(114, 230, 80, 23);
		contentPane.add(btnTosa);
		
		flor = new JLabel("New label");
		flor.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/230588225055212(1).png")));
		flor.setBounds(277, 144, 429, 328);
		contentPane.add(flor);
		
		background = new JLabel("New label");
		background.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 644, 401);
		contentPane.add(background);

	}

	protected void Confirmar() {
	
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "";
		
		try {
			Statement comando = c.conn.createStatement();
			
			
			// --------------------------------------------------------------------------------------------
			if (rdbtnPequeno.isSelected() && rdbtnBanho.isSelected()) {

				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 15,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho', '15.00')";
				
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}
			}else if (rdbtnPequeno.isSelected() && rdbtnBanhoETosa.isSelected()) {
				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 25,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho e Tosa', '25.00')";
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}

			} else if (rdbtnMedio.isSelected() && rdbtnBanho.isSelected()) {
				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 20,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho', '20.00')";
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}
			} else if (rdbtnMedio.isSelected() && rdbtnBanhoETosa.isSelected()) {
				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho e tosa', '30.00')";
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}
			} else if (rdbtnGrande.isSelected() && rdbtnBanho.isSelected()) {
				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho', '30.00')";
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}
			} else if (rdbtnGrande.isSelected() && rdbtnBanhoETosa.isSelected()) {
				Object[] options = { "Confirmar", "Cancelar" };
				int N = JOptionPane.showOptionDialog(null, "Valor: R$ 40,00", "Gostaria de confirmar horário?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (N == 0) {
					JOptionPane.showMessageDialog(null,
							"Horário confirmado! Favor chegar com 15 minutos de antecedência!");
					q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES"
							 + " ('" + txtDATA.getText() + "', '" + txtHORA.getText() + "', '" + txtCLIENTE.getText() + "', 'Banho e tosa', '40.00')";
				} else {
					JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
				}
			}
			// --------------------------------------------------------------------------------------------

				System.out.println(q);
				comando.executeUpdate(q);
			
		} catch (Exception ex) {
			System.err.println("FALHA NA no bang da CONFIRMAÇÃO");
			ex.printStackTrace();
		} finally {
			if (c.conn != null) {
				try {
					c.conn.close();
				} catch (Exception ex) {
					System.err.println("ALGO ERRADO NÃO ESTÁ CERTO!");
				}
			}
		}
	}

	protected void Atualizar() {

		MySQLConfiguration c = new MySQLConfiguration();

		String q = "";
		String w = "";

		q = "SELECT DT_Servico, HR_Servico, NM_Cliente FROM agenda ";
	/*	if (!txtDATA.getText().isEmpty()) {
			w = "DT_Servico = " + txtDATA.getText();
		}
		// -------------------------------------------------------------\\
		if (!txtHORA.getText().isEmpty()) {
			w = "HR_Servico = '" + txtHORA.getText() + "' ";
		}
		// -------------------------------------------------------------\\
		if (!txtCLIENTE.getText().isEmpty()) {
			if (w.isEmpty()) {
				w = "NM_Cliente like '%" + txtCLIENTE.getText() + "%' ";
			} else {
				w += " and NM_Cliente like '%" + txtCLIENTE.getText() + "%' ";
			}
		}
		// -------------------------------------------------------------\\
		if (!w.isEmpty()) {
			q += " WHERE " + w;
		}*/
		// -------------------------------------------------------------\\
		try {
			PreparedStatement comando = c.conn.prepareStatement(q);
			ResultSet rs = comando.executeQuery();

			tblAGENDA.setModel(DbUtils.resultSetToTableModel(rs));

			rs.close();
			comando.close();

		} catch (SQLException e) {
			System.err.println("ERRO NO SQL");
			System.err.println(q);
			e.printStackTrace();
		}
	}
}