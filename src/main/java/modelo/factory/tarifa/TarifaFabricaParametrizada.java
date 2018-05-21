package modelo.factory.tarifa;

import modelo.decoradorTarifa.Tarifa;
import modelo.decoradorTarifa.TarifaEnum;
import modelo.decoradorTarifa.tarifasBase.TarifaBase;

public class TarifaFabricaParametrizada implements TarifasFactory {

	@Override
	public Tarifa getTarifa(TarifaEnum tipo) {
		
		Tarifa base = null;
		
		switch(tipo) {
			case BASICA:
				base = new TarifaBase(15);
				break;
			default:
				break;
		}
		return base;
	}

}
