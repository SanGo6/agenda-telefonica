package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import main.UtilidadesMemoria;
import modelo.cliente.Cliente;
import modelo.cliente.Particular;
import modelo.decoradorTarifa.OfertaEnum;
import modelo.decoradorTarifa.Tarifa;
import modelo.decoradorTarifa.TarifaEnum;
import modelo.factory.cliente.factoryCliente;
import modelo.factory.cliente.implementacionCliente;
import modelo.factory.oferta.OfertasFabricaParametrizada;
import modelo.factory.oferta.OfertasFactory;
import modelo.factory.tarifa.TarifaFabricaParametrizada;
import modelo.factory.tarifa.TarifasFactory;
import modelo.gestores.GestorClientes;
import modelo.gestores.GestorFacturaInt;
import modelo.gestores.GestorLlamadasInt;
import modelo.objetos.Direccion;
import modelo.objetos.Factura;
import modelo.objetos.Llamada;
import vista.InformaVista;

public class ImplementacionModelo implements InformaModelo, InterrogaModelo {

	private InformaVista vista;
	private GestorClientes gestorClientes = new GestorClientes();

	@Override
	public void setGestorClientes(GestorClientes gestorClientes) {
		this.gestorClientes = gestorClientes;
	}

	public void setVista(InformaVista vista) {
		this.vista = vista;
	}

	@Override
	public String[][] getClientes() {
		// "Tipo", "NIF", "Nombre", "Direccion,"Email", "Tarifa"
		String[][] clientes = new String[gestorClientes.clientes().size()][6];
		Collection<Cliente> lista = gestorClientes.clientes();
		int i = 0;
		for (Cliente actual : lista) {
			if (actual instanceof Particular)
				clientes[i][0] = "PARTICULAR";
			else
				clientes[i][0] = "EMPRESA";
			clientes[i][1] = actual.getNif();
			clientes[i][2] = actual.getNombre();
			clientes[i][3] = actual.getDireccion().toString();
			clientes[i][4] = actual.getEmail();
			clientes[i][5] = actual.getTarifa().getDescripcion();
			i++;
		}
		return clientes;
	}

	@Override
	public String[][] getLlamadas(String nif) {

		Cliente cliente = gestorClientes.getCliente(nif);

		if (cliente == null) {
			vista.error();
			return new String[0][3];
		}

		// "Tlfn", "Fecha", "Duracion"
		GestorLlamadasInt gestorLlamadas = cliente.getLlamadas();
		Set<Llamada> listaLlamadas = gestorLlamadas.getLlamadas();
		
		String[][] llamadas = new String[listaLlamadas.size()][3];
		System.out.println("Obteniendo todas las llamadas del cliente con nif " + nif);
		int i = 0;
		for (Llamada actual : listaLlamadas) {
			System.out.println(actual.toString());
			llamadas[i][0] = actual.getTelefono();
			llamadas[i][1] = formatearFecha(actual.getFecha());
			llamadas[i][2] = "" + actual.getDuracion();
			i++;
		}

		return llamadas;
	}

	@Override
	public String[][] getFacturas(String nif) {
		Cliente cliente = gestorClientes.getCliente(nif);

		if (cliente == null) {
			vista.error();
			return new String[0][3];
		}

		GestorFacturaInt gestorFacturas = cliente.getFacturas();
		Collection<Factura> listaFacturas = gestorFacturas.facturas();
		
		// "Identificador", "Emision", "Importe"
		String[][] lista = new String[listaFacturas.size()][3];
		System.out.println("Obteniendo todas las facturas del cliente con nif " + nif);
		int i = 0;
		for (Factura actual : listaFacturas) {
			System.out.println(actual.toString());
			lista[i][0] = Integer.toString(actual.getIdentificador());
			lista[i][1] = formatearFecha(actual.getFecha());
			lista[i][2] = "" + actual.getImporte();
			i++;
		}
		return lista;
	}

	@Override
	public String[][] getClientesEntreFechas(String inicio, String fin) {
		GregorianCalendar fechaInicio = calcularFecha(inicio);
		GregorianCalendar fechaFinal = calcularFecha(fin);

		Collection<Cliente> clientesEntreFechas = gestorClientes.clientesEntreFechas(fechaInicio, fechaFinal);
		
		// "Tipo", "NIF", "Nombre", "Direccion,"Email", "Tarifa"
		String[][] clientes = new String[clientesEntreFechas.size()][6];
		int i = 0;
		System.out.println("Obteniendo los clientes entre fechas");
		for (Cliente actual : clientesEntreFechas) {
			System.out.println(actual.toString());
			if (actual instanceof Particular)
				clientes[i][0] = "PARTICULAR";
			else
				clientes[i][0] = "EMPRESA";
			clientes[i][1] = actual.getNif();
			clientes[i][2] = actual.getNombre();
			clientes[i][3] = actual.getDireccion().toString();
			clientes[i][4] = actual.getEmail();
			clientes[i][5] = actual.getTarifa().getDescripcion();
			i++;
		}
		return clientes;
	}

