package vista;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

public class VentanaPrincipal extends JFrame {

	private JPanel panelClientes;
	private JPanel panelLlamadas;
	private JPanel panelFacturas;
	private JPanel panelEntreFechas;
	private JPanel panelLabels;
	private JTextField fieldNIF;
	private JTextField fieldApellidos;
	private JTextField fieldNombre;
	private JTextField fieldCodPostal;
	private JTextField fieldPoblacion;
	private JTextField fieldProvincia;
	private JTextField fieldEmail;
	private JTextField fieldTarifa;
	private JCheckBox checkTardes;
	private JCheckBox checkDomingos;
	private JTable tabla;
	private JTable tablaLlamadas;
	private JTable tablaFacturas;
	private JTable tablaEntreFechas;
	private JButton botonAnyadirCliente;
	private JButton botonBorrarCliente;
	private JButton botonCambiarTarifa;
	private JButton botonBuscarCliente;
	private JTextField fieldNIFLlamadas;
	private JTextField fieldTlfn;
	private JTextField fieldFechaLlamada;
	private JTextField fieldHoraLlamada;
	private JTextField fieldDuraccionLlamada;
	private JButton botonAnyadirLlamada;
	private JButton botonBuscarLlamada;
	private JTextField fieldNIFFacturas;
	private JTextField fieldFechaInicioFactura;
	private JTextField fieldFechaFinFactura;
	private JTextField fieldCodigoFactura;
	private JButton botonAnyadirFactura;
	private JButton botonBuscarFactura;
	private JButton botonFacturasCliente;
	private JTextField fieldNIFEntreFechas;
	private JTextField fieldFechaInicioEntreFechas;
	private JTextField fieldFechaFinEntreFechas;
	private JRadioButton radioClientes;
	private JRadioButton radioLlamadas;
	private JRadioButton radioFacturas;
	private JButton botonBuscarEntreFechas;
	private TablaClientes modeloClientes;
	private TablaLlamadas modeloLlamadas;
	private TablaFacturas modeloFacturas;

	public class TablaClientes extends AbstractTableModel {

		private final String nombreDatos[] = {"Tipo", "NIF", "Nombre","Direccion", "Email", "Tarifa"};
		private Object datos[][] = new String[0][nombreDatos.length];

		@Override
		public int getColumnCount() {
			return nombreDatos.length;
		}

		@Override
		public int getRowCount() {
			return datos.length;
		}

		@Override
		public Object getValueAt(int i, int j) {
			return datos[i][j];
		}

		@Override
		public String getColumnName(int column) {
			return nombreDatos[column];
		}

		@Override
		public void setValueAt(Object value, int fila, int columna){
			datos[fila][columna] = value;
		}

		public void setDatos(Object[][] nuevosDatos){
			this.datos = nuevosDatos;
		}

	}

	public class TablaLlamadas extends AbstractTableModel {

		private final String nombreDatos[] = {"Tlfn", "Fecha", "Duración"};
		private Object datos[][] = new String[0][nombreDatos.length];

		@Override
		public int getRowCount() {
			return datos.length;
		}

		@Override
		public int getColumnCount() {
			return nombreDatos.length;
		}

		@Override
		public Object getValueAt(int i, int j) {
			return datos[i][j];
		}

		@Override
		public String getColumnName(int column) {
			return nombreDatos[column];
		}

		@Override
		public void setValueAt(Object value, int fila, int columna){
			datos[fila][columna] = value;
		}
		
		public void setDatos(Object[][] nuevosDatos){
			this.datos = nuevosDatos;
		}

	}

	public class TablaFacturas extends AbstractTableModel {

		private final String nombreDatos[] = {"Código", "Emision",  "Importe"};
		private Object datos[][] = new String[0][nombreDatos.length];

		@Override
		public int getRowCount() {
			return datos.length;
		}

		@Override
		public int getColumnCount() {
			return nombreDatos.length;
		}

		@Override
		public Object getValueAt(int i, int j) {
			return datos[i][j];
		}

		@Override
		public String getColumnName(int column) {
			return nombreDatos[column];
		}

		@Override
		public void setValueAt(Object value, int fila, int columna){
			datos[fila][columna] = value;
		}
		
		public void setDatos(Object[][] nuevosDatos){
			datos = nuevosDatos;
		}

	}


	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		panelClientes = new JPanel();
		panelLlamadas = new JPanel();
		panelFacturas = new JPanel();
		panelEntreFechas = new JPanel();

