package modelo.cliente;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;

public class Particular extends Cliente implements Serializable {

	private static final long serialVersionUID = -4144870995763095684L;
	private String apellidos;

	public Particular(String nif, String nombre, String apellido, Direccion direccion, String email,
			GregorianCalendar fecha_alta, Tarifa tarifa) {

		super(nif, nombre, direccion, email, fecha_alta, tarifa);
		this.apellidos = apellido;
	}

	@Override
	public String getNombre() {
		return super.getNombre() + ' ' + this.apellidos;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		StringBuilder sb = new StringBuilder(getNombre());
		sb.append(" (");
		sb.append(getNif());
		sb.append(")\n");
		sb.append(super.getEmail());
		sb.append(")\n");
		sb.append(getDireccion());
		sb.append("\n");
		sb.append("Fecha alta: ");
		sb.append(sdf.format(super.getFecha().getTime()));
		sb.append(")\n");
		sb.append("Tarifa contratada: ");
		sb.append(super.getTarifa());
		sb.append(")\n");
		return sb.toString();
	}
}
