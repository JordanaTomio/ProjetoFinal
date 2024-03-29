package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Beans.Produto;
import Conexao.MySQLConfiguration;

public class ProdutoDAO {
	public static void save(Produto produto) {
		String q = "INSERT INTO produto(NM_Produto, DS_Produto, VL_Produto, UND_Produto, DT_Validade, QT_Estoque_Produto) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getValor());
			ps.setString(4, produto.getUnidade());
			ps.setString(5, produto.getValidade());
			ps.setInt(6, produto.getQuantidadeEstoque());
			ps.executeUpdate();
			System.out.println("Produto was insert.");
		} catch (SQLException e) {
			System.err.println("Some error happen in inserting 'Produto'");
			e.printStackTrace();
		}
	}
	public static ResultSet findAll() {
		String q = "SELECT CD_Produto, NM_Produto, DS_Produto, VL_Produto, UND_Produto, DT_Validade, QT_Estoque_Produto, DT_Cadastro_Produto FROM produto p";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet findById(int idProduto) {
		String q = "SELECT CD_Produto, NM_Produto, DS_Produto, VL_Produto, UND_Produto, DT_Validade, QT_Estoque_Produto, DT_Cadastro_Produto FROM produto p WHERE p.CD_Produto = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idProduto);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static void update(int id, String nome, String descricao, double valor, String unidade, String date,
			int estoque) {
		String q = "UPDATE produto SET NM_Produto = ?, DS_Produto = ?, VL_Produto = ?, UND_Produto = ?, DT_Validade = ?, QT_Estoque_Produto = ? WHERE CD_Produto = ?";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.setDouble(3, valor);
			ps.setString(4, unidade);
			ps.setString(5, date);
			ps.setInt(6, estoque);
			ps.setInt(7, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error during update 'Produto'");
			e.printStackTrace();
		}
	}
}
