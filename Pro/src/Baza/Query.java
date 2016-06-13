package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dane.Alarm;
import dane.Zdarzenie;

public class Query {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:prodb;create=true";
	public void addZdarzenie(Zdarzenie z, int index) throws SQLException
	{
		Connection connection=DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("insert into zdarzenia values ('"+index
												+"', '"+z.getNazwa()
												+"', '"+z.getMiejsce()
												+"', '"+z.getOpis()
												+"', '"+z.getData()
												+"')");
		
		for(int i = 0; i<z.getAlarmCount(); i++)
		{
			connection.createStatement().execute("insert into alarmy values('"+i
													+"', '"+z.getList().get(i).getGodzina()
													+"', '"+index);
		}
		if(connection !=null)connection.close();
		
	}
	public void deleteZdarzenie(int index) throws SQLException
	{
		Connection connection=DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("delete from zdarzenia where id_z="+index);
		connection.createStatement().execute("delete from alarmy where id_z="+index);
		if(connection !=null)connection.close();

	}
	public void getZdarzenia(List<Zdarzenie> a) throws SQLException
	{
		a.clear();
		Connection connection=DriverManager.getConnection(JDBC_URL);
		String query="select nazwa, miejsce, opis, data from zdarzenia";
		String queryA="select godzina from alarmy where id_z=";
		Zdarzenie z=new Zdarzenie();
		Alarm b = new Alarm(0,null);
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
	
}
