package dane;

import java.util.Date;

public class Alarm {
	private Date date;
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
