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

public class Adm extends JFrame {

	private JPanel contentPane;

	/**
	 * Frame que abre uma aba exclusiva para administradores que tenham acesso.
	 */
	
	public Adm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adm.class.getResource("/imagens/3775232-16.png")));
		setTitle("Administração");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mnu = new Menu();
				mnu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(14, 345, 55, 56);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		contentPane.add(btnVoltar);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(Adm.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(20, 344, 53, 56);
		contentPane.add(lblVoltar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.setOpaque(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarClientes cnc = new ConsultarClientes();
				cnc.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(487, 147, 141, 135);

		contentPane.add(btnConsultar);
		
		JLabel lblClientes = new JLabel("New label");
		lblClientes.setIcon(new ImageIcon(Adm.class.getResource("/imagens/877017-128(1).png")));
		lblClientes.setBounds(488, 143, 137, 144);
		contentPane.add(lblClientes);
		
		JLabel lblConsultarClientes = new JLabel("Consultar Clientes");
		lblConsultarClientes.setToolTipText("");
		lblConsultarClientes.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblConsultarClientes.setBounds(495, 276, 131, 45);
		contentPane.add(lblConsultarClientes);
		
		JLabel lblCadastrar = new JLabel("Cadastrar Produtos");
		lblCadastrar.setToolTipText("");
		lblCadastrar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCadastrar.setBounds(46, 275, 141, 45);
		contentPane.add(lblCadastrar);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto cdp = new CadastrarProduto();
				cdp.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setOpaque(false);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFocusPainted(false);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarProduto alp = new AlterarProduto();
				alp.setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(270, 147, 141, 135);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setOpaque(false);
		btnAlterar.setFocusPainted(false);
		contentPane.add(btnAlterar);
		btnCadastrar.setBounds(47, 148, 141, 135);
		contentPane.add(btnCadastrar);
		
		JLabel lblAdministrao = new JLabel("Administração");
		lblAdministrao.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblAdministrao.setBounds(215, 24, 281, 68);
		contentPane.add(lblAdministrao);
		
		JLabel lblAlterar = new JLabel("New label");
		lblAlterar.setIcon(new ImageIcon(Adm.class.getResource("/imagens/877015-128-2-.png")));
		lblAlterar.setBounds(270, 143, 137, 144);
		contentPane.add(lblAlterar);
		
		JLabel lblAlterarProdutos = new JLabel("Alterar Produtos");
		lblAlterarProdutos.setToolTipText("");
		lblAlterarProdutos.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblAlterarProdutos.setBounds(283, 275, 131, 45);
		contentPane.add(lblAlterarProdutos);
		
		JLabel lblCadastroProdutos = new JLabel("New label");
		lblCadastrar.setLabelFor(lblCadastroProdutos);
		lblCadastroProdutos.setIcon(new ImageIcon(Adm.class.getResource("/imagens/877020-128-2-.png")));
		lblCadastroProdutos.setBounds(45, 143, 137, 144);
		contentPane.add(lblCadastroProdutos);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(Adm.class.getResource("/imagens/Background.jpg")));
		Background.setBounds(0, 0, 654, 411);
		contentPane.add(Background);
	}

}
