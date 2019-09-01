package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.MySQLConfiguration;

public class HotelDAO {
	
	public static ResultSet findAll(int one) {
		//cria conexao com o banco
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "SELECT NM_CUIDADOR, DS_CUIDADOR, NS_CUIDADOR FROM cuidadores where CD_Cuidador > " + one + " order by CD_Cuidador";
		try {
			System.out.println(q);
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Cuidador não encontrado!");
			e.printStackTrace();
			return null;
		}
	}
		public static void Agendar(String cliente, String data1, String data2, String cuidador, String obs, String tipo){
			//recria conexao com o banco
			MySQLConfiguration c = new MySQLConfiguration();
		String q = "INSERT INTO agendamento_cuidador (NM_CLIENTE, DT_EINS_AG_CUIDADOR, DT_ZWEI_AG_CUIDADOR, NM_CUIDADOR, OBS_Agendamento, TP_Agendamento) VALUES (?, ?, ?, ?, ?, ?)" ;
			try {
				PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
				ps.setString(1, cliente);
				ps.setString(2, data1);
				ps.setString(3, data2);
				ps.setString(4, cuidador);
				ps.setString(5, obs);
				ps.setString(6, tipo);
				System.out.println("Inserção concluida.");
				System.out.println(q);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println("Some error happen in inserting 'Cliente'");
				e.printStackTrace();
			}
		}
}
