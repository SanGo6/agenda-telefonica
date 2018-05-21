package vista;

import javax.swing.*;

import controlador.Controlador;
import modelo.InterrogaModelo;

import java.awt.event.*;

public class ImplementacionVista implements InterrogaVista, InformaVista {

	private InterrogaModelo modelo;
	private Controlador controlador;

	private VentanaPrincipal frame;

	public void creaGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void GUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException,
			IllegalAccessException {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}

		frame = new VentanaPrincipal();
		frame.getBotonAnyadirCliente().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.addCliente();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonBorrarCliente().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.removeCliente();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonBuscarCliente().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					busquedaCliente(frame.getFieldNIF().getText());
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonCambiarTarifa().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.changeTarifa();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonAnyadirLlamada().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.addLlamada();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonBuscarLlamada().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					busquedaLlamada();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonAnyadirFactura().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.addFactura();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonBuscarFactura().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					busquedaFacturaCodigo();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonFacturasCliente().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					actualizarTablaFacturas();
				} catch (RuntimeException e) {
					error();
				}
			}
		});

		frame.getBotonBuscarEntreFechas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					controlador.searchEntreFechas();
				} catch (RuntimeException e) {
					error();
				}
			}
		});
		frame.setTitle("Facturacion Movil");
		frame.setVisible(true);
		frame.pack();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				controlador.save();
			}
		});

		this.actualizarTablaClientes();

	}

	public void setModelo(InterrogaModelo modelo) {
		this.modelo = modelo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return frame;
	}

	@Override
	public void actualizarTablaClientes() {
		frame.cambioDatosClientes(modelo.getClientes());
	}

	@Override
	public void busquedaCliente(String NIF) {
		for (int i = 0; i < frame.getTabla().getRowCount(); i++) {
			if (frame.getTabla().getValueAt(i, 1).equals(NIF)) {
				frame.getTabla().setRowSelectionInterval(i, i);
			}
		}
	}

	@Override
	public void nuevaLlamada() {
		frame.cambioDatosLlamadas(modelo.getLlamadas(frame.getFieldNIFLlamadas().getText()));
	}

	@Override
	public void busquedaLlamada() {
		String[][] lista = modelo.getLlamadas(frame.getFieldNIFLlamadas().getText());
		frame.cambioDatosLlamadas(lista);
	}

	@Override
	public void error() {
		JOptionPane.showMessageDialog(frame, "ERROR. Asegúrate de haber introducido los datos correctos.");
	}

	@Override
	public void actualizarTablaFacturas() {
		String[][] facturas = modelo.getFacturas(frame.getFieldNIFFacturas().getText());
		frame.cambioDatosFacturas(facturas);
	}

	@Override
	public void busquedaFacturaCodigo() {
		String[] facturas = modelo.getFactura(getVentanaPrincipal().getFieldCodigoFactura().getText());
		frame.cambioDatosFacturas(new String[][] { facturas });
	}

	@Override
	public void busquedaClientesEntreFechas() {
		String fechaInicio = frame.getFieldFechaInicioEntreFechas().getText();
		String fechaFin = frame.getFieldFechaFinEntreFechas().getText();
		frame.cambioDatosEntreFechas(modelo.getClientesEntreFechas(fechaInicio, fechaFin), TipoTabla.CLIENTES);
	}

	@Override
	public void busquedaLlamadasEntreFechas() {
		frame.cambioDatosEntreFechas(modelo.getLlamadasEntreFechas(frame.getFieldNIFEntreFechas().getText(),
				frame.getFieldFechaInicioEntreFechas().getText(), frame.getFieldFechaFinEntreFechas().getText()),
				TipoTabla.LLAMADAS);
	}

	@Override
	public void busquedaFacturasEntreFechas() {
		frame.cambioDatosEntreFechas(modelo.getFacturasEntreFechas(frame.getFieldNIFEntreFechas().getText(),
				frame.getFieldFechaInicioEntreFechas().getText(), frame.getFieldFechaFinEntreFechas().getText()),
				TipoTabla.FACTURAS);
	}

	@Override
	public boolean isParticular() {
		if (frame.getFieldApellidos().getText().equals(""))
			return false;
		else
			return true;
	}

	@Override
	public String getNIFCliente() {
		return frame.getFieldNIF().getText();
	}

	@Override
	public String getNombreCliente() {
		return frame.getFieldNombre().getText();
	}

	@Override
	public String getApellidosCliente() {
		return frame.getFieldApellidos().getText();
	}

	@Override
	public String getCodPostalCliente() {
		return frame.getFieldCodPostal().getText();
	}

	@Override
	public String getPoblacionCliente() {
		return frame.getFieldPoblacion().getText();
	}

	@Override
	public String getProvinciaCliente() {
		return frame.getFieldProvincia().getText();
	}

	@Override
	public String getEmailCliente() {
		return frame.getFieldEmail().getText();
	}

	@Override
	public double getPrecioTarifaCliente() {
		return Double.parseDouble(frame.getFieldTarifa().getText());
	}

	@Override
	public boolean getTarifaTardesCliente() {
		return frame.getCheckTardes().isSelected();
	}

	@Override
	public boolean getTarifaDomingosCliente() {
		return frame.getCheckDomingos().isSelected();
	}

	@Override
	public String getNIFLlamada() {
		return frame.getFieldNIFLlamadas().getText();
	}

	@Override
	public String getTlfnLlamada() {
		return frame.getFieldTlfn().getText();
	}

	@Override
	public String getFechaLlamada() {
		return frame.getFieldFechaLlamada().getText();
	}

	@Override
	public String getHoraLlamada() {
		return frame.getFieldHoraLlamada().getText();
	}

	@Override
	public int getDuracionLlamada() {
		return Integer.parseInt(frame.getFieldDuracionLlamada().getText());
	}

	@Override
	public String getNIFFactura() {
		return frame.getFieldNIFFacturas().getText();
	}

	@Override
	public String getFechaInicioFactura() {
		return frame.getFieldFechaInicioFactura().getText();
	}

	@Override
	public String getFechaFinFactura() {
		return frame.getFieldFechaFinFactura().getText();
	}

	@Override
	public String getFechaInicioEntreFechas() {
		return frame.getFieldFechaInicioEntreFechas().getText();
	}

	@Override
	public String getFechaFinEntreFechas() {
		return frame.getFieldFechaFinEntreFechas().getText();
	}

	@Override
	public int aBuscarEntreFechas() {
		// aBuscarEntreFechas() < 0 --- Busca Clientes
		// aBuscarEntreFechas() = 0 --- Busca Llamadas
		// aBuscarEntreFechas() > 0 --- Busca Facturas

		if (frame.getRadioClientes().isSelected())
			return -1;
		else if (frame.getRadioLlamadas().isSelected())
			return 0;
		else
			return 1;

	}

}
