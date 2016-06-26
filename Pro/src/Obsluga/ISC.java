package Obsluga;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URI;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JFileChooser;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
import dane.Alarm;
import dane.ListaZdarzen;
import dane.Zdarzenie;

public class ISC {
	/**
	 * Klasa zawieraj¹ca funkcje, których zadaniem jest serializacja Kalendazra do formatu ISC.
	 *@see ListaZdarzen
	 */
	public void serialize(ListaZdarzen lista)
	{
		Calendar calendare = new Calendar();
		calendare.getProperties().add(new ProdId("Organizator wersja pierwsza"));
		calendare.getProperties().add(Version.VERSION_2_0);
		calendare.getProperties().add(CalScale.GREGORIAN);
		List<Zdarzenie> list = lista.getZdarzenia();
		for(Zdarzenie a:list)
		{
			java.util.Calendar startDate = new GregorianCalendar();
			startDate.set(java.util.Calendar.MONTH, a.getData().getMonth());
			startDate.set(java.util.Calendar.DAY_OF_MONTH, a.getData().getDay());
			startDate.set(java.util.Calendar.YEAR, a.getData().getYear());
			startDate.set(java.util.Calendar.HOUR_OF_DAY, a.getData().getHours());
			startDate.set(java.util.Calendar.MINUTE, a.getData().getMinutes());
			startDate.set(java.util.Calendar.SECOND, a.getData().getSeconds());
			VEvent zdarznie = new VEvent(new DateTime(startDate.getTime()),a.dane());
			if(a.getList().size()!=0)
			{
				for(Alarm z:a.getList())
				{
					java.util.Calendar startDate1 = new GregorianCalendar();
					startDate1.set(java.util.Calendar.MONTH, z.getDate().getMonth());
					startDate1.set(java.util.Calendar.DAY_OF_MONTH, z.getDate().getDay());
					startDate1.set(java.util.Calendar.YEAR, z.getDate().getYear());
					startDate1.set(java.util.Calendar.HOUR_OF_DAY, z.getDate().getHours());
					startDate1.set(java.util.Calendar.MINUTE, z.getDate().getMinutes());
					startDate1.set(java.util.Calendar.SECOND, z.getDate().getSeconds());
					VEvent zdarznie1 = new VEvent(new DateTime(startDate1.getTime()),"Alarm");
					zdarznie.getAlarms().add(zdarznie1);
				}
			}
			calendare.getComponents().add(zdarznie);
		}
		System.out.println(calendare);
		JFileChooser fc =new JFileChooser();
		if(fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
		{
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("mileFile.isc");
			CalendarOutputter outputter = new CalendarOutputter();
			  outputter.setValidating(false);
				outputter.output(calendare, fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
