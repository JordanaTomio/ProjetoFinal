package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class Perfil<EntityManager> extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePerfil;
	private JTextField txtSobreNomePerfil;
	private JTextField txtEmailPerfil;
	private JTextField txtEnderecoPerfil;
	private JLabel lblGeneroPerfil;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton btnMasculino = new JRadioButton("Masculino");
	JRadioButton btnFeminino = new JRadioButton("Feminino");
	JRadioButton btnOutro = new JRadioButton("Outro");
	private Object visualizaDadosUsuario;
	private JButton btnBuscar;
	private JButton btnAlterar;
	private JLabel background;
	private JFormattedTextField txtTelefonePerfil;
	private MaskFormatter TelefonePerfil;
	private JFormattedTextField txtCEPPerfil;
	private MaskFormatter CEPPerfil;

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
		setTitle("Perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Perfil.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		try{
			TelefonePerfil = new MaskFormatter("(##) #####-####"); 
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		
		try{
			CEPPerfil = new MaskFormatter("#####-###");
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		
		txtCEPPerfil = new JFormattedTextField(CEPPerfil);
		txtCEPPerfil.setBounds(446, 248, 175, 19);
		contentPane.add(txtCEPPerfil);
		
		txtTelefonePerfil = new JFormattedTextField(TelefonePerfil);
		txtTelefonePerfil.setBounds(127, 189, 170, 19);
		contentPane.add(txtTelefonePerfil);

		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
		lblPerfil.setBounds(268, 11, 123, 81);
		contentPane.add(lblPerfil);

		JLabel lblNomePerfil = new JLabel("Nome:");
		lblNomePerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblNomePerfil.setBounds(20, 127, 46, 14);
		contentPane.add(lblNomePerfil);

		txtNomePerfil = new JTextField();
		txtNomePerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtNomePerfil.setBounds(127, 123, 170, 20);
		contentPane.add(txtNomePerfil);
		txtNomePerfil.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblSobrenome.setBounds(357, 127, 79, 14);
		contentPane.add(lblSobrenome);

		txtSobreNomePerfil = new JTextField();
		txtSobreNomePerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtSobreNomePerfil.setColumns(10);
		txtSobreNomePerfil.setBounds(446, 126, 175, 20);
		contentPane.add(txtSobreNomePerfil);

		JLabel lblTelefonePerfil = new JLabel("Telefone:");
		lblTelefonePerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblTelefonePerfil.setBounds(20, 189, 79, 14);
		contentPane.add(lblTelefonePerfil);

		JLabel lblEmailPerfil = new JLabel("E-mail:");
		lblEmailPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblEmailPerfil.setBounds(357, 190, 53, 14);
		contentPane.add(lblEmailPerfil);

		txtEmailPerfil = new JTextField();
		txtEmailPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtEmailPerfil.setColumns(10);
		txtEmailPerfil.setBounds(446, 188, 175, 20);
		contentPane.add(txtEmailPerfil);

		JLabel lblEnderecoPerfil = new JLabel("Nome Social:");
		lblEnderecoPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblEnderecoPerfil.setBounds(20, 248, 99, 14);
		contentPane.add(lblEnderecoPerfil);

		txtEnderecoPerfil = new JTextField();
		txtEnderecoPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtEnderecoPerfil.setColumns(10);
		txtEnderecoPerfil.setBounds(127, 244, 170, 20);
		contentPane.add(txtEnderecoPerfil);

		JLabel lblCepPerfil = new JLabel("CEP:");
		lblCepPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblCepPerfil.setBounds(357, 249, 46, 14);
		contentPane.add(lblCepPerfil);

		lblGeneroPerfil = new JLabel("Sexo: ");
		lblGeneroPerfil.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblGeneroPerfil.setBounds(348, 307, 63, 17);
		contentPane.add(lblGeneroPerfil);

		buttonGroup.add(btnMasculino);
		btnMasculino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMasculino.setBackground(new Color(224, 255, 255));
		btnMasculino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMasculino.setBounds(388, 304, 93, 23);
		btnMasculino.setBorderPainted(false);
		btnMasculino.setOpaque(false);
		btnMasculino.setContentAreaFilled(false);
		contentPane.add(btnMasculino);

		buttonGroup.add(btnFeminino);
		btnFeminino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFeminino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFeminino.setBackground(new Color(224, 255, 255));
		btnFeminino.setBounds(483, 304, 87, 23);
		btnFeminino.setBorderPainted(false);
		btnFeminino.setOpaque(false);
		btnFeminino.setContentAreaFilled(false);
		contentPane.add(btnFeminino);

		buttonGroup.add(btnOutro);
		btnOutro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOutro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOutro.setBackground(new Color(224, 255, 255));
		btnOutro.setBounds(572, 304, 66, 23);
		btnOutro.setBorderPainted(false);
		btnOutro.setOpaque(false);
		btnOutro.setContentAreaFilled(false);
		contentPane.add(btnOutro);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(new Color(0, 100, 0));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
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
		btnBuscar.setBounds(36, 304, 111, 23);
		contentPane.add(btnBuscar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setForeground(new Color(0, 100, 0));
		btnAlterar.setBackground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
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

				if (btnMasculino.isSelected()) {
					sexo = "Masculino";
				} else if (btnFeminino.isSelected()) {
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
		btnAlterar.setBounds(186, 304, 111, 23);
		contentPane.add(btnAlterar);
		
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		background = new JLabel("New label");
		background.setIcon(new ImageIcon(Perfil.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 440);
		contentPane.add(background);
	}
}
