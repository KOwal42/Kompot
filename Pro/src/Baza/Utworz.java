package Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Klasa odpowiedzialna za utworzenie wewnêtrznej bazy danych przechowuj¹cej
 * listê zdarzeñ.
 * @see ListaZdarzen
 *
 */
public class Utworz {
	/**
	 * Œcie¿ka do sterownika.
	 */
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	/**
	 * Œcie¿ka po³¹czenia.
	 */
	public static final String JDBC_URL = "jdbc:derby:prodb;create=true";
	/**
	 * Funkcja odpowiedzialna za utworzenie tablic w bazie danych przechowywuj¹cych dane z listy.
	 * Nawi¹zuje po³¹czanie z baz¹ danych i wywo³uje zapytania sql dotycz¹ce tworzenia tablic.
	 * Nastêpnie wywo³uje funkcjê check
	 * @see Utworz
	 * @see Utworz#checkTables()
	 */
	public static void create() 
	{
		try
		{
			Connection connection=DriverManager.getConnection(JDBC_URL);
			connection.createStatement().execute("create table zdarzenia(id_z int not null, nazwa varchar(30), miejsce varchar(30), opis varchar(500), data date, constraint pk_z primary key(id_z))");
			connection.createStatement().execute("create table alarmy(id_a int not null, data date, id_z int,constraint pk_a primary key(id_a),constraint fk_a foreign key (id_z) references zdarzenia(id_z))");
			if(connection !=null)connection.close();
		}
		catch(SQLException e)
		{
			return;
		}
		finally
		{
			checkTables();
		}
		
	}
	/**
	 * Funkcja sprawdzaj¹ca, czy tablice zosta³y utworzone poprzez wypisanie tablic w konsoli.
	 * @see Utworz
	 */
	private static void checkTables() 
	{
		try
		{
			String query="select * from sys.systables";
			Connection connection=DriverManager.getConnection(JDBC_URL);
			Statement stmt = connection.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int columnsNumber = rsmd.getColumnCount();
			 while (rs.next()) 
			 {
			    for (int i = 1; i <= columnsNumber; i++) 
			    {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");
			 }
			 if(connection !=null)connection.close();
		}
		catch(SQLException e)
		{
			return;
		}
	}
}
