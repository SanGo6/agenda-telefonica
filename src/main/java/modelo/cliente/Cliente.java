package modelo.cliente;

import modelo.decoradorTarifa.Tarifa;
import modelo.gestores.GestorFacturaInt;
import modelo.gestores.GestorFacturas;
import modelo.gestores.GestorLlamadas;
import modelo.gestores.GestorLlamadasInt;
import modelo.objetos.Direccion;
import modelo.objetos.Fecha;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Cliente implements Fecha, Serializable {

	private static final long serialVersionUID = 1L;

	private String nif, nombre, email;
	private Direccion direccion;
	private GregorianCalendar fecha_alta;
	private Tarifa tarifa;

	private GestorFacturaInt facturas;
	private GestorLlamadasInt llamadas;

	public Cliente(String nif, String nombre, Direccion direccion, String email, GregorianCalendar fecha_alta,
			Tarifa tarifa) {
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.fecha_alta = fecha_alta;
		this.tarifa = tarifa;
		this.llamadas = new GestorLlamadas();
		this.facturas = new GestorFacturas();
	}

	// Gets del Cliente
	public String getNif() {
		return this.nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public GregorianCalendar getFecha() {
		return this.fecha_alta;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Tarifa nuevaTarifa) {
		tarifa = nuevaTarifa;
	}

	public GestorLlamadasInt getLlamadas() {
		return llamadas;
	}

	public GestorFacturaInt getFacturas() {
		return facturas;
	}

	@Override
	public abstract String toString();
}
