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
import br.com.idog.DAO.PedidoDAO;
import br.com.idog.Frames.Main;
import br.com.idog.Models.Pedido;

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
	private JTextField txtCPFPerfil;
	JRadioButton rdbtnMasculinoPerfil = new JRadioButton("Masculino");
	JRadioButton rdbtnFemininoPerfil = new JRadioButton("Feminino");
	JRadioButton rdbtnOutroPerfil = new JRadioButton("Outro");
	private Object visualizaDadosUsuario;

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
		txtNomePerfil.setBounds(59, 124, 231, 20);
		contentPane.add(txtNomePerfil);
		txtNomePerfil.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSobrenome.setBounds(300, 126, 79, 14);
		contentPane.add(lblSobrenome);

		txtSobreNomePerfil = new JTextField();
		txtSobreNomePerfil.setColumns(10);
		txtSobreNomePerfil.setBounds(383, 124, 251, 20);
		contentPane.add(txtSobreNomePerfil);

		JLabel lblTelefonePerfil = new JLabel("Telefone:");
		lblTelefonePerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTelefonePerfil.setBounds(10, 188, 63, 14);
		contentPane.add(lblTelefonePerfil);

		txtTelefonePerfil = new JTextField();
		txtTelefonePerfil.setColumns(10);
		txtTelefonePerfil.setBounds(76, 186, 214, 20);
		contentPane.add(txtTelefonePerfil);

		JLabel lblEmailPerfil = new JLabel("E-mail:");
		lblEmailPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmailPerfil.setBounds(300, 189, 53, 14);
		contentPane.add(lblEmailPerfil);

		txtEmailPerfil = new JTextField();
		txtEmailPerfil.setColumns(10);
		txtEmailPerfil.setBounds(350, 186, 284, 20);
		contentPane.add(txtEmailPerfil);

		JLabel lblEnderecoPerfil = new JLabel("Endere\u00E7o:");
		lblEnderecoPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnderecoPerfil.setBounds(10, 247, 74, 14);
		contentPane.add(lblEnderecoPerfil);

		txtEnderecoPerfil = new JTextField();
		txtEnderecoPerfil.setColumns(10);
		txtEnderecoPerfil.setBounds(83, 245, 207, 20);
		contentPane.add(txtEnderecoPerfil);

		JLabel lblCepPerfil = new JLabel("CEP:");
		lblCepPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCepPerfil.setBounds(300, 248, 46, 14);
		contentPane.add(lblCepPerfil);

		txtCEPPerfil = new JTextField();
		txtCEPPerfil.setColumns(10);
		txtCEPPerfil.setBounds(339, 245, 295, 20);
		contentPane.add(txtCEPPerfil);

		lblGeneroPerfil = new JLabel("Gen\u00EAro:");
		lblGeneroPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGeneroPerfil.setBounds(300, 308, 63, 14);
		contentPane.add(lblGeneroPerfil);

		buttonGroup.add(rdbtnMasculinoPerfil);
		rdbtnMasculinoPerfil.setBackground(new Color(224, 255, 255));
		rdbtnMasculinoPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnMasculinoPerfil.setBounds(352, 304, 93, 23);
		contentPane.add(rdbtnMasculinoPerfil);

		buttonGroup.add(rdbtnFemininoPerfil);
		rdbtnFemininoPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnFemininoPerfil.setBackground(new Color(224, 255, 255));
		rdbtnFemininoPerfil.setBounds(441, 304, 87, 23);
		contentPane.add(rdbtnFemininoPerfil);

		buttonGroup.add(rdbtnOutroPerfil);
		rdbtnOutroPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnOutroPerfil.setBackground(new Color(224, 255, 255));
		rdbtnOutroPerfil.setBounds(524, 304, 66, 23);
		contentPane.add(rdbtnOutroPerfil);
		
		// PROCURANDO ALGUMA FORMA DE FAZER COM QUE QUANDO ABRIRMOS O PERFIL OS
		// DADOS DA CONTA QUE ESTA "LOGADA" JA ESTEJAM NA TELA
		//TESTANDO
		
		JButton btnBuscarPerfil = new JButton("Perfil");
		btnBuscarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
