package dane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
/**
 * Klasa zawieraj¹ca funkcje, których zadaniem jest serializacja i
 * deserializacja wyborów opcji do i z pliku xml.
 * @see Opcjie
 *
 */
public class ZapisOpcji {
	/**
	 * Zmienna opisuj¹ca plik xml, na którym bêd¹ wykonywane operacje zapisu i odczytu.
	 * @see ZapisOpcji#Serialize(Opcjie)
	 * @see ZapisOpcji#Deserialize()
	 */
	File xmlP = new File("C:/Data/Projekt/Opcjie.xml");
	/**
	 * Funkcja, która zapisuje wybran¹ opcjê do pliku xml.
	 * Funkcja tworzy plik pod wskazan¹ œcie¿k¹, tworzy i otwiera strumieñ,
	 * po czym zapisuje wybory opcji do pliku.
	 * @param o opcja, jaka ma byæ zapisana do pliku.
	 * @see Opcjie
	 * @see ZapisOpcji
	 * @see ZapisOpcji#xmlP
	 */
	public void Serialize(Opcjie o)
	{
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("Opcjie", Opcjie.class);    
		String xml = xstream.toXML(o);
		
		try	{
			xmlP.createNewFile();					// Utworzenie pliku pod sciezka zapisana w plik 
			FileWriter strumienZapisu = new FileWriter(xmlP);	// Konstrukcja i otwarcie strumienia
			strumienZapisu.write(xml);		// Zapis do pliku liter od 0 do 7 z txt  
			strumienZapisu.close(); 				// Zamkniecie strumienia
		}
		catch (FileNotFoundException io)												
		{System.out.println(io.getMessage());}

	catch (IOException io)												
		{System.out.println(io.getMessage());}
	}
	/**
	 * Funkcja, która wczytuje wybory opcji zawartej w pliku i zwraca w postaci klasy Opcjie.
	 * Funkcja tworzy i otwiera strumieñ, po czym tworzy klasê Opcjie, do której zapisuje wybory.
	 * @return wybory opcji zawartej w pliku xml
	 * @see Opcjie
	 * @see ZapisOpcji
	 * @see ZapisOpcji#xmlP
	 */
	public Opcjie Deserialize()
	{
		Opcjie op;
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("Opcjie", Opcjie.class); 
		String xmlod = null;
		String linia;
		if(xmlP.isFile())
		{
			try{
				FileReader file= new FileReader(xmlP);
				BufferedReader buforr= new BufferedReader(file);
				while((linia = buforr.readLine()) != null){
					xmlod=linia;
			     }
			}catch (IOException e) {
				e.printStackTrace();
				
			}
			op = (Opcjie)xstream.fromXML(xmlod);
		}
		else
		{
			op = new Opcjie();
		}
		return op;
	}

}
