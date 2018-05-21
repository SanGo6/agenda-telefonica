package modelo.objetos;

import java.io.Serializable;

public class Direccion implements Serializable {


	private static final long serialVersionUID = 1213844362092780597L;
	
	private String codPostal;
	private String provincia;
	private String poblacion;
	
	
	//#########################################################################
	//#####################  		CONSTRUCTORES			################################
	//#########################################################################
	
	public Direccion(String codPostal, String provincia, String poblacion){
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.poblacion = poblacion;
		
	}
	
	public String getCodigoPostal(){
		return this.codPostal;
	}
	public String getProvincia(){
		return this.provincia;
	}
	public String getPoblacion(){
		return this.poblacion;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(codPostal);
		sb.append(" ");
		sb.append(poblacion);
		sb.append(" (");
		sb.append(provincia);
		sb.append(")");
		return sb.toString();
	}
	
}
