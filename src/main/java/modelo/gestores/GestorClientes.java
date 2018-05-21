package modelo.gestores;
import java.io.Serializable;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import modelo.cliente.Cliente;
import modelo.cliente.Particular;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Fecha;
import modelo.objetos.ObjetosEntreFechas;

public class GestorClientes implements Serializable {  
	
	private static final long serialVersionUID = 911788017039574610L;
	
	private HashMap<String, Cliente> clientes;			
	private int nClientes;
	
	public GestorClientes() {
		clientes = new HashMap<String, Cliente>();			
		nClientes = 0;													
	}
	
	public boolean addCliente(Cliente c) {
		if (clientes.containsKey(c.getNif()))
				return false;
		clientes.put(c.getNif(), c);
		nClientes++;
		return true;
	}
	
	public Cliente getCliente(String NIF) {
		return clientes.get(NIF);
	}
	
	public Cliente removeCliente(String NIF) { 
		if (clientes.containsKey(NIF))
			nClientes--;
		return clientes.remove(NIF);
	}
	
	public Set<String> keySetClientes() {
		return clientes.keySet();
	}
	
	public int numClientes() {
		return nClientes;
	}
	
	public void cambiarTarifa(String NIF, Tarifa nuevaTarifa) {
		if (clientes.containsKey(NIF))
			clientes.get(NIF).setTarifa(nuevaTarifa);
	}
	
	public Collection<Cliente> convertirAColeccion() {
		return clientes.values();
	}
	
	public String listadoCorto() {
		StringBuilder sb = new StringBuilder();
		for (String keyCliente : clientes.keySet()) {
			Cliente cliente = getCliente(keyCliente);
			sb.append("\t");
			if (cliente instanceof Particular) {
				sb.append("(PARTICULAR)  ");
				sb.append(cliente.getNif());
				sb.append("  ");
				sb.append(cliente.getNombre());
				
			} else {
				sb.append("(EMPRESA)     ");
				sb.append(cliente.getNif());
				sb.append("  ");
				sb.append(cliente.getNombre());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String keyCliente : clientes.keySet()) {
			sb.append(getCliente(keyCliente));
			sb.append("\n\n");
		}
		return sb.toString();
	}

	
	public Set<Cliente> clientesEntreFechas(GregorianCalendar fechaInicio, GregorianCalendar fechaFinal) {
		Set<Fecha> entreFechas = ObjetosEntreFechas.objetosEntreFechas(clientes.values(), fechaInicio, fechaFinal);
		Set<Cliente> cli = new HashSet<Cliente>();
		for(Fecha a : entreFechas )
			cli.add( (Cliente) a );
		return cli;
	}

	public Collection<Cliente> clientes() {
		return clientes.values();
	}
}
