package modelo.objetos;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import modelo.comparadores.ComparadorFechas;

public class ObjetosEntreFechas {
	
	public static Set<Fecha> objetosEntreFechas (Collection<? extends Fecha> objetos, Calendar fechaInicio, Calendar fechaFinal){
		Set<Fecha> objetosEntreFechas = new HashSet<Fecha>();
		GregorianCalendar fechaObjeto;
		int dif1, dif2;
		for (Fecha objeto : objetos){
			fechaObjeto = objeto.getFecha();
			
			if(fechaObjeto.compareTo(fechaInicio) > 0 && fechaObjeto.compareTo(fechaFinal) < 0)
				objetosEntreFechas.add(objeto);
		}
		return objetosEntreFechas;
	}
}
