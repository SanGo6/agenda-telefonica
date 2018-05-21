package controlador;

import modelo.InformaModelo;
import vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {

	private InterrogaVista vista;
	private InformaModelo modelo;

	public void setVista(InterrogaVista vista) {
		this.vista = vista;
	}

	public void setModelo(InformaModelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public void addCliente() {
		if (vista.isParticular()) {
			addParticular();
		} else {
			addEmpresa();
		}
	}

	@Override
	public void addParticular() {
		String NIF = vista.getNIFCliente();
		String nombre = vista.getNombreCliente();
		String apellidos = vista.getApellidosCliente();
		String codpost = vista.getCodPostalCliente();
		String poblacion = vista.getPoblacionCliente();
		String provincia = vista.getProvinciaCliente();
		String email = vista.getEmailCliente();
		double precioTarifa = vista.getPrecioTarifaCliente();
		boolean tardes = vista.getTarifaTardesCliente();
		boolean domingos = vista.getTarifaDomingosCliente();
		modelo.altaParticular(NIF, nombre, apellidos, codpost, poblacion, provincia, email, precioTarifa, tardes,
				domingos);
	}

	@Override
	public void addEmpresa() {
		String NIF = vista.getNIFCliente();
		String nombre = vista.getNombreCliente();
		String codpost = vista.getCodPostalCliente();
		String poblacion = vista.getPoblacionCliente();
		String provincia = vista.getProvinciaCliente();
		String email = vista.getEmailCliente();
		double precioTarifa = vista.getPrecioTarifaCliente();
		boolean tardes = vista.getTarifaTardesCliente();
		boolean domingos = vista.getTarifaDomingosCliente();
		modelo.altaEmpresa(NIF, nombre, codpost, poblacion, provincia, email, precioTarifa, tardes, domingos);
	}

	@Override
	public void removeCliente() {
		String NIF = vista.getNIFCliente();
        modelo.bajaCliente(NIF);
	}

	@Override
	public void changeTarifa() {
		String NIF = vista.getNIFCliente();
        double precioTarifa = vista.getPrecioTarifaCliente();
        boolean tardes = vista.getTarifaTardesCliente();
        boolean domingos = vista.getTarifaDomingosCliente();
        modelo.cambiarTarifa(NIF, precioTarifa, tardes, domingos);
	}

	@Override
	public void addLlamada() {
		String NIF = vista.getNIFLlamada();
        String tlfn = vista.getTlfnLlamada();
        String fecha = vista.getFechaLlamada();
        String hora = vista.getHoraLlamada();
        int  duracion = vista.getDuracionLlamada();
        
        modelo.anyadirLlamada(NIF, tlfn, fecha, hora,duracion);
	}

	@Override
	public void addFactura() {
		String NIF = vista.getNIFFactura();
        String FechaInicio = vista.getFechaInicioFactura();
        String FechaFin = vista.getFechaFinFactura();
        
        modelo.anyadirFactura(NIF, FechaInicio, FechaFin);
	}

	@Override
	public void searchEntreFechas() {

        if(vista.aBuscarEntreFechas() < 0 ) {
            modelo.buscarClientesEntreFechas();
        }
        else if(vista.aBuscarEntreFechas() == 0 )
            modelo.buscarLlamadasEntreFechas();
        else if(vista.aBuscarEntreFechas() > 0 )
            modelo.buscarFacturasEntreFechas();
	}

	@Override
	public void save() {
		modelo.guardar();
	}

}
