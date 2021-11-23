package models;

public class Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuentaX;

	// Constructor
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuentaX) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuentaX = cuentaX;
	}

	// Getters y setters
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public CuentaCorriente getCuentaX() {
		return cuentaX;
	}

	public void setCuentaX(CuentaCorriente cuentaX) {
		this.cuentaX = cuentaX;
	}

	public void cobrarSueldo() {
		this.cuentaX.setSaldo(this.sueldo);
		
	}

	public void sacarPasta(double cantidad) {
		double saldo = this.cuentaX.getSaldo();
		saldo -= cantidad;
		this.cuentaX.setSaldo(saldo);
	}

	public void subirSueldo(double nuevoSueldo) {
		this.sueldo = nuevoSueldo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo
				+ ", saldo=" + cuentaX.getSaldo() + "]";
	}

}
