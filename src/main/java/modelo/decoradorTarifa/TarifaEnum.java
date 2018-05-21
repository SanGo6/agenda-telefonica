package modelo.decoradorTarifa;

public enum TarifaEnum {
	BASICA("Precio de la tarifa basica");
	
	private String descripcion;
	private TarifaEnum(String descripcion){
		this.descripcion = descripcion;
	}
	 public static String options(){
		 StringBuilder sb = new StringBuilder();
		  for ( TarifaEnum tipo: values())
			  sb.append(tipo.ordinal() + ".- " + tipo.descripcion + "\n");
		  return sb.toString();
	 }
	 
	 public static TarifaEnum intTipo( int posicion){
		 return values()[posicion];
	 }
}
