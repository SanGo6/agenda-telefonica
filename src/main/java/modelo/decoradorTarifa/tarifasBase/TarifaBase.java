package modelo.decoradorTarifa.tarifasBase;

import java.io.Serializable;

import modelo.decoradorTarifa.Tarifa;
import modelo.decoradorTarifa.TarifaEnum;

public class TarifaBase extends Tarifa implements Serializable {

	private static final long serialVersionUID = 9103898352338840394L;

	public TarifaBase(double precio) {
		super(precio);
	}

	@Override
	public String getDescripcion() {
		return "Tarifa basica de" + super.getPrecio() + " cnt/min";
	}

	@Override
	public boolean contieneTarifa(TarifaEnum tipo) {
		if (tipo.equals(TarifaEnum.BASICA))
			return true;
		return false;
	}
}
