package modelo.factory.oferta;

import modelo.decoradorTarifa.OfertaEnum;
import modelo.decoradorTarifa.Tarifa;

public interface OfertasFactory {

	public Tarifa getTarifa(OfertaEnum tipo, Tarifa original);
}
