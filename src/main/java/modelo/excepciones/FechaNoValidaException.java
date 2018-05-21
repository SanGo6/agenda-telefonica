package modelo.excepciones;

@SuppressWarnings("serial")
public class FechaNoValidaException extends Exception {
	public FechaNoValidaException(){
		super("La fecha inicial no puede ser posterior a la fecha final.");
	}
}
