package modelo;

import modelo.gestores.GestorClientes;

public interface InformaModelo {
	public void altaEmpresa(String NIF, String nombre, String codpost, String poblacion, String provincia, String email,
			double precioTarifa, boolean tardes, boolean domingos);

	public void altaParticular(String NIF, String nombre, String apellidos, String codpost, String poblacion,
			String provincia, String email, double precioTarifa, boolean tardes, boolean domingos);

	public void bajaCliente(String NIF);

	public void cambiarTarifa(String NIF, double base, boolean tardes, boolean domingos);

	public void anyadirLlamada(String NIF, String tlfn, String fecha, String hora, int duracion);

	public void anyadirFactura(String nif, String fechaInicio, String fechaFin);

	public void buscarClientesEntreFechas();

	public void buscarLlamadasEntreFechas();

	public void buscarFacturasEntreFechas();

	public void setGestorClientes(GestorClientes gestorClientes);

	public void guardar();
}
