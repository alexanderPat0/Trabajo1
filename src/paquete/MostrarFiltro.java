package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MostrarFiltro extends JFrame {

	private JLabel lblInfo;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnVolver;

	public MostrarFiltro() {
		setTitle(" Listado personas");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 289);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblInfo = new JLabel(Test.filtro + ":");
		lblInfo.setBounds(25, 25, 117, 14);
		contentPane.add(lblInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 50, 540, 146);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setColumns(10);

		OperacionFichero OF = new OperacionFichero();

		// Muestro en el JTextField las personas que cumplen el filtro.

		String ruta;
		if (Test.filtro.matches("Sin Pareja"))
			ruta = "SinPareja";
		else
			ruta = Test.filtro;

		List<Persona> listaFiltrada = new ArrayList<>();

		OF.leerTexto(listaFiltrada, ruta);

		String texto = "";
		for (Persona p : listaFiltrada) {
			texto = texto + p.toString() + "   \n";
		}
		textArea.setText(texto);

		// Sacar persona a persona de la lista y añadirlos a la lista en la que cumpla
		// los requisitos

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(25, 207, 89, 23);
		contentPane.add(btnVolver);

		ManejadorBoton manejador = new ManejadorBoton();
		btnVolver.addActionListener(manejador);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				OperacionFichero.escribirTexto(Test.listMayor, "Mayores");
				OperacionFichero.escribirTexto(Test.listMenor, "Menores");
				OperacionFichero.escribirTexto(Test.listSoltero, "SinPareja");
				OperacionFichero.escribirTexto(Test.listCasado, "Casados");
				OperacionFichero.escribirTexto(Test.listViudo, "Viudos");

				OperacionFichero.escribirBinario(Test.listado);
				System.exit(0);
			}
		});
	}

	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnVolver) {
				new MostrarEntidades();
				dispose();
			}
		}

	}
}
