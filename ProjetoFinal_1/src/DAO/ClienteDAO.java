package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Beans.Cliente;
import Conexao.MySQLConfiguration;
import Frames.Main;

public class ClienteDAO {
	//save as informacoes no banco
	public static void save(Cliente cliente) {
		//cria conexao com o banco
		MySQLConfiguration s = new MySQLConfiguration();
		String q = "INSERT INTO cliente (EM_Cliente, PS_Cliente, PN_Cliente, SN_Cliente,"+
				" SX_Cliente, TL_Cliente, ADM_Cliente, CEP_Cliente, CPF_Cliente, PJF_Cliente,"
				+" RZ_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, cliente.getEmail());
			ps.setString(2, cliente.getSenha());
			ps.setString(3, cliente.getPrimeiroNome());
			ps.setString(4, cliente.getUltimoNome());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getTelefone());
			ps.setInt(7, cliente.getAdm());
			ps.setString(8, cliente.getCPF());
			ps.setString(9, cliente.getCEP());
			ps.setString(10,cliente.getPessoa());
			ps.setString(11, cliente.getRazao());
			ps.executeUpdate();
			System.out.println("Cliente was insert.");
			
		} catch (SQLException e) {
			System.err.println("Some error happen in inserting 'Cliente'");
			e.printStackTrace();
		}
	}
	//puxa as informacoes de para login
	public static boolean giveAuth(String email, String senha) {
		//cria conexao com o banco
		MySQLConfiguration s = new MySQLConfiguration();
		String q = "SELECT CD_Cliente, EM_Cliente, PS_Cliente, PN_Cliente, SN_Cliente, SX_Cliente, TL_Cliente, ADM_Cliente FROM cliente WHERE EM_Cliente = ?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, email);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Cliente isn't found. (Email is wrong)");
			e.printStackTrace();
		}

		int cdCodigo = 0;
		String emailValido = null;
		String senhaValida = null;
		String primeiroNome = null;
		String ultimoNome = null;
		String sexo = null;
		String telefone = null;
		int adm = 0;

		try {
			if (rs.next()) {
				cdCodigo = rs.getInt("CD_Cliente");
				emailValido = rs.getString("EM_Cliente");
				senhaValida = rs.getString("PS_Cliente");
				primeiroNome = rs.getString("PN_Cliente");
				ultimoNome = rs.getString("SN_Cliente");
				sexo = rs.getString("SX_Cliente");
				telefone = rs.getString("TL_Cliente");
				adm = rs.getInt("ADM_Cliente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if ((emailValido != null) && emailValido.equals(email) && (senhaValida != null) && senhaValida.equals(senha)) {
			Cliente cliente = Main.cliente;
			cliente.setCdCodigo(cdCodigo);
			cliente.setEmail(emailValido);
			cliente.setSenha(senhaValida);
			cliente.setPrimeiroNome(primeiroNome);
			cliente.setUltimoNome(ultimoNome);
			cliente.setSexo(sexo);
			cliente.setTelefone(telefone);
			cliente.setAdm(adm);
			return true;
		} else {
			return false;
		}
	}
	public static ResultSet findAll() {
		String q = "SELECT CD_Cliente, PN_Cliente, SN_Cliente, TL_Cliente, EM_Cliente FROM cliente";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Clientes aren't found.");
			e.printStackTrace();
			return null;
		}
	}
	//Puxa todas as informacoes do usuario
	public static ResultSet findAllByID(int cdCodigo) {
		String q = "SELECT CD_Cliente, PN_Cliente, SN_Cliente, TL_Cliente, EM_Cliente, CEP_Cliente, SX_Cliente, RZ_Cliente FROM cliente where CD_Cliente = ?";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setInt(1, cdCodigo);
			System.out.println(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Clientes aren't found by id.");
			e.printStackTrace();
			return null;
		}
	}
	//Altera as informaçoes do usuario
	public static void UpdateAllByID(int cdCodigo, String primeiroNome, String segundoNome, String sexo, String telefone, String cep, String razao, String email ) {
		String q = "UPDATE cliente set EM_Cliente= ?, PN_Cliente= ?, SN_Cliente= ?, SX_Cliente= ?, TL_Cliente= ?, CEP_Cliente= ?, RZ_Cliente= ? WHERE CD_Cliente= ?";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, primeiroNome);
			ps.setString(3, segundoNome);
			ps.setString(4, sexo);
			ps.setString(5, telefone);
			ps.setString(6, cep);
			ps.setString(7, razao);
			ps.setInt(8, cdCodigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error during update 'Produto'");
			e.printStackTrace();
		}
	}
	//Puxa as informaçoes pelo nome do cliente
	public static ResultSet findAllTyped(String nome) {
		String q = "SELECT CD_Cliente Cliente, PN_Cliente Nome, SN_Cliente Sobrenome FROM cliente where PN_Cliente like '%" + nome + "%'";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Clientes aren't found.");
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet findAllCPF() {
		String q = "SELECT CPF_Cliente FROM cliente where = ";

		try {
			PreparedStatement ps = MySQLConfiguration.conn.prepareStatement(q);
			System.out.println(q);
			return ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Clientes aren't found.");
			e.printStackTrace();
			return null;
		}
	}
	
}
