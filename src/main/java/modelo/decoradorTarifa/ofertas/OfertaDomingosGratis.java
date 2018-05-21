package modelo.decoradorTarifa.ofertas;

import java.io.Serializable;
import java.util.Calendar;

import modelo.decoradorTarifa.Oferta;
import modelo.decoradorTarifa.OfertaEnum;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Llamada;

public class OfertaDomingosGratis extends Oferta implements Serializable {

	private static final long serialVersionUID = 4721104858280715663L;

	public OfertaDomingosGratis(Tarifa original, double precio) {
		super(original, precio);
	}

	@Override
	public double calcularPrecio(Llamada l) {
		
		// Si el dia de la semana es el domingo es gratuito
		if( l.getFecha().get(Calendar.DAY_OF_WEEK) == 0)
			return 0;
		
		// Si la tarifa no se aplica se calcula el coste segun las otras tarifas
		return super.original.calcularPrecio(l);
	}

	@Override
	public String getDescripcion() {
		return "\n" + super.toString() + "\n Para los domingos el precio es 0 euros/min";
	}

	@Override
	public boolean contieneOferta(OfertaEnum oferta) {
		if( oferta.equals(OfertaEnum.DOMINGOS_REDUCIDOS))
			return true;
		return super.original.contieneOferta(oferta);
	}
}
