package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.Items;
import Conexao.MySQLConfiguration;

public class ItemsDAO {
	public static void save(Items item) {
		String q = "INSERT INTO item(CD_Pedido, CD_Produto) VALUES (?, ?);";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, item.getCdPedido());
			ps.setInt(2, item.getCdProduto());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on save item");
			e.printStackTrace();
		}
	}
	public static void remove(int idPedido, int idProduto) {
		String q = "DELETE FROM item WHERE CD_Pedido = ? AND CD_Produto = ? LIMIT 1;";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idPedido);
			ps.setInt(2, idProduto);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

