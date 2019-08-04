package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.Items;
import br.com.idog.Configuration.MySQLConfiguration;

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
}
