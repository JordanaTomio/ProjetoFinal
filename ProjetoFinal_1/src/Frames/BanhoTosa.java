package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.idog.Configuration.MySQLConfiguration;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alunos\\Downloads\\iconfinder_43_Duck_River_Canada_4783009.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanhoETosa = new JLabel("Banho e Tosa");
		lblBanhoETosa.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblBanhoETosa.setBounds(250, 11, 181, 51);
		contentPane.add(lblBanhoETosa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 136, 301, 188);
		contentPane.add(scrollPane);
		
		tblAGENDA = new JTable();
		scrollPane.setViewportView(tblAGENDA);
		tblAGENDA.setModel(new DefaultTableModel(
				//https://www.guj.com.br/t/gravar-dados-direto-no-jtable/56176/3 use isso
			new Object[][] {
				{"00/00", "08:30", null},
				{"00/00", "09:30", null},
				{"00/00", "10:30", null},
				{"00/00", "11:30", null},
				{"00/00", "13:30", null},
				{"00/00", "14:30", null},
				{"00/00", "15:30", null},
				{"00/00", "16:30", null},
				{"00/00", "17:30", null},
				{"00/00", "18:00", null},
			},
			new String[] {
				"Data", "Hora", "Cliente"
			}
		));
		tblAGENDA.getColumnModel().getColumn(0).setPreferredWidth(38);
		tblAGENDA.getColumnModel().getColumn(1).setPreferredWidth(46);
		
		JLabel lblPorte = new JLabel("Porte:");
		lblPorte.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPorte.setBounds(140, 58, 65, 19);
		contentPane.add(lblPorte);
		
		rdbtnPequeno = new JRadioButton("Pequeno");
		buttonGroup.add(rdbtnPequeno);
		rdbtnPequeno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnPequeno.setBorderPainted(false);
		rdbtnPequeno.setContentAreaFilled(false);
		rdbtnPequeno.setFocusPainted(false);
		rdbtnPequeno.setBounds(193, 56, 100, 23);
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
		rdbtnMedio.setBounds(314, 56, 100, 23);
		contentPane.add(rdbtnMedio);
		
		rdbtnGrande = new JRadioButton("Grande");
		buttonGroup.add(rdbtnGrande);
		rdbtnGrande.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnGrande.setBackground(new Color(176, 224, 230));
		rdbtnGrande.setBorderPainted(false);
		rdbtnGrande.setContentAreaFilled(false);
		rdbtnGrande.setFocusPainted(false);
		rdbtnGrande.setOpaque(false);
		rdbtnGrande.setBounds(421, 56, 112, 23);
		contentPane.add(rdbtnGrande);
		
		JRadioButton rdbtnGato = new JRadioButton("Gato");
		buttonGroup_1.add(rdbtnGato);
		rdbtnGato.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnGato.setBackground(new Color(176, 224, 230));
		rdbtnGato.setBorderPainted(false);
		rdbtnGato.setContentAreaFilled(false);
		rdbtnGato.setFocusPainted(false);
		rdbtnGato.setOpaque(false);
		rdbtnGato.setBounds(193, 81, 80, 23);
		contentPane.add(rdbtnGato);
		
		JRadioButton rdbtnCachorro = new JRadioButton("Cachorro");
		buttonGroup_1.add(rdbtnCachorro);
		rdbtnCachorro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnCachorro.setBackground(new Color(176, 224, 230));
		rdbtnCachorro.setBorderPainted(false);
		rdbtnCachorro.setContentAreaFilled(false);
		rdbtnCachorro.setFocusPainted(false);
		rdbtnCachorro.setOpaque(false);
		rdbtnCachorro.setBounds(314, 81, 130, 23);
		contentPane.add(rdbtnCachorro);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmar();
			}
		});
		btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnConfirmar.setBounds(180, 345, 113, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnVoltar.setBounds(346, 345, 105, 23);
		contentPane.add(btnVoltar);
		
		rdbtnBanho = new JRadioButton("Banho");
		buttonGroup_2.add(rdbtnBanho);
		rdbtnBanho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnBanho.setBackground(new Color(176, 224, 230));
		rdbtnBanho.setBorderPainted(false);
		rdbtnBanho.setContentAreaFilled(false);
		rdbtnBanho.setFocusPainted(false);
		rdbtnBanho.setOpaque(false);
		rdbtnBanho.setBounds(193, 107, 119, 23);
		contentPane.add(rdbtnBanho);
		
		rdbtnBanhoETosa = new JRadioButton("Banho e tosa");
		buttonGroup_2.add(rdbtnBanhoETosa);
		rdbtnBanhoETosa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnBanhoETosa.setBackground(new Color(176, 224, 230));
		rdbtnBanhoETosa.setBorderPainted(false);
		rdbtnBanhoETosa.setContentAreaFilled(false);
		rdbtnBanhoETosa.setFocusPainted(false);
		rdbtnBanhoETosa.setOpaque(false);
		rdbtnBanhoETosa.setBounds(314, 107, 119, 23);
		contentPane.add(rdbtnBanhoETosa);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(BanhoTosa.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}

	protected void Confirmar() {
		
/*		MySQLConfiguration c = new MySQLConfiguration();
		String q;
		try{
			Statement comando = c.conn.createStatement();
			q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico)"
					+ "VALUES ('" + "" + "', '" +""+  "', '" +""+  "', '" +""+ "')";
		comando.executeUpdate(q);
	*/		
	//--------------------------------------------------------------------------------------------		
			
			if(rdbtnPequeno.isSelected() && rdbtnBanho.isSelected()){
				
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 15,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 
		} else if(rdbtnPequeno.isSelected() && rdbtnBanhoETosa.isSelected()){
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 25,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 

		} else if(rdbtnMedio.isSelected() && rdbtnBanho.isSelected()){
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 20,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 
		}else if(rdbtnMedio.isSelected() && rdbtnBanhoETosa.isSelected()){
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 
		}else if (rdbtnGrande.isSelected() && rdbtnBanho.isSelected()){
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 30,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 
		}else if(rdbtnGrande.isSelected() && rdbtnBanhoETosa.isSelected()){
				  Object[] options = {"Confirmar","Cancelar"};
				   int N =JOptionPane.showOptionDialog(null, "Valor: R$ 40,00", "Gostaria de confirmar horário?",
						   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				   
					   if(N == 0){
						   JOptionPane.showMessageDialog(null, "Horário confirmado! Favor chegar com 15 minutos de antecedência!");   
					   }else{
					   JOptionPane.showMessageDialog(null, "Lamentamos não poder ajudar, agradecemos a procura!");
					   } 
		}
			
			
	//--------------------------------------------------------------------------------------------		
		/*} catch (Exception ex) {
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
		*/
		}
		
	}
//}
