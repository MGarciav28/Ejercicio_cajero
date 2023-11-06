package Dominio;

public abstract class Transaccion {
	private int id;
	private int numCuenta;
	private int monto;
	private String fecha;
	
	public Transaccion() {
		
	}

	public Transaccion(int id) {
		this.id=id;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", numCuenta=" + numCuenta + ", monto=" + monto + ", fecha=" + fecha + "]";
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public abstract void actualizarCuenta();
	

}
