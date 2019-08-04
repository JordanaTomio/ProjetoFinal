package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FormularioAdocao extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAdocao frame = new FormularioAdocao();
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
	public FormularioAdocao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTermoDeRespons = new JLabel("Veterin\u00E1rio");
		lblTermoDeRespons.setBounds(209, 27, 176, 36);
		lblTermoDeRespons.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		contentPane.add(lblTermoDeRespons);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 86, 486, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nome", "Contato", "Endere\u00E7o"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnConfirmVet = new JButton("Confirmar");
		btnConfirmVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Consulta agendada com sussesso!");
			}
		});
		btnConfirmVet.setBounds(209, 336, 94, 30);
		contentPane.add(btnConfirmVet);
		
		JButton btnSairVet = new JButton("Sair");
		btnSairVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSairVet.setBounds(339, 336, 94, 30);
		contentPane.add(btnSairVet);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FormularioAdocao.class.getResource("/imagens/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 401);
		contentPane.add(lblNewLabel);
	}
}
