package modelo.factory.cliente;

import java.util.GregorianCalendar;

import modelo.cliente.Cliente;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;

public interface factoryCliente {
	public Cliente getParticular(String nif, String nombre, String apellido, Direccion direccion,String email, GregorianCalendar fecha_alta, Tarifa tarifa);
	public Cliente getEmpresa(String nif, String nombre,  Direccion direccion,String email, GregorianCalendar fecha_alta, Tarifa tarifa);
}
