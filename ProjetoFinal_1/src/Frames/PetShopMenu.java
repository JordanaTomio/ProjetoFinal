package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		setTitle("Menu Pet Shop");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PetShopMenu.class.getResource("/imagens/3775232-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		JButton btnPedidos = new JButton("");
		btnPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPedidos frp = new ConsultarPedidos();
				frp.setVisible(true);
				dispose();
			}
		});
		btnPedidos.setOpaque(false);
		btnPedidos.setFocusPainted(false);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBounds(38, 141, 154, 142);
		contentPane.add(btnPedidos);
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnLoja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblProdutos.setBounds(281, 112, 75, 33);
		contentPane.add(lblProdutos);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblPedidos.setBounds(76, 118, 75, 25);
		contentPane.add(lblPedidos);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblPerfil.setBounds(508, 103, 48, 45);
		contentPane.add(lblPerfil);
		
		JLabel Perfil_icon = new JLabel("New label");
		Perfil_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877017-128(1).png")));
		Perfil_icon.setBounds(461, 148, 140, 135);
		contentPane.add(Perfil_icon);
		
		JLabel btnVoltar_icon = new JLabel("New label");
		btnVoltar_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/3209260-128(1).png")));
		btnVoltar_icon.setBounds(10, 345, 40, 45);
		contentPane.add(btnVoltar_icon);
		
		JLabel Produtos_icon = new JLabel("New label");
		Produtos_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877020-128-2-.png")));
		Produtos_icon.setBounds(248, 148, 140, 135);
		contentPane.add(Produtos_icon);
		
		JLabel Pedidos_icon = new JLabel("New label");
		Pedidos_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/877015-128-2-.png")));
		Pedidos_icon.setBounds(40, 148, 140, 135);
		contentPane.add(Pedidos_icon);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblPetShop.setBounds(255, 30, 154, 57);
		contentPane.add(lblPetShop);
		
		JLabel Flor_icon = new JLabel("New label");
		Flor_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/302817012222211(1).png")));
		Flor_icon.setBounds(101, 41, 461, 318);
		contentPane.add(Flor_icon);
		
		JLabel Background_icon = new JLabel("New label");
		Background_icon.setIcon(new ImageIcon(PetShopMenu.class.getResource("/imagens/Background.jpg")));
		Background_icon.setBounds(0, 0, 660, 440);
		contentPane.add(Background_icon);
	}
}
