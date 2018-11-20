package parser;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Parser {
	
	private Document dom = null;
	private ArrayList <Accion> acciones = null;
	
	public Parser () {
		acciones = new ArrayList<Accion>();
	}
	
	public void parseFicheroXML (String fichero) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
	
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void parseDocument() {
		
		Element docEle = dom.getDocumentElement();
		NodeList n1 = docEle.getElementsByTagName("accion");
		
		if (n1 != null && n1.getLength() > 0) {
			for (int i = 0; i < n1.getLength(); i++) {
				
				Element el = (Element) n1.item(i);
				Accion a = getAccion(el);
				acciones.add(a);
				
			}
		}
	}
	
	public Accion getAccion(Element accionEle) {
		
		String nombre = getTextValue(accionEle, "nombre");
		ArrayList  operaciones = getArray(accionEle, "operaciones");	
		Accion a = new Accion (nombre, operaciones);
		return a;
		
	}
	
	private String getTextValue (Element ele, String tagName) {
		
		String textValue = null;
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			textValue = el.getFirstChild().getTextContent();
		}
		
		return textValue;
	}
	
	private ArrayList<Operaciones> getArray (Element ele, String tagName) {
		
		ArrayList <Operaciones> operaciones = new ArrayList<Operaciones>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlOperaciones = el.getElementsByTagName("operaciones");
			
			if (nlOperaciones != null && nlOperaciones.getLength() > 0) {
				for (int i = 0; i < nlOperaciones.getLength(); i++) {
					Element e1 = (Element) nlOperaciones.item(i);
					ArrayList<Compra> compras = getArrayListCompra(e1, "compras");
					ArrayList<Venta> ventas = getArrayListVenta(e1,"ventas");
					Operaciones o = new Operaciones(compras, ventas);
					operaciones.add(o);
					}
			}
			
		}
	
		return operaciones;
	}	
	
	private ArrayList<Compra> getArrayListCompra (Element ele, String tagName) {
		
		ArrayList <Compra> compras = new ArrayList<Compra>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlCompras = el.getElementsByTagName("compra");
			
			if (nlCompras != null && nlCompras.getLength() > 0) {
				for (int i = 0; i < nlCompras.getLength(); i++) {
					Element e1 = (Element) nlCompras.item(i);
					int cantidad = getIntValue(e1, "cantidad");
					double precio = getDoubleValue(e1,"precio");
					Compra c = new Compra(cantidad, precio);
					compras.add(c);
					}
			}
			
		}
	
		return compras;
	}
	
	private ArrayList<Venta> getArrayListVenta (Element ele, String tagName) {
		
		ArrayList <Venta> ventas = new ArrayList<Venta>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlVentas = el.getElementsByTagName("venta");
			
			if (nlVentas != null && nlVentas.getLength() > 0) {
				for (int i = 0; i < nlVentas.getLength(); i++) {
					Element e1 = (Element) nlVentas.item(i);
					int cantidad = getIntValue(e1, "cantidad");
					double precio = getDoubleValue(e1,"precio");
					Venta v = new Venta(cantidad, precio);
					ventas.add(v);
					}
			}
			
		}
	
		return ventas;
	}
	
	private int getIntValue (Element ele, String tagName) {
		
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	private int getDoubleValue (Element ele, String tagName) {
		
		return (int) Double.parseDouble(getTextValue(ele,tagName));
	}
	
	public void print () {
		
		Iterator it = acciones.iterator();
		while (it.hasNext()) {
			Accion a = (Accion) it.next();
			System.out.println(a);
		}
			
		}

}
