package modelo.gestores;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import modelo.objetos.Fecha;
import modelo.objetos.Llamada;
import modelo.objetos.ObjetosEntreFechas;



public class GestorLlamadas implements GestorLlamadasInt, Serializable {


	private static final long serialVersionUID = 6167028586755899983L;
	
	private Set<Llamada> llamadas;
	public GestorLlamadas() {
		llamadas = new HashSet<Llamada>();											//Inicializar con new, revisar el resto
	}
	
	public boolean addLlamada(Llamada l) {
		llamadas.add(l);
		return true;
	}
	
	public List<Llamada> llamadasEntreFechas(Calendar fechaInicio, Calendar fechaFin) {
		Set<Fecha> llamadasEntreFechas = ObjetosEntreFechas.objetosEntreFechas(llamadas, fechaInicio, fechaFin);
		List<Llamada> res = new LinkedList<Llamada> ();
		for (Fecha actual : llamadasEntreFechas){
			res.add((Llamada) actual);
		}
		return res;
	}
	
	public Set<Llamada> getLlamadas() {
		return llamadas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Llamada llamada : llamadas) {
			sb.append(llamada);
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
