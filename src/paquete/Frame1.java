package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	
	private JButton btnCrearEntidad, btnVerEntidad;
	
	private JLabel label1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame1() {
		setVisible(true);
		setTitle("Registro civil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 208);
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
	}
	
	private class ManejadorBoton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnCrearEntidad) {
				new CrearEntidad();
				dispose();
			}else {
				new MostrarEntidades();
				dispose();
			}
				
						
		}
		
	}
	
}
