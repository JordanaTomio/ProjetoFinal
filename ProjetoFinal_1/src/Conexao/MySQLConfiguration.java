package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfiguration {

	public static Connection conn;
	
	//Faz conexao com o Database
	public MySQLConfiguration() {
		try {
			//Lembrete altere para 3306 no Cedup
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb?autoReconnect=true&useSSL=false",
					"root", "");
			System.out.println("Connected on Database");
		} catch (SQLException e) {
			System.err.println("Something went wrong during the connecting of db.");
			e.printStackTrace();
		}
	}
}