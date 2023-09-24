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

	public static void escribirBinario(List<Persona> listado) {
		try {
			FileOutputStream fos = new FileOutputStream("ficheros/fichBinario.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listado);
			oos.close();
		} catch (Exception e) {

		}
	}

	public static List<Persona> leerBinario(List<Persona> listado) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("ficheros/fichBinario.dat"));
			listado = (List<Persona>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

	public static void escribirTexto(List<Persona> listado, String ruta) {
		try {
			FileWriter fw = new FileWriter("ficheros/fichTxt" + ruta + ".txt");

			for (Persona p : listado) {
				String datos = p.getDni() + ";" + p.getSexo() + ";" + p.getNombre() + ";" + p.getApellidos() + ";"
						+ p.getEdad() + ";" + p.getEstadoCivil() + ";" + p.getHijos() + ";" + p.getNumHijos() + "\n";
				fw.write(datos);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerTexto(List<Persona> listaTexto, String ruta) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("ficheros/fichTxt"+ruta+".txt"));
			String persona = br.readLine();

			while (persona != null) {
				String[] cad = persona.split(";");
				String dni = cad[0];
				String sexo = cad[1];
				String nombre = cad[2];
				String apellidos = cad[3];
				int edad = Integer.parseInt(cad[4]);
				String estadoCivil = cad[5];
				String hijos = cad[6];
				int numHijos = Integer.parseInt(cad[7]);
				Persona p = new Persona(dni, sexo, nombre, apellidos, edad, estadoCivil, hijos, numHijos);
				listaTexto.add(p);
				persona = br.readLine();
			}
			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}