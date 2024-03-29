package FramesDE;

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

import Frames.Login;
import FramesEN.LoginEN;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class LoginDE extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	JButton btnRegistrar = new JButton("");
	JLabel lblLogar = new JLabel("Eintreten");
	JLabel lblRegistrese = new JLabel("Anmelden");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDE frame = new LoginDE();
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
	public LoginDE() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDE.class.getResource("/imagens/3775232-16.png")));
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
		btnEntrar.setBounds(376, 227, 210, 28);
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
					new MenuDE().setVisible(true);
					dispose();
				} else {//ß
					JOptionPane.showMessageDialog(null, "E-Mail oder Passwort ist ungültig.", "Fehler in login.", 1);
				}

			}
		});
		
		JButton btnPT = new JButton("");
		btnPT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		
		JButton btnEN = new JButton("");
		btnEN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginEN().setVisible(true);
				dispose();
			}
		});
		btnEN.setBounds(138, 358, 55, 38);
		btnEN.setContentAreaFilled(false);
		btnEN.setFocusPainted(false);
		btnEN.setBorderPainted(false);
		btnEN.setOpaque(false);
		contentPane.add(btnEN);
		
		btnPT.setBounds(214, 355, 55, 43);
		btnPT.setContentAreaFilled(false);
		btnPT.setFocusPainted(false);
		btnPT.setBorderPainted(false);
		btnPT.setOpaque(false);
		contentPane.add(btnPT);
		
		JButton btnAL = new JButton("");
		btnAL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Sie sind bereits in dieser Sprache");
			}
		});
		btnAL.setBounds(51, 358, 59, 35);
		btnAL.setBorderPainted(false);
		btnAL.setContentAreaFilled(false);
		btnAL.setFocusPainted(true);
		btnAL.setOpaque(false);
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
				new CadastroDE().setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setOpaque(false);
		contentPane.add(btnRegistrar);
		lblLogar.setHorizontalAlignment(SwingConstants.CENTER);


		lblLogar.setBounds(391, 227, 183, 28);
		lblLogar.setForeground(new Color(240, 255, 240));
		lblLogar.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		contentPane.add(lblLogar);
		
		JLabel English = new JLabel("");
		English.setIcon(new ImageIcon(LoginDE.class.getResource("/imagens/2634451-64.png")));
		English.setBounds(138, 358, 53, 39);
		contentPane.add(English);
		
		JLabel Deutsch = new JLabel("New label");
		Deutsch.setIcon(new ImageIcon(LoginDE.class.getResource("/imagens/2634422-64.png")));
		Deutsch.setBounds(51, 358, 59, 37);
		contentPane.add(Deutsch);

		
		lblRegistrese.setBounds(452, 286, 89, 23);
		lblRegistrese.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		contentPane.add(lblRegistrese);
		
		JLabel pt = new JLabel("");
		pt.setIcon(new ImageIcon(LoginDE.class.getResource("/imagens/2634471-64.png")));
		pt.setBounds(215, 358, 60, 38);
		contentPane.add(pt);

		JLabel Background = new JLabel("New label");
		Background.setBounds(0, 0, 654, 411);
		Background.setIcon(new ImageIcon(LoginDE.class.getResource("/imagens/login v3.jpg")));
		contentPane.add(Background);

	}


}
