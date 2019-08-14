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
		setLocationRelativeTo(null);
		
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
				ConsultarPedidos frp = new ConsultarPedidos();
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
		
		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil pfl = new Perfil();
				pfl.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setBounds(461, 148, 140, 135);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setOpaque(false);
		contentPane.add(btnPerfil);
		
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
		
		JLabel lblCarrinho = new JLabel("Pedidos");
		lblCarrinho.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblCarrinho.setBounds(76, 118, 75, 25);
		contentPane.add(lblCarrinho);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877017-128(1).png")));
		label_1.setBounds(461, 148, 140, 135);
		contentPane.add(label_1);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblProdutos.setBounds(281, 112, 75, 33);
		contentPane.add(lblProdutos);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblPerfil.setBounds(508, 103, 48, 45);
		contentPane.add(lblPerfil);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel_2.setBounds(10, 345, 40, 45);
		contentPane.add(lblNewLabel_2);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/302817012222211(1).png")));
		lblNewLabel_3.setBounds(101, 41, 461, 318);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}
}
