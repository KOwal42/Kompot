package sortowanie;

import java.util.Comparator;

import dane.Zdarzenie;

public class SortowanieMiejsce  implements Comparator<Zdarzenie>{

	@Override
	public int compare(Zdarzenie arg0, Zdarzenie arg1) {
			return arg0.getMiejsce().compareTo(arg1.getMiejsce());
	}

}
