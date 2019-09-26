package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.MySQLConfiguration;

public class VeterinariosDAO {
	
	public static ResultSet VeterinariosDAO(String Bairro){
		MySQLConfiguration c = new MySQLConfiguration();

		String q = "";
		String w = "";
		// -------------------------------------------------------------\\
		q = "SELECT NM_Veterinario Nome, TL_Veterinario Telefone, LC_Veterinario Endereço"
				+ " FROM contato_veterinario"
				+ " WHERE BR_Veterinario like '%" + Bairro + "%' ";
		
		
		// -------------------------------------------------------------\\
		q += " order by CD_Veterinario";
		try {
			PreparedStatement ps = c.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("erro busca vet");
			e.printStackTrace();
			return null;
		}
	}

}