		this.construirPanelClientes();
		this.construirPanelLlamadas();
		this.construirPanelFacturas();
		this.construirPanelEntreFechas();

		tabbedPane.add("Clientes", panelClientes);
		tabbedPane.add("Llamadas", panelLlamadas);
		tabbedPane.add("Facturas", panelFacturas);
		tabbedPane.add("Búsqueda Entre Fechas", panelEntreFechas);

	}

	private void construirPanelClientes() {

		JPanel panelLabels = new JPanel();
		panelLabels.setLayout(new GridLayout(0,2,0,0));
		TitledBorder bordeDatos = BorderFactory.createTitledBorder("Datos de Cliente");
		panelLabels.setBorder(bordeDatos);

		//Añadimos elementos a la opción CLIENTES:
		JLabel labelNIF = new JLabel("NIF: ");
		JLabel labelNombre = new JLabel("Nombre: ");
		JLabel labelApellidos = new JLabel("Apellidos: ");
		JLabel labelCodPostal = new JLabel("Codigo Postal: ");
		JLabel labelPoblacion = new JLabel("Poblacion: ");
		JLabel labelPronvincia = new JLabel("Provincia: ");
		JLabel labelEmail = new JLabel("Email: ");
		JLabel labelTarifa = new JLabel("Precio Base Tarifa");

		fieldNIF = new JTextField();
		fieldNombre = new JTextField();
		fieldApellidos = new JTextField();
		fieldCodPostal = new JTextField();
		fieldPoblacion = new JTextField();
		fieldProvincia = new JTextField();
		fieldEmail = new JTextField();
		fieldTarifa = new JTextField();
		checkTardes = new JCheckBox("Tarifa Tardes");
		checkDomingos = new JCheckBox("Tarifa Domingos");


		fieldNIF.setColumns(9);
		fieldNombre.setColumns(10);
		fieldApellidos.setColumns(15);
		fieldCodPostal.setColumns(5);
		fieldPoblacion.setColumns(10);
		fieldProvincia.setColumns(10);
		fieldEmail.setColumns(10);
		fieldTarifa.setColumns(5);


		panelLabels.add(labelNIF);panelLabels.add(fieldNIF);
		panelLabels.add(labelNombre);panelLabels.add(fieldNombre);
		panelLabels.add(labelApellidos);panelLabels.add(fieldApellidos);
		panelLabels.add(labelCodPostal);panelLabels.add(fieldCodPostal);
		panelLabels.add(labelPoblacion); panelLabels.add(fieldPoblacion);
		panelLabels.add(labelPronvincia);panelLabels.add(fieldProvincia);
		panelLabels.add(labelEmail); panelLabels.add(fieldEmail);
		panelLabels.add(labelTarifa); panelLabels.add(fieldTarifa);
		panelLabels.add(checkDomingos); panelLabels.add(checkTardes);

		panelClientes.setLayout(new BorderLayout());
		JPanel panelRelleno = new JPanel(new BorderLayout());
		panelRelleno.add(panelLabels, BorderLayout.NORTH);
		panelRelleno.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelClientes.add(panelRelleno, BorderLayout.WEST);

		//Añadimos Tabla

		JPanel panelTablaClientes = new JPanel();
		modeloClientes = new TablaClientes();
		this.tabla = new JTable(modeloClientes);


		JScrollPane scrollTabla = new JScrollPane(tabla);
		scrollTabla.createHorizontalScrollBar();
		panelTablaClientes.add(scrollTabla);


		panelClientes.add(panelTablaClientes, BorderLayout.CENTER);

		//Añadimos botones:
		JPanel panelBotonesCliente = new JPanel();

		botonAnyadirCliente = new JButton("Añadir Cliente");
		botonBorrarCliente = new JButton("Borrar Cliente");
		botonBuscarCliente = new JButton("Buscar Cliente");
		botonCambiarTarifa = new JButton("Cambiar Tarifa");

		panelBotonesCliente.add(botonAnyadirCliente);
		panelBotonesCliente.add(botonBorrarCliente);
		panelBotonesCliente.add(botonBuscarCliente);
		panelBotonesCliente.add(botonCambiarTarifa);

		panelClientes.add(panelBotonesCliente, BorderLayout.SOUTH);


	}

	private void construirPanelLlamadas() {
		JPanel panelLabelsLlamadas = new JPanel();
		panelLabelsLlamadas.setLayout(new GridLayout(0,2,0,0));

		//---

		//Añadimos elementos a la opción LLAMADAS:
		JLabel labelNIF = new JLabel("NIF: ");
		JLabel labelTlfn= new JLabel("Teléfono: ");
		JLabel labelFecha = new JLabel("Fecha (YYYY-MM-DD): ");
		JLabel labelHora = new JLabel("Hora (hh:mm) : ");
		JLabel labelDuracion= new JLabel("Duracion: ");

		fieldNIFLlamadas = new JTextField();
		fieldTlfn = new JTextField();
		fieldFechaLlamada = new JTextField();
		fieldHoraLlamada = new JTextField();
		fieldDuraccionLlamada = new JTextField();


		fieldNIFLlamadas.setColumns(9);
		fieldTlfn.setColumns(9);
		fieldFechaLlamada.setColumns(10);
		fieldHoraLlamada.setColumns(5);
		fieldDuraccionLlamada.setColumns(5);
		//---



		panelLabelsLlamadas.add(labelNIF);panelLabelsLlamadas.add(fieldNIFLlamadas);
		panelLabelsLlamadas.add(labelTlfn);panelLabelsLlamadas.add(fieldTlfn);
		panelLabelsLlamadas.add(labelFecha);panelLabelsLlamadas.add(fieldFechaLlamada);
		panelLabelsLlamadas.add(labelHora);panelLabelsLlamadas.add(fieldHoraLlamada);
		panelLabelsLlamadas.add(labelDuracion);panelLabelsLlamadas.add(fieldDuraccionLlamada);

		panelLlamadas.setLayout(new BorderLayout());
		JPanel panelRelleno = new JPanel(new BorderLayout());
		panelRelleno.add(panelLabelsLlamadas, BorderLayout.NORTH);
		panelRelleno.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelLlamadas.add(panelRelleno, BorderLayout.WEST);
		TitledBorder bordeDatos = BorderFactory.createTitledBorder("Datos de Llamadas");
		panelLabelsLlamadas.setBorder(bordeDatos);

		//Añadimos Tabla

		this.tablaLlamadas = new JTable();
		JPanel panelTablaLlamadas = new JPanel();
		tablaLlamadas.setModel(modeloLlamadas = new TablaLlamadas());

		JScrollPane scrollTabla = new JScrollPane(tablaLlamadas);
		panelTablaLlamadas.add(scrollTabla);
		panelLlamadas.add(panelTablaLlamadas, BorderLayout.CENTER);


		//Añadimos botones:
		JPanel panelBotonesLlamada = new JPanel();
		botonAnyadirLlamada = new JButton("Añadir Llamada");
		botonBuscarLlamada = new JButton("Buscar Llamadas por NIF");
		panelBotonesLlamada.add(botonAnyadirLlamada);
		panelBotonesLlamada.add(botonBuscarLlamada);


		panelLlamadas.add(panelBotonesLlamada, BorderLayout.SOUTH);

	}

	private void construirPanelFacturas(){
		JPanel panelLabelsFacturas= new JPanel();
		panelLabelsFacturas.setLayout(new GridLayout(0,2,0,0));

		//Añadimos elementos a la opción FACTURAS:
		JLabel labelNIFFacturas = new JLabel("NIF: ");
		JLabel labelFechaInicio= new JLabel("Fecha Inicio (YYYY-MM-DD):  ");
		JLabel labelFechaFin = new JLabel("Fecha Fin (YYYY-MM-DD): ");
		JLabel labelCodigoFactura = new JLabel("Código de Factura (Sólo búsquedas)");

		fieldNIFFacturas = new JTextField();
		fieldNIFFacturas.setColumns(9);
		fieldFechaInicioFactura = new JTextField();
		fieldFechaInicioFactura.setColumns(10);
		fieldFechaFinFactura = new JTextField();
		fieldFechaFinFactura.setColumns(10);
		fieldCodigoFactura = new JTextField(5);

		panelLabelsFacturas.add(labelNIFFacturas); panelLabelsFacturas.add(fieldNIFFacturas);
		panelLabelsFacturas.add(labelFechaInicio); panelLabelsFacturas.add(fieldFechaInicioFactura);
		panelLabelsFacturas.add(labelFechaFin);panelLabelsFacturas.add(fieldFechaFinFactura);
		panelLabelsFacturas.add(labelCodigoFactura); panelLabelsFacturas.add(fieldCodigoFactura);

		panelFacturas.setLayout(new BorderLayout());
		JPanel panelRelleno = new JPanel(new BorderLayout());
		panelRelleno.add(panelLabelsFacturas, BorderLayout.NORTH);
		panelRelleno.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelFacturas.add(panelRelleno, BorderLayout.WEST);
		TitledBorder bordeDatos = BorderFactory.createTitledBorder("Datos de Facturas");
		panelLabelsFacturas.setBorder(bordeDatos);


		//Añadimos Tabla:
		JPanel panelTablaFacturas = new JPanel();
		this.tablaFacturas = new JTable();
		tablaFacturas.setModel(modeloFacturas = new TablaFacturas());
		JScrollPane scrollTabla = new JScrollPane(tablaFacturas);
		panelTablaFacturas.add(scrollTabla);
		panelFacturas.add(panelTablaFacturas, BorderLayout.CENTER);

		//Añadimos Botones:
		JPanel panelBotonesFacturas = new JPanel();
		botonAnyadirFactura = new JButton("Añadir Factura");
		botonBuscarFactura = new JButton("Buscar Factura por código");
		botonFacturasCliente = new JButton("Buscar Facturas por NIF");
		panelBotonesFacturas.add(botonAnyadirFactura);
		panelBotonesFacturas.add(botonBuscarFactura);
		panelBotonesFacturas.add(botonFacturasCliente);

		panelFacturas.add(panelBotonesFacturas, BorderLayout.SOUTH);
	}

	private void construirPanelEntreFechas(){

		JPanel panelLabelsEntreFechas= new JPanel();
		panelLabelsEntreFechas.setLayout(new GridLayout(0,2,0,0));

		//Añadimos elementos a la opción Entre Fechas:
		JLabel labelNIFEntreFechas = new JLabel("NIF: ");
		JLabel labelFechaInicio= new JLabel("Fecha Inicio (YYYY-MM-DD):  ");
		JLabel labelFechaFin = new JLabel("Fecha Fin (YYYY-MM-DD): ");

		fieldNIFEntreFechas = new JTextField();
		fieldFechaInicioEntreFechas = new JTextField();
		fieldFechaFinEntreFechas = new JTextField();
		radioClientes = new JRadioButton("Clientes");
		radioLlamadas = new JRadioButton("Llamadas");
		radioFacturas = new JRadioButton("Facturas");

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radioClientes);
		grupo.add(radioLlamadas);
		grupo.add(radioFacturas);

		panelLabelsEntreFechas.add(labelNIFEntreFechas); panelLabelsEntreFechas.add(fieldNIFEntreFechas);
		panelLabelsEntreFechas.add(labelFechaInicio); panelLabelsEntreFechas.add(fieldFechaInicioEntreFechas);
		panelLabelsEntreFechas.add(labelFechaFin); panelLabelsEntreFechas.add(fieldFechaFinEntreFechas);
		panelLabelsEntreFechas.add(radioClientes); panelLabelsEntreFechas.add(new JLabel());
		panelLabelsEntreFechas.add(radioLlamadas); panelLabelsEntreFechas.add(new JLabel());
		panelLabelsEntreFechas.add(radioFacturas);

		panelEntreFechas.setLayout(new BorderLayout());
		JPanel panelRelleno = new JPanel(new BorderLayout());
		panelRelleno.add(panelLabelsEntreFechas, BorderLayout.NORTH);
		panelRelleno.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelEntreFechas.add(panelRelleno, BorderLayout.WEST);
		TitledBorder bordeDatos = BorderFactory.createTitledBorder("Datos de Búsqueda");
		panelLabelsEntreFechas.setBorder(bordeDatos);

		//TABLA:
		JPanel panelTablaEntreFechas = new JPanel();
		this.tablaEntreFechas= new JTable();
		JScrollPane scrollTabla = new JScrollPane(tablaEntreFechas);
		panelTablaEntreFechas.add(scrollTabla);
		panelEntreFechas.add(panelTablaEntreFechas, BorderLayout.CENTER);


		//Añadimos Botones:
		JPanel panelBotonesEntreFechas = new JPanel();
		botonBuscarEntreFechas = new JButton("Buscar");
		panelBotonesEntreFechas.add(botonBuscarEntreFechas);

		panelEntreFechas.add(panelBotonesEntreFechas, BorderLayout.SOUTH);
	}


	public JButton getBotonAnyadirCliente() {
		return botonAnyadirCliente;
	}

	public JButton getBotonBorrarCliente() {
		return botonBorrarCliente;
	}

	public JButton getBotonCambiarTarifa() {
		return botonCambiarTarifa;
	}

	public JButton getBotonBuscarCliente() {
		return botonBuscarCliente;
	}

	public JButton getBotonAnyadirLlamada() {
		return botonAnyadirLlamada;
	}

	public JButton getBotonAnyadirFactura() {
		return botonAnyadirFactura;
	}

	public JButton getBotonBuscarFactura() {
		return botonBuscarFactura;
	}

	public JButton getBotonFacturasCliente() {
		return botonFacturasCliente;
	}

	public JButton getBotonBuscarEntreFechas() {
		return botonBuscarEntreFechas;
	}

	public JTextField getFieldNIF() {
		return fieldNIF;
	}

	public JTextField getFieldApellidos() {
		return fieldApellidos;
	}

	public JTextField getFieldNombre() {
		return fieldNombre;
	}

	public JTextField getFieldCodPostal() {
		return fieldCodPostal;
	}

	public JTextField getFieldPoblacion() {
		return fieldPoblacion;
	}

	public JTextField getFieldProvincia() {
		return fieldProvincia;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public JTextField getFieldTarifa() {
		return fieldTarifa;
	}

	public JCheckBox getCheckTardes() {
		return checkTardes;
	}

	public JCheckBox getCheckDomingos() {
		return checkDomingos;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JTextField getFieldNIFLlamadas() {
		return fieldNIFLlamadas;
	}

	public JTextField getFieldTlfn() {
		return fieldTlfn;
	}

	public JTextField getFieldFechaLlamada() {
		return fieldFechaLlamada;
	}

	public JTextField getFieldHoraLlamada() {
		return fieldHoraLlamada;
	}

	public JTextField getFieldDuracionLlamada() {
		return fieldDuraccionLlamada;
	}

	public JTextField getFieldNIFFacturas() {
		return fieldNIFFacturas;
	}

	public JTextField getFieldFechaInicioFactura() {
		return fieldFechaInicioFactura;
	}

	public JTextField getFieldFechaFinFactura() {
		return fieldFechaFinFactura;
	}

	public JTextField getFieldNIFEntreFechas() {
		return fieldNIFEntreFechas;
	}

	public JTextField getFieldFechaInicioEntreFechas() {
		return fieldFechaInicioEntreFechas;
	}

	public JTextField getFieldFechaFinEntreFechas() {
		return fieldFechaFinEntreFechas;
	}

	public JRadioButton getRadioClientes() {
		return radioClientes;
	}

	public JRadioButton getRadioLlamadas() {
		return radioLlamadas;
	}

	public JRadioButton getRadioFacturas() {
		return radioFacturas;
	}

	public JTable getTablaLlamadas() {
		return tablaLlamadas;
	}

	public JTable getTablaFacturas() {
		return tablaFacturas;
	}

	public TablaClientes getModeloClientes() {
		return modeloClientes;
	}

	public TablaLlamadas getModeloLlamadas() {
		return modeloLlamadas;
	}

	public TablaFacturas getModeloFacturas() {
		return modeloFacturas;
	}

	public JTextField getFieldCodigoFactura() {
		return fieldCodigoFactura;
	}

	public void cambioDatosClientes(String[][] datos){
		modeloClientes = new TablaClientes();
		modeloClientes.setDatos(datos);
		tabla.setModel(modeloClientes);
		this.repaint();
	}

	public void cambioDatosLlamadas(String[][] llamadas) {
		modeloLlamadas = new TablaLlamadas();
		modeloLlamadas.setDatos(llamadas);
		tablaLlamadas.setModel(modeloLlamadas);
		this.repaint();
	}

	public void cambioDatosFacturas(String[][] facturas) {
		modeloFacturas = new TablaFacturas();
		modeloFacturas.setDatos(facturas);
		tablaFacturas.setModel(modeloFacturas);
		this.repaint();
	}

	public void cambioDatosEntreFechas(String[][] datos, TipoTabla tipo){
		switch (tipo) {
			case CLIENTES:
				TablaClientes modelo = new TablaClientes();
				modelo.setDatos(datos);
				tablaEntreFechas.setModel(modelo);
				break;
			case FACTURAS:
				TablaFacturas modelo2 = new TablaFacturas();
				modelo2.setDatos(datos);
				tablaEntreFechas.setModel(modelo2);
				break;
			case LLAMADAS:
				TablaLlamadas modelo3 = new TablaLlamadas();
				modelo3.setDatos(datos);
				tablaEntreFechas.setModel(modelo3);
				break;
		}
		this.repaint();
	}

	public JButton getBotonBuscarLlamada() {
		return botonBuscarLlamada;
	}

}