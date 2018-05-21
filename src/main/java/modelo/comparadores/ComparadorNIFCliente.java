package modelo.comparadores;
import java.io.Serializable;
import java.util.Comparator;

import modelo.cliente.Cliente;

public class ComparadorNIFCliente implements Comparator<Cliente>, Serializable {
	
	private static final long serialVersionUID = -7851710350805386292L;

	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getNif().compareTo(c2.getNif());
	}
	
}
