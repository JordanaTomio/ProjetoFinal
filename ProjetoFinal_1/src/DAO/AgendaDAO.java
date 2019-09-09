package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexao.MySQLConfiguration;




public class AgendaDAO {

	public static ResultSet Atualizar() {
		//cria conexao com o banco
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "";

		q = "SELECT (DT_Servico)Dia, (HR_Servico)Hora, (NM_Cliente)Cliente FROM agenda ";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();

		} catch (SQLException e) {
			System.err.println("ERRO NO SQL");
			System.err.println(q);
			e.printStackTrace();
			return null;
		}

	}

	public static void Confirmar(String data, String hora, String cliente, int N) {

		String q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES" + " ('";

		try {
			Statement comando = MySQLConfiguration.conn.createStatement();

			// --------------------------------------------------------------------------------------------
			switch (N) {
			case 1:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho', '15.00')";
				break;
			case 2:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho e Tosa', '25.00')";
				break;
			case 3:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho', '20.00')";
				break;
			case 4:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho e tosa', '30.00')";
				break;
			case 5:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho', '30.00')";
				break;
			case 6:
				q += data + "', '" + hora + "', '" + cliente + "', 'Banho e tosa', '40.00')";
				break;
			}

			// --------------------------------------------------------------------------------------------

			System.out.println(q);
			comando.executeUpdate(q);

		}catch (

		Exception ex) {
			System.err.println("FALHA NA no bang da CONFIRMACAO");
			ex.printStackTrace();
		} finally {
			if (MySQLConfiguration.conn != null) {
				try {
					MySQLConfiguration.conn.close();
				} catch (Exception ex) {
					System.err.println("ALGO ERRADO NAO ESTA CERTO!/n Fechar");
				}
			}
		}
	}
}
