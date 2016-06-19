package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;

import sortowanie.SortowanieData;
import sortowanie.SortowanieMiejsce;
import sortowanie.SortowanieNazwa;



/**
 * Klasa przechowuj�ca list� zdarze� i zawieraj�ca funkcje umo�liwiaj�ce
 * operacje dodawania, usuwania i sortowania zdarze�.
 * @see Zdarzenie
 *
 */
public class ListaZdarzen {
	/**
	 * Lista typu zdarzenie przechowuj�ca zdarzenia.
	 * @see Zdarzenie
	 */
	private List<Zdarzenie> zdarzenia;
	/**
	 * Konstruktor klasy ListaZdarze� inicjalizuj�cy pust� list� zdarzenia
	 */
	public ListaZdarzen()
	{
		zdarzenia = new ArrayList<Zdarzenie>();
	}
	/**
	 * Funkcja dodaj�ca do listy zdarzenia nowe Zdarzenie
	 * @param e Dodawane Zdarzenie.
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public void add(Zdarzenie e)
	{
		zdarzenia.add(e);
	}
	/**
	 * Funkcja usuwaj�ca z listy zdarzenia wybrane Zdarzenie
	 * @param e Usuwane Zdarzenie
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public void delete(Zdarzenie e)
	{
		zdarzenia.remove(e);
	}
	/**
	 * Funkcja sortuj�ca list� zdarzenia po zmiennej nazwa
	 * z wykorzystaniem klasy SortowanieNazwa
	 * @see Zdarzenie#getNazwa()
	 * @see SortowanieNazwa
	 * @see zdarzenia
	 */
	public void sortujNazwa() {
		zdarzenia.sort(new SortowanieNazwa());
	}
	/**
	 * Funkcja sortuj�ca list� zdarzenia po zmiennej miejsce
	 * z wykorzystaniem klasy SortowanieMiejsce
	 * @see Zdarzenie#getMiejsce()
	 * @see SortowanieMiejsce
	 * @see zdarzenia
	 */
	public void sortujMiejsce() {
		zdarzenia.sort(new SortowanieMiejsce());
	}
	/**
	 * Funkcja sortuj�ca list� zdarzenia po zmiennej data
	 * z wykorzystaniem klasy SortowanieData
	 * @see Zdarzenie#getData()
	 * @see SortowanieData
	 * @see zdarzenia
	 */
	public void sortujData() {
		zdarzenia.sort(new SortowanieData());
	}
	/**
	 * Funkcja usuwaj�ca wszystkie zdarzenia kt�re posiadaj� dat� wcze�niejsz� od wybranej
	 * @param date data przed kt�r� wszystkie zdarzenia maj� by� usuni�te.
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public void UsunZdarzenia(Date date) {
		System.out.println(zdarzenia);
		List<Zdarzenie> remove = new ArrayList<Zdarzenie>();
		for(Zdarzenie e:zdarzenia)
		{
			if(e.getData().before(date)==true)
			{
				remove.add(e);
			}
		}
		zdarzenia.removeAll(remove);
	}
	/**
	 * Funkcja zwracaj�ca wszystkie zdarzenia o tej samej dacie co wybrana.
	 * @param date data, wed�ug kt�rej maj� by� wybrane zdarzenia
	 * @return lista zdarze� o identycznej dacie z wybran�.
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
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
	/**
	 * Funkcja sprawdzaj�ca, czy lista zdarzenia jest pusta.
	 * @return false je�li jest pusta, true je�li nie jest pusta.
	 * @see zdarzenia
	 */
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
	/**
	 * Funkcja zwracaj�ca list� zdarzenia.
	 * @return
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public List<Zdarzenie> getZdarzenia()
	{
		return zdarzenia;
	}
	public void alarm(Date tym) {
		// TODO Auto-generated method stub
		for(Zdarzenie z :zdarzenia)
		{
			z.informacjie(tym);
		}
	}
}
