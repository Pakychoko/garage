package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

	public static List loadData(String fileName) {

		List <List> listaObjetos = new ArrayList<List>();
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			file = new File(fileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				listaObjetos.add(metodo1(linea));
			}

		} catch (Exception e) {
			System.out.println("Error: Fail Reading");
		} finally {

			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				System.out.println("Error: Fail Closing");
			}
			
			
		}
		
		return listaObjetos;

	}

	public static void writeFile(ArrayList datos, String fileName) {

		FileWriter file = null;
		PrintWriter pw = null;

		try {
			file = new FileWriter(fileName, true);
			pw = new PrintWriter(file);

			int i = 0;
			for (Object dato : datos) {
				if (i == 0)
					pw.write("Victorias: " + dato.toString() + " ");
				else if (i == 1)
					pw.write("Derrotas: " + dato.toString() + " ");
				else if (i == 2)
					pw.write("Rondas: " + dato.toString() + "\n");
				pw.println();
				i++;
			}

		} catch (Exception e) {
			System.out.println("Error: Fail Write");
		} finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				System.out.println("Error: Fail Save");
			}
		}
	}

	public static List<String> metodo1(String line) {
		
		List <String> datos = new ArrayList<String>();
		
		datos = Arrays.asList(line.split(" "));
		
		return datos;
		
	}
	
	
}
