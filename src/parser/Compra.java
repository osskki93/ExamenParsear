package parser;

public class Compra {
	
	int cantidad;
	double precio;
	
	public Compra() {
		
	}
	
	public Compra(int cantidad, double precio) {
		
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		String res = null;
		res += "Operaciones: \n";
		res = "\nCantidad: "+cantidad+ "\nPrecio: "+precio;
		return res;
	}
	

}