	@Override
	public String[][] getLlamadasEntreFechas(String NIF, String inicio, String fin) {

		Cliente cliente = gestorClientes.getCliente(NIF);

		if (cliente == null) {
			vista.error();
			return new String[0][3];
		}

		GestorLlamadasInt gestorLlamadas = cliente.getLlamadas();
		GregorianCalendar fechaInicio = calcularFecha(inicio);
		GregorianCalendar fechaFinal = calcularFecha(fin);

		Collection<Llamada> llamadasEntreFechas = gestorLlamadas.llamadasEntreFechas(fechaInicio, fechaFinal);

		String[][] llamadas = new String[llamadasEntreFechas.size()][3];
		System.out.println("Obteniendo las llamadas entre fechas");
		int i = 0;
		for (Llamada actual : llamadasEntreFechas) {
			System.out.println(actual.toString());
			llamadas[i][0] = actual.getTelefono();
			llamadas[i][1] = formatearFecha(actual.getFecha());
			llamadas[i][2] = "" + actual.getDuracion();
			i++;
		}
		return llamadas;
	}

	@Override
	public String[][] getFacturasEntreFechas(String NIF, String inicio, String fin) {
		Cliente cliente = gestorClientes.getCliente(NIF);

		if (cliente == null) {
			vista.error();
			return new String[0][3];
		}

		GestorFacturaInt gestorFacturas = cliente.getFacturas();
		GregorianCalendar fechaInicio = calcularFecha(inicio);
		GregorianCalendar fechaFinal = calcularFecha(fin);

		Collection<Factura> llamadasEntreFechas = gestorFacturas.facturasEntreFechas(fechaInicio, fechaFinal);
		
		// "Identificador", "Emision", "Importe"
		String[][] lista = new String[llamadasEntreFechas.size()][3];
		int i = 0;
		System.out.println("Obteniendo las facturas entre fechas indicadas");
		for (Factura actual : llamadasEntreFechas) {
			System.out.println(actual.toString());
			lista[i][0] = Integer.toString(actual.getIdentificador());
			lista[i][1] = formatearFecha(actual.getFecha());
			lista[i][2] = "" + actual.getImporte();
			i++;
		}
		return lista;

	}

	@Override
	public String[] getFactura(String code) {

		Collection<Cliente> listaClientes = gestorClientes.clientes();

		String[] factura = new String[3];

		for (Cliente uno : listaClientes) {
			GestorFacturaInt gestor = uno.getFacturas();
			for (Factura actual : gestor.facturas()) {
				if ("" + actual.getIdentificador() == code) {
					factura[0] = Integer.toString(actual.getIdentificador());
					factura[1] = formatearFecha(actual.getFecha());
					factura[2] = "" + actual.getImporte();
				}
			}
		}

		return factura;
	}

