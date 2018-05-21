package modelo.factory.cliente;

import java.util.GregorianCalendar;

import modelo.cliente.Cliente;
import modelo.cliente.Empresa;
import modelo.cliente.Particular;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;

public class implementacionCliente implements factoryCliente{

	@Override
	public Cliente getParticular(String nif, String nombre, String apellido, Direccion direccion,String email, GregorianCalendar fecha_alta, Tarifa tarifa){
		return new Particular(nif, nombre,apellido, direccion,email,  fecha_alta, tarifa);
	}
	@Override
	public Cliente getEmpresa(String nif, String nombre,  Direccion direccion,String email, GregorianCalendar fecha_alta, Tarifa tarifa){
		return new Empresa(nif, nombre, direccion,email,  fecha_alta, tarifa);
	}
}
