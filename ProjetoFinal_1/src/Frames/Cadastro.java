package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.ClienteDAO;

import javax.swing.JFormattedTextField;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtRZ_Social;
	private JTextField txtEM;
	private JTextField txtSN;
	private JTextField txtPN;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPS;
	private JLabel btnVoltar_icon;
	private MaskFormatter CPF;
	private MaskFormatter CEP;
	private MaskFormatter telefone;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCEP;
	private JFormattedTextField txtCPF;
	JRadioButton btnFeminino = new JRadioButton("Fem");
	JRadioButton btnMasculino = new JRadioButton("Masc");
	JRadioButton rdbtnOutros = new JRadioButton("Outros");
	private String ver;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastrar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		try {
			telefone = new MaskFormatter("(##)#####-####");
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(telefone);
		txtTelefone.setBounds(128, 286, 150, 23);
		contentPane.add(txtTelefone);

		try {
			CEP = new MaskFormatter("#####-###");
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		txtCEP = new JFormattedTextField(CEP);
		txtCEP.setBounds(128, 184, 150, 23);
		contentPane.add(txtCEP);

		try {
			CPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		txtCPF = new JFormattedTextField(CPF);
		txtCPF.setBounds(128, 145, 150, 22);
		contentPane.add(txtCPF);

		txtPN = new JTextField();
		txtPN.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtPN.setBounds(128, 98, 150, 22);
		contentPane.add(txtPN);
		txtPN.setColumns(10);

		JLabel lblNOME = new JLabel("Nome*:");
		lblNOME.setForeground(new Color(0, 0, 0));
		lblNOME.setBounds(30, 99, 62, 22);
		lblNOME.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblNOME);

		JLabel lblCadastroDaInstituio = new JLabel("Dados Cadastrais");
		lblCadastroDaInstituio.setBounds(210, 12, 272, 49);
		lblCadastroDaInstituio.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		contentPane.add(lblCadastroDaInstituio);

		JLabel lblNM_RAZAOSOCIAL = new JLabel("Nome social:");
		lblNM_RAZAOSOCIAL.setBounds(333, 142, 104, 22);
		lblNM_RAZAOSOCIAL.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblNM_RAZAOSOCIAL);

		txtRZ_Social = new JTextField();
		txtRZ_Social.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtRZ_Social.setBounds(433, 143, 150, 20);
		contentPane.add(txtRZ_Social);
		txtRZ_Social.setColumns(10);

		JLabel lblCPF_CNPJ = new JLabel("CPF*:");
		lblCPF_CNPJ.setBounds(28, 140, 91, 22);
		lblCPF_CNPJ.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblCPF_CNPJ);

		JLabel lblCEP = new JLabel("CEP*:");
		lblCEP.setBounds(27, 185, 65, 22);
		lblCEP.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblCEP);

		JLabel lblENDERECO = new JLabel("Email*:");
		lblENDERECO.setBounds(28, 233, 64, 22);
		lblENDERECO.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblENDERECO);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(335, 99, 88, 22);
		lblSobrenome.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblSobrenome);

		txtSN = new JTextField();
		txtSN.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtSN.setBounds(433, 99, 150, 20);
		contentPane.add(txtSN);
		txtSN.setColumns(10);

		JLabel lblCIDADE = new JLabel("Telefone*:");
		lblCIDADE.setBounds(28, 283, 88, 22);
		lblCIDADE.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblCIDADE);

		txtEM = new JTextField();
		txtEM.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtEM.setBounds(129, 236, 150, 20);
		contentPane.add(txtEM);
		txtEM.setColumns(10);

		JLabel lblGenero = new JLabel("Sexo*: ");
		lblGenero.setBounds(337, 189, 63, 14);
		lblGenero.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		contentPane.add(lblGenero);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(0, 100, 0));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String primeiroNome = txtPN.getText();
				String ultimoNome = txtSN.getText();
				String email = txtEM.getText();
				String senha = txtPS.getText();
				String telefone = txtTelefone.getText();
				String CPF = txtCPF.getText();
				String razao = txtRZ_Social.getText();
				String pessoa = null;
				String sexo = null;
				String CEP = txtCEP.getText();
				int admin = 0;

				ResultSet rs = ClienteDAO.findAllCPF();
				try {
					if (rs.next()) {
						ver = rs.getString("CPF_Cliente");
					}
					System.out.println(ver);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(ver);
				}
				
				
				if (btnMasculino.isSelected()) {
					sexo = "Masculino";
					System.out.println("batata");
				} else if (btnFeminino.isSelected()) {
					sexo = "Feminino";
					System.out.println("batata");
				} else if (rdbtnOutros.isSelected()) {
					sexo = "Outros";
				}

				if (!(email.isEmpty() && senha.isEmpty() && primeiroNome.isEmpty() && ultimoNome.isEmpty())) {
					Beans.Cliente cliente = new Beans.Cliente(email, senha, primeiroNome, ultimoNome, sexo, telefone,
							admin, CEP, CPF, pessoa, razao);
					DAO.ClienteDAO.save(cliente);
					System.out.println("inseriu");
					new Login().setVisible(true);
					dispose();
					
				} else if (!(email.equals(ver))){
					System.out.println(ver);
					JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
					
				} else {
					JOptionPane.showMessageDialog(null, "Informações faltando!");
				}

			}
		});

		btnCadastrar.setBounds(228, 346, 167, 23);
		btnCadastrar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		contentPane.add(btnCadastrar);
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(240, 255, 255));
		btnVoltar.setBounds(8, 345, 43, 43);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lbldadosObrigatrios = new JLabel("*Dados obrigatórios");
		lbldadosObrigatrios.setBounds(30, 317, 95, 14);
		lbldadosObrigatrios.setForeground(Color.RED);
		lbldadosObrigatrios.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		contentPane.add(lbldadosObrigatrios);

		JLabel Flor1_icon = new JLabel("New label");
		Flor1_icon.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/301738460207211(1).png")));
		Flor1_icon.setBounds(110, -43, 180, 146);
		contentPane.add(Flor1_icon);

		JLabel Flor2_icon = new JLabel("New label");
		Flor2_icon.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/301738460207211(1).png")));
		Flor2_icon.setBounds(383, -51, 180, 160);
		contentPane.add(Flor2_icon);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblSenha.setBounds(335, 233, 93, 22);
		contentPane.add(lblSenha);

		txtPS = new JPasswordField();
		txtPS.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtPS.setBounds(433, 234, 150, 20);
		contentPane.add(txtPS);

		btnVoltar_icon = new JLabel("");
		btnVoltar_icon.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/3209260-128(1).png")));
		btnVoltar_icon.setBounds(10, 346, 40, 44);
		contentPane.add(btnVoltar_icon);

		btnFeminino = new JRadioButton("Fem");
		btnFeminino.setSelected(true);
		buttonGroup.add(btnFeminino);
		btnFeminino.setBounds(406, 187, 62, 23);
		btnFeminino.setBorderPainted(false);
		btnFeminino.setContentAreaFilled(false);
		btnFeminino.setFocusPainted(false);
		btnFeminino.setOpaque(false);
		btnFeminino.setBackground(new Color(204, 255, 204));
		btnFeminino.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnFeminino);
		btnFeminino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnMasculino = new JRadioButton("Masc");
		buttonGroup.add(btnMasculino);
		btnMasculino.setBounds(467, 187, 65, 23);
		btnMasculino.setBorderPainted(false);
		btnMasculino.setContentAreaFilled(false);
		btnMasculino.setFocusPainted(false);
		btnMasculino.setOpaque(false);
		btnMasculino.setBackground(new Color(204, 255, 204));
		btnMasculino.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnMasculino);
		btnMasculino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		rdbtnOutros = new JRadioButton("Outros");
		buttonGroup.add(rdbtnOutros);
		rdbtnOutros.setBackground(new Color(204, 255, 204));
		rdbtnOutros.setBorderPainted(false);
		rdbtnOutros.setContentAreaFilled(false);
		rdbtnOutros.setFocusPainted(false);
		rdbtnOutros.setOpaque(false);
		rdbtnOutros.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnOutros.setBounds(538, 186, 65, 23);
		contentPane.add(rdbtnOutros);
		rdbtnOutros.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel Background_icon = new JLabel("New label");
		Background_icon.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/Background.jpg")));
		Background_icon.setBounds(0, -2, 660, 440);
		contentPane.add(Background_icon);
	}
}
