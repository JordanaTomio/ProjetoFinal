package FramesDE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Beans.Produto;
import DAO.ProdutoDAO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;



public class CadastrarProdutoDE extends JFrame {

	private static final long serialVersionUID = -5472934021092490724L;
	
	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtEstoque;
	private JTextField txtDesc;
	private JTextField txtNome;
	private JTextField txtUnidade;
	private JFormattedTextField txtValidade;
	private MaskFormatter validar;
	
	public CadastrarProdutoDE() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarProdutoDE.class.getResource("/imagens/3775232-16.png")));
		setTitle("Produktregistrierung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmDE adm = new AdmDE();
				adm.setVisible(true);
				dispose();
			}
		});
		try{
			validar = new MaskFormatter("####/##/##");
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		txtValidade = new JFormattedTextField(validar);
		txtValidade.setBounds(495, 251, 116, 20);
		contentPane.add(txtValidade);
		btnVoltar.setBounds(20, 331, 37, 59);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBorderPainted(false);
		contentPane.add(btnVoltar);

		JLabel lblNome = new JLabel("Name:");
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblNome.setBounds(34, 105, 69, 23);
		contentPane.add(lblNome);

		JLabel lblDescrio = new JLabel("Beschreibung:");
		lblDescrio.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblDescrio.setBounds(11, 173, 126, 24);
		contentPane.add(lblDescrio);

		JLabel lblValor = new JLabel("Wert:");
		lblValor.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValor.setBounds(399, 115, 62, 14);
		contentPane.add(lblValor);

		JLabel lblValidade = new JLabel("G\u00FCltigkeit:");
		lblValidade.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValidade.setBounds(398, 246, 92, 24);
		contentPane.add(lblValidade);

		JLabel lblEstoque = new JLabel("Vorr\u00E4tig:");
		lblEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblEstoque.setBounds(398, 176, 92, 23);
		contentPane.add(lblEstoque);
		
		JLabel lblCadastroDeProdutos = new JLabel("Produktregistrierung");
		lblCadastroDeProdutos.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblCadastroDeProdutos.setBounds(151, 11, 416, 68);
		contentPane.add(lblCadastroDeProdutos);
		
		JLabel unidade_1 = new JLabel("Einheit:");
		unidade_1.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		unidade_1.setBounds(34, 247, 103, 23);
		contentPane.add(unidade_1);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(CadastrarProdutoDE.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(20, 331, 40, 59);
		contentPane.add(lblVoltar);
		
		txtEstoque = new JTextField();
		txtEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(521, 178, 72, 20);
		contentPane.add(txtEstoque);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtValor.setColumns(10);
		txtValor.setBounds(522, 113, 71, 20);
		contentPane.add(txtValor);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtDesc.setBounds(146, 152, 185, 68);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(145, 109, 185, 20);
		contentPane.add(txtNome);

		JButton btnCadastrar = new JButton("Registrieren");
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String descricao = txtDesc.getText();
				String valorString = txtValor.getText();
				String unidade = txtUnidade.getText();
				String estoqueString = txtEstoque.getText();
				String validade = txtValidade.getText();
			//	String mes = txtMes.getText();
			//	String ano = txtAno.getText();

			//	String data = ano + "-" + mes + "-" + dia;

				if (valorString.contains(",")) {
					valorString = valorString.replace(",", ".");
				} else {
					
				}
				
				
				double valor = Double.parseDouble(valorString);
				int estoque = Integer.parseInt(estoqueString);

				if (!(nome.isEmpty() && valorString.isEmpty() && unidade.isEmpty() && estoqueString.isEmpty()
						&& validade.isEmpty()/* && mes.isEmpty() && ano.isEmpty()*/)) {
					// Cria e salva o produto.
					Produto produto = new Produto(nome, descricao, valor, unidade, validade, estoque);
					ProdutoDAO.save(produto);

					// Limpa campos
					txtNome.setText("");
					txtDesc.setText("");
					txtValor.setText("");
					txtUnidade.setText("");
					txtEstoque.setText("");
					txtValidade.setText("");
			//		txtMes.setText("");
			//		txtAno.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Fehlende Informationen. "," Registrierungsfehler", 1);
				}
			}
		});
		btnCadastrar.setForeground(new Color(0, 100, 0));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnCadastrar.setBounds(236, 324, 174, 23);
		contentPane.add(btnCadastrar);

		txtUnidade = new JTextField();
		txtUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(147, 249, 181, 20);
		contentPane.add(txtUnidade);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(CadastrarProdutoDE.class.getResource("/imagens/Background.jpg")));
		Background.setBounds(0, 0, 654, 411);
		contentPane.add(Background);
	}
}
