package dane;

import java.util.Date;
/**
 * Klasa przechowuj�ca informacje dotycz�ce alarm�w dla danego zdarzenia.
 * @see Zdarzenie
 *
 */
public class Alarm {
	/**
	 * Zmienna przechowuj�ca dat� i godzin� alarmu.
	 * @see Alarm
	 */
	private Date date;
	private int time;
	/**
	 * Konstruktor klasy Alarm.
	 * Argument i okre�la na ile minut przed dat� zdarzenia ma si� uruchomi� alarm.
	 * Je�li warto�� i jest mniejsza od 60, od daty zdarzenia s� odejmowane minuty.
	 * W przeciwnym wypadku jest odejmowana godzina.
	 * Argument date jest dat� i godzin� zdarzenia, do kt�rego jest tworzony alarm.
	 * @param i ilo�� minut przed zdarzeniem.
	 * @param date data i godzina zdarzenia, do kt�rego jest przypisywany alarm.
	 * @see Zdarzenie
	 * @see Zdarzenie#addAlarm(int)
	 */
	public Alarm(int i,Date date) {
		this.date=date;
		this.setTime(i);
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setGodzina(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getGodzina() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean czas(Date tym) {
		// TODO Auto-generated method stub
		if(this.date.getYear()==tym.getYear())
		{
			if(this.date.getMonth()==tym.getMonth())
			{
				if(this.date.getDay()==tym.getDay())
				{
					if(this.date.getHours()==tym.getHours())
					{
						if(this.date.getMinutes()==tym.getMinutes())
						{
							return true;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
