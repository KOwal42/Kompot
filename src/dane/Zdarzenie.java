package dane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zdarzenie {
	List<Alarm> alarmy;
	private String miejsce;
	private String opis;
	private Date data;
	private String nazwa;
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getMiejsce() {
		return miejsce;
	}
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Zdarzenie()
	{
		alarmy = new ArrayList<Alarm>();
		miejsce = "";
		nazwa= "";
		opis ="";
		data = new Date();
	}
	public void addAlarm(int i)
	{
	alarmy.add(new Alarm(i,data));	
	}
	public List<Alarm> getList() {
		return alarmy;
	}
	public int getAlarmCount() {
		// TODO Auto-generated method stub
		return alarmy.size();
	}
	@Override
	public String toString() {
		return "Zdarzenie [miejsce=" + miejsce
				+ ", opis=" + opis + ", data=" + data + ", nazwa=" + nazwa
				+ "]";
	}
	
}
