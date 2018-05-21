package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.cliente.Empresa;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;


public class EmpresaTest {
	private Empresa empresa;
	
	@Before
	public void init() {
		empresa = new Empresa("12345678","Fortea Chispas S.A.",new Direccion("12006", "Castellón", "Castellón de la Plana"),"chispitas@gmail.com",new GregorianCalendar(2016, 2, 26),new Tarifa(0.15));
	}
	
	@After
	public void finish() {
		empresa = null;
	}
	
	@Test
	public void testGetFecha() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		StringBuilder expected = new StringBuilder();
		expected.append("Fortea Chispas S.A. (12345678)\n");
		expected.append("chispitas@gmail.com\n");
		expected.append("12006 Castellón de la Plana (Castellón)\n");
		expected.append("Fecha alta: 26/03/16\n");
		expected.append("Tarifa contratada: 0.15 €/min");
		assertThat(empresa.toString(), is(expected.toString()));
		expected = null;
	}

}
