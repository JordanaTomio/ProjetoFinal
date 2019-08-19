package Frames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnVet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnAdocao = new JButton("");
		btnAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetAdotar pea = new PetAdotar();
				pea.setVisible(true);
				dispose();
			}
		});
		
		JButton btnLoja = new JButton("");
		btnLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetShopMenu psm = new PetShopMenu();
				psm.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPetShop = new JButton("");
		btnPetShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanhoTosa bnt = new BanhoTosa();
				bnt.setVisible(true);
				dispose();
			}
		});
		
		JButton btnLogoff = new JButton("");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		btnLogoff.setBounds(22, 323, 47, 56);
		btnLogoff.setBorderPainted(false);
		btnLogoff.setContentAreaFilled(false);
		btnLogoff.setFocusPainted(false);
		btnLogoff.setOpaque(false);
		contentPane.add(btnLogoff);
		
		btnVet = new JButton("Veterin\u00E1rio");
		btnVet.setIcon(new ImageIcon(Menu.class.getResource("/imagens/vet.png")));
		btnVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContatoVeterinario cvt = new ContatoVeterinario();
				cvt.setVisible(true);
				dispose();
			}
		});
		btnVet.setBounds(566, 323, 77, 76);
		btnVet.setBorderPainted(false);
		btnVet.setContentAreaFilled(false);
		btnVet.setOpaque(false);
		btnVet.setFocusPainted(false);
		contentPane.add(btnVet);
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setForeground(new Color(0, 0, 0));
		lblLoja.setBounds(114, 244, 37, 22);
		contentPane.add(lblLoja);
		lblLoja.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		
		btnPetShop.setBounds(248, 142, 136, 103);
		btnPetShop.setBorderPainted(false);
		btnPetShop.setContentAreaFilled(false);
		btnPetShop.setFocusPainted(false);
		btnPetShop.setOpaque(false);
		contentPane.add(btnPetShop);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/imagens/183189-128(1).png")));
		lblNewLabel_1.setBounds(22, 328, 47, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblMenu.setBounds(266, 34, 186, 65);
		contentPane.add(lblMenu);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage.png")));
		label.setBounds(258, 129, 138, 135);
		contentPane.add(label);
		
		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio");
		lblVeterinrio.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblVeterinrio.setBounds(561, 305, 77, 22);
		contentPane.add(lblVeterinrio);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setForeground(new Color(0, 0, 0));
		lblPetShop.setBounds(296, 246, 75, 22);
		contentPane.add(lblPetShop);
		lblPetShop.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		btnLoja.setBounds(70, 142, 132, 103);
		btnLoja.setBorderPainted(false);
		btnLoja.setContentAreaFilled(false);
		btnLoja.setFocusPainted(false);
		btnLoja.setOpaque(false);
		contentPane.add(btnLoja);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage (1).png")));
		lblNewLabel.setBounds(69, 129, 138, 135);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdoo = new JLabel("Ado\u00E7\u00E3o");
		lblAdoo.setBounds(494, 244, 65, 22);
		contentPane.add(lblAdoo);
		lblAdoo.setForeground(new Color(0, 0, 0));
		lblAdoo.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnAdocao.setBounds(473, 147, 105, 98);
		btnAdocao.setBorderPainted(false);
		btnAdocao.setContentAreaFilled(false);
		btnAdocao.setFocusPainted(false);
		btnAdocao.setOpaque(false);
		contentPane.add(btnAdocao);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage (2).png")));
		label_1.setBounds(463, 129, 138, 135);
		contentPane.add(label_1);
		
		JLabel cachorro = new JLabel("New label");
		cachorro.setIcon(new ImageIcon(Menu.class.getResource("/imagens/dog(1).png")));
		cachorro.setBounds(168, 84, 329, 309);
		contentPane.add(cachorro);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Background.jpg")));
		lblBackground.setBounds(0, 0, 664, 440);
		contentPane.add(lblBackground);
	}
}
