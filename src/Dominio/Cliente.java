package Dominio;

public class Cliente {
	private String nombre;
	private int numCuenta;
	private int saldo;
	
	public Cliente(String nombre, int numCuenta, int saldo) {		
		this.nombre = nombre;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}

	public Cliente(int numCuenta) {	
		this.numCuenta = numCuenta;
	}

	public Cliente() {
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", numCuenta=" + numCuenta + ", saldo=" + saldo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
