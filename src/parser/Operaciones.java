package parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Operaciones {
	
	ArrayList <Compra> compras;
	ArrayList <Venta> ventas;
	
	public Operaciones(ArrayList<Compra> compras, ArrayList<Venta> ventas) {
		
		this.compras = compras;
		this.ventas = ventas;
		
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	
	@Override
	public String toString() {
		String res = null;
		Iterator it = compras.iterator();
		while (it.hasNext()) {
			Compra c = (Compra)it.next();
			res+= "" + c + ", ";
		}
		res += "\n---------------------------------";
		while (it.hasNext()) {
			Venta v = (Venta)it.next();
			res+= "" + v + ", ";
		}
		return res;
	}
	

}
