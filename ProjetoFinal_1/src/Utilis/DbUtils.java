package Utilis;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class DbUtils {
    public static TableModel resultSetTable(ResultSet rs) {
	try {
	    ResultSetMetaData metaData = rs.getMetaData();
	    int NColunas = metaData.getColumnCount();
	    Vector<String> ColunaNomes = new Vector<String>();

	    // pega nomes das colunas
	    for (int Add = 0; Add < NColunas; Add++) {
		ColunaNomes.addElement(metaData.getColumnLabel(Add + 1));
	    }

	    // pega todas linhas.
	    Vector<Vector<Object>> linhas = new Vector<Vector<Object>>();

	    while (rs.next()) {
		Vector<Object> nvLinha = new Vector<Object>();

		for (int i = 1; i <= NColunas; i++) {
		    nvLinha.addElement(rs.getObject(i));
		}

		linhas.addElement(nvLinha);
	    }

	    return new DefaultTableModel(linhas, ColunaNomes);
	} catch (Exception e) {
	    e.printStackTrace();

	    return null;
	}
    }

    public static List<List<Object>> resultSetList(ResultSet rs, boolean IncluiNomes) {
	try {
	    // coloca nas linhas.
	    List<List<Object>> linhas = new ArrayList<List<Object>>();
	    ResultSetMetaData metaData = rs.getMetaData();
	    int NColunas = metaData.getColumnCount();

	    // inclui cabeçalho
	    if (IncluiNomes) {
		List<Object> ColunaNomes = new ArrayList<Object>();

		// pega os nomes da coluna
		for (int column = 0; column < NColunas; column++) {
		    ColunaNomes.add(metaData.getColumnLabel(column + 1));
		}
		linhas.add(ColunaNomes);
	    }

	    // pega as Info
	    while (rs.next()) {
		List<Object> nvLinha = new ArrayList<Object>();

		for (int i = 1; i <= NColunas; i++) {
		    nvLinha.add(rs.getObject(i));
		}

		linhas.add(nvLinha);
	    }
	    return linhas;
	} catch (Exception e) {
	    e.printStackTrace();

	    return null;
	}
    }

    public static List<List<Object>> resultSetList(ResultSet rs) {
	try {
	    // coloca nas linhas.
	    List<List<Object>> linhas = new ArrayList<List<Object>>();
	    ResultSetMetaData metaData = rs.getMetaData();
	    int NColunas = metaData.getColumnCount();

	    // pega as Info
	    while (rs.next()) {
		List<Object> nvLinha = new ArrayList<Object>();

		for (int i = 1; i <= NColunas; i++) {
		    nvLinha.add(rs.getObject(i));
		}

		linhas.add(nvLinha);
	    }
	    return linhas;
	} catch (Exception e) {
	    e.printStackTrace();

	    return null;
	}
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
	ResultSet rs = new Dbhiperbeans();
	TableModel tm = DbUtils.resultSetTable(rs);
	System.out.println(tm.getValueAt(0, 0));
    }
}
