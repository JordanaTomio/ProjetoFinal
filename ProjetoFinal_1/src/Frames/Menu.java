package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnAdocao = new JButton("botao");
		btnAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetAdotar pea = new PetAdotar();
				pea.setVisible(true);
				dispose();
			}
		});
		
		JButton btnLoja = new JButton("lojaaaa");
		btnLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetShopMenu psm = new PetShopMenu();
				psm.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPetShop = new JButton("pet shooop\r\n");
		btnPetShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnPetShop.setBounds(256, 142, 136, 103);
		btnPetShop.setBorderPainted(false);
		btnPetShop.setContentAreaFilled(false);
		btnPetShop.setFocusPainted(false);
		btnPetShop.setOpaque(false);
		contentPane.add(btnPetShop);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage.png")));
		label.setBounds(254, 129, 138, 135);
		contentPane.add(label);
		btnLoja.setBounds(75, 142, 132, 103);
		btnLoja.setBorderPainted(false);
		btnLoja.setContentAreaFilled(false);
		btnLoja.setFocusPainted(false);
		btnLoja.setOpaque(false);
		contentPane.add(btnLoja);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage (1).png")));
		lblNewLabel.setBounds(69, 129, 138, 135);
		contentPane.add(lblNewLabel);

		btnAdocao.setBounds(478, 147, 105, 98);
		btnAdocao.setBorderPainted(false);
		btnAdocao.setContentAreaFilled(false);
		btnAdocao.setFocusPainted(false);
		btnAdocao.setOpaque(false);
		contentPane.add(btnAdocao);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Webp.net-resizeimage (2).png")));
		label_1.setBounds(463, 129, 138, 135);
		contentPane.add(label_1);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(Menu.class.getResource("/imagens/Background.jpg")));
		lblBackground.setBounds(0, 0, 642, 393);
		contentPane.add(lblBackground);
	}
}
