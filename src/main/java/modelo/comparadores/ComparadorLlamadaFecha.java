package modelo.comparadores;
import java.io.Serializable;
import java.util.Comparator;

import modelo.objetos.Llamada;

public class ComparadorLlamadaFecha implements Comparator<Llamada>, Serializable {

	private static final long serialVersionUID = 4143806302461658333L;

	@Override
	public int compare(Llamada l1, Llamada l2) {
		return (int) (l1.getFecha().getTimeInMillis() - l2.getFecha().getTimeInMillis());
	}

}
