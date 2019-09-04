package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import DAO.PeedidoDAO;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FinalizarPedido extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton x3 = new JRadioButton("3x");
	JRadioButton x2 = new JRadioButton("2x");
	JLabel desconto = new JLabel("15% de desconto!");
	JLabel totalFinal = new JLabel("  ");
	String lbl = ConsultarPedidos.ValoresTotaisString;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarPedido frame = new FinalizarPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinalizarPedido() {
		setTitle("Finaliza��o");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FinalizarPedido.class.getResource("/imagens/3775232-16.png")));
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
			
		
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PetShopMenu psm = new PetShopMenu();
				psm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 308, 68, 69);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);
		
		JLabel lblSeuTotal = new JLabel("Seu total � de R$");
		lblSeuTotal.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblSeuTotal.setBounds(194, 100, 179, 26);
		contentPane.add(lblSeuTotal);
		
		JLabel total = new JLabel("");
		total.setForeground(new Color(0, 100, 0));
		total.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		total.setBounds(364, 100, 95, 24);
		String lbl = ConsultarPedidos.ValoresTotaisString;
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setIcon(new ImageIcon(FinalizarPedido.class.getResource("/imagens/3209260-128(1).png")));
		lblVoltar.setBounds(19, 308, 53, 69);
		contentPane.add(lblVoltar);
		total.setText(ConsultarPedidos.ValoresTotaisString);
		contentPane.add(total);
		
		JLabel lblSelecioneOMtodo = new JLabel("Selecione o m�todo de pagamento:");
		lblSelecioneOMtodo.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		lblSelecioneOMtodo.setBounds(171, 122, 282, 52);
		contentPane.add(lblSelecioneOMtodo);
		
		JRadioButton cartao = new JRadioButton("Cart�o");
		cartao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (cartao.isSelected()) {
					x2.setVisible(true);
					x3.setVisible(true);
					desconto.setVisible(true);
				}
			}
		});
		buttonGroup.add(cartao);
		cartao.setBackground(new Color(255, 228, 225));
		cartao.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		cartao.setBounds(122, 181, 127, 25);
		cartao.setBorderPainted(false);
		cartao.setContentAreaFilled(false);
		cartao.setOpaque(false);
		cartao.setFocusPainted(false);
		contentPane.add(cartao);
		
		JRadioButton avista = new JRadioButton("� vista");
		avista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		avista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x2.setVisible(false);
				x3.setVisible(false);
				desconto.setVisible(true);
				String TotalVista = lbl;
				double TotalVistaD = Double.parseDouble(TotalVista);
				double Avista = TotalVistaD - (TotalVistaD*0.15);
				totalFinal.setText(df.format(Avista));

			}
		});
		buttonGroup.add(avista);
		avista.setBackground(new Color(255, 228, 225));
		avista.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		avista.setBounds(363, 181, 127, 25);
		avista.setBorderPainted(false);
		avista.setContentAreaFilled(false);
		avista.setFocusPainted(false);
		avista.setOpaque(false);
		contentPane.add(avista);
		
		x2 = new JRadioButton("2x");
		x2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Total2x = lbl;
				double Total2xD = Double.parseDouble(Total2x);
				double juros2x = (Total2xD*0.10) + Total2xD;
				totalFinal.setText(df.format(juros2x));

			}
		});
		buttonGroup_1.add(x2);
		x2.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		x2.setBackground(new Color(255, 228, 225));
		x2.setBounds(141, 208, 127, 25);
		x2.setBorderPainted(false);
		x2.setContentAreaFilled(false);
		x2.setVisible(false);
		x2.setFocusPainted(false);
		contentPane.add(x2);
		
		x3 = new JRadioButton("3x");
		x3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Total3x = lbl;
				double Total3xD = Double.parseDouble(Total3x);
				double juros3x = (Total3xD*0.15) + Total3xD;
				totalFinal.setText(df.format(juros3x));

			}
		});
		buttonGroup_1.add(x3);
		x3.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		x3.setBackground(new Color(255, 228, 225));
		x3.setBounds(142, 238, 127, 25);
		x3.setBorderPainted(false);
		x3.setContentAreaFilled(false);
		x3.setFocusPainted(false);
		x3.setVisible(false);
		contentPane.add(x3);
		
		desconto = new JLabel("15% de desconto!");
		desconto.setForeground(new Color(0, 100, 0));
		desconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		desconto.setBounds(361, 213, 117, 16);
		desconto.setVisible(false);
		contentPane.add(desconto);
		
		JLabel lblTotal = new JLabel("Total: R$");
		lblTotal.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblTotal.setBounds(151, 313, 134, 32);
		contentPane.add(lblTotal);
		
		totalFinal = new JLabel("");
		totalFinal.setForeground(new Color(0, 100, 0));
		totalFinal.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
		totalFinal.setBounds(264, 310, 135, 37);
		contentPane.add(totalFinal);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (!(avista.isSelected() || cartao.isSelected() || x2.isSelected() || x3.isSelected() )) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um m�todo de pagamento!");
				} else {
					JOptionPane.showMessageDialog(null, "Obrigada por comprar conosco, volte sempre!");
					PeedidoDAO.updateATT(ConsultarPedidos.pedido[1]);
					new Menu().setVisible(true);
					dispose();
				}
				
			}
		});
		btnFinalizar.setBackground(new Color(255, 255, 255));
		btnFinalizar.setForeground(Color.BLACK);
		btnFinalizar.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		btnFinalizar.setBounds(492, 316, 119, 51);
		contentPane.add(btnFinalizar);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblPagamento.setBounds(238, 11, 282, 62);
		contentPane.add(lblPagamento);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(FinalizarPedido.class.getResource("/imagens/Background.jpg")));
		background.setBounds(0, 0, 660, 440);
		contentPane.add(background);
	}
}
