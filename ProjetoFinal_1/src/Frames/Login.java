package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnRegistrar = new JButton("");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro CIC = new Cadastro();
				CIC.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(442, 286, 89, 23);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setOpaque(false);
		contentPane.add(btnRegistrar);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		txtEmail.setBounds(392, 121, 183, 23);
		txtEmail.setBorder(null);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		txtSenha.setBounds(392, 157, 183, 23);
		txtSenha.setBorder(null);
		contentPane.add(txtSenha);
		
		JLabel lblLogar = new JLabel("Entrar");
		lblLogar.setForeground(new Color(240, 255, 240));
		lblLogar.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		lblLogar.setBounds(442, 216, 110, 28);
		contentPane.add(lblLogar);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				
				boolean auth = DAO.ClienteDAO.giveAuth(email, senha);

				if (auth) {
					new Menu().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Email ou senha são inválidos.", "Erro no login.", 1);
				}

			}
		});
		btnEntrar.setBounds(398, 216, 166, 28);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setFocusPainted(false);
		btnEntrar.setOpaque(false);
		contentPane.add(btnEntrar);
		
		JLabel lblRegistrese = new JLabel("Registre-se");
		lblRegistrese.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblRegistrese.setBounds(452, 286, 89, 23);
		contentPane.add(lblRegistrese);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagens/login v3.jpg")));
		lblNewLabel.setBounds(0, 0, 642, 393);
		contentPane.add(lblNewLabel);
		
	}
}
