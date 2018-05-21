package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.objetos.Direccion;

public class DireccionTest {
	private static Direccion direccion;
	
	@Before
	public void init() {
		direccion = new Direccion("12006", "Castell�n", "Castell�n de la Plana");
	}
	
	@After
	public void finish() {
		direccion = null;
	}
	
	@Test
	public void testToString() {
		String expected = "12006 Castell�n de la Plana (Castell�n)";
		assertThat(direccion.toString(), is(expected));
		expected = null;
	}

}
