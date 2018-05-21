package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.objetos.Llamada;

public class LlamadaTest {
	private static Llamada llamada;
	
	@Before
	public void init() {
		llamada = new Llamada("645510103",new GregorianCalendar(2016, 1, 2, 15, 32, 54),14);
	}
	
	@After
	public void finish() {
		llamada = null;
	}
	
	@Test
	public void testGetFecha() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		StringBuilder expected = new StringBuilder();
		expected.append("645510103    02/02/16  15:32:54    14 min");
		assertThat(llamada.toString(), is(expected.toString()));
		expected = null;
	}
    	
}
