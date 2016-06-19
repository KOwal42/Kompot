package dane;

import java.util.Date;
/**
 * Klasa przechowuj¹ca informacje dotycz¹ce alarmów dla danego zdarzenia.
 * @see Zdarzenie
 *
 */
public class Alarm {
	/**
	 * Zmienna przechowuj¹ca datê i godzinê alarmu.
	 * @see Alarm
	 */
	private Date date;
	/**
	 * Konstruktor klasy Alarm.
	 * Argument i okreœla na ile minut przed dat¹ zdarzenia ma siê uruchomiæ alarm.
	 * Jeœli wartoœæ i jest mniejsza od 60, od daty zdarzenia s¹ odejmowane minuty.
	 * W przeciwnym wypadku jest odejmowana godzina.
	 * Argument date jest dat¹ i godzin¹ zdarzenia, do którego jest tworzony alarm.
	 * @param i iloœæ minut przed zdarzeniem.
	 * @param date data i godzina zdarzenia, do którego jest przypisywany alarm.
	 * @see Zdarzenie
	 * @see Zdarzenie#addAlarm(int)
	 */
	public Alarm(int i,Date date) {
		this.date=date;
		int minut = this.date.getMinutes();
		if(i<60)
		{
			this.date.setMinutes(minut-i);
		}
		else
		{
			this.date.setHours(this.date.getHours()-1);
		}
		
	}

	public void setGodzina(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getGodzina() {
		// TODO Auto-generated method stub
		return null;
	}

}
