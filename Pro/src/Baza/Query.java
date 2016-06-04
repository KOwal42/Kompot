package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
	
}
