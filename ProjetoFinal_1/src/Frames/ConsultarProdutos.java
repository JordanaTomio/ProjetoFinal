package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Beans.Items;
import Beans.Pedido;
import DAO.ItemsDAO;
import DAO.PeedidoDAO;

public class ConsultarProdutos extends JFrame {

	//Frame para consultar os itens na loja
	private static final long serialVersionUID = 6415911970193186182L;

	private JPanel contentPane;
	private JTextField txtNome;
	private JScrollPane tblProdutos;
	private JTable table;
	private JComboBox comboBox;

	public ConsultarProdutos() {
		setTitle("Loja");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ConsultarProdutos.class.getResource("/imagens/3775232-16.png")));
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		setResizable(false);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			
			//Seta o valor total no Database
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if (comboBox.getItemCount() > 0) {
					String item = comboBox.getSelectedItem().toString();

					ResultSet rsValoTotal = PeedidoDAO.getPedidosItems(Integer.parseInt(item));
					double valorTotalPedido = 0;
					try {
						if (rsValoTotal.next()) {
							valorTotalPedido += rsValoTotal.getDouble("Valor");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					PeedidoDAO.updateValorTotal(Integer.parseInt(item), valorTotalPedido);
				}
			}
		});
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblNome.setBounds(185, 85, 65, 25);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		txtNome.addFocusListener(new FocusAdapter() {
			
			//Seta a tabela puxando do Database
			
			@Override
			public void focusGained(FocusEvent e) {
				ResultSet rs = PeedidoDAO.findAllToTable();
				table.setModel(Utilis.DbUtils.resultSetTable(rs));
			}
		});
		txtNome.addKeyListener(new KeyAdapter() {
			
			//Faz a pesquisa na tabela utilizando o Database
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				String nomeProduto = txtNome.getText();

				ResultSet rs = PeedidoDAO.findByNameToTable(nomeProduto);
				table.setModel(Utilis.DbUtils.resultSetTable(rs));
			}
		});
		txtNome.setBounds(265, 87, 200, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		tblProdutos = new JScrollPane();
		tblProdutos.setBounds(135, 170, 378, 157);
		contentPane.add(tblProdutos);

		table = new JTable();
		tblProdutos.setViewportView(table);
		table.setBackground(new Color(255, 240, 245));

		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblConsultar.setBounds(240, 16, 216, 61);
		contentPane.add(lblConsultar);

		JButton Carrinho = new JButton("Carrinho");
		Carrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Carrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPedidos cpd = new ConsultarPedidos();
				cpd.setVisible(true);
				dispose();
			}
		});

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PetShopMenu().setVisible(true);
				dispose();
			}
		});
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnSair.setBackground(new Color(255, 240, 245));
		btnSair.setBorderPainted(false);
		btnSair.setFocusPainted(false);
		btnSair.setOpaque(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setBounds(8, 336, 51, 50);
		contentPane.add(btnSair);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultarProdutos.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel.setBounds(12, 336, 59, 55);
		contentPane.add(lblNewLabel);
		Carrinho.setForeground(new Color(0, 100, 0));
		Carrinho.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		Carrinho.setBackground(new Color(255, 255, 255));
		Carrinho.setBounds(155, 340, 135, 23);
		contentPane.add(Carrinho);

		JButton button = new JButton("+");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		button.setForeground(new Color(0, 100, 0));
		button.setBackground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			
			//confere se pode ser Adicionado o item e o adiciona
			
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() > 0) {
					String nomeProduto = null;
					try {
						nomeProduto = (String) table.getValueAt(table.getSelectedRow(), 1);
						ResultSet rs = PeedidoDAO.findByName(nomeProduto);

						int cdCodigo = 0;
						int numEstoque = 0;
						try {
							if (rs.next()) {
								cdCodigo = rs.getInt("CD_Produto");
								numEstoque = rs.getInt("QT_Estoque_Produto");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

						if (comboBox.getItemCount() > 0) {
							if (numEstoque >= 1) {
								String cdCodigoPedidoString = comboBox.getSelectedItem().toString();
								int cdPedido = Integer.parseInt(cdCodigoPedidoString);
								Items item = new Items(cdPedido, cdCodigo);
								ItemsDAO.save(item);
								JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!", "Sucesso!", 1);
								PeedidoDAO.removeFromEstoque(cdCodigo, numEstoque);
							} else {
								JOptionPane.showMessageDialog(null, "Item em falta!", "Falta de estoque!", 1);
							}
						}
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro!", 1);
					}

				}
			}
		});
		button.setBounds(523, 170, 44, 35);
		contentPane.add(button);

		JButton btnNovoPedido = new JButton("Novo pedido");
		btnNovoPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoPedido.addActionListener(new ActionListener() {
		
			//cria um novo pedido
			
			public void actionPerformed(ActionEvent arg0) {
				Pedido pedido = new Pedido(0, Main.cliente.getCdCodigo());
				PeedidoDAO.save(pedido);
			}
		});
		btnNovoPedido.setForeground(new Color(0, 100, 0));
		btnNovoPedido.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnNovoPedido.setBackground(new Color(255, 255, 255));
		btnNovoPedido.setBounds(355, 340, 135, 23);
		contentPane.add(btnNovoPedido);

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		comboBox.addFocusListener(new FocusAdapter() {
			
			//seta os pedidos na combobox
			
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBox.removeAllItems();
				ResultSet rs = PeedidoDAO.getAllPedidosFromCliente(Main.cliente.getCdCodigo());

				int cdCodigo = 0;
				try {
					while (rs.next()) {
						cdCodigo = rs.getInt("CD_Pedido");
						comboBox.addItem(cdCodigo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		comboBox.setBounds(265, 127, 200, 20);
		contentPane.add(comboBox);

		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblPedido.setBounds(185, 120, 80, 30);
		contentPane.add(lblPedido);

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(ConsultarProdutos.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 440);
		contentPane.add(background);
	}
}
