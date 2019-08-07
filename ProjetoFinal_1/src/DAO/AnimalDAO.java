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

	public static ResultSet selectByTipo(String tipo) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where TP_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + tipo + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet selectByVacinas(String vacinas) {
		String q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal where VC_Animal like ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + vacinas + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Animal isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet selectByAll(String nome, String castrado, String vacinas, String tipo, String sexo,
			String tamanho, String raca, String ano) {
		String q = "";
		String w = "";


		q = "SELECT NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal ";
		if (!ano.isEmpty()) {
			if (w.isEmpty()) {
				w = " ANO_Animal Like '%" + ano + "%'";
			} else {
				w += " and ANO_Animal like '%" + ano + "%'";
			}
			
		if (!tamanho.isEmpty()) {
			w = " TM_Animal like '%" + tamanho + "%'";
		}
		
		if (!raca.isEmpty()) {
			if (w.isEmpty()) {
				w = " RC_Animal Like '%" + raca + "%'";
			} else {
				w += " and RC_Animal like '%" + raca + "%'";
			}
		}
		if (!tipo.isEmpty()) {
			if (w.isEmpty()) {
				w = " TP_Animal Like '%" + tipo + "%'";
			} else {
				w += " and TP_Animal like '%" + tipo + "%'";
			}
		}
	}
		
		if (!w.isEmpty()) {
			q += "where" + w;
		}
		System.out.println(q);
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (Exception ex) {
			System.out.println("Erro no SQL");
			ex.printStackTrace();
		}

		return null;

	}
}
