package modelo.decoradorTarifa;

import java.io.Serializable;

import modelo.objetos.Llamada;

public abstract class Oferta extends Tarifa implements Serializable {
	
	private static final long serialVersionUID = -5784569219139763815L;
	
	protected Tarifa original;
	
	public Oferta(Tarifa original, double precio){
		super(precio);
		this.original = original;
	}
	
	@Override
	public abstract double calcularPrecio(Llamada l);
	
	public abstract String  getDescripcion();
	
	public abstract boolean contieneOferta (OfertaEnum oferta);				
	
	public boolean contieneTarifa (TarifaEnum tarifa){
		return original.contieneTarifa(tarifa);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}
