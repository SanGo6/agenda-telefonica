package modelo.factory.oferta;

import modelo.decoradorTarifa.OfertaEnum;
import modelo.decoradorTarifa.Tarifa;
import modelo.decoradorTarifa.ofertas.OfertaDomingosGratis;
import modelo.decoradorTarifa.ofertas.OfertaTardesReducidas;

public class OfertasFabricaParametrizada implements OfertasFactory {

	@Override
	public Tarifa getTarifa(OfertaEnum tipo, Tarifa original) {
		Tarifa nueva = null;
		switch(tipo){
		case DOMINGOS_REDUCIDOS:
			nueva = new OfertaDomingosGratis(original, 2);
			break;
		case TARDES_GRATIS:
			nueva = new OfertaTardesReducidas(original, 0);
			break;
		default:
			break;
		
		}
		return nueva;
	}

}
