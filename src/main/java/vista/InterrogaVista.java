package vista;

public interface InterrogaVista {
    public boolean isParticular();
    public String getNIFCliente();
    public String getNombreCliente();
    public String getApellidosCliente();
    public String getCodPostalCliente();
    public String getPoblacionCliente();
    public String getProvinciaCliente();
    public String getEmailCliente();
    public double getPrecioTarifaCliente();
    public boolean getTarifaTardesCliente();
    public boolean getTarifaDomingosCliente();
    public String getNIFLlamada();
    public String getTlfnLlamada();
    public String getFechaLlamada();
    public String getHoraLlamada();
    public int getDuracionLlamada();
    public String getNIFFactura();
    public String getFechaInicioFactura();
    public String getFechaFinFactura();
    public String getFechaInicioEntreFechas();
    public String getFechaFinEntreFechas();
    public int aBuscarEntreFechas();
}
