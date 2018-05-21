package vista;

public interface InformaVista {
    public void actualizarTablaClientes();
    public void busquedaCliente(String NIF);
    public void nuevaLlamada();
    public void busquedaLlamada();
    public void actualizarTablaFacturas();
    public void busquedaFacturaCodigo();
    public void busquedaClientesEntreFechas();
    public void busquedaLlamadasEntreFechas();
    public void busquedaFacturasEntreFechas();
    public void error();

}
