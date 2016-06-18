package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dane.Alarm;
import dane.ListaZdarzen;
import dane.Zdarzenie;

public class Query {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:prodb;create=true";
	public void addZdarzenia(ListaZdarzen l) throws SQLException
	{
		Connection connection=DriverManager.getConnection(JDBC_URL);
		connection.createStatement().executeQuery("truncate table alarmy");
		connection.createStatement().executeQuery("truncate table zdarzenia");
		Zdarzenie z = new Zdarzenie();
		for(int i=0;i<l.getZdarzenia().size();i++)
		{
			
			connection.createStatement().execute("insert into zdarzenia values ('"+i
					+"', '"+z.getNazwa()
					+"', '"+z.getMiejsce()
					+"', '"+z.getOpis()
					+"', '"+z.getData()
					+"')");

			for(int j = 0; j<z.getAlarmCount(); i++)
			{
					connection.createStatement().execute("insert into alarmy values('"+j
							+"', '"+z.getList().get(j).getDate()
							+"', '"+j);
			}
		}
		if(connection !=null)connection.close();
		
	}
	public void getZdarzenia(List<Zdarzenie> a) throws SQLException
	{
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
