package sortowanie;

import java.util.Comparator;

import dane.Zdarzenie;

public class SortowanieNazwa implements Comparator<Zdarzenie>{

	@Override
	public int compare(Zdarzenie arg0, Zdarzenie arg1) {
		return arg0.getNazwa().compareTo(arg1.getNazwa());
	}
	

}
