package parser;

public class Parser_Acciones {

	public static void main (String [] args) {
		
		Parser parser = new Parser ();
		parser.parseFicheroXML("acciones.xml");
		parser.parseDocument();
		parser.print();
	}

}
