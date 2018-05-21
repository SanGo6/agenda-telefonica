package modelo.comparadores;
import java.io.Serializable;
import java.util.Comparator;

import modelo.objetos.Factura;

public class ComparadorFacturaIdentificador implements Comparator<Factura>, Serializable {
	

	private static final long serialVersionUID = 5645220475369588755L;

	@Override
	public int compare(Factura f1, Factura f2) {
		return f1.getIdentificador() - f2.getIdentificador();
	}
	
}
