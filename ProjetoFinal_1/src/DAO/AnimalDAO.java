package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Beans.Animal;
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

	public static ResultSet BuscaAnimal(int one) {
		
		String q = "SELECT  NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal "
				+ " WHERE CD_Animal > "+ one +" ORDER BY CD_Animal";
		
		System.out.println(q);
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();

		} catch (Exception ex) {
			System.out.println("Erro no SQL");
			System.out.println("aqui2");
			// ex.printStackTrace();
			return null;
		}

	}
	public static void AdotarBixim(String nomePet) {
			
		MySQLConfiguration c = new MySQLConfiguration();
		
		try {
			
			Statement comando = MySQLConfiguration.conn.createStatement();
			String q = "";
			q += "delete from animal where NM_Animal = ";
			q += "'" + nomePet + "'";
			comando.executeUpdate(q);

		} catch (Exception ex) {
			System.out.println("Falha na insercao");
			ex.printStackTrace();
		} finally {
			if (c.conn != null) {
				try {
					c.conn.close();
				} catch (Exception ex) {

					System.out.println("Error in connection");
				}
			}
		}
	}
	/*
	 * public static ResultSet BuscaAnimalMenor(int one) {
	 * 
	 * String q =
	 * "SELECT  NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal "
	 * + " WHERE CD_Animal > "+ one +" ORDER BY CD_Animal";
	 * 
	 * System.out.println(q); try { PreparedStatement ps =
	 * MySQLConfiguration.conn.prepareStatement(q); return ps.executeQuery();
	 * 
	 * } catch (Exception ex) { System.out.println("Erro no SQL");
	 * System.out.println("aqui2"); // ex.printStackTrace(); return null; }
	 * 
	 * }
	 */
}
