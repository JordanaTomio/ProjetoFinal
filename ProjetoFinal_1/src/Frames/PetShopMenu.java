package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetShopMenu extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetShopMenu frame = new PetShopMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PetShopMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877017-128(1).png")));
		label_1.setBounds(461, 148, 140, 135);
		contentPane.add(label_1);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 345, 40, 45);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setOpaque(false);
		contentPane.add(btnVoltar);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalizarPedido frp = new FinalizarPedido();
				frp.setVisible(true);
				dispose();
			}
		});
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(38, 141, 154, 142);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel_2.setBounds(10, 345, 40, 45);
		contentPane.add(lblNewLabel_2);
		
		JButton btnLoja = new JButton("");
		btnLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProdutos crp = new ConsultarProdutos();
				crp.setVisible(true);
				dispose();
			}
		});
		btnLoja.setBounds(234, 144, 154, 142);
		btnLoja.setBorderPainted(false);
		btnLoja.setContentAreaFilled(false);
		btnLoja.setFocusPainted(false);
		btnLoja.setOpaque(false);
		contentPane.add(btnLoja);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877020-128-2-.png")));
		label.setBounds(248, 148, 140, 135);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877015-128-2-.png")));
		lblNewLabel_1.setBounds(40, 148, 140, 135);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblPetShop.setBounds(255, 30, 154, 57);
		contentPane.add(lblPetShop);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}

}
