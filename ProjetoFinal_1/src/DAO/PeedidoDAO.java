package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.MySQLConfiguration;

public class PeedidoDAO {

	public static ResultSet getPedidosItems(int idPedido) {
		String q = "SELECT (v.NM_Produto) Produto, (v.VL_Produto) Valor FROM v_cliente_itens_pedido v WHERE v.CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idPedido);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Some error happen on get items from 'itens pedido cliente'");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet getPedidosItemsEN(int idPedido) {
		String q = "SELECT (v.NM_Produto) Product, (v.VL_Produto) Value FROM v_cliente_itens_pedido v WHERE v.CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idPedido);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Some error happen on get items from 'itens pedido cliente'");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getPedidosItemsDE(int idPedido) {
		String q = "SELECT (v.NM_Produto) Produkt, (v.VL_Produto) Wert FROM v_cliente_itens_pedido v WHERE v.CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idPedido);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Some error happen on get items from 'itens pedido cliente'");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateValorTotal(int idCliente, double valorTotal) {
		String q = "UPDATE pedido SET VL_Total = ? WHERE CD_Cliente = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setDouble(1, valorTotal);
			ps.setInt(2, idCliente);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on update 'Valor Total'");
			e.printStackTrace();
		}
	}

	public static ResultSet findAllToTable() {
		String q = "SELECT CD_Produto Codigo, NM_Produto Produto, VL_Produto Valor FROM produto";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet findAllToTableEN() {
		String q = "SELECT CD_Produto Code, NM_Produto Product, VL_Produto Value FROM produto";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet findAllToTableDE() {
		String q = "SELECT CD_Produto Code, NM_Produto Produkt, VL_Produto Wert FROM produto";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet findByNameToTable(String nome) {
		String q = "SELECT CD_Produto Codigo, NM_Produto Produto, VL_Produto Valor FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet findByNameToTableEN(String nome) {
		String q = "SELECT CD_Produto Code, NM_Produto Product, VL_Produto Value FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet findByNameToTableDE(String nome) {
		String q = "SELECT CD_Produto Code, NM_Produto Produkt, VL_Produto Wert FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet findByName(String nome) {
		String q = "SELECT CD_Produto, NM_Produto, DS_Produto, VL_Produto, UND_Produto, DT_Validade, QT_Estoque_Produto, DT_Cadastro_Produto FROM produto p WHERE p.NM_Produto LIKE ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, "%" + nome + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Produto isn't found.");
			e.printStackTrace();
			return null;
		}
	}

	public static void removeFromEstoque(int id, int numEstoque) {
		String q = "UPDATE produto SET QT_Estoque_Produto = ? WHERE CD_Produto = ?";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, (numEstoque - 1));
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error during update 'Produto Estoque'");
			e.printStackTrace();
		}
	}

	public static void save(Beans.Pedido pedido) {
		MySQLConfiguration s = new MySQLConfiguration();
		String q = "INSERT INTO pedido(CD_Cliente) VALUES (?)";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, pedido.getCodigoCliente());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on save 'Pedido'");
			e.printStackTrace();
		}
	}

	public static ResultSet getAllPedidosFromCliente(int idCliente) {
		String q = "SELECT CD_Pedido, VL_Total, DT_Pedido, ATT_Pedido FROM pedido WHERE CD_Cliente = ? and ATT_Pedido = 0";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idCliente);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Some error happen on get items from 'pedidos cliente'");
			e.printStackTrace();
			return null;
		}
	}

	public static void addIntoEstoque(int id, int numEstoque) {
		String q = "UPDATE produto SET QT_Estoque_Produto = ? WHERE CD_Produto = ?";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, (numEstoque + 1));
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error during update 'Produto Estoque'");
			e.printStackTrace();
		}
	}

	public static void removeByClienteId(int idCliente) {
		String q = "DELETE FROM pedido WHERE CD_Cliente = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, idCliente);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on remove 'Pedido'");
			e.printStackTrace();
		}
	}

	public static void removePedido(String cdPedido) {
		String q = "DELETE FROM pedido WHERE CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, cdPedido);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on remove 'Pedido'");
			e.printStackTrace();
		}
	}
	public static ResultSet getPedidosATT(String pedido) {
		String q = "SELECT ATT_Pedido FROM pedido WHERE CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, pedido);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Some error happen on get items from 'itens pedido cliente'");
			e.printStackTrace();
			return null;
		}
	}
	public static void updateATT(String pedido) {
		String q = "UPDATE pedido SET ATT_Pedido = 1 WHERE CD_Pedido = ?";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, pedido);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error on update 'Valor Total'");
			e.printStackTrace();
		}
	}

}
