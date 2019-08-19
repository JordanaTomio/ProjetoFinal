package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.border.EmptyBorder;

import DAO.ItemsDAO;
import DAO.PeedidoDAO;
import net.proteanit.sql.DbUtils;

public class ConsultarPedidos extends JFrame {

	private static final long serialVersionUID = -1830098794526254168L;

	

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTable table;
	private JLabel lblValorTotalValue;
	public static String ValorTotal;
	public static String ValorTotalRd;
	public static String ValoresTotaisString = null;
	public static String[] pedido;

	/**
	 * Create the frame.
	 */
	public ConsultarPedidos() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(comboBox.getItemCount() > 0) {
					String item = comboBox.getSelectedItem().toString();
					String itens[] = item.split(": ");
					pedido = itens;
					ResultSet rsValoTotal = PeedidoDAO.getPedidosItems(Integer.parseInt(itens[1]));
					double valorTotalPedido = 0;
					try {
						while (rsValoTotal.next()) {
							valorTotalPedido += rsValoTotal.getDouble("VL_Produto");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					PeedidoDAO.updateValorTotal(Integer.parseInt(itens[1]), valorTotalPedido);
					lblValorTotalValue.setText(valorTotalPedido + "");
					String ValorS = lblValorTotalValue.getText();
					ValorTotal = ValorS;
					ValorTotalRd = df.format(valorTotalPedido);
					ValoresTotaisString = ValorS;
					
				}
			}
		});
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FinalizarPedido().setVisible(true);
				dispose();
			}
		});
		btnFinalizar.setForeground(new Color(0, 0, 0));
		btnFinalizar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnFinalizar.setBackground(new Color(255, 255, 255));
		btnFinalizar.setBounds(269, 315, 110, 23);
		contentPane.add(btnFinalizar);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PetShopMenu().setVisible(true);
				dispose();
			}
		});
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnSair.setBackground(new Color(255, 240, 245));
		btnSair.setBorderPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setFocusPainted(false);
		btnSair.setOpaque(false);
		btnSair.setBounds(10, 337, 53, 53);
		contentPane.add(btnSair);
		

		JScrollPane tblProdutos = new JScrollPane();
		tblProdutos.setBounds(112, 117, 416, 187);
		contentPane.add(tblProdutos);

		table = new JTable();
		tblProdutos.setViewportView(table);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getItemCount() > 0) {
					String item = comboBox.getSelectedItem().toString();
					String itens[] = item.split(": ");

					ResultSet rs = PeedidoDAO.getPedidosItems(Integer.parseInt(itens[1]));
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			}
		});
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBox.removeAllItems();
				ResultSet rs = PeedidoDAO.getAllPedidosFromCliente(Main.cliente.getCdCodigo());

				int cdPedido;

				try {
					while (rs.next()) {
						cdPedido = rs.getInt("CD_Pedido");
						comboBox.addItem("Pedido: " + cdPedido);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultarPedidos.class.getResource("/imagens/3209260-128(1).png")));
		lblNewLabel.setBounds(14, 337, 53, 53);
		contentPane.add(lblNewLabel);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(113, 72, 183, 25);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("-");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() > 0) {
					String nomeProduto = null;
					try {
						nomeProduto = (String) table.getValueAt(table.getSelectedRow(), 0);
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Erro!", 1);
					}
					ResultSet rs = PeedidoDAO.findByName(nomeProduto);

					int idProduto = 0;
					int numEstoque = 0;
					try {
						if (rs.next()) {
							idProduto = rs.getInt("CD_Produto");
							numEstoque = rs.getInt("QT_Estoque_Produto");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					if (comboBox.getItemCount() > 0) {
						String item = comboBox.getSelectedItem().toString();
						String itens[] = item.split(": ");

						int idPedido = Integer.parseInt(itens[1]);

						ItemsDAO.remove(idPedido, idProduto);
						JOptionPane.showMessageDialog(null, "Item removido com sucesso.", "Sucesso!", 1);
						PeedidoDAO.addIntoEstoque(idProduto, numEstoque);

						if (comboBox.getItemCount() > 0) {

							ResultSet rsPedidos = PeedidoDAO.getPedidosItems(Integer.parseInt(itens[1]));
							table.setModel(DbUtils.resultSetToTableModel(rsPedidos));
						}
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		btnNewButton.setBounds(538, 119, 42, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblCarrinho.setBounds(226, 11, 237, 50);
		contentPane.add(lblCarrinho);

		JLabel lblValorTotal = new JLabel("Valor Total: R$");
		lblValorTotal.setForeground(new Color(0, 0, 0));
		lblValorTotal.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblValorTotal.setBounds(331, 77, 181, 20);
		contentPane.add(lblValorTotal);

		lblValorTotalValue = new JLabel(" ");
		lblValorTotalValue.setForeground(new Color(0, 0, 0));
		lblValorTotalValue.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblValorTotalValue.setBounds(487, 76, 90, 20);
		contentPane.add(lblValorTotalValue);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(ConsultarPedidos.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 440);
		contentPane.add(background);
	}
}
