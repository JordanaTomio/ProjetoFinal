package Frames;

import Beans.Cliente;
import Conexao.MySQLConfiguration;

public class Main {

	public static Cliente cliente = new Cliente();


	//faz intermédio entre a conexao e os frames

	public static void main(String[] args) {
		MySQLConfiguration c = new MySQLConfiguration();
		cliente.setAdm(0);
		new Login().setVisible(true);
	}

}
