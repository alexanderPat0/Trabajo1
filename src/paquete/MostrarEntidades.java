package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	private String[] filtros = {"Sin fitro", "Mayores de edad" , "Menores de edad" , "Sin pareja" , "Casados", "Jubilados"};
	
	public MostrarEntidades() {
		setTitle(" Listado personas");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo = new JLabel("Todas las personas:");
		lblInfo.setBounds(25, 25, 117, 14);
		contentPane.add(lblInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 50, 383, 146);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[]{"DNI" , "Sexo" ,"Nombre", "Apellidos", "Edad" , "Estado Civil" , "Num. Hijos"});	

		tabla = new JTable(model);
		scrollPane.setViewportView(tabla);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(25, 207, 89, 23);
		contentPane.add(btnVolver);
		
		lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setBounds(217, 211, 46, 14);
		contentPane.add(lblFiltrar);
		
		comboBox = new JComboBox(filtros);
		comboBox.setBounds(260, 207, 148, 22);
		contentPane.add(comboBox);
		
		ManejadorBoton manejador = new ManejadorBoton();
		btnVolver.addActionListener(manejador);
	}
	
	private class ManejadorBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnVolver)
				new Frame1();
				dispose();
		}
		
	}
}