/*
				String nome = txtNomePerfil.getText();
				String sobrenome = txtSobreNomePerfil.getText();
				String telefone = txtTelefonePerfil.getText();
				String email = txtEmailPerfil.getText();
				String endereco = txtEnderecoPerfil.getText();
				String CEP = txtCEPPerfil.getText();
				String CPF = txtCPFPerfil.getText();

				String genero = "Masculino";
				if (rdbtnMasculinoPerfil.isSelected()) {
					genero = "Masculino";
				} else {
					genero = "Feminino";
				}

				if (!(nome.equals(null))) {
					ResultSet rs = ClienteDAO.selectAll(nome);
					try {
						while (rs.next()) {
							String pnome = rs.getString("PN_Cliente");
							String snome = rs.getString("SN_Cliente");
							String telefonep = rs.getString("TL_Cliente");
							String CEPp = rs.getString("CEP_Cliente");
							String emailp = rs.getString("EM_Cliente");
							String ederecop = rs.getString("EN_Cliente");
							String generop = rs.getString("SX_Cliente");
							String CPFp = rs.getString("CPF_Cliente");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				// ----------------------------------------------------

				if (!(sobrenome.equals(null))) {
					ResultSet rs = ClienteDAO.selectAll(sobrenome);
					try {
						while (rs.next()) {
							String pnome = rs.getString("PN_Cliente");
							String snome = rs.getString("SN_Cliente");
							String telefonep = rs.getString("TL_Cliente");
							String CEPp = rs.getString("CEP_Cliente");
							String emailp = rs.getString("EM_Cliente");
							String ederecop = rs.getString("EN_Cliente");
							String generop = rs.getString("SX_Cliente");
							String CPFp = rs.getString("CPF_Cliente");
						}
						txtNomePerfil.setText(nome);
						txtSobreNomePerfil.setText(sobrenome);
						txtEmailPerfil.setText(email);
						txtTelefonePerfil.setText(telefone);
						txtCEPPerfil.setText(CEP);
						txtCPFPerfil.setText(CPF);
						txtEnderecoPerfil.setText(endereco);

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				// -----------------------------------------------------
				if (!(email.equals(null))) {
					ResultSet rs = ClienteDAO.selectAll(sobrenome);
					try {
						while (rs.next()) {
							String pnome = rs.getString("PN_Cliente");
							String snome = rs.getString("SN_Cliente");
							String telefonep = rs.getString("TL_Cliente");
							String CEPp = rs.getString("CEP_Cliente");
							String emailp = rs.getString("EM_Cliente");
							String ederecop = rs.getString("EN_Cliente");
							String generop = rs.getString("SX_Cliente");
							String CPFp = rs.getString("CPF_Cliente");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		*/
		btnBuscarPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuscarPerfil.setBounds(172, 361, 93, 29);
		contentPane.add(btnBuscarPerfil);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PetShopMenu psm = new PetShopMenu();
				psm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnVoltar.setBounds(275, 361, 93, 29);
		contentPane.add(btnVoltar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSair.setBounds(378, 361, 93, 29);
		contentPane.add(btnSair);

		JLabel lblCPFPerfil = new JLabel("CPF:");
		lblCPFPerfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCPFPerfil.setBounds(10, 309, 46, 14);
		contentPane.add(lblCPFPerfil);

		txtCPFPerfil = new JTextField();
		txtCPFPerfil.setColumns(10);
		txtCPFPerfil.setBounds(47, 306, 243, 20);
		contentPane.add(txtCPFPerfil);
			}
			});
/*
 * 				Pedido pedido = new Pedido(0, Main.cliente.getCdCodigo());
				PedidoDAO.save(pedido);
 * 
 * 
 * 
	public static class ClienteDAO {
		public static ResultSet selectAll(String pnome) {
			MySQLConfiguration c = new MySQLConfiguration();
			String q = "SELECT PS_Cliente, SN_Cliente, TL_Cliente, EM_Cliente, EN_Cliente, SX_Cliente, CEP_Cliente, CPF_Cliente FROM cliente where PN_Cliente ?";
			try {
				PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
				ps.setString(1, "%" + pnome + "%");
			} catch (SQLException e) {
				System.err.println("Perfil isn't found.");
				e.printStackTrace();
				
			}
			return null;
		}

		public void selectSnome(String snome) {
			String q = "SELECT PS_Cliente, SN_Cliente, TL_Cliente, EM_Cliente, EN_Cliente, SX_Cliente, CEP_Cliente, CPF_Cliente FROM cliente where SN_Cliente ?";
			try {
				PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
				ps.setString(1, "%" + snome + "%");
			} catch (SQLException e) {
				System.err.println("Animal isn't found.");
				e.printStackTrace();
				return;
			}
		}

		public ResultSet selectByEmail(String email) {
			String q = "SELECT PS_Cliente, SN_Cliente, TL_Cliente, EM_Cliente, EN_Cliente, SX_Cliente, CEP_Cliente, CPF_Cliente FROM cliente where EM_Cliente ?";
			try {
				PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
				ps.setString(1, email);
				return ps.executeQuery();
			} catch (SQLException e) {
				System.err.println("Perfil isn't found.");
				e.printStackTrace();
				return null;
			}
		}
	}

	// TESTANDO
	
	
	
	public class Persistence {
		private Object visualizaDadosUsuario;

		public <EntityManagerFactory> EntityManagerFactory createEntityManagerFactory(String unitName) {

		}

		public void createEntityManagerFactory(String nome, java.util.Map(properties)){
			
		}

		// DAO
		public Perfil buscarUsuairoPorLogin(String login) {
			EntityManager em = EntityManagerUtil.getEM();
			try {
				System.out.println("Login: " + login);
				return (Perfil) em.createNamedQuery("Cliente").setParameter("login", login).getSingleResult();
			} catch (NoResultException nre) {
				return null;
			}
		}

		// BEAN
		public String dadosUsuarioCadastrado() {
			ClienteDAO usuarioDAO = new ClienteDAO();
			this.visualizaDadosUsuario = usuarioDAO.buscarUsuairoPorLogin(visualizaDadosUsuario());
			return "/usuario/usuario_dadosCadastrais.xhtml";
		}*/
	
	}
}

