package modelo.objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Llamada implements Fecha, Serializable {

	private static final long serialVersionUID = 7972283013267920898L;

	private String telefono;
	private GregorianCalendar fecha;
	private int duracion; // Lo contaremos en segundos, por eso utilizamos int

	public Llamada(String telefono, GregorianCalendar fecha, int duracion) {
		this.telefono = telefono;
		this.fecha = fecha;
		this.duracion = duracion;
	}

	public Llamada(Llamada l) {
		this.telefono = new String(l.telefono);
		this.fecha = (GregorianCalendar) l.fecha.clone();
		this.duracion = l.duracion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public GregorianCalendar getFecha() {
		return this.fecha;
	}

	public int getDuracion() {
		return this.duracion;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy  HH':'mm':'ss");
		StringBuilder sb = new StringBuilder();
		sb.append(telefono);
		sb.append("    ");
		sb.append(sdf.format(fecha.getTime()));
		sb.append("    ");
		sb.append(duracion);
		sb.append(" min");
		return sb.toString();
	}
}
