package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MostrarEntidades extends JFrame {

	private JButton btnVolver;

	private JPanel contentPane;
	private JTable tabla;
	private JLabel lblInfo, lblFiltrar;
	private JComboBox<String> comboBox;

	private String[] filtros = { "Mayores", "Menores", "Sin Pareja", "Casados", "Viudos" };

	public MostrarEntidades() {
		setTitle(" Listado personas");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 289);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblInfo = new JLabel("Personas:");
		lblInfo.setBounds(25, 25, 117, 14);
		contentPane.add(lblInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 50, 540, 146);
		contentPane.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Creo y estilizo la tabla

		model.setColumnIdentifiers(
				new String[] { "DNI", "Sexo", "Nombre", "Apellidos", "Edad", "Estado Civil", "Num. Hijos" });

		for (Persona p : Test.listado) {
			model.addRow(new Object[] { p.getDni(), p.getSexo(), p.getNombre(), p.getApellidos(), p.getEdad(),
					p.getEstadoCivil(), p.getNumHijos() });
		}

		tabla = new JTable(model);

		tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(23);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(55);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(155);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(23);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(70);

		scrollPane.setViewportView(tabla);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(25, 207, 89, 23);
		contentPane.add(btnVolver);

		lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setBounds(374, 212, 46, 14);
		contentPane.add(lblFiltrar);

		comboBox = new JComboBox(filtros);
		comboBox.setBounds(417, 208, 148, 22);
		contentPane.add(comboBox);

		ManejadorBoton manejador = new ManejadorBoton();
		btnVolver.addActionListener(manejador);
		comboBox.addActionListener(manejador);

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
				new Frame1();
				dispose();
			} else if (e.getSource() == comboBox) {
				Test.filtro = comboBox.getSelectedItem().toString();
				if (Test.listado.size() == 0) {
					JOptionPane.showMessageDialog(null, "No se ha agregado nadie todavía.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					new MostrarFiltro();
					dispose();
				}

			}
		}
	}
}
