package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utworz {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:prodb;create=true";
	public static void create() throws SQLException
	{
		Connection connection=DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("create table zdarzenia(id_z int not null auto_increment, nazwa varchar(30), miejsce varchar(30), opis varchar(500), data date, primary key(id_z))");
		connection.createStatement().execute("create table alarmy(id_a int not null auto_increment primary key, godzina time, id_z int, primary key(id_a), foreign key (id_z) references zdarzenia(id_z))");
		if(connection !=null)connection.close();
		
	}
}
