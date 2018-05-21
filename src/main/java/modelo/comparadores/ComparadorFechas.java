package modelo.comparadores;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;

public class ComparadorFechas implements Comparator<Calendar>, Serializable {
	

	private static final long serialVersionUID = 3548506378251222149L;

	@Override
	public int compare(Calendar c1, Calendar c2){
		return (int) (c1.getTimeInMillis() - c2.getTimeInMillis() );
	}
}
