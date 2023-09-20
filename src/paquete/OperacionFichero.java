package paquete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class OperacionFichero {

	public void escribirBinario(List<Persona> listado) {
		try {
			FileOutputStream fos = new FileOutputStream("ficheros/fichBinario");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listado);
			oos.close();
		} catch (Exception e) {

		}
	}

	public void leerBinario(List<Persona> listado) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("ficheros/fichBinario"));
			listado = (List<Persona>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escribirTexto(List<Persona> listado) {

		try {
			FileWriter fw = new FileWriter("ficheros/");

			for (Persona p : listado) {
				String datos = p.getDni() + ";" + p.getSexo() + ";" + p.getNombre() + ";" + p.getApellidos() + ";"
						+ p.getEdad() + ";" + p.getEstadoCivil() +";"+ p.getHijos() +";"+ p.getNumHijos() + "\n";
				fw.write(datos);
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void leerTexto(List<Agrupacion> aT) {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("docT/agrupaciones"));
//			String nom = br.readLine();
//
//			while (nom != null) {
//				String[] cad = nom.split(";");
//				String nomb = cad[0];
//				String aut = cad[1];
//				String cat = cad[2];
//				int anyo = Integer.parseInt(cad[3]);
//				int pos = Integer.parseInt(cad[4]);
//				Test.aT.add(new Agrupacion(nomb, aut, cat, anyo, pos));
//				nom = br.readLine();
//
//			}
//			br.close();
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//	}

	public void anadirPersona(Persona p) {

	}

}