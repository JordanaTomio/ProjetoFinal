package Frames;

import java.awt.Color;
import java.awt.Font;
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
import java.text.DecimalFormat;

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

	private static final long serialVersionUID = 6415911970193186182L;

	private JPanel contentPane;
	private JTextField txtNome;
	private JScrollPane tblProdutos;
	private JTable table;
	private JComboBox comboBox;
	public static String ValoresTotaisString;
	public double ValoresTotais;

	/**
	 * Create the frame.
	 */
	public ConsultarProdutos() {
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (comboBox.getItemCount() > 0) {
					String item = comboBox.getSelectedItem().toString();

					ResultSet rsValorTotal = PeedidoDAO.getPedidosItems(Integer.parseInt(item));
					double valorTotalPedido = 0;
					try {
						while (rsValorTotal.next()) {
							valorTotalPedido += rsValorTotal.getDouble("VL_Produto");
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
		lblNome.setBounds(177, 89, 65, 22);
		lblNome.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(254, 88, 206, 20);
		txtNome.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ResultSet rs = PeedidoDAO.findAllToTable();
				//tabela aquiiiiiiiiiiiiiiiiiiiiiii
			}
		});
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String nomeProduto = txtNome.getText();

				ResultSet rs = PeedidoDAO.findByNameToTable(nomeProduto);
				//tabelaaaaaaaaaaaa
			}
		});
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblPesquisarProdutos = new JLabel("Pesquisar Produtos");
		lblPesquisarProdutos.setBounds(165, 11, 348, 54);
		lblPesquisarProdutos.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		contentPane.add(lblPesquisarProdutos);

		tblProdutos = new JScrollPane();
		tblProdutos.setBounds(122, 161, 380, 157);
		contentPane.add(tblProdutos);

		table = new JTable();
		tblProdutos.setViewportView(table);
		table.setBackground(new Color(255, 240, 245));

		JButton btnSair = new JButton("Voltar");
		btnSair.setBounds(426, 343, 100, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PetShopMenu().setVisible(true);
				dispose();
			}
		});
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnSair.setBackground(new Color(255, 240, 245));
		contentPane.add(btnSair);

		JButton button = new JButton("+");
		button.setBounds(512, 138, 44, 35);
		button.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(255, 240, 245));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() > 0) {
					String nomeProduto = null;
					try {
						nomeProduto = (String) table.getValueAt(table.getSelectedRow(), 1);
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro!", 1);
					}
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
				}
			}
		});
		contentPane.add(button);

		JButton btnNovoPedido = new JButton("Novo pedido");
		btnNovoPedido.setBounds(100, 343, 144, 23);
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedido pedido = new Pedido(0, Main.cliente.getCdCodigo());
				PeedidoDAO.save(pedido);
			}
		});
		btnNovoPedido.setForeground(Color.BLACK);
		btnNovoPedido.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnNovoPedido.setBackground(new Color(255, 240, 245));
		contentPane.add(btnNovoPedido);

		comboBox = new JComboBox();
		comboBox.setBounds(254, 116, 206, 20);
		comboBox.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		comboBox.addFocusListener(new FocusAdapter() {
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
		contentPane.add(comboBox);

		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(177, 114, 122, 22);
		lblPedido.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		contentPane.add(lblPedido);
		
		JLabel back = new JLabel("New label");
		back.setBounds(0, 0, 643, 401);
		contentPane.add(back);
		back.setIcon(new ImageIcon(ConsultarProdutos.class.getResource("/imagens/Background.jpg")));
	}
}
