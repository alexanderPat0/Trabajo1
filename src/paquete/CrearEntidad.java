package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;

public class CrearEntidad extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombre, lblDni, lblApellidos, lblEdad, lblEstado, lblHijos,  lblNumHijos, lblSexo;
	private JTextField txt_Dni, txt_Nombre, txt_Apellidos, txt_NumHijos, txt_Edad ;
	private JComboBox<String> comboBox_Sexo, comboBox_EstadoCivil, comboBox_Hijo;
	private JButton btnCancelar,  btnAceptar;
	private Persona p;
	private String[] comboBox_Sexos = {"M" , "F"}  ;
	private String[] comboBox_Hijos = { "No" , "Si"};
	private String[] comboBox_EstadosCiviles = {"Sin pareja" , "Casado" , "Viudo"};

	public CrearEntidad() {
		setVisible(true);
		setTitle("Creación de entidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 355, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 60, 60, 14);
		contentPane.add(lblNombre);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(29, 14, 60, 14);
		contentPane.add(lblDni);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(29, 85, 68, 14);
		contentPane.add(lblApellidos);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(29, 110, 46, 14);
		contentPane.add(lblEdad);
		
		lblEstado = new JLabel("Estado civil:");
		lblEstado.setBounds(29, 135, 77, 14);
		contentPane.add(lblEstado);
		
		lblHijos = new JLabel("Hijos:");
		lblHijos.setBounds(29, 164, 46, 14);
		contentPane.add(lblHijos);
		
		txt_Dni = new JTextField();
		txt_Dni.setToolTipText("Case sensitive");
		txt_Dni.setBounds(157, 11, 144, 20);
		contentPane.add(txt_Dni);
		txt_Dni.setColumns(10);
		
		txt_Nombre = new JTextField();
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(157, 57, 144, 20);
		contentPane.add(txt_Nombre);
		
		txt_Apellidos = new JTextField();
		txt_Apellidos.setColumns(10);
		txt_Apellidos.setBounds(157, 82, 144, 20);
		contentPane.add(txt_Apellidos);
		
		comboBox_EstadoCivil = new JComboBox(comboBox_EstadosCiviles);
		comboBox_EstadoCivil.setBounds(157, 132, 134, 22);
		contentPane.add(comboBox_EstadoCivil);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(29, 37, 46, 14);
		contentPane.add(lblSexo);
		
		comboBox_Sexo = new JComboBox(comboBox_Sexos);
		comboBox_Sexo.setBounds(157, 33, 46, 22);
		contentPane.add(comboBox_Sexo);
		
		comboBox_Hijo = new JComboBox(comboBox_Hijos);
		comboBox_Hijo.setBounds(68, 160, 58, 22);
		contentPane.add(comboBox_Hijo);
		
		lblNumHijos = new JLabel("Si tiene... ¿Cuántos?");
		lblNumHijos.setBounds(136, 164, 127, 14);
		contentPane.add(lblNumHijos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(49, 203, 89, 23);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(177, 203, 89, 23);
		contentPane.add(btnAceptar);
		
		txt_NumHijos = new JTextField();
		txt_NumHijos.setBounds(254, 161, 47, 20);
		contentPane.add(txt_NumHijos);
		txt_NumHijos.setColumns(10);
		
		txt_Edad = new JTextField();
		txt_Edad.setColumns(10);
		txt_Edad.setBounds(157, 107, 144, 20);
		contentPane.add(txt_Edad);
		
		ManejadorBoton manejador = new ManejadorBoton();
		btnAceptar.addActionListener(manejador);
		btnCancelar.addActionListener(manejador);
		
		
		//Si la persona es menor de edad, se asume que no tiene pareja ni hijos.		
		txt_Edad.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarEstadoNumeroDeHijosTextField();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarEstadoNumeroDeHijosTextField();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarEstadoNumeroDeHijosTextField();
			}
        });
		}
		
		private void actualizarEstadoNumeroDeHijosTextField() {
	        String edadStr = txt_Edad.getText();
	        if (!edadStr.isEmpty()) {
	            try {
	                int edad = Integer.parseInt(edadStr);
	                txt_NumHijos.setText("0");
	                txt_NumHijos.setEnabled(edad >= 18);
	                comboBox_Hijo.setSelectedIndex(0);
	                comboBox_Hijo.setEnabled(edad >= 18);
	                comboBox_EstadoCivil.setSelectedIndex(0);
	                comboBox_EstadoCivil.setEnabled(edad >= 18);
	            } catch (NumberFormatException ex) {
	            	
	            }
	        
	    }
		

		

	}
	
		private class ManejadorBoton implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAceptar) {
					
					//Crear una variable boolean que compruebe que todo está en orden. Si no lo está, que salga un JPanel que indique error y vuelva a la
					//pantalla de creación de persona sin borrar los datos que ya estaban escritos.
					
					boolean todoCorrecto = true;
					try {
						
						String dniPersona = txt_Dni.getText();
						String sexo = (String)comboBox_Sexo.getSelectedItem();
						String nombre =  txt_Nombre.getText();
						String apellidos = txt_Apellidos.getText();
						String estadoCiv = (String)comboBox_EstadoCivil.getSelectedItem();
						int edad =  Integer.parseInt(txt_Edad.getText());
						int numHijos = Integer.parseInt(txt_NumHijos.getText());
						String tieneHijos = (String)comboBox_Hijo.getSelectedItem();
						
						//Comprobar que esté todo bien, en caso contrario. todoCorrecto = false
						if(	!dniPersona.matches("\\d{8}[A-NO-Z]") || !nombre.matches("[a-zA-Z]+") ||
							!apellidos.matches("[a-zA-Z\\s]+") ||edad <= 0 ||numHijos < 0 || 
							(tieneHijos.matches("Si") && numHijos == 0) || 
							tieneHijos.matches("No") && numHijos > 0 ) {
							JOptionPane.showMessageDialog(null, "Se ha introducido algún dato erróneo.", "Error", JOptionPane.ERROR_MESSAGE	);
						}else { 
							//Según la edad de la persona, se creará una instancia menor de edad o adulta.
							if(edad < 18)
								p = new Persona(dniPersona, sexo, nombre, apellidos, edad);
							else
								p = new Persona(dniPersona, sexo , nombre , apellidos , edad , estadoCiv , tieneHijos, numHijos );
						
							JOptionPane.showMessageDialog(null, "Persona añadida al registro.", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
								
					}catch(Exception e2){
						
						JOptionPane.showMessageDialog(null, "Faltan datos por rellenar.", "Error", JOptionPane.ERROR_MESSAGE	);

					}
					
				}else if(e.getSource() == btnCancelar) {					
					new Frame1();
					dispose();
				}
				
			}

		}
}
