package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Beans.Produto;
import DAO.ProdutoDAO;
import javax.swing.ImageIcon;



public class CadastrarProduto extends JFrame {

	private static final long serialVersionUID = -5472934021092490724L;
	
	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtDia;
	private JTextField txtEstoque;
	private JTextField txtDesc;
	private JTextField txtNome;
	private JTextField txtMes;
	private JTextField txtAno;
	private JTextField txtUnidade;

	public CadastrarProduto() {
		setTitle("Cadastro de Produtos");
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adm adm = new Adm();
				adm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(20, 331, 37, 59);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBorderPainted(false);
		contentPane.add(btnVoltar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblNome.setBounds(49, 99, 69, 23);
		contentPane.add(lblNome);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblDescrio.setBounds(49, 146, 92, 17);
		contentPane.add(lblDescrio);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValor.setBounds(414, 109, 62, 14);
		contentPane.add(lblValor);

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValidade.setBounds(413, 240, 87, 24);
		contentPane.add(lblValidade);

		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblEstoque.setBounds(413, 170, 92, 23);
		contentPane.add(lblEstoque);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblCadastroDeProdutos.setBounds(151, 11, 416, 68);
		contentPane.add(lblCadastroDeProdutos);
		
				JLabel unidade_1 = new JLabel("Unidade:");
				unidade_1.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
				unidade_1.setBounds(49, 241, 103, 23);
				contentPane.add(unidade_1);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(20, 331, 40, 59);
		contentPane.add(lblVoltar);
		
				txtEstoque = new JTextField();
				txtEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
				txtEstoque.setColumns(10);
				txtEstoque.setBounds(536, 172, 72, 20);
				contentPane.add(txtEstoque);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtValor.setColumns(10);
		txtValor.setBounds(537, 107, 71, 20);
		contentPane.add(txtValor);

		txtDia = new JTextField();
		txtDia.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtDia.setColumns(10);
		txtDia.setBounds(510, 242, 27, 22);
		contentPane.add(txtDia);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtDesc.setBounds(161, 146, 185, 68);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(160, 103, 185, 20);
		contentPane.add(txtNome);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String descricao = txtDesc.getText();
				String valorString = txtValor.getText();
				String unidade = txtUnidade.getText();
				String estoqueString = txtEstoque.getText();
				String dia = txtDia.getText();
				String mes = txtMes.getText();
				String ano = txtAno.getText();

				String data = ano + "-" + mes + "-" + dia;

				if (valorString.contains(",")) {
					valorString = valorString.replace(",", ".");
				} else {
					
				}
				
				
				double valor = Double.parseDouble(valorString);
				int estoque = Integer.parseInt(estoqueString);

				if (!(nome.isEmpty() && valorString.isEmpty() && unidade.isEmpty() && estoqueString.isEmpty()
						&& dia.isEmpty() && mes.isEmpty() && ano.isEmpty())) {
					// Cria e salva o produto.
					Produto produto = new Produto(nome, descricao, valor, unidade, data, estoque);
					ProdutoDAO.save(produto);

					// Limpa campos
					txtNome.setText("");
					txtDesc.setText("");
					txtValor.setText("");
					txtUnidade.setText("");
					txtEstoque.setText("");
					txtDia.setText("");
					txtMes.setText("");
					txtAno.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Informações faltando.", "Erro no cadastro", 1);
				}
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnCadastrar.setBounds(294, 316, 174, 23);
		contentPane.add(btnCadastrar);

		txtMes = new JTextField();
		txtMes.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtMes.setColumns(10);
		txtMes.setBounds(550, 242, 27, 22);
		contentPane.add(txtMes);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtAno.setColumns(10);
		txtAno.setBounds(589, 242, 27, 22);
		contentPane.add(txtAno);

		txtUnidade = new JTextField();
		txtUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(162, 243, 181, 20);
		contentPane.add(txtUnidade);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/imagens/Background.jpg")));
		Background.setBounds(0, 0, 654, 411);
		contentPane.add(Background);
	}
}
