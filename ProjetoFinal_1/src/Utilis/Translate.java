package Utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Translate {

	public String Translate() {

		Properties prop = new Properties();
		try {
			// Ingles
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/Idioma.txt"));
			if (prop.getProperty("#").equals(1)) {
				String one = "1";
				return one;
				// Port
			} else if (prop.getProperty("#").equals(2)) {
				String dois = "2";
				return dois;
				// Alemao
			} else if (prop.getProperty("#").equals(3)) {
				String drei = "1";
				return drei;
			} else {
				String duvi = "2";
				return duvi;
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

}
