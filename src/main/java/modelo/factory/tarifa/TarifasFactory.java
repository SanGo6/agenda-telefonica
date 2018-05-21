package modelo.factory.tarifa;

import modelo.decoradorTarifa.Tarifa;
import modelo.decoradorTarifa.TarifaEnum;

public interface TarifasFactory {

	public Tarifa getTarifa(TarifaEnum tipo);
	
}
