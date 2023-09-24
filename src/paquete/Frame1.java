package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	private JButton btnCrearEntidad, btnVerEntidad;
	private JLabel label1;

	public Frame1() {
		setVisible(true);
		setTitle("Registro civil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 208);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		label1 = new JLabel("¿Que operacion desea realizar?");
		label1.setBounds(32, 37, 187, 14);
		contentPane.add(label1);

		btnCrearEntidad = new JButton("Crear persona");
		btnCrearEntidad.setBounds(47, 65, 150, 23);
		contentPane.add(btnCrearEntidad);

		btnVerEntidad = new JButton("Ver personas");
		btnVerEntidad.setBounds(47, 99, 150, 23);
		contentPane.add(btnVerEntidad);

		ManejadorBoton manejador = new ManejadorBoton();
		btnCrearEntidad.addActionListener(manejador);
		btnVerEntidad.addActionListener(manejador);

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

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnCrearEntidad) {
				new CrearEntidad();
				dispose();
			} else {
				new MostrarEntidades();
				dispose();
			}

		}

	}

}
