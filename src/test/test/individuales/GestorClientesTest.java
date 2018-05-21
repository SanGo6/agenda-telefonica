package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import modelo.cliente.Cliente;
import modelo.cliente.Empresa;
import modelo.cliente.Particular;
import modelo.decoradorTarifa.Tarifa;
import modelo.gestores.GestorClientes;
import modelo.objetos.Direccion;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorClientesTest {
	private static GestorClientes gestor;
	private static Cliente clientePar;
	private static Cliente clienteEmp;
	
	@Before
	public void init() {
		gestor = new GestorClientes();
		clientePar = new Particular("12345678","Sergiu","Pirbulescu",new Direccion("12006", "Castellón", "Castellón de la Plana"),	"rumi@gmail.es",new GregorianCalendar(2016, 0, 1),new Tarifa(0.54));
		clienteEmp = new Empresa("87654321","Consulado",new Direccion("12006", "Castellón", "Castellón de la Plana"),"elconsulado@gmail.com",new GregorianCalendar(2016, 2, 26),new Tarifa(0.35)); 
	}
	
	@After
	public void finish() {
		gestor = null;
		clientePar = null;
		clienteEmp = null;
	}
	
	@Test
	public void testAddCliente() {
		assertThat(gestor.addCliente(clientePar), is(true));
		assertThat(gestor.addCliente(clienteEmp), is(true));
	}
	
	@Test
	public void testNumClientes() {
		assertThat(gestor.numClientes(), is(0));
		gestor.addCliente(clientePar);
		assertThat(gestor.numClientes(), is(1));
		gestor.addCliente(clienteEmp);
		assertThat(gestor.numClientes(), is(2));
		gestor.removeCliente(clienteEmp.getNif());
		assertThat(gestor.numClientes(), is(1));
		gestor.removeCliente(clientePar.getNif());
		assertThat(gestor.numClientes(), is(0));
	}

	@Test
	public void testGetCliente() {
		gestor.addCliente(clientePar);
		gestor.addCliente(clienteEmp);
		assertThat(gestor.getCliente(clientePar.getNif()), is(clientePar));
		assertThat(gestor.getCliente(clienteEmp.getNif()), is(clienteEmp));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
