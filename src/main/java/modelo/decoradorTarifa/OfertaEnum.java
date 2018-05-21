package modelo.decoradorTarifa;

import java.io.Serializable;

public enum OfertaEnum implements Serializable {
	TARDES_GRATIS("Tardes gratuitas de 16:00 a 22:00"),
	DOMINGOS_REDUCIDOS("Sabados reducidos durante todo el dia");
	
	private String descripcion;
	
	private OfertaEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static String opciones() {
		StringBuilder sb = new StringBuilder();
		for(OfertaEnum tipo : values() ) 
			sb.append(tipo.ordinal() + "-" + tipo.descripcion + "\n");
		return sb.toString();
	}
	
	public static OfertaEnum intATipo( int posicion )  {
		return values()[posicion];
	}
}
