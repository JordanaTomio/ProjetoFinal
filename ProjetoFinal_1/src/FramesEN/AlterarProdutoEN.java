package FramesEN;

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
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.ProdutoDAO;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import java.awt.Cursor;

public class AlterarProdutoEN extends JFrame {

	private static final long serialVersionUID = 8419457666179579366L;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDesc;
	private JTextField txtValor;
	private JTextField txtEstoque;
	private JTextField txtUnidade;
	private JFormattedTextField txtValidade;
	private MaskFormatter validade;

	/**
	 * Frame para alterar detalhes de produtos já cadastrados no DB.
	 */
	public AlterarProdutoEN() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlterarProdutoEN.class.getResource("/imagens/3775232-16.png")));
		setTitle("Products Alteration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			validade = new MaskFormatter("####-##-##");
		} catch (ParseException el) {
			el.printStackTrace();
		}

		txtValidade = new JFormattedTextField(validade);
		txtValidade.setBounds(530, 262, 107, 20);
		contentPane.add(txtValidade);

		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			
			//Add os produtos na combo box
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
		
		//Seta as informaçoes do produto
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
							validade = rs.getString("DT_Validade");

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					txtNome.setText(nome);
					txtDesc.setText(descricao);
					txtValor.setText(valor);
					txtEstoque.setText(estoque);
					txtUnidade.setText(unidade);
					txtValidade.setText(validade);
				}
			}
		});

		comboBox.setBackground(new Color(255, 240, 245));
		comboBox.setBounds(148, 64, 332, 30);
		contentPane.add(comboBox);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblName.setBounds(10, 142, 69, 23);
		contentPane.add(lblName);

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

		JLabel lblDescricao = new JLabel("Description:");
		lblDescricao.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblDescricao.setBounds(10, 198, 107, 30);
		contentPane.add(lblDescricao);

		JLabel lblValor = new JLabel("Value:");
		lblValor.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValor.setBounds(368, 146, 62, 14);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtValor.setColumns(10);
		txtValor.setBounds(484, 141, 62, 20);
		contentPane.add(txtValor);

		JLabel lblValidade = new JLabel("Expiration date:");
		lblValidade.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblValidade.setBounds(368, 258, 152, 22);
		contentPane.add(lblValidade);

		JLabel lblEstoque = new JLabel("Stock:");
		lblEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblEstoque.setBounds(368, 202, 92, 23);
		contentPane.add(lblEstoque);

		txtEstoque = new JTextField();
		txtEstoque.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(484, 198, 62, 20);
		contentPane.add(txtEstoque);

		JButton btnAlterar = new JButton("Alter");
		btnAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAlterar.addActionListener(new ActionListener() {
			
			//Faz a atualizacao no database
			public void actionPerformed(ActionEvent arg0) {
				String item = comboBox.getSelectedItem().toString();
				String itens[] = item.split(" - ");

				int cdCodigo = Integer.parseInt(itens[0]);

				String nome = txtNome.getText();
				String descricao = txtDesc.getText();
				String valorString = txtValor.getText();
				String estoqueString = txtEstoque.getText();
				String unidade = txtUnidade.getText();
				String validade = txtValidade.getText();

				if (valorString.contains(",")) {
					valorString = valorString.replace(",", ".");
				} else {

				}
				double valor = Double.parseDouble(valorString);
				int estoque = Integer.parseInt(estoqueString);

				ProdutoDAO.update(cdCodigo, nome, descricao, valor, unidade, validade, estoque);
				JOptionPane.showMessageDialog(null, "Successfully altered!", "Confirmation", 1);
			}
		});

		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmEN adm = new AdmEN();
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

		JLabel lblUnidade = new JLabel("Unit:");
		lblUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblUnidade.setBounds(10, 265, 92, 14);
		contentPane.add(lblUnidade);

		JLabel lblNewLabel = new JLabel("Products Alteration");
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(148, 11, 354, 61);
		contentPane.add(lblNewLabel);

		txtUnidade = new JTextField();
		txtUnidade.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(137, 264, 189, 20);
		contentPane.add(txtUnidade);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AlterarProdutoEN.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel_1.setBounds(14, 344, 55, 45);
		contentPane.add(lblNewLabel_1);

		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon(AlterarProdutoEN.class.getResource("/imagens/Background.jpg")));
		Background.setBounds(0, 1, 654, 410);
		contentPane.add(Background);
	}
}
