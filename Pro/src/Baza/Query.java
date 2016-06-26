package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import dane.Alarm;
import dane.ListaZdarzen;
import dane.Zdarzenie;
/**
 * Klasa obs³uguj¹ca zapytania sql do bazy danych, które zapisuj¹ i 
 * odzczytuj¹ dane zawarte w klasie ListaZdarzen
 * @see ListaZdarzen
 *
 */
public class Query {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:C:/Users/Daniel/workspace/Projekt/prodb";
	/**
	 * Klasa zapisuj¹ca dane z klasy ListaZdarzen do tablic w bazie danych.
	 * Nawi¹zuje po³¹czenie z baz¹ danych, po czym zapisuje zdarzenia przy pomocy pêtli do tablicy.
	 * @param l Klasa ListaZdarzeñ zawieraj¹ca zdarzenia stworzone przez u¿ytkownika.
	 * @see Query
	 * @see ListaZdarzen
	 */
	public void addZdarzenia(ListaZdarzen l)
	{
	try{
		Connection connection=DriverManager.getConnection(JDBC_URL);
		Statement sta = connection.createStatement();
		Statement sta2 = connection.createStatement();
		connection.createStatement().executeQuery("truncate table alarmy");
		connection.createStatement().executeQuery("truncate table zdarzenia");
		int i=0;
		int k=0;
		for(Zdarzenie z: l.getZdarzenia())
		{
			
			sta.executeUpdate("insert into zdarzenia (id_z, nazwa, miejsce, opis, data) values ('"+i
					+"', '"+z.getNazwa()
					+"', '"+z.getMiejsce()
					+"', '"+z.getOpis()
					+"', '"+z.getData()
					+"')");
			for(int j = 0; j<z.getAlarmCount(); j++)
			{
					sta2.executeUpdate("insert into alarmy (id_a, data, id_z) values('"+k
							+"', '"+z.getList().get(j).getDate()
							+"', '"+i);
					k++;
			}
			i++;
		}
		if(sta !=null)sta.close();
		if(sta2 !=null)sta2.close();
		if(connection !=null)connection.close();
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
		System.out.println(e.getNextException());
	}
		
	}
	/**
	 * Klasa odczytuj¹ca dane z bazy danych do klasy ListaZdarzen.
	 * Nawi¹zuje po³¹czenie z baz¹ danych, po czym odczytuje zdarzenia przy pomocy pêtli do listy.
	 * @param a lista typu Zdarzenie z klasy ListaZdarzen
	 * @see Query
	 * @see ListaZdarzen
	 * @see ListaZdarzen#getZdarzenia()
	 */
	public void getZdarzenia(ListaZdarzen a)
	{
		try{
			Connection connection=DriverManager.getConnection(JDBC_URL);
			String query="select nazwa, miejsce, opis, data from zdarzenia";
			String queryA="select godzina from alarmy where id_z=x`";
			Zdarzenie z=new Zdarzenie();
			Alarm b = new Alarm(0,new Date(2016,6,12));
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSet rsA;
			while (rs.next())
			{
				z.setNazwa(rs.getString("nazwa"));
				z.setMiejsce(rs.getString("miejsce"));
				z.setOpis(rs.getString("opis"));
				z.setData(rs.getDate("data"));
				rsA=stmt.executeQuery(queryA+rs.getInt("id_z"));
				while(rsA.next())
				{
					b.setGodzina(rsA.getString("godzina"));
					z.getList().add(b);
				}
				a.add(z);
			}
			if(stmt!=null){stmt.close();}
			if(connection!=null){connection.close();}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getNextException());

		}
		
		
	}
	
}
