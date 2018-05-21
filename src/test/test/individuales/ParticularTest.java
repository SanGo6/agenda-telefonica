package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.cliente.Particular;
import modelo.decoradorTarifa.Tarifa;
import modelo.objetos.Direccion;

public class ParticularTest {
	private static Particular particular;
	
	@Before
	public void init() {
		particular = new Particular("66666666","Antonio","Orenes",	new Direccion("12002", "Castellón", "Castellón de la Plana"),"lorenes@gmail.es",new GregorianCalendar(2016, 0, 1),new Tarifa(0.05));
	}
	
	@After
	public void finish() {
		particular = null;
	}
	
	@Test
	public void testGetFecha() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		StringBuilder expected = new StringBuilder();
		expected.append("Antonio Orenes (66666666)\n");
		expected.append("lorenes@gmail.es)\n");
		expected.append("12002 Castellón de la Plana (Castellón)\n");
		expected.append("Fecha alta: 01/01/16)\n");
		expected.append("Tarifa contratada: 0.05)\n");
		assertThat(particular.toString(), is(expected.toString()));
		expected = null;
	}

}