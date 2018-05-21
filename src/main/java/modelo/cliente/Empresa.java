package modelo.cliente;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;

public class Empresa extends Cliente implements Serializable {

	private static final long serialVersionUID = 7838505969491954455L;

	public Empresa(String nif, String nombre, Direccion direccion, String email, GregorianCalendar fecha_alta,
			Tarifa tarifa) {
		super(nif, nombre, direccion, email, fecha_alta, tarifa);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		StringBuilder sb = new StringBuilder(super.getNombre());
		sb.append(" (");
		sb.append(getNif());
		sb.append(")\n");
		sb.append(super.getEmail());
		sb.append("\n");
		sb.append(super.getDireccion());
		sb.append("\n");
		sb.append("Fecha alta: ");
		sb.append(sdf.format(super.getFecha().getTime()));
		sb.append("\n");
		sb.append("Tarifa contratada: ");
		sb.append(super.getTarifa());
		sb.append(" euros/min");
		return sb.toString();
	}
}
