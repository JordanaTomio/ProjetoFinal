package Beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.idog.Configuration.MySQLConfiguration;

public class Produto {
	public static ResultSet findByName(String nome) {
		String q = "SELECT CD_Produto, NM_Produto, DS_Produto, VL_Produto, UND_Produto, DT_Validade, QT_Estoque_Produto, DT_Cadastro_Produto FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet findByNameToTable(String nome) {
		String q = "SELECT CD_Produto, NM_Produto, VL_Produto FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
}
