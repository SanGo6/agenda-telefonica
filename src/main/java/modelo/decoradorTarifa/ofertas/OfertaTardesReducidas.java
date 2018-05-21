package modelo.decoradorTarifa.ofertas;

import java.io.Serializable;
import java.util.Calendar;

import modelo.decoradorTarifa.Oferta;
import modelo.decoradorTarifa.OfertaEnum;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Llamada;

public class OfertaTardesReducidas extends Oferta implements Serializable {

	private static final long serialVersionUID = 4721104858280715663L;

	public OfertaTardesReducidas(Tarifa original, double precio) {
		super(original, precio);
	}

	@Override
	public double calcularPrecio(Llamada l) {
		
		// Si se ha realizado en la franja horaria se aplica el precio de la oferta
		if( l.getFecha().get(Calendar.HOUR_OF_DAY) >= 16 && l.getFecha().get(Calendar.HOUR_OF_DAY) <= 22 )
			return super.getPrecio();
		
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
