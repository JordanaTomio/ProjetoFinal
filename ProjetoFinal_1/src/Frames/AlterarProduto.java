package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.ProdutoDAO;

public class AlterarProduto extends JFrame {

	private static final long serialVersionUID = 8419457666179579366L;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDesc;
	private JTextField txtValor;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAno;
	private JTextField txtEstoque;
	private JTextField txtUnidade;

	/**
	 * Create the frame.
	 */
	public AlterarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBox.removeAllItems();
				ResultSet rs = ProdutoDAO.findAll();

				try {
					while (rs.next()) {
						int cdCodigo = rs.getInt("CD_Produto");
						String nome = rs.getString("NM_Produto");
						comboBox.addItem(cdCodigo + " - " + nome);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getItemCount() > 0) {
					String item = comboBox.getSelectedItem().toString();
					String itens[] = item.split(" - ");

					ResultSet rs = ProdutoDAO.findById(Integer.parseInt(itens[0]));
					String nome = null;
					String descricao = null;
					String valor = null;
					String estoque = null;
					String unidade = null;
					String validade = null;
					try {
						if (rs.next()) {
							nome = rs.getString("NM_Produto");
							descricao = rs.getString("DS_Produto");
							valor = rs.getString("VL_Produto");
							unidade = rs.getString("UND_Produto");
							estoque = rs.getString("QT_Estoque_Produto");
							try {
								validade = rs.getString("DT_Validade");
							} catch (SQLException e) {
								validade = "0000-00-00";
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					String data[] = validade.split("-");

					txtNome.setText(nome);
					txtDesc.setText(descricao);
					txtValor.setText(valor);
					txtEstoque.setText(estoque);
					txtUnidade.setText(unidade);
					txtAno.setText(data[0]);
					txtMes.setText(data[1]);
					txtDia.setText(data[2]);
				}
			}
		});
		comboBox.setBackground(new Color(255, 240, 245));
		comboBox.setBounds(148, 64, 332, 30);
		contentPane.add(comboBox);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		label.setBounds(30, 143, 69, 23);
		contentPane.add(label);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(137, 147, 189, 20);
		contentPane.add(txtNome);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtDesc.setColumns(10);
		txtDesc.setBounds(137, 189, 189, 51);
		contentPane.add(txtDesc);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		label_1.setBounds(30, 206, 92, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Valor:");
		label_2.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		label_2.setBounds(394, 142, 62, 14);
		contentPane.add(label_2);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtValor.setColumns(10);
		txtValor.setBounds(484, 141, 62, 20);
		contentPane.add(txtValor);

		JLabel label_3 = new JLabel("Validade:");
		label_3.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		label_3.setBounds(394, 258, 87, 22);
		contentPane.add(label_3);

		txtDia = new JTextField();
		txtDia.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtDia.setColumns(10);
		txtDia.setBounds(484, 260, 27, 20);
		contentPane.add(txtDia);

		txtMes = new JTextField();
		txtMes.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtMes.setColumns(10);
		txtMes.setBounds(524, 260, 27, 20);
		contentPane.add(txtMes);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtAno.setColumns(10);
		txtAno.setBounds(563, 260, 42, 20);
		contentPane.add(txtAno);

		JLabel label_4 = new JLabel("Estoque:");
		label_4.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		label_4.setBounds(394, 196, 92, 23);
		contentPane.add(label_4);

		txtEstoque = new JTextField();
		txtEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(484, 198, 62, 20);
		contentPane.add(txtEstoque);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = comboBox.getSelectedItem().toString();
				String itens[] = item.split(" - ");

				int cdCodigo = Integer.parseInt(itens[0]);

				String nome = txtNome.getText();
				String descricao = txtDesc.getText();
				String valorString = txtValor.getText();
				String estoqueString = txtEstoque.getText();
				String unidade = txtUnidade.getText();
				String ano = txtAno.getText();
				String mes = txtMes.getText();
				String dia = txtDia.getText();

				String data = ano + "-" + mes + "-" + dia;

				if (valorString.contains(",")) {
					valorString = valorString.replace(",", ".");
				} else {
					
				}
				double valor = Double.parseDouble(valorString);
				int estoque = Integer.parseInt(estoqueString);

				ProdutoDAO.update(cdCodigo, nome, descricao, valor, unidade, data, estoque);
			}
		});
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adm adm = new Adm();
				adm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 338, 53, 51);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBorderPainted(false);
		contentPane.add(btnVoltar);
		
		
		
		
		btnAlterar.setBackground(new Color(255, 255, 255));
		btnAlterar.setForeground(new Color(0, 100, 0));
		btnAlterar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnAlterar.setBounds(236, 330, 164, 23);
		contentPane.add(btnAlterar);

		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblUnidade.setBounds(30, 266, 92, 14);
		contentPane.add(lblUnidade);
		
		JLabel lblNewLabel = new JLabel("Alterar Produtos");
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(174, 7, 317, 61);
		contentPane.add(lblNewLabel);

		txtUnidade = new JTextField();
		txtUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(137, 264, 189, 20);
		contentPane.add(txtUnidade);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AlterarProduto.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel_1.setBounds(14, 344, 55, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(AlterarProduto.class.getResource("/imagens/Background.jpg")));
		Background.setBounds(0, 1, 654, 410);
		contentPane.add(Background);
	}
}
