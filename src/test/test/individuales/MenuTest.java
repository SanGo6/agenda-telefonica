package test.individuales;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import consola.principal.Menu;
import controlador.Controlador;

public class MenuTest {
	private static Controlador menu;
	
	@Before
	public void init() {
		menu = new Menu();
	}
	
	@After
	public void finish() {
		menu = null;
	}
	
	@Test
	public void testConvertirAFecha() 
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method metodoConvertirAFecha = Menu.class.getDeclaredMethod("convertirAFecha", String.class);
		metodoConvertirAFecha.setAccessible(true);
		GregorianCalendar output = (GregorianCalendar) metodoConvertirAFecha.invoke(menu, "21/04/2015");
        assertThat(output, is(new GregorianCalendar(2015, 3, 21)));
	}
	
	@Test
	public void testMenu() {
		fail("Not yet implemented");
	}

}
