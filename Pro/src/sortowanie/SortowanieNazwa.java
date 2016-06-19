package sortowanie;

import java.util.Comparator;

import dane.Zdarzenie;
/**
 * Klasa sortuj¹ca listê typu Zdarzenie po polu nazwa.
 * @see Zdarzenie
 */
public class SortowanieNazwa implements Comparator<Zdarzenie>{

	@Override
	public int compare(Zdarzenie arg0, Zdarzenie arg1) {
		return arg0.getNazwa().compareTo(arg1.getNazwa());
	}
	

}
