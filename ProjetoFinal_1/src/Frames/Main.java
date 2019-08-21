package Frames;

import Beans.Cliente;
import br.com.idog.Configuration.MySQLConfiguration;

public class Main {

	public static Cliente cliente = new Cliente();

	public static void main(String[] args) {
		new MySQLConfiguration();
		cliente.setAdm(0);
		new Login().setVisible(true);
	}

}
