package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.idog.Configuration.MySQLConfiguration;

public class AgendaDAO {
	public static ResultSet getHorarios() {
		String q = "SELECT Horario, Segunda, Terca, Quarta, Quinta, Sexta FROM java";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Erro DAO getHorario'");
			e.printStackTrace();
			return null;
		}
	}
}
