package paquete;

import java.io.Serializable;

public class Persona implements Serializable {

	private String dni, sexo, nombre, apellidos, estadoCivil, hijos;
	private int edad, numHijos;

	public Persona(String dni, String sexo, String nombre, String apellidos, int edad, String estadoCivil, String hijos,
			int numHijos) {
		super();
		this.dni = dni;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.estadoCivil = estadoCivil;
		this.numHijos = numHijos;
		this.hijos = hijos;

	}

	public Persona() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public String getHijos() {
		return hijos;
	}

	public void setHijos(String hijos) {
		this.hijos = hijos;
	}

	@Override
	public String toString() {
		return "Dni: " + dni + ", sexo: " + sexo + ", nombre: " + nombre + ", apellidos: " + apellidos
				+ ", estado civil: " + estadoCivil + ", edad: " + edad + ", hijos: " + hijos + ", numero de hijos: "
				+ numHijos;
	}

}
