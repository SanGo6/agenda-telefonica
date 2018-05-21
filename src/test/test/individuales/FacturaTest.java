package test.individuales;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.cliente.Cliente;
import modelo.cliente.Empresa;
import modelo.decoradorTarifa.Tarifa;
import modelo.excepciones.FechaNoValidaException;
import modelo.gestores.GestorLlamadas;
import modelo.objetos.Direccion;
import modelo.objetos.Factura;
import modelo.objetos.Llamada;

public class FacturaTest {
	private static Factura factura;
	
	@Before
	public void init() throws FechaNoValidaException {
		factura = new Factura(	new Tarifa(0.15),	new GregorianCalendar(2016, 2, 1),	new GregorianCalendar(2016, 0, 1),	300);
		}
	
	@After
	public void finish() {
		factura = null;
	}
	
	@Test
	public void testCalcularPeriodo() 
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method metodoCalcularPeriodo = Factura.class.getDeclaredMethod("calcularPeriodo", Calendar.class, Calendar.class);
		metodoCalcularPeriodo.setAccessible(true);
		int output = (int) metodoCalcularPeriodo.invoke(factura, new GregorianCalendar(2016, 0, 1), new GregorianCalendar(2016, 2, 1));
        assertThat(output, is(60));
	}
	
	@Test
	public void testCalcularImporte()
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method metodoCalcularImporte = Factura.class.getDeclaredMethod("calcularImporte", int.class);
		metodoCalcularImporte.setAccessible(true);
		double output = (double) metodoCalcularImporte.invoke(factura, 300);
		assertThat(output, is(45.0));
	}
	
	@Test
	public void testCalcularMinutos() {
		Cliente cliente = new Empresa("12345678","Fortea Chispas S.A.",new Direccion("12006", "Castellón", "Castellón de la Plana"),"chispitas@gmail.com",new GregorianCalendar(2016, 2, 26),new Tarifa(0.15));
		GestorLlamadas gestorLlamadas = new GestorLlamadas(cliente);
		gestorLlamadas.addLlamada(new Llamada("964039096",new GregorianCalendar(15, 11, 11, 21, 5, 11),15));
		gestorLlamadas.addLlamada(new Llamada("644125125",new GregorianCalendar(15, 12, 20, 14, 16, 13),20));
		gestorLlamadas.addLlamada(new Llamada("964039096",new GregorianCalendar(16, 0, 5, 20, 5, 54),17));
		gestorLlamadas.addLlamada(new Llamada("654842818",new GregorianCalendar(16, 2, 7, 1, 5, 4),5));
		Calendar c1 = new GregorianCalendar(2015, 1, 10);
		Calendar c2 = new GregorianCalendar(2016, 8, 6);
		assertThat(Factura.calcularMinutos(cliente, c1, c2), is(57));
	}
	
	@Test
	public void testGetFecha() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		StringBuilder expected = new StringBuilder();
		expected.append("2\n");
		expected.append("Tarifa contratada: 0.15 €/min\n");
		expected.append("Fecha de emisión: 01/03/16\n");
		expected.append("Periodo de facturación: 60 días\n");
		expected.append("Importe: 45.0 €\n");
		assertThat(factura.toString(), is(expected.toString()));
		expected = null;
	}
}
