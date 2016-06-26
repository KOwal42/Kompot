package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
/**
 * Klasa przechowuj¹ca informacje dotycz¹ce zdarzenia.
 * 
 *
 */
public class Zdarzenie {
	/**
	 * Lista typu Alarm przechowuj¹ca alarmy dla danego zdarzenia.
	 * @see Alarm
	 */
	List<Alarm> alarmy;
	/**
	 * Zmienna typu String przechowuj¹ca informacje o miejscu zdarzenia.
	 */
	private String miejsce;
	/**
	 * Zmienna typu String przechowuj¹ca opis zdarzenia.
	 */
	private String opis;
	/**
	 * Zmienna typu Date przechowuj¹ca informacje o dacie i godzinie zdarzenia.
	 */
	private Date data;
	/**
	 * Zmienna typu String przechowuj¹ca informacje o nazwie zdarzenia.
	 */
	private String nazwa;
	/**
	 * Funkcja zwracaj¹ca wartoœæ prywatnej zmiennej nazwa.
	 * @see Zdarzenie#nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * Funkcja zmieniaj¹ca wartoœæ prywatnej zmiennej nazwa.
	 * @param nazwa wartoœæ, jak¹ przyjmie zmienna nazwa po wywo³aniu funkcji.
	 * @see Zdarzenie#nazwa
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * Funkcja zwracaj¹ca wartoœæ prywatnej zmiennej miejsce. 
	 * @see Zdarzenie#miejsce
	 */
	public String getMiejsce() {
		return miejsce;
	}
	/**
	 * Funkcja zmieniaj¹ca wartoœæ prywatnej zmiennej miejsce.
	 * @param miejsce wartoœæ, jak¹ przyjmie zmienna miejsce po wywo³aniu funkcji.
	 * @see Zdarzenie#miejsce
	 */
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	/**
	 * Funkcja zwracaj¹ca wartoœæ prywatnej zmiennej opis.
	 * @see Zdarzenie#opis
	 */
	public String getOpis() {
		return opis;
	}
	/**
	 * Funkcja zmieniaj¹ca wartoœæ prywatnej zmiennej opis.
	 * @param nazwa wartoœæ, jak¹ przyjmie zmienna opis po wywo³aniu funkcji.
	 * @see Zdarzenie#opis
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}
	/**
	 * Funkcja zwracaj¹ca wartoœæ prywatnej zmiennej data.
	 * @see Zdarzenie#data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * Funkcja zmieniaj¹ca wartoœæ prywatnej zmiennej data.
	 * @param nazwa wartoœæ, jak¹ przyjmie zmienna data po wywo³aniu funkcji.
	 * @see Zdarzenie#data
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Konstruktor klasy Zdarzenie inicjalizowany z pustymi wartoœciami.
	 * @see Zdarzenie
	 */
	public Zdarzenie()
	{
		alarmy = new ArrayList<Alarm>();
		miejsce = "";
		nazwa= "";
		opis ="";
		data = new Date();
	}
	/**
	 * Funkcja dodaj¹ca alarm do listy alarmy. Argument i okreœla na ile minut przed zdarzeniem alarm siê uaktywnia.
	 * Argument data to data zdarzenia, do którego jest dodawany alarm
	 * @param i Zmienna pomocnicza wykorzystywana w konstruktorze klasy Alarm.
	 * @see Alarm
	 * @see Alarm#Alarm(int, Date)
	 */
	public void addAlarm(int i)
	{
	alarmy.add(new Alarm(i,data));	
	}
	/**
	 * Funkcja zwracaj¹ca prywatn¹ listê alarmy
	 * @see Zdarzenie#alarmy
	 */
	public List<Alarm> getList() {
		return alarmy;
	}
	/**
	 * Funkcja zwracaj¹ca iloœæ alarmów znajduj¹ca siê w liœcie alarmy.
	 * @return iloœæ alarmów
	 * @see Zdarzenie#alarmy
	 */
	public int getAlarmCount() {
		// TODO Auto-generated method stub
		return alarmy.size();
	}
	@Override
	/**
	 * Funkcja wypisuj¹ca nazwy i wartoœci wszystkich zmiennych opisuj¹cych zdarzenie.
	 * @return zwraca nazwy i wartoœci zmiennych nazwa, miejsce, data i opis.
	 * @see Zdarzenie
	 */
	public String toString() {
		return "Nazwa: "+nazwa+"\n Miejsce: "+miejsce+"\n Data: "+data+"\n Opis: "+opis;
	}
	public void informacjie(Date tym) {
		// TODO Auto-generated method stub
		if(alarmy.isEmpty()==false)
		{
			for(Alarm a :alarmy)
			{
				if(a.czas(tym)==true)
				{
					JOptionPane.showMessageDialog(null,this.toString());
				}
			}
		}
	}
	public String dane() {
		String dane = "Nazwa: "+this.nazwa+" Miejsce: "+this.miejsce+" Opis: "+this.opis;
		return dane;
	}
	
}
