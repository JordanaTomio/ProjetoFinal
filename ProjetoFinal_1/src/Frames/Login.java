package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	JButton btnRegistrar = new JButton("");
	JLabel lblLogar = new JLabel("Entrar");
	JLabel lblRegistrese = new JLabel("Registre-se");

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagens/3775232-16.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setBounds(391, 129, 183, 23);
		txtEmail.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		txtEmail.setBorder(null);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(391, 169, 183, 23);
		txtSenha.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		txtSenha.setBorder(null);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("");
		btnEntrar.setBounds(398, 223, 166, 28);
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				contentPane.getRootPane().setDefaultButton(btnEntrar);

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();

				}
			}
		});
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
		
		JButton btnEN = new JButton("EN");
		btnEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lerEN();
				
			}
		});
		btnEN.setBounds(121, 348, 72, 52);
		contentPane.add(btnEN);
		
		JButton btnPT = new JButton("PT");
		btnPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lerPT();
				
			}
		});
		btnPT.setBounds(218, 348, 72, 52);
		contentPane.add(btnPT);
		
		JButton btnAL = new JButton("AL");
		btnAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lerAL();
				
			}
		});
		btnAL.setBounds(22, 348, 72, 52);
		contentPane.add(btnAL);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setFocusPainted(true);
		btnEntrar.setOpaque(false);
		contentPane.add(btnEntrar);

		
		btnRegistrar.setBounds(442, 286, 89, 23);
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro CIC = new Cadastro();
				CIC.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setOpaque(false);
		contentPane.add(btnRegistrar);


		lblLogar.setBounds(441, 224, 110, 28);
		lblLogar.setForeground(new Color(240, 255, 240));
		lblLogar.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		contentPane.add(lblLogar);

		
		lblRegistrese.setBounds(452, 286, 89, 23);
		lblRegistrese.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		contentPane.add(lblRegistrese);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 654, 411);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagens/login v3.jpg")));
		contentPane.add(lblNewLabel);

	}

	protected void lerPT() {//2
		Properties prop = new Properties();

		try {

			// carrega properties
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/PT.txt"));

			// recupera e imprime valores
			lblLogar.setText(prop.getProperty("btn1"));
			lblRegistrese.setText(prop.getProperty("btn2"));
			
			prop.store(new FileOutputStream(System.getProperty("user.dir")+"/Idioma.txt"), "2");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void lerAL() {//3
		Properties prop = new Properties();

		try {

			// carrega properties
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/AL.txt"));

			// recupera e imprime valores
			lblLogar.setText(prop.getProperty("btn1"));
			lblRegistrese.setText(prop.getProperty("btn2"));
			
			prop.store(new FileOutputStream(System.getProperty("user.dir")+"/Idioma.txt"),"3");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void lerEN() {//1
		Properties prop = new Properties();

		try {

			// carrega properties
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/EN.txt"));

			// recupera e imprime valores
			lblLogar.setText(prop.getProperty("btn1"));
			lblRegistrese.setText(prop.getProperty("btn2"));
			
			prop.store(new FileOutputStream(System.getProperty("user.dir")+"/Idioma.txt"),"1");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
