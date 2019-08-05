package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.idog.Configuration.MySQLConfiguration;

public class AnimalDAO {
	public static void selectAll(String nome) {
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where NM_Animal ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return;
		}
	}

	public static void selectRaca(String nome) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where NM_Animal ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return;
		}
	}

	public static ResultSet selectByRaca(String raca) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where RC_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + raca + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet selectByAno(String ano) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where ANO_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + ano + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet selectByTamanho(String tamanho) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where ANO_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + tamanho + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet selectBySexo(String sexo) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where SX_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + sexo + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}
}
