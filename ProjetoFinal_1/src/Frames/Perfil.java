package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Beans.Cliente;
import DAO.ClienteDAO;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
*/
import br.com.idog.Configuration.MySQLConfiguration;
import javax.swing.ImageIcon;

public class Perfil<EntityManager> extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePerfil;
	private JTextField txtSobreNomePerfil;
	private JTextField txtTelefonePerfil;
	private JTextField txtEmailPerfil;
	private JTextField txtEnderecoPerfil;
	private JTextField txtCEPPerfil;
	private JLabel lblGeneroPerfil;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton btnMasculino = new JRadioButton("Masculino");
	JRadioButton btnFeminino = new JRadioButton("Feminino");
	JRadioButton btnOutro = new JRadioButton("Outro");
	private Object visualizaDadosUsuario;
	private JButton btnBuscar;
	private JButton btnAlterar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Perfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPerfil.setBounds(275, 11, 69, 81);
		contentPane.add(lblPerfil);

		JLabel lblNomePerfil = new JLabel("Nome:");
		lblNomePerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNomePerfil.setBounds(10, 126, 46, 14);
		contentPane.add(lblNomePerfil);

		txtNomePerfil = new JTextField();
		txtNomePerfil.setBounds(120, 124, 170, 20);
		contentPane.add(txtNomePerfil);
		txtNomePerfil.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSobrenome.setBounds(300, 126, 79, 14);
		contentPane.add(lblSobrenome);

		txtSobreNomePerfil = new JTextField();
		txtSobreNomePerfil.setColumns(10);
		txtSobreNomePerfil.setBounds(422, 124, 212, 20);
		contentPane.add(txtSobreNomePerfil);

		JLabel lblTelefonePerfil = new JLabel("Telefone:");
		lblTelefonePerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTelefonePerfil.setBounds(10, 188, 63, 14);
		contentPane.add(lblTelefonePerfil);

		txtTelefonePerfil = new JTextField();
		txtTelefonePerfil.setColumns(10);
		txtTelefonePerfil.setBounds(120, 186, 170, 20);
		contentPane.add(txtTelefonePerfil);

		JLabel lblEmailPerfil = new JLabel("E-mail:");
		lblEmailPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmailPerfil.setBounds(300, 189, 53, 14);
		contentPane.add(lblEmailPerfil);

		txtEmailPerfil = new JTextField();
		txtEmailPerfil.setColumns(10);
		txtEmailPerfil.setBounds(422, 186, 212, 20);
		contentPane.add(txtEmailPerfil);

		JLabel lblEnderecoPerfil = new JLabel("Raz\u00E3o Social:");
		lblEnderecoPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnderecoPerfil.setBounds(10, 247, 87, 14);
		contentPane.add(lblEnderecoPerfil);

		txtEnderecoPerfil = new JTextField();
		txtEnderecoPerfil.setColumns(10);
		txtEnderecoPerfil.setBounds(120, 245, 170, 20);
		contentPane.add(txtEnderecoPerfil);

		JLabel lblCepPerfil = new JLabel("CEP:");
		lblCepPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCepPerfil.setBounds(300, 248, 46, 14);
		contentPane.add(lblCepPerfil);

		txtCEPPerfil = new JTextField();
		txtCEPPerfil.setColumns(10);
		txtCEPPerfil.setBounds(422, 245, 212, 20);
		contentPane.add(txtCEPPerfil);

		lblGeneroPerfil = new JLabel("Gen\u00EAro:");
		lblGeneroPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGeneroPerfil.setBounds(300, 308, 63, 14);
		contentPane.add(lblGeneroPerfil);

		buttonGroup.add(btnMasculino);
		btnMasculino.setBackground(new Color(224, 255, 255));
		btnMasculino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMasculino.setBounds(352, 304, 93, 23);
		contentPane.add(btnMasculino);

		buttonGroup.add(btnFeminino);
		btnFeminino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFeminino.setBackground(new Color(224, 255, 255));
		btnFeminino.setBounds(441, 304, 87, 23);
		contentPane.add(btnFeminino);

		buttonGroup.add(btnOutro);
		btnOutro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOutro.setBackground(new Color(224, 255, 255));
		btnOutro.setBounds(524, 304, 66, 23);
		contentPane.add(btnOutro);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cdCodigo = Main.cliente.getCdCodigo();	
				ResultSet rs = ClienteDAO.findAllByID(cdCodigo);
					
				try {
					while (rs.next()) {
						String primeiroNome = rs.getString("PN_Cliente");
						String segundoNome = rs.getString("SN_Cliente");
						String telefone = rs.getString("TL_Cliente");
						String email = rs.getString("EM_Cliente");
						String razao = rs.getString("RZ_Cliente");
						String cep = rs.getString("CEP_Cliente");
						String sexo = rs.getString("SX_Cliente");
						
						txtNomePerfil.setText(primeiroNome);
						txtSobreNomePerfil.setText(segundoNome);
						txtTelefonePerfil.setText(telefone);
						txtEmailPerfil.setText(email);
						txtEnderecoPerfil.setText(razao);
						txtCEPPerfil.setText(cep);

						if (sexo.equalsIgnoreCase("Masculino")) {
							btnMasculino.setSelected(true);
						} else if (sexo.equalsIgnoreCase("Feminino")) {
							btnFeminino.setSelected(true);
						} else {
							btnOutro.setSelected(true);
						}
						
						
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(36, 304, 99, 23);
		contentPane.add(btnBuscar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cdCodigo = Main.cliente.getCdCodigo();
				String primeiroNome = txtNomePerfil.getText();
				String segundoNome = txtSobreNomePerfil.getText();
				String sexo = "";
				String telefone = txtTelefonePerfil.getText();
				String cep = txtCEPPerfil.getText();
				String razao = txtEnderecoPerfil.getText();
				String email = txtEmailPerfil.getText();
				
				if (btnMasculino.isSelected()){
					sexo = "Masculino";
				} else if (btnFeminino.isSelected()){
					sexo = "Feminino";
				} else {
					sexo = "Outros";
				}
				ClienteDAO.UpdateAllByID(cdCodigo, primeiroNome, segundoNome, sexo, telefone, cep, razao, email);
				ResultSet rs = ClienteDAO.findAllByID(cdCodigo);
				try {
					while (rs.next()) {

						txtNomePerfil.setText(primeiroNome);
						txtSobreNomePerfil.setText(segundoNome);
						txtTelefonePerfil.setText(telefone);
						txtEmailPerfil.setText(email);
						txtEnderecoPerfil.setText(razao);
						txtCEPPerfil.setText(cep);

						if (sexo.equalsIgnoreCase("Masculino")) {
							btnMasculino.setSelected(true);
						} else if (sexo.equalsIgnoreCase("Feminino")) {
							btnFeminino.setSelected(true);
						} else {
							btnOutro.setSelected(true);
						}

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			
			}
		});
		btnAlterar.setBounds(155, 304, 99, 23);
		contentPane.add(btnAlterar);

		// PROCURANDO ALGUMA FORMA DE FAZER COM QUE QUANDO ABRIRMOS O PERFIL OS
		// DADOS DA CONTA QUE ESTA "LOGADA" JA ESTEJAM NA TELA
		// TESTANDO



				JButton btnVoltar = new JButton("");
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PetShopMenu psm = new PetShopMenu();
						psm.setVisible(true);
						dispose();
					}
				});
				btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btnVoltar.setBounds(10, 348, 46, 50);
				btnVoltar.setBorderPainted(false);
				btnVoltar.setContentAreaFilled(false);
				btnVoltar.setFocusPainted(false);
				btnVoltar.setOpaque(false);
				contentPane.add(btnVoltar);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Perfil.class.getResource("/imagens/3209260-128(1).png")));
				lblNewLabel.setBounds(11, 346, 46, 52);
				contentPane.add(lblNewLabel);
			}
}
