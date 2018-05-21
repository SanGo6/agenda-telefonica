package modelo;

public interface InterrogaModelo {
	
	public String[][] getClientes();

	public String[][] getLlamadas(String text);

	public String[][] getFacturas(String text);

	public String[][] getClientesEntreFechas(String inicio, String fin);

	public String[][] getLlamadasEntreFechas(String NIF, String inicio, String fin);

	public String[][] getFacturasEntreFechas(String NIF, String inicio, String fin);

	public String[] getFactura(String code);
	
}
