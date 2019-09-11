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

		q = "SELECT (DT_Servico)Data, (HR_Servico)Hora, (NM_Cliente)Cliente FROM agenda ";
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
	public static ResultSet AtualizarEN() {
		//cria conexao com o banco
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "";

		q = "SELECT (DT_Servico)Date, (HR_Servico)Hour, (NM_Cliente)Client FROM agenda ";
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
	public static ResultSet AtualizarDE() {
		//cria conexao com o banco
		MySQLConfiguration c = new MySQLConfiguration();
		String q = "";

		q = "SELECT (DT_Servico)Datum, (HR_Servico)Uhr, (NM_Cliente)Kunde FROM agenda ";
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
	public static void ConfirmarEN(String date, String hour, String client, int N) {

		String q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES" + " ('";

		try {
			Statement comando = MySQLConfiguration.conn.createStatement();

			// --------------------------------------------------------------------------------------------
			switch (N) {
			case 1:
				q += date + "', '" + hour + "', '" + client + "', 'Banho', '15.00')";
				break;
			case 2:
				q += date + "', '" + hour + "', '" + client + "', 'Banho e Tosa', '25.00')";
				break;
			case 3:
				q += date + "', '" + hour + "', '" + client + "', 'Banho', '20.00')";
				break;
			case 4:
				q += date + "', '" + hour + "', '" + client + "', 'Banho e tosa', '30.00')";
				break;
			case 5:
				q += date + "', '" + hour + "', '" + client + "', 'Banho', '30.00')";
				break;
			case 6:
				q += date + "', '" + hour + "', '" + client + "', 'Banho e tosa', '40.00')";
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
	}	public static void ConfirmarDE(String datum, String uhr, String kunde, int N) {

		String q = "INSERT INTO agenda (DT_Servico, HR_Servico, NM_Cliente, SV_Servico, VL_Servico) VALUES" + " ('";

		try {
			Statement comando = MySQLConfiguration.conn.createStatement();

			// --------------------------------------------------------------------------------------------
			switch (N) {
			case 1:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho', '15.00')";
				break;
			case 2:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho e Tosa', '25.00')";
				break;
			case 3:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho', '20.00')";
				break;
			case 4:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho e tosa', '30.00')";
				break;
			case 5:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho', '30.00')";
				break;
			case 6:
				q += datum + "', '" + uhr + "', '" + kunde + "', 'Banho e tosa', '40.00')";
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