	@Override
	public void altaEmpresa(String NIF, String nombre, String codpost, String poblacion, String provincia, String email,
			double precioTarifa, boolean tardes, boolean domingos) {

		TarifasFactory fabricaTarifas = new TarifaFabricaParametrizada();
		Tarifa tarifa = fabricaTarifas.getTarifa(TarifaEnum.BASICA);

		OfertasFactory fabricaOfertas = new OfertasFabricaParametrizada();
		if (tardes)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.TARDES_GRATIS, tarifa);
		if (domingos)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.DOMINGOS_REDUCIDOS, tarifa);

		Direccion direccion = new Direccion(codpost, provincia, poblacion);
		factoryCliente fabrica = new implementacionCliente();

		Cliente cliente = fabrica.getEmpresa(NIF, nombre, direccion, email, new GregorianCalendar(), tarifa);

		gestorClientes.addCliente(cliente);
		vista.actualizarTablaClientes();
	}

	@Override
	public void altaParticular(String NIF, String nombre, String apellidos, String codpost, String poblacion,
			String provincia, String email, double precioTarifa, boolean tardes, boolean domingos) {

		TarifasFactory fabricaTarifas = new TarifaFabricaParametrizada();
		Tarifa tarifa = fabricaTarifas.getTarifa(TarifaEnum.BASICA);

		OfertasFactory fabricaOfertas = new OfertasFabricaParametrizada();
		if (tardes)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.TARDES_GRATIS, tarifa);
		if (domingos)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.DOMINGOS_REDUCIDOS, tarifa);

		Direccion direccion = new Direccion(codpost, provincia, poblacion);
		factoryCliente fabrica = new implementacionCliente();

		Cliente cliente = fabrica.getParticular(NIF, nombre, apellidos, direccion, email, new GregorianCalendar(),
				tarifa);

		gestorClientes.addCliente(cliente);
		vista.actualizarTablaClientes();
	}

	@Override
	public void bajaCliente(String NIF) {
		Cliente cliente = gestorClientes.getCliente(NIF);

		if (cliente == null) {
			vista.error();
			return;
		}

		gestorClientes.removeCliente(NIF);
		vista.actualizarTablaClientes();
	}

	@Override
	public void cambiarTarifa(String NIF, double base, boolean tardes, boolean domingos) {
		Cliente cliente = gestorClientes.getCliente(NIF);

		if (cliente == null) {
			vista.error();
			return;
		}

		TarifasFactory fabricaTarifas = new TarifaFabricaParametrizada();
		Tarifa tarifa = fabricaTarifas.getTarifa(TarifaEnum.BASICA);

		OfertasFactory fabricaOfertas = new OfertasFabricaParametrizada();
		if (tardes)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.TARDES_GRATIS, tarifa);
		if (domingos)
			tarifa = fabricaOfertas.getTarifa(OfertaEnum.DOMINGOS_REDUCIDOS, tarifa);
		
		gestorClientes.cambiarTarifa(NIF, tarifa);
		vista.actualizarTablaClientes();
	}

	@Override
	public void anyadirLlamada(String NIF, String tlfn, String fecha, String hora, int duracion) {

		Cliente cliente = gestorClientes.getCliente(NIF);
		
		if (cliente == null)
			vista.error();
		else {
			GestorLlamadasInt gestorLlamadas = cliente.getLlamadas();
			GregorianCalendar fechaLlamada = anyadirHora(calcularFecha(fecha), hora);
			Llamada nueva = new Llamada(tlfn, fechaLlamada, duracion);
			gestorLlamadas.addLlamada(nueva);
			System.out.println("Llamada añadida con datos: " + nueva.toString());
			
		}
		vista.nuevaLlamada();
	}

	@Override
	public void anyadirFactura(String nif, String fechaInicio, String fechaFin) {
		Cliente cliente = gestorClientes.getCliente(nif);

		if (cliente == null) {
			vista.error();
			return;
		}

		GestorLlamadasInt gestorllamadas = cliente.getLlamadas();
		GestorFacturaInt gestorFacturas = cliente.getFacturas();
		Collection<Llamada> llamadas = gestorllamadas.getLlamadas();

		try {
			Factura nueva = new Factura(cliente.getTarifa(), calcularFecha(fechaInicio), calcularFecha(fechaFin),
					llamadas);
			System.out.println("Factura creada con datos " + nueva.toString());
			gestorFacturas.addFactura(nueva);
		} catch (Exception e) {
			vista.error();
		}
		
		vista.actualizarTablaFacturas();

	}

	@Override
	public void buscarClientesEntreFechas() {
		vista.busquedaClientesEntreFechas();
	}

	@Override
	public void buscarLlamadasEntreFechas() {
		vista.busquedaLlamadasEntreFechas();
	}

	@Override
	public void buscarFacturasEntreFechas() {
		vista.busquedaFacturasEntreFechas();
	}

	@Override
	public void guardar() {
		UtilidadesMemoria.guardar(this.gestorClientes);
	}

	// Metodos privados para convertir strings a fechas y horas
	private GregorianCalendar anyadirHora(GregorianCalendar fecha, String hora) {
		String tokens[] = hora.split(":");
		int h = Integer.parseInt(tokens[0]);
		int min = Integer.parseInt(tokens[1]);
		fecha.set(Calendar.HOUR_OF_DAY, h);
		fecha.set(Calendar.MINUTE, min);
		return fecha;
	}

	private GregorianCalendar calcularFecha(String fecha) {
		System.out.println("La fecha leida por vista es " + fecha);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		System.out.println("La fecha transformada a GregorianCalendar es " + formatearFecha(cal));
		
		int year = Integer.parseInt(fecha.substring(0, 4));
		int day = Integer.parseInt(fecha.substring(7));
		int month = Integer.parseInt(fecha.substring(5, 7));
		System.out.println("Se ha leido la fecha con " + year + "-" + month + "-" + day);
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);

		return calendar;
	}
	
	private String formatearFecha(Calendar calendar){
	    SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}
}
