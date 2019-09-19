package FramesDE;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Frames.Main;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class MenuDE extends JFrame {

	private JPanel contentPane;
	private JButton btnVet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDE frame = new MenuDE();
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
	public MenuDE() {
		setTitle("Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuDE.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnAdocao = new JButton("");
		btnAdocao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PetAdotarDE().setVisible(true);
				dispose();
			}
		});
		
		JButton btnLoja = new JButton("");
		btnLoja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PetShopMenuDE().setVisible(true);
				dispose();
			}
		});
		
		JButton btnPetShop = new JButton("");
		btnPetShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPetShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BanhoTosaDE().setVisible(true);
				dispose();
			}
		});
		
		JButton btnLogoff = new JButton("");
		btnLogoff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginDE().setVisible(true);
				dispose();
			}
		});
		btnLogoff.setBounds(22, 323, 52, 56);
		btnLogoff.setBorderPainted(false);
		btnLogoff.setContentAreaFilled(false);
		btnLogoff.setFocusPainted(false);
		btnLogoff.setOpaque(false);
		contentPane.add(btnLogoff);
		
		btnVet = new JButton("VeterinÃƒÂ¡rio");
		btnVet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVet.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/vet.png")));
		btnVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ContatoVeterinarioDE().setVisible(true);
				dispose();
			}
		});
		btnVet.setBounds(566, 323, 77, 76);
		btnVet.setBorderPainted(false);
		btnVet.setContentAreaFilled(false);
		btnVet.setOpaque(false);
		btnVet.setFocusPainted(false);
		contentPane.add(btnVet);
		
		JLabel lblLoja = new JLabel("Gesch\u00E4ft");
		lblLoja.setForeground(new Color(0, 0, 0));
		lblLoja.setBounds(96, 246, 80, 22);
		contentPane.add(lblLoja);
		lblLoja.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		
		btnPetShop.setBounds(295, 142, 65, 103);
		btnPetShop.setBorderPainted(false);
		btnPetShop.setContentAreaFilled(false);
		btnPetShop.setFocusPainted(false);
		btnPetShop.setOpaque(false);
		contentPane.add(btnPetShop);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/183189-128(1).png")));
		lblNewLabel_1.setBounds(22, 328, 47, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblMenu.setBounds(266, 34, 186, 65);
		contentPane.add(lblMenu);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Webp.net-resizeimage.png")));
		label.setBounds(258, 129, 138, 135);
		contentPane.add(label);
		
		JLabel lblVeterinrio = new JLabel("Tier\u00E4rztlich");
		lblVeterinrio.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblVeterinrio.setBounds(561, 305, 77, 22);
		contentPane.add(lblVeterinrio);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setForeground(new Color(0, 0, 0));
		lblPetShop.setBounds(296, 246, 75, 22);
		contentPane.add(lblPetShop);
		lblPetShop.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		JButton btnAdm = new JButton("");
		btnAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Main.cliente.getAdm() == 1){
					btnAdm.setVisible(true);
					new AdmDE().setVisible(true);
					dispose();
				} else {
					btnAdm.setVisible(false);
				}
			}
		});
		btnAdm.setBounds(548, 16, 77, 79);
		btnAdm.setBorderPainted(false);
		btnAdm.setContentAreaFilled(false);
		btnAdm.setFocusPainted(false);
		btnAdm.setOpaque(false);
		contentPane.add(btnAdm);
		
		
		btnLoja.setBounds(94, 142, 89, 103);
		btnLoja.setBorderPainted(false);
		btnLoja.setContentAreaFilled(false);
		btnLoja.setFocusPainted(false);
		btnLoja.setOpaque(false);
		contentPane.add(btnLoja);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Webp.net-resizeimage (1).png")));
		lblNewLabel.setBounds(69, 129, 138, 135);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdoo = new JLabel("Adoption");
		lblAdoo.setBounds(494, 244, 84, 22);
		contentPane.add(lblAdoo);
		lblAdoo.setForeground(new Color(0, 0, 0));
		lblAdoo.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnAdocao.setBounds(483, 151, 95, 85);
		btnAdocao.setBorderPainted(false);
		btnAdocao.setContentAreaFilled(false);
		btnAdocao.setFocusPainted(false);
		btnAdocao.setOpaque(false);
		contentPane.add(btnAdocao);
		btnAdocao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Webp.net-resizeimage (2).png")));
		label_1.setBounds(463, 129, 138, 135);
		contentPane.add(label_1);
		
		
		JLabel cachorro = new JLabel("New label");
		cachorro.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/dog(1).png")));
		cachorro.setBounds(179, 97, 329, 315);
		contentPane.add(cachorro);
		
		
		JLabel lblManager = new JLabel("");
		lblManager.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Adm menor.png")));
		lblManager.setBounds(542, 6, 89, 94);
		if (Main.cliente.getAdm() == 1){
			lblManager.setVisible(true);
		} else {
			lblManager.setVisible(false);
		}
		contentPane.add(lblManager);
		
		
		JLabel lblAdministrao = new JLabel("Verwaltung");
		lblAdministrao.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblAdministrao.setBounds(548, 85, 86, 33);
		
		if (Main.cliente.getAdm() ==1){
			lblAdministrao.setVisible(true);
		} else {
			lblAdministrao.setVisible(false);
		}
		contentPane.add(lblAdministrao);
		
		JButton btnHotel = new JButton("");
		btnHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HotelDE().setVisible(true);
				dispose();
			}
		});
		btnHotel.setBounds(18, 19, 89, 79);
		btnHotel.setContentAreaFilled(false);
		btnHotel.setOpaque(false);
		btnHotel.setFocusPainted(false);
		btnHotel.setBorderPainted(false);
		contentPane.add(btnHotel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Hotel2.png")));
		lblNewLabel_2.setBounds(22, 11, 89, 88);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblHotel.setBounds(57, 94, 52, 22);
		contentPane.add(lblHotel);
		
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(MenuDE.class.getResource("/imagens/Background.jpg")));
		lblBackground.setBounds(0, 0, 664, 440);
		contentPane.add(lblBackground);
		
	}
}
