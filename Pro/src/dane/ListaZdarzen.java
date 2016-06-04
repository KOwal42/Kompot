package dane;

import java.util.ArrayList;
import java.util.List;

import sortowanie.SortowanieData;
import sortowanie.SortowanieMiejsce;
import sortowanie.SortowanieNazwa;




public class ListaZdarzen {
	private List<Zdarzenie> zdarzenia;
	public ListaZdarzen()
	{
		zdarzenia = new ArrayList<Zdarzenie>();
	}
	public void add(Zdarzenie e)
	{
		zdarzenia.add(e);
	}
	public void delete(Zdarzenie e)
	{
		zdarzenia.remove(e);
	}
	
	public void sortujNazwa() {
		zdarzenia.sort(new SortowanieNazwa());
	}

	public void sortujMiejsce() {
		zdarzenia.sort(new SortowanieMiejsce());
	}

	public void sortujData() {
		zdarzenia.sort(new SortowanieData());
	}

}
