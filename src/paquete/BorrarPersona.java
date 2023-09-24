package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BorrarPersona extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEliminar, btnVolver;

	public BorrarPersona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 207);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel("Introduzca el dni de la persona que quiere eliminar del registro");
		lblInfo.setBounds(33, 26, 355, 14);
		contentPane.add(lblInfo);
		
		textField = new JTextField();
		textField.setBounds(131, 51, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(148, 82, 89, 23);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(148, 116, 89, 23);
		contentPane.add(btnVolver);
		
		ManejadorBoton manejador = new ManejadorBoton();
		btnVolver.addActionListener(manejador);
		btnEliminar.addActionListener(manejador);
		
	}
	
	private class ManejadorBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnVolver) {
				new MostrarEntidades();
				dispose();
			}else {
				String dni = textField.getText();
				if(!dni.matches("\\d{8}[A-NO-Z]"))
					JOptionPane.showMessageDialog(null, "El DNI introducido es incorrecto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				else {
					int eleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar a ese usuario?" , "Seguro?!!?!?!" ,  JOptionPane.YES_NO_OPTION );
					if(eleccion == JOptionPane.YES_OPTION) {
						
					for (Persona p : Test.listado) {
						System.out.println(p);
					}
						
						
						
						JOptionPane.showMessageDialog(null, "La persona ha sido borrada del registro.");
						dispose();
						new MostrarEntidades();
					}
				}
					
			}
			
		}
		
	}
}
