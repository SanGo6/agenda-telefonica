package modelo.gestores;
import java.io.Serializable;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import modelo.cliente.Cliente;
import modelo.objetos.Factura;
import modelo.objetos.Fecha;
import modelo.objetos.ObjetosEntreFechas;



public class GestorFacturas implements GestorFacturaInt, Serializable{


	private static final long serialVersionUID = 5038449572620750329L;
	
	private HashMap<Integer, Factura> facturas;
	
	public GestorFacturas() {
		facturas= new HashMap<Integer, Factura>();																
	}

	
	public boolean addFactura(Factura f) {						//Anyadir las facturas del cliente
		facturas.put(f.getIdentificador(), f);
		return true;
	}
	
	public Factura getFactura(int identificador) { 				//Conseguir las facturas a partir de su identificador
		return facturas.get(identificador);
	}
	
	public Collection<Factura> facturas() {		//Cambia de mapa a collection
		return facturas.values();
	}
	
	@Override
	public String toString() {											//Devuelve todas las facturas del cliente
		StringBuilder sb = new StringBuilder();
		for (Integer keyFactura : facturas.keySet()) {
			sb.append(getFactura(keyFactura));
			sb.append("\n\n");
		}
		return sb.toString();
	}


	@Override
	public Collection<Factura> facturasEntreFechas(GregorianCalendar fechaInicio, GregorianCalendar fechaFinal) {
		Set<Fecha> entreFechas = ObjetosEntreFechas.objetosEntreFechas(facturas.values(), fechaInicio, fechaFinal);
		Set<Factura> fac = new HashSet<Factura>();
		for(Fecha a : entreFechas )
			fac.add( (Factura) a );
		return fac;
	}
}
