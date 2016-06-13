package sortowanie;
import java.util.Comparator;


import dane.Zdarzenie;
public class SortowanieData implements Comparator<Zdarzenie>{

	@Override
	public int compare(Zdarzenie arg0, Zdarzenie arg1) {
		if(arg0.getData().before(arg1.getData()))
		{
			return -1;
		}
		if(arg0.getData().after(arg1.getData()))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

}
