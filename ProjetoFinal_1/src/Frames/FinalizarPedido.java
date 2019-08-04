package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalizarPedido extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton x3 = new JRadioButton("3x");
	JRadioButton x2 = new JRadioButton("2x");
	JLabel desconto = new JLabel("15% de desconto!");
	JLabel totalFinal = new JLabel("  ");
	String lbl = ConsultarProdutos.ValoresTotaisString;
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
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
			
		
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 410, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblPagamento.setForeground(new Color(255, 240, 245));
		lblPagamento.setBounds(128, 13, 148, 40);
		panel.add(lblPagamento);
		
		JLabel lblSeuTotal = new JLabel("Seu total \u00E9 de");
		lblSeuTotal.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		lblSeuTotal.setBounds(65, 99, 141, 26);
		contentPane.add(lblSeuTotal);
		
		JLabel total = new JLabel("");
		total.setForeground(new Color(255, 0, 51));
		total.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		total.setBounds(216, 100, 95, 23);
		String lbl = ConsultarProdutos.ValoresTotaisString;
		total.setText(ConsultarProdutos.ValoresTotaisString);
		contentPane.add(total);
		
		JLabel lblSelecioneOMtodo = new JLabel("Selecione o m\u00E9todo de pagamento:");
		lblSelecioneOMtodo.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		lblSelecioneOMtodo.setBounds(64, 125, 282, 52);
		contentPane.add(lblSelecioneOMtodo);
		
		JRadioButton cartao = new JRadioButton("Cart\u00E3o");
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
		cartao.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		cartao.setBounds(45, 181, 127, 25);
		contentPane.add(cartao);
		
		JRadioButton avista = new JRadioButton("\u00C0 vista");
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
		avista.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		avista.setBounds(238, 181, 127, 25);
		contentPane.add(avista);
		
		x2 = new JRadioButton("2x");
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
		x2.setBounds(64, 208, 127, 25);
		x2.setVisible(false);
		contentPane.add(x2);
		
		x3 = new JRadioButton("3x");
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
		x3.setBounds(65, 238, 127, 25);
		x3.setVisible(false);
		contentPane.add(x3);
		
		desconto = new JLabel("15% de desconto!");
		desconto.setBounds(236, 209, 113, 16);
		desconto.setVisible(false);
		contentPane.add(desconto);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblTotal.setBounds(30, 313, 134, 32);
		contentPane.add(lblTotal);
		
		totalFinal = new JLabel("  ");
		totalFinal.setForeground(new Color(255, 0, 51));
		totalFinal.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
		totalFinal.setBounds(126, 319, 95, 23);
		contentPane.add(totalFinal);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu().setVisible(true);
				dispose();
			}
		});
		btnFinalizar.setBackground(new Color(255, 240, 245));
		btnFinalizar.setForeground(new Color(255, 0, 51));
		btnFinalizar.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		btnFinalizar.setBounds(269, 321, 97, 25);
		contentPane.add(btnFinalizar);
	}
}
