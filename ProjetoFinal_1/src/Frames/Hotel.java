package Frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import DAO.HotelDAO;
import Utilis.Data;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Hotel extends JFrame {

	private JPanel contentPane;
	private JButton btnVai;
	private JButton btnVolta;
	private JTextField txtNomeCliente;
	private MaskFormatter mascaras;
	private JFormattedTextField data;
	private JFormattedTextField data2;
	private JTextField txtNome;
	private JDateChooser Date1;
	private JDateChooser Date2;

	JTextPane txtDs = new JTextPane();
	private int one = -1;
	private JTextField txtObs;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton gato = new JRadioButton("Gato");
	JRadioButton cachorro = new JRadioButton("Cachorro");
	private String tipo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Hotel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel.class.getResource("/imagens/3775232-16.png")));
		setTitle("Hotel iPet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		try {
			mascaras = new MaskFormatter("##/##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 139, 191, 28);
		contentPane.add(scrollPane);

		JTextPane txtDs = new JTextPane();
		txtDs.setEditable(false);
		txtDs.setContentType("");
		txtDs.setBounds(424, 179, 191, 135);
		contentPane.add(txtDs);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		scrollPane.setViewportView(txtNome);
		txtNome.setColumns(10);

		txtNomeCliente.setBounds(166, 130, 210, 23);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
				
						JRadioButton gato_1 = new JRadioButton("Gato");
						gato_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						buttonGroup.add(gato_1);
						gato_1.setContentAreaFilled(false);
						gato_1.setBorderPainted(false);
						gato_1.setOpaque(false);
						gato_1.setFocusPainted(false);
						gato_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
						gato_1.setBounds(168, 223, 63, 23);
						contentPane.add(gato_1);
				
						JRadioButton cachorro_1 = new JRadioButton("Cachorro");
						cachorro_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						buttonGroup.add(cachorro_1);
						cachorro_1.setContentAreaFilled(false);
						cachorro_1.setBorderPainted(false);
						cachorro_1.setOpaque(false);
						cachorro_1.setFocusPainted(false);
						cachorro_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
						cachorro_1.setBounds(243, 223, 101, 23);
						contentPane.add(cachorro_1);
		
				Date1 = new JDateChooser();
				Date1.setBounds(192, 182, 73, 20);
				Date1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				contentPane.add(Date1);
		
				Date2 = new JDateChooser();
				Date2.setBounds(303, 182, 73, 20);
				Date2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				contentPane.add(Date2);
		
				JButton btnFinalizar = new JButton("Agendar");
				btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnFinalizar.setForeground(new Color(0, 100, 0));
				btnFinalizar.setBackground(Color.WHITE);
				btnFinalizar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String nome = txtNomeCliente.getText();
						// String dataComeco = data.getText();
						String entrega = ((JTextField) Date1.getDateEditor().getUiComponent()).getText();
						// String dataFinal = data2.getText();
						String retirada = ((JTextField) Date2.getDateEditor().getUiComponent()).getText();
					
						String cuidador = txtNome.getText();
						String obs = txtObs.getText();

						if (cachorro_1.isSelected()) {
							tipo = "Cachorro";
							System.out.println("dog");
				} else if (gato_1.isSelected()) {
							tipo = "Gato";
							System.out.println("cat");
						}
						if (!nome.isEmpty() && !entrega.isEmpty() && !retirada.isEmpty() && !cuidador.isEmpty()
								&& !tipo.isEmpty()) {
							if (Data.validaData(entrega)) {
								if (Data.validaDuplaData(entrega,retirada)) {
									Beans.HotelBeans hotel = new Beans.HotelBeans();
									DAO.HotelDAO.Agendar(nome, entrega, retirada, cuidador, obs, tipo);
									DAO.HotelDAO.save(hotel);
									new Menu().setVisible(true);
									dispose();
									JOptionPane.showMessageDialog(null, "Agendamento finalizado!");
								}else{
									JOptionPane.showMessageDialog(null, "Data retirada invalida!");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Data entrega invalida!");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Informações faltando!");
						}

					}
				});
				txtObs = new JTextField();
				txtObs.setBounds(139, 280, 205, 20);
				contentPane.add(txtObs);
				txtObs.setColumns(10);
				btnFinalizar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
				btnFinalizar.setBounds(182, 336, 101, 31);
				contentPane.add(btnFinalizar);
		
				btnVai = new JButton("");
				btnVai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVai.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ResultSet rs = HotelDAO.findmaior(one);

						try {
							if (rs.next()) {
								String nome = rs.getString("NM_Cuidador");
								String ds = rs.getString("DS_Cuidador");
								one = rs.getInt("CD_CUIDADOR");
								txtNome.setText(nome);
								txtDs.setText(ds);

							} else {
								one = 0;
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				btnVai.setContentAreaFilled(false);
				btnVai.setOpaque(false);
				btnVai.setFocusPainted(false);
				btnVai.setBorderPainted(false);
				
						btnVai.setIcon(new ImageIcon(Hotel.class.getResource("/imagens/3847912-128(2).png")));
						btnVai.setBounds(523, 325, 89, 51);
						contentPane.add(btnVai);
		
				btnVolta = new JButton("");
				btnVolta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVolta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ResultSet rs = HotelDAO.Findmenor(one);

						try {
							if (rs.next()) {
								String nome = rs.getString("NM_Cuidador");
								String ds = rs.getString("DS_Cuidador");
								one = rs.getInt("CD_CUIDADOR");
								txtNome.setText(nome);
								txtDs.setText(ds);
							} else {
								one = 999999;
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}

				});
				btnVolta.setContentAreaFilled(false);
				btnVolta.setOpaque(false);
				btnVolta.setFocusPainted(false);
				btnVolta.setBorderPainted(false);
				
						btnVolta.setIcon(new ImageIcon(Hotel.class.getResource("/imagens/3847912-128(1).png")));
						btnVolta.setBounds(424, 325, 89, 51);
						contentPane.add(btnVolta);
		
				JButton sair = new JButton("");
				sair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				sair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Menu mnu = new Menu();
						mnu.setVisible(true);
						dispose();
					}
				});
				sair.setContentAreaFilled(false);
				sair.setOpaque(false);
				sair.setFocusPainted(false);
				sair.setBorderPainted(false);
				sair.setIcon(new ImageIcon(Hotel.class.getResource("/imagens/3209260-128(1).png")));
				sair.setBounds(10, 336, 63, 51);
				contentPane.add(sair);

		JLabel lblTraco = new JLabel("New label");
		lblTraco.setIcon(new ImageIcon(Hotel.class.getResource("/imagens/Sem t\u00EDtulo.png")));
		lblTraco.setBounds(399, 108, 2, 268);
		contentPane.add(lblTraco);

		JLabel lblAte = new JLabel("até");
		lblAte.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblAte.setBounds(266, 182, 36, 20);
		contentPane.add(lblAte);

		JLabel lblCuidadores = new JLabel("Cuidadores");
		lblCuidadores.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblCuidadores.setBounds(461, 108, 117, 20);
		contentPane.add(lblCuidadores);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblData.setBounds(97, 182, 63, 20);
		contentPane.add(lblData);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		label.setBounds(97, 131, 73, 20);
		contentPane.add(label);

		JLabel lblAlgumaObservao = new JLabel("Alguma observação?");
		lblAlgumaObservao.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblAlgumaObservao.setBounds(150, 253, 205, 28);
		contentPane.add(lblAlgumaObservao);

		JLabel lblCuidador = new JLabel("Hotel IPet");
		lblCuidador.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblCuidador.setBounds(231, 37, 247, 65);
		contentPane.add(lblCuidador);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblTipo.setBounds(97, 224, 63, 23);
		contentPane.add(lblTipo);

		JLabel lblDe = new JLabel("De");
		lblDe.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblDe.setBounds(165, 177, 46, 31);
		contentPane.add(lblDe);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Hotel.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 411);
		contentPane.add(background);
	}
}
