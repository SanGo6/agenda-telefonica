package test.conjuntos;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.individuales.DireccionTest;
import test.individuales.EmpresaTest;
import test.individuales.FacturaTest;
import test.individuales.LlamadaTest;
import test.individuales.ParticularTest;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, ParticularTest.class, DireccionTest.class,
	FacturaTest.class, LlamadaTest.class })
public class AllObjectsTest {

}
