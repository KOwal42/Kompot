package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;

import sortowanie.SortowanieData;
import sortowanie.SortowanieMiejsce;
import sortowanie.SortowanieNazwa;



/**
 * Klasa przechowuj¹ca listê zdarzeñ i zawieraj¹ca funkcje umo¿liwiaj¹ce
 * operacje dodawania, usuwania i sortowania zdarzeñ.
 * @see Zdarzenie
 *
 */
public class ListaZdarzen {
	/**
	 * Lista typu zdarzenie przechowuj¹ca zdarzenia.
	 * @see Zdarzenie
	 */
	private List<Zdarzenie> zdarzenia;
	/**
	 * Konstruktor klasy ListaZdarzeñ inicjalizuj¹cy pust¹ listê zdarzenia
	 */
	public ListaZdarzen()
	{
		zdarzenia = new ArrayList<Zdarzenie>();
	}
	/**
	 * Funkcja dodaj¹ca do listy zdarzenia nowe Zdarzenie
	 * @param e Dodawane Zdarzenie.
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public void add(Zdarzenie e)
	{
		zdarzenia.add(e);
	}
	/**
	 * Funkcja usuwaj¹ca z listy zdarzenia wybrane Zdarzenie
	 * @param e Usuwane Zdarzenie
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public void delete(Zdarzenie e)
	{
		zdarzenia.remove(e);
	}
	/**
	 * Funkcja sortuj¹ca listê zdarzenia po zmiennej nazwa
	 * z wykorzystaniem klasy SortowanieNazwa
	 * @see Zdarzenie#getNazwa()
	 * @see SortowanieNazwa
	 * @see zdarzenia
	 */
	public void sortujNazwa() {
		zdarzenia.sort(new SortowanieNazwa());
	}
	/**
	 * Funkcja sortuj¹ca listê zdarzenia po zmiennej miejsce
	 * z wykorzystaniem klasy SortowanieMiejsce
	 * @see Zdarzenie#getMiejsce()
	 * @see SortowanieMiejsce
	 * @see zdarzenia
	 */
	public void sortujMiejsce() {
		zdarzenia.sort(new SortowanieMiejsce());
	}
	/**
	 * Funkcja sortuj¹ca listê zdarzenia po zmiennej data
	 * z wykorzystaniem klasy SortowanieData
	 * @see Zdarzenie#getData()
	 * @see SortowanieData
	 * @see zdarzenia
	 */
	public void sortujData() {
		zdarzenia.sort(new SortowanieData());
	}
	/**
	 * Funkcja usuwaj¹ca wszystkie zdarzenia które posiadaj¹ datê wczeœniejsz¹ od wybranej
	 * @param date data przed któr¹ wszystkie zdarzenia maj¹ byæ usuniête.
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
	 * Funkcja zwracaj¹ca wszystkie zdarzenia o tej samej dacie co wybrana.
	 * @param date data, wed³ug której maj¹ byæ wybrane zdarzenia
	 * @return lista zdarzeñ o identycznej dacie z wybran¹.
	 * @see Zdarzenie
	 * @see zdarzenia
	 */
	public Vector<Vector<String>> ChoseDate(Date date)
	{
		Vector<Vector<String>> row = new Vector<Vector<String>>();
		for(Zdarzenie e:zdarzenia)
		{
			if(e.getData().getDay()==date.getDay()&&e.getData().getYear()==date.getYear()&&e.getData().getMonth()==date.getMonth())
			{
				Vector<String> colum = new Vector<String>();
				colum.add(e.getNazwa());
				colum.add(e.getMiejsce());
				colum.add(e.getData().toString());
				row.add(colum);
			}
		}
		return row;
	}
	@Override
	public String toString() {
		return "ListaZdarzen [zdarzenia=" + zdarzenia + "]";
	}
	/**
	 * Funkcja sprawdzaj¹ca, czy lista zdarzenia jest pusta.
	 * @return false jeœli jest pusta, true jeœli nie jest pusta.
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
	public Vector<Vector<String>> ChoseAll()
	{
		Vector<Vector<String>> row = new Vector<Vector<String>>();
		for(Zdarzenie e:zdarzenia)
		{
			Vector<String> colum = new Vector<String>();
			colum.add(e.getNazwa());
			colum.add(e.getMiejsce());
			colum.add(e.getData().toString());
			row.add(colum);
		}
		return row;
	}
	/**
	 * Funkcja zwracaj¹ca listê zdarzenia.
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
	public Zdarzenie find(String name, String polozenie, String data) {
		// TODO Auto-generated method stub
		Zdarzenie a = null;
		Vector<Zdarzenie> wybrane = new Vector<Zdarzenie>();
		Vector<Zdarzenie> wybrane1 = new Vector<Zdarzenie>();
		for(Zdarzenie e:zdarzenia)
		{
			if(e.getNazwa()==name)
			{
				System.out.println("true name");
				wybrane.add(e);
				if(wybrane.size()==1){
					a=wybrane.get(0);
				}
				else
				{
					for(Zdarzenie z:wybrane)
					{
						if(e.getNazwa()==polozenie)
						{
							System.out.println("true miejsce");
							wybrane1.add(z);
							if(wybrane1.size()==1){
								a=wybrane1.get(0);
							}
						}
					}
				}
			}
		}
		return a;
	}
}
