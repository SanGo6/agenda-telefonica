package modelo.objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import modelo.cliente.Cliente;
import modelo.comparadores.ComparadorFechas;
import modelo.decoradorTarifa.Tarifa;
import modelo.excepciones.FechaNoValidaException;
import modelo.gestores.GestorLlamadasInt;

public class Factura implements Fecha, Serializable {

	private static final long serialVersionUID = 8803738561174746529L;

	private static Random generador = new Random();
	private static int codigo = generador.nextInt();

	private int identificador;
	private GregorianCalendar fechaEmision = new GregorianCalendar();
	private Tarifa tarifa;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private double importe;


	public Factura() {
		identificador = codigo;
		tarifa = null;
		importe = 0.0;
		codigo++;
	}

	public Factura(Tarifa tarifa, GregorianCalendar fechaIni, GregorianCalendar fechaFin, Collection<Llamada> llamadas)
			throws FechaNoValidaException {
		
		ComparadorFechas comparator = new ComparadorFechas();
		if (comparator.compare(fechaIni, fechaFin) <= 0)
			throw new FechaNoValidaException();
		
		this.identificador = codigo;
		this.fechaInicio = fechaIni;
		this.fechaFin = fechaFin;
		this.tarifa = tarifa;
		importe = 0.0;
		for ( Llamada actual: llamadas ) {
			importe += tarifa.calcularPrecio(actual);
		}
		
		codigo++;
	}

	public Factura(Factura f) {
		this.identificador = f.identificador;
		this.tarifa = f.tarifa;
		this.fechaEmision = (GregorianCalendar) f.fechaEmision.clone();
		this.importe = f.importe;
	}


	public static int calcularMinutos(Cliente c, Calendar fechaInicio, Calendar fechaFin) {
		GestorLlamadasInt gestor = c.getLlamadas();
		List<Llamada> llamadas = gestor.llamadasEntreFechas(fechaInicio, fechaFin);
		int aux = 0;
		for (Llamada llamada : llamadas)
			aux += llamada.getDuracion();
		return aux;
	}

	public int getIdentificador() {
		return identificador;
	}

	public GregorianCalendar getFecha() {
		return fechaEmision;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		StringBuilder sb = new StringBuilder();
		sb.append(identificador);
		sb.append("\n");
		sb.append("Tarifa contratada: ");
		sb.append(tarifa);
		sb.append(" �/min\n");
		sb.append("Fecha de emisi�n: ");
		sb.append(sdf.format(fechaEmision.getTime()));
		sb.append("\n");
		sb.append("Periodo de facturaci�n: ");
		sb.append(formatearFecha(fechaInicio) + "->" + formatearFecha(fechaFin));
		sb.append(" d�as\n");
		sb.append("Importe: ");
		sb.append(importe);
		sb.append(" �\n");
		return sb.toString();
	}

	public double getImporte() {
		return importe;
	}

	private String formatearFecha(Calendar calendar){
	    SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}
}
