package models;

public class CuentaCorriente {
	private int numeroCuenta;
	private double saldo;
	private Persona titular;

	// Constructor
	public CuentaCorriente(int numeroCuenta, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = 0;
		this.titular = titular;
	}

	// Getters y setters
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sumarCantidad(double cantidad) { // para meter dinero a la cuenta
		this.saldo += cantidad;
	}

	public void restarCantidad(double cantidad) { //para sacar dinero de la cuenta
		this.saldo -= cantidad;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}

}
