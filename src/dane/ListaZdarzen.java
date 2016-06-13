package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;

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
	public void UsunZdarzenia(Date date) {
		for(Zdarzenie e:zdarzenia)
		{
			if(e.getData().before(date)==true)
			{
				zdarzenia.remove(e);
				delete(e);
			}
		}
	}
	public DefaultListModel<Zdarzenie> ChoseDate(Date date)
	{
		DefaultListModel<Zdarzenie> dane = new DefaultListModel<>();
		for(Zdarzenie e:zdarzenia)
		{
			if(e.getData().getDay()==date.getDay()&&e.getData().getYear()==date.getYear()&&e.getData().getMonth()==date.getMonth())
			{
				dane.addElement(e);
			}
		}
		return dane;
	}
	@Override
	public String toString() {
		return "ListaZdarzen [zdarzenia=" + zdarzenia + "]";
	}
	public boolean NotZero() {
		if(zdarzenia.isEmpty()== true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public DefaultListModel<Zdarzenie> ChoseAll()
	{
		DefaultListModel<Zdarzenie> dane = new DefaultListModel<>();
		for(Zdarzenie e:zdarzenia)
		{
			dane.addElement(e);
		}
		return dane;
	}
}
