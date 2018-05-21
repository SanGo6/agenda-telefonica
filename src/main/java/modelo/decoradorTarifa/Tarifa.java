package modelo.decoradorTarifa;

import java.io.Serializable;

import modelo.objetos.Llamada;


public abstract class Tarifa implements Serializable {
	
	
	private static final long serialVersionUID = -5195366690884697251L;
	
	private double precio;

	public Tarifa (double precio){
		this.precio = precio;
	}
	public  double getPrecio(){
		return this.precio;
	}
	public abstract String  getDescripcion();
	public double calcularPrecio(Llamada l){
		return precio*l.getDuracion();
	}
	public abstract boolean contieneTarifa (TarifaEnum tarifa);			
	
	public boolean contieneOferta(OfertaEnum oferta){
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getPrecio());
		return sb.toString();
}
	
}
