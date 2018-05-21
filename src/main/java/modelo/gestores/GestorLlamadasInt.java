package modelo.gestores;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import modelo.objetos.Llamada;


public interface GestorLlamadasInt{
	
	public boolean addLlamada(Llamada l) ;
	
	public List<Llamada> llamadasEntreFechas(Calendar fechaInicio, Calendar fechaFin) ;
		
		
	
	public Set<Llamada> getLlamadas() ;
		
}
