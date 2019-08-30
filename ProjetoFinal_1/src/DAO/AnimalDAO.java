package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Frames.Main;
import br.com.idog.Configuration.MySQLConfiguration;

public class AnimalDAO {

	public static ResultSet BuscaAnimalMaior(String one) {

		String q = "SELECT  CD_Animal, NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal, AD_Animal FROM animal "
				+ " WHERE AD_Animal = 0 and CD_Animal > " + one + " ORDER BY CD_Animal";

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
	public static ResultSet BuscaAnimalMenor(String one) {

		String q = "SELECT  CD_Animal, NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal, AD_Animal FROM animal "
				+ " WHERE AD_Animal = 0 and CD_Animal < " + one + " ORDER BY CD_Animal desc";

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

	public static void AdotarAnimal(String nomePet) {
		MySQLConfiguration c = new MySQLConfiguration();

		try {
			Statement ps = c.conn.createStatement();

			String q = "";
			String x = "";
			
			x += "'" + nomePet + "'";
			q += " UPDATE animal SET AD_Animal = 1 WHERE NM_Animal = "+ x;
					
			System.out.println(q);
			 ps.executeUpdate(q);


		} catch (Exception ex) {
			System.out.println("Falha na insercao");
			ex.printStackTrace();
		} finally {
			if (MySQLConfiguration.conn != null) {
				try {
					MySQLConfiguration.conn.close();
				} catch (Exception ex) {
					System.out.println("Error in connection");
					
				}
			}
		}
		
	}
	public static ResultSet BuscaAnimalUpdate(int one) {
		one++;
		MySQLConfiguration c = new MySQLConfiguration();

		String q = "SELECT  CD_Animal, NM_Animal, ANO_Animal, TM_Animal, DS_Animal, RC_Animal, TP_Animal, SX_Animal, VC_Animal, CS_Animal FROM animal "
				+ " WHERE CD_Animal > " + one + " ORDER BY CD_Animal";

		System.out.println(q);
		try {
			PreparedStatement ps = c.conn.prepareStatement(q);
			return ps.executeQuery();

		} catch (Exception ex) {
			System.out.println("Erro no SQL");
			System.out.println("aqui2");
			// ex.printStackTrace();
			return null;
		}

	}
	public static void InsertAdotado(int cd){
			
		String q = "INSERT INTO adocao (Animal_CD_Animal, Cliente_CD_Cliente) VALUES";
		q+="("+cd+","+Main.cliente.getCdCodigo()+ ")";

		try {
			Statement comando = MySQLConfiguration.conn.createStatement();

			System.out.println(q);
			comando.executeUpdate(q);

		}catch (

		Exception ex) {
			System.err.println("FALHA NA no bang da CONFIRMAÃƒâ€¡ÃƒÆ’O");
			ex.printStackTrace();
		} finally {
			if (MySQLConfiguration.conn != null) {
				try {
					MySQLConfiguration.conn.close();
				} catch (Exception ex) {
					System.err.println("ALGO ERRADO NÃƒÆ’O ESTÃƒï¿½ CERTO!");
				}
			}
		}
	

	}
}
