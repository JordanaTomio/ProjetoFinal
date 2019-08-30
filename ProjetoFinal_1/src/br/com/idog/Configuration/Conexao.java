package br.com.idog.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection conn;

	public Conexao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_ipet?autoReconnect=true&useSSL=false",
					"root", "");
			System.out.println("Connected on Database");
			// comentário 
		} catch (SQLException e) {
			System.err.println("Something went wrong during the connecting of db.");
			e.printStackTrace();
		}
	}
}
