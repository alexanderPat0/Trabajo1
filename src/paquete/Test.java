package paquete;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Test {

	// ERROR que no he arreglado:
	// 1. Al comenzar el programa desde 0 sin ficheros, crear personas, e ir a la
	// ventana de muestras y filtrarlas, como los ficheros no están creados todavía
	// y yo muestro las personas en el JTextArea leyéndolas del fichero, da error.
	// 2. Hasta que no cierre el programa, no se me actualizan los ficheros para ver
	// las personas filtradas.

	// A lo largo de todo este programa uso un WindowsListener para detectar cuando
	// el usuario cierra la aplicación, así guardo las listas en los ficheros cuando
	// eso ocurre.

	// Listas en las que entrarán las personas al iniciar la aplicación y cuando sea
	// creada una nueva persona.
	static List<Persona> listado = new ArrayList<Persona>();
	static List<Persona> listMayor = new ArrayList<Persona>();
	static List<Persona> listMenor = new ArrayList<Persona>();
	static List<Persona> listCasado = new ArrayList<Persona>();
	static List<Persona> listSoltero = new ArrayList<Persona>();
	static List<Persona> listViudo = new ArrayList<Persona>();

	static String filtro;

	public static void main(String[] args) {

		OperacionFichero OF = new OperacionFichero();
		File f1 = new File("ficheros/fichBinario.dat");

		// Comprobar que los ficheros están creados, o si están creados pero no hay
		// nadie añadido todavía.

		if (!f1.exists())
			JOptionPane.showMessageDialog(null, "No se ha creado el registro todavía.");
		else if (!(f1.length() > 0))
			JOptionPane.showMessageDialog(null, "No hay nadie agregado en el registro");
		else {
			// Sacar las personas del fichero binario y trabajar con ellas en listas.
			listado = OF.leerBinario(listado);
			for (Persona p : listado) {
				if (p.getEdad() < 18)
					listMenor.add(p);
				else
					listMayor.add(p);
				if (p.getEstadoCivil().matches("Sin pareja"))
					listSoltero.add(p);
				else if (p.getEstadoCivil().matches("Casado"))
					listCasado.add(p);
				else
					listViudo.add(p);
			}

		}

		Frame1 f = new Frame1();
		f.setVisible(true);

	}
}
