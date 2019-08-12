package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtRZ_Social;
	private JTextField txtCPF_CNPJ;
	private JTextField txtCEP;
	private JTextField txtEM;
	private JTextField txtTL;
	private JTextField txtSN;
	private JTextField txtPN;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPasswordField txtPS;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alunos\\Downloads\\ia004b-500x500.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnOutros = new JRadioButton("Outros");
		buttonGroup.add(rdbtnOutros);
		rdbtnOutros.setBackground(new Color(204, 255, 204));
		rdbtnOutros.setBorderPainted(false);
		rdbtnOutros.setContentAreaFilled(false);
		rdbtnOutros.setFocusPainted(false);
		rdbtnOutros.setOpaque(false);
		rdbtnOutros.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnOutros.setBounds(538, 186, 65, 23);
		contentPane.add(rdbtnOutros);
		
		JLabel lblCadastroDaInstituio = new JLabel("Dados Cadastrais");
		lblCadastroDaInstituio.setBounds(210, 12, 272, 49);
		lblCadastroDaInstituio.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		contentPane.add(lblCadastroDaInstituio);
		
		JLabel lblNOME = new JLabel("Nome*:");
		lblNOME.setForeground(new Color(0, 0, 0));
		lblNOME.setBounds(30, 99, 62, 22);
		lblNOME.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNOME);
		
		JLabel lblNM_RAZAOSOCIAL = new JLabel("Raz\u00E3o social:");
		lblNM_RAZAOSOCIAL.setBounds(335, 140, 93, 22);
		lblNM_RAZAOSOCIAL.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNM_RAZAOSOCIAL);
		
		txtRZ_Social = new JTextField();
		txtRZ_Social.setBounds(433, 143, 150, 20);
		contentPane.add(txtRZ_Social);
		txtRZ_Social.setColumns(10);
		
		JLabel lblCPF_CNPJ = new JLabel("CPF/CNPJ*:");
		lblCPF_CNPJ.setBounds(28, 140, 91, 22);
		lblCPF_CNPJ.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblCPF_CNPJ);
		
		JLabel lblCEP = new JLabel("CEP*:");
		lblCEP.setBounds(27, 185, 65, 22);
		lblCEP.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblCEP);
		
		JLabel lblENDERECO = new JLabel("Email*:");
		lblENDERECO.setBounds(28, 233, 64, 22);
		lblENDERECO.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblENDERECO);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(335, 99, 88, 22);
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblSobrenome);
		
		txtSN = new JTextField();
		txtSN.setBounds(433, 99, 150, 20);
		contentPane.add(txtSN);
		txtSN.setColumns(10);
		
		JLabel lblCIDADE = new JLabel("Telefone*:");
		lblCIDADE.setBounds(28, 283, 88, 22);
		lblCIDADE.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblCIDADE);
		
		txtCPF_CNPJ = new JTextField();
		txtCPF_CNPJ.setBounds(129, 143, 150, 20);
		contentPane.add(txtCPF_CNPJ);
		txtCPF_CNPJ.setColumns(10);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(129, 188, 150, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		txtEM = new JTextField();
		txtEM.setBounds(129, 236, 150, 20);
		contentPane.add(txtEM);
		txtEM.setColumns(10);
		
		txtTL = new JTextField();
		txtTL.setBounds(129, 286, 150, 20);
		contentPane.add(txtTL);
		txtTL.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo*: ");
		lblNewLabel.setBounds(337, 189, 63, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JRadioButton btnMasculino = new JRadioButton("Masc");
		buttonGroup.add(btnMasculino);
		btnMasculino.setBounds(467, 187, 65, 23);
		btnMasculino.setBorderPainted(false);
		btnMasculino.setContentAreaFilled(false);
		btnMasculino.setFocusPainted(false);
		btnMasculino.setOpaque(false);
		btnMasculino.setBackground(new Color(204, 255, 204));
		btnMasculino.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnMasculino);
		
		JRadioButton btnFeminino = new JRadioButton("Fem");
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String primeiroNome = txtPN.getText();
				String ultimoNome = txtSN.getText();
				String email = txtEM.getText();
				String senha = txtPS.getText();
				String telefone = txtTL.getText();
				String CPF = txtCPF_CNPJ.getText();
				String razao = txtRZ_Social.getText();
				String pessoa = null;
				String sexo = null;
				String CEP = txtCEP.getText();
				int admin = 0;
				
				if (btnMasculino.isSelected()) {
					sexo = "Masculino";
				} else if (btnFeminino.isSelected()) {
					sexo = "Feminino";
				} else {
					sexo = "Outros";
				}


				if (!(email.isEmpty() && senha.isEmpty() && primeiroNome.isEmpty() && ultimoNome.isEmpty())) {
					Beans.Cliente cliente = new Beans.Cliente(email, senha, primeiroNome, ultimoNome, sexo, telefone, admin, CPF, CEP, pessoa, razao);
					DAO.ClienteDAO.save(cliente);
					new Login().setVisible(true);
					dispose();
				} else {
					JOptionPane.showConfirmDialog(null, "Informação faltando.", "Erro no cadastro", 1);
				}

			}
		});
		
		btnCadastrar.setBounds(149, 340, 109, 23);
		btnCadastrar.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(382, 340, 109, 23);
		btnVoltar.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JLabel lbldadosObrigatrios = new JLabel("*Dados obrigat\u00F3rios");
		lbldadosObrigatrios.setBounds(30, 317, 95, 14);
		lbldadosObrigatrios.setForeground(Color.RED);
		lbldadosObrigatrios.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		contentPane.add(lbldadosObrigatrios);
		
		txtPN = new JTextField();
		txtPN.setBounds(128, 98, 150, 22);
		contentPane.add(txtPN);
		txtPN.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPessoa.setBounds(335, 233, 65, 14);
		contentPane.add(lblPessoa);
		
		JRadioButton rdbtnJu = new JRadioButton("Jur\u00EDdica");
		rdbtnJu.setSelected(true);
		buttonGroup_1.add(rdbtnJu);
		rdbtnJu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnJu.setBounds(406, 234, 76, 23);
		rdbtnJu.setBorderPainted(false);
		rdbtnJu.setContentAreaFilled(false);
		rdbtnJu.setFocusPainted(false);
		rdbtnJu.setOpaque(false);
		contentPane.add(rdbtnJu);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/301738460207211(1).png")));
		lblNewLabel_2.setBounds(110, -43, 180, 146);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/301738460207211(1).png")));
		label.setBounds(383, -51, 180, 160);
		contentPane.add(label);
		
		JRadioButton rdbtnFsica = new JRadioButton("F\u00EDsica");
		buttonGroup_1.add(rdbtnFsica);
		rdbtnFsica.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnFsica.setBounds(527, 234, 76, 23);
		rdbtnFsica.setBorderPainted(false);
		rdbtnFsica.setContentAreaFilled(false);
		rdbtnFsica.setFocusPainted(false);
		rdbtnFsica.setOpaque(false);
		contentPane.add(rdbtnFsica);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSenha.setBounds(335, 282, 93, 22);
		contentPane.add(lblSenha);
		
		txtPS = new JPasswordField();
		txtPS.setBounds(433, 283, 150, 20);
		contentPane.add(txtPS);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/Background.jpg")));
		lblNewLabel_1.setBounds(0, -2, 644, 401);
		contentPane.add(lblNewLabel_1);
	}
}
