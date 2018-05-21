package modelo.gestores;

import java.util.Collection;
import java.util.GregorianCalendar;

import modelo.objetos.Factura;

public interface GestorFacturaInt {
	public boolean addFactura(Factura f) ;
	
	public Factura getFactura(int identificador) ;
	
	public Collection<Factura> facturas() ;

	public Collection<Factura> facturasEntreFechas(GregorianCalendar fechaInicio, GregorianCalendar fechaFinal);
	
}
