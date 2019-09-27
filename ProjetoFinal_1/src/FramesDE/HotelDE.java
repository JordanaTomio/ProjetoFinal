package FramesDE;

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

import DAO.HotelDAO;
import Frames.Menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

public class HotelDE extends JFrame {

	private JPanel contentPane;
	private JButton btnVai;
	private JButton btnVolta;
	private JTextField txtNomeCliente;
	private MaskFormatter mascaras;
	private JTextField txtNome;
	JTextPane txtDs = new JTextPane();
	int one = -1;
	private JTextField txtObs;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton gato = new JRadioButton("Gato");
	JRadioButton cachorro = new JRadioButton("Cachorro");
	private String tipo;
	private JDateChooser Date1;
	private JDateChooser Date2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelDE frame = new HotelDE();
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
	public HotelDE() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HotelDE.class.getResource("/imagens/3775232-16.png")));
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
	
		
		JRadioButton gato = new JRadioButton("Katze");
		buttonGroup.add(gato);
		gato.setContentAreaFilled(false);
		gato.setBorderPainted(false);
		gato.setOpaque(false);
		gato.setFocusPainted(false);
		gato.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		gato.setBounds(217, 224, 73, 23);
		contentPane.add(gato);
		
		JRadioButton cachorro = new JRadioButton("Hund");
		buttonGroup.add(cachorro);
		cachorro.setContentAreaFilled(false);
		cachorro.setBorderPainted(false);
		cachorro.setOpaque(false);
		cachorro.setFocusPainted(false);
		cachorro.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		cachorro.setBounds(292, 224, 101, 23);
		contentPane.add(cachorro);

		JButton btnFinalizar = new JButton("Ansetzen f\u00FCr");
		btnFinalizar.setForeground(new Color(0, 100, 0));
		btnFinalizar.setBackground(Color.WHITE);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomeCliente.getText();
			//	String dataComeco = data.getText();
				String daata = ((JTextField) Date1.getDateEditor().getUiComponent()).getText();
				java.util.Date d = new Date();
				String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

				System.out.println(dStr);
				System.out.println(daata);
			
			//	String dataFinal = data2.getText();
				String daata2 = ((JTextField) Date2.getDateEditor().getUiComponent()).getText();
				java.util.Date d2 = new Date();
				String dStr2 = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d2);

				System.out.println(dStr2);
				System.out.println(daata2);

				String cuidador = txtNome.getText();
				String obs = txtObs.getText();
				
				if (cachorro.isSelected()){
					tipo = "Cachorro";
					System.out.println("dog");
				} else if (gato.isSelected()) {
					tipo = "Gato";
					System.out.println("cat");
				}
				
				if (!nome.isEmpty() && !daata.isEmpty() && !daata2.isEmpty() && !cuidador.isEmpty()
						&& !tipo.isEmpty()) {
					Beans.HotelBeans hotel = new Beans.HotelBeans();
					DAO.HotelDAO.Agendar(nome, daata, daata2, cuidador, obs, tipo);
					DAO.HotelDAO.save(hotel);
					new MenuDE().setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(null, "Zeitplan abgeschlossen!");
				} else {
					JOptionPane.showMessageDialog(null, "Fehlende Informationen!");
				}
				
			}
		});

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
		btnFinalizar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnFinalizar.setBounds(127, 336, 156, 31);
		contentPane.add(btnFinalizar);

		btnVai = new JButton("");
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

		btnVai.setIcon(new ImageIcon(HotelDE.class.getResource("/imagens/3847912-128(2).png")));
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
				
						btnVolta.setIcon(new ImageIcon(HotelDE.class.getResource("/imagens/3847912-128(1).png")));
						btnVolta.setBounds(424, 325, 89, 51);
						contentPane.add(btnVolta);
		
				JButton sair = new JButton("");
				sair.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		MenuDE mnu = new MenuDE();
		mnu.setVisible(true);
		dispose();
	}});sair.setContentAreaFilled(false);sair.setOpaque(false);sair.setFocusPainted(false);sair.setBorderPainted(false);sair.setIcon(new ImageIcon(HotelDE.class.getResource("/imagens/3209260-128(1).png")));sair.setBounds(10,336,63,51);contentPane.add(sair);

	txtObs=new JTextField();txtObs.setBounds(139,280,205,20);contentPane.add(txtObs);txtObs.setColumns(10);txtNomeCliente.setBounds(166,130,210,23);contentPane.add(txtNomeCliente);txtNomeCliente.setColumns(10);

	JLabel lblTraco = new JLabel(
			"New label");lblTraco.setIcon(new ImageIcon(HotelDE.class.getResource("/imagens/Sem t\u00EDtulo.png")));lblTraco.setBounds(399,108,2,268);contentPane.add(lblTraco);

	JLabel lblAte = new JLabel(
			"bis");lblAte.setFont(new Font("Lucida Bright", Font.PLAIN, 15));lblAte.setBounds(267,182,36,20);contentPane.add(lblAte);

	JLabel lblCuidadores = new JLabel(
			"Kinderm\u00E4dchen");lblCuidadores.setFont(new Font("Lucida Bright",Font.PLAIN,20));lblCuidadores.setBounds(440,108,166,20);contentPane.add(lblCuidadores);

	JLabel lblData = new JLabel(
			"Datum: ");lblData.setFont(new Font("Lucida Bright",Font.PLAIN,20));lblData.setBounds(97,182,95,20);contentPane.add(lblData);

	JLabel lblName = new JLabel(
			"Name:");lblName.setFont(new Font("Lucida Bright",Font.PLAIN,20));lblName.setBounds(97,131,73,20);contentPane.add(lblName);

	JLabel lblAlgumaObservao = new JLabel(
			"Irgendwelche Beobachtungen?");lblAlgumaObservao.setFont(new Font("Lucida Bright",Font.PLAIN,18));lblAlgumaObservao.setBounds(107,253,269,28);contentPane.add(lblAlgumaObservao);

	JLabel lblCuidador = new JLabel(
			"Hotel IPet");lblCuidador.setFont(new Font("Bauhaus 93",Font.PLAIN,50));lblCuidador.setBounds(231,37,247,65);contentPane.add(lblCuidador);

	JLabel lblTipo = new JLabel(
			"Haustiere:");lblTipo.setFont(new Font("Lucida Bright",Font.PLAIN,20));lblTipo.setBounds(97,224,114,23);contentPane.add(lblTipo);
	Date2 = new JDateChooser();
	Date2.setBounds(300, 181, 87, 20);
	contentPane.add(Date2);
	Date1 = new JDateChooser();
	Date1.setBounds(172, 182, 87, 20);
	contentPane.add(Date1);

	JLabel background = new JLabel(
			"");background.setIcon(new ImageIcon(HotelDE.class.getResource("/imagens/Background.jpg")));background.setBounds(0,0,660,411);contentPane.add(background);
}	
}
