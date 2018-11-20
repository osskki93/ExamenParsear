package parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Accion {
	
	String nombre;
	ArrayList <Operaciones> operaciones;
	
	public Accion(String nombre, ArrayList<Operaciones> operaciones) {
		
		this.nombre = nombre;
		this.operaciones = operaciones;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Operaciones> getOperaciones() {
		return operaciones;
	}


	public void setOperaciones(ArrayList<Operaciones> operaciones) {
		this.operaciones = operaciones;
	}
	
	@Override
	public String toString() {
		String res = null;
		res = "Nombre: " + nombre+"\n";
		res += "Operaciones: ";
		Iterator it = operaciones.iterator();
		while (it.hasNext()) {
			Operaciones o = (Operaciones)it.next();
			res+= "" + o + ", ";
		}
	
		return res;
	}
	
	
}

