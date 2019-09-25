package Utilis;

import java.text.DateFormat;
import java.util.Date;

public class Data {

	// valida as datas

	public static boolean validaData(String data) {
		String valida = data;
		java.util.Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

		System.out.println(dStr);
		System.out.println(valida);

		String[] sprdAtual = dStr.split("/");
		String jntAtual = sprdAtual[0] + sprdAtual[1] + sprdAtual[2];

		String[] sprdValida = valida.split("/");
		String jntValida = sprdValida[0] + sprdValida[1] + sprdValida[2];

		System.out.println(jntAtual);
		System.out.println(jntValida);

		int Validar = Integer.parseInt(jntValida);
		int atual = Integer.parseInt(jntAtual);

		if (Validar > atual) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validaDataTraço(String data) {
		String valida = data;
		java.util.Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

		System.out.println(dStr);
		System.out.println(valida);

		String[] sprdAtual = dStr.split("/");
		String jntAtual = sprdAtual[0] + sprdAtual[1] + sprdAtual[2];

		String[] sprdValida = valida.split("-");
		String jntValida = sprdValida[0] + sprdValida[1] + sprdValida[2];

		System.out.println(jntAtual);
		System.out.println(jntValida);

		int Validar = Integer.parseInt(jntValida);
		int atual = Integer.parseInt(jntAtual);

		if (Validar > atual) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validaDuplaData(String data, String data2) {
		String valida = data;
		String valida2 = data2;
		java.util.Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

		String[] sprdAtual = dStr.split("/");
		String jntAtual = sprdAtual[0] + sprdAtual[1] + sprdAtual[2];

		String[] sprdValida = valida.split("/");
		String jntValida = sprdValida[0] + sprdValida[1] + sprdValida[2];

		String[] sprdValida2 = valida2.split("/");
		String jntValida2 = sprdValida2[0] + sprdValida2[1] + sprdValida2[2];

		System.out.println(jntAtual);
		System.out.println(jntValida);
		System.out.println(jntValida2);

		int atual = Integer.parseInt(jntAtual);
		int Validar = Integer.parseInt(jntValida);
		int Validar2 = Integer.parseInt(jntValida2);
		if (Validar >= atual) {
			if (Validar2 > Validar) {
				return true;
			}else{
				return false;
			}
		} else {
			return false;
		}
	}
}
