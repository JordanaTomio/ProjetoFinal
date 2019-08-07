package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Cliente;
import Frames.Main;
import br.com.idog.Configuration.MySQLConfiguration;

public class ClienteDAO {
	public static void save(Cliente cliente) {
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
	public static boolean giveAuth(String email, String senha) {
		MySQLConfiguration s = new MySQLConfiguration();
		String q = "SELECT CD_Cliente, EM_Cliente, PS_Cliente, PN_Cliente, SN_Cliente, SX_Cliente, TL_Cliente, ADM_Cliente, PJF_Cliente, CPF_Cliente, CEP_Cliente, RZ_Cliente FROM cliente WHERE EM_Cliente = ?";
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
		String pessoa = null;
		String razao = null;
		String cpf = null;
		String cep = null;
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
				pessoa = rs.getString("PJF_Cliente");
				razao = rs.getString("RZ_Cliente");
				cep = rs.getString("CEP_Cliente");
				adm = rs.getInt("ADM_Cliente");
				cpf = rs.getString("CPF_Cliente");
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
			cliente.setCEP(cep);
			cliente.setCPF(cpf);
			cliente.setRazao(razao);
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
}
