package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
/**
 * Klasa przechowuj�ca informacje dotycz�ce zdarzenia.
 * 
 *
 */
public class Zdarzenie {
	/**
	 * Lista typu Alarm przechowuj�ca alarmy dla danego zdarzenia.
	 * @see Alarm
	 */
	List<Alarm> alarmy;
	/**
	 * Zmienna typu String przechowuj�ca informacje o miejscu zdarzenia.
	 */
	private String miejsce;
	/**
	 * Zmienna typu String przechowuj�ca opis zdarzenia.
	 */
	private String opis;
	/**
	 * Zmienna typu Date przechowuj�ca informacje o dacie i godzinie zdarzenia.
	 */
	private Date data;
	/**
	 * Zmienna typu String przechowuj�ca informacje o nazwie zdarzenia.
	 */
	private String nazwa;
	/**
	 * Funkcja zwracaj�ca warto�� prywatnej zmiennej nazwa.
	 * @see Zdarzenie#nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * Funkcja zmieniaj�ca warto�� prywatnej zmiennej nazwa.
	 * @param nazwa warto��, jak� przyjmie zmienna nazwa po wywo�aniu funkcji.
	 * @see Zdarzenie#nazwa
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * Funkcja zwracaj�ca warto�� prywatnej zmiennej miejsce. 
	 * @see Zdarzenie#miejsce
	 */
	public String getMiejsce() {
		return miejsce;
	}
	/**
	 * Funkcja zmieniaj�ca warto�� prywatnej zmiennej miejsce.
	 * @param miejsce warto��, jak� przyjmie zmienna miejsce po wywo�aniu funkcji.
	 * @see Zdarzenie#miejsce
	 */
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	/**
	 * Funkcja zwracaj�ca warto�� prywatnej zmiennej opis.
	 * @see Zdarzenie#opis
	 */
	public String getOpis() {
		return opis;
	}
	/**
	 * Funkcja zmieniaj�ca warto�� prywatnej zmiennej opis.
	 * @param nazwa warto��, jak� przyjmie zmienna opis po wywo�aniu funkcji.
	 * @see Zdarzenie#opis
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}
	/**
	 * Funkcja zwracaj�ca warto�� prywatnej zmiennej data.
	 * @see Zdarzenie#data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * Funkcja zmieniaj�ca warto�� prywatnej zmiennej data.
	 * @param nazwa warto��, jak� przyjmie zmienna data po wywo�aniu funkcji.
	 * @see Zdarzenie#data
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Konstruktor klasy Zdarzenie inicjalizowany z pustymi warto�ciami.
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
	 * Funkcja dodaj�ca alarm do listy alarmy. Argument i okre�la na ile minut przed zdarzeniem alarm si� uaktywnia.
	 * Argument data to data zdarzenia, do kt�rego jest dodawany alarm
	 * @param i Zmienna pomocnicza wykorzystywana w konstruktorze klasy Alarm.
	 * @see Alarm
	 * @see Alarm#Alarm(int, Date)
	 */
	public void addAlarm(int i)
	{
	alarmy.add(new Alarm(i,data));	
	}
	/**
	 * Funkcja zwracaj�ca prywatn� list� alarmy
	 * @see Zdarzenie#alarmy
	 */
	public List<Alarm> getList() {
		return alarmy;
	}
	/**
	 * Funkcja zwracaj�ca ilo�� alarm�w znajduj�ca si� w li�cie alarmy.
	 * @return ilo�� alarm�w
	 * @see Zdarzenie#alarmy
	 */
	public int getAlarmCount() {
		// TODO Auto-generated method stub
		return alarmy.size();
	}
	@Override
	/**
	 * Funkcja wypisuj�ca nazwy i warto�ci wszystkich zmiennych opisuj�cych zdarzenie.
	 * @return zwraca nazwy i warto�ci zmiennych nazwa, miejsce, data i opis.
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
