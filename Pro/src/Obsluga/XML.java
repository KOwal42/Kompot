package Obsluga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import dane.Alarm;
import dane.ListaZdarzen;
import dane.Opcjie;
import dane.ZapisOpcji;
import dane.Zdarzenie;

/**
 * Klasa zawieraj�ca funkcje, kt�rych zadaniem jest serializacja i
 * deserializacja listy ListaZdarzen do i z pliku xml.
 *@see ListaZdarzen
 */
public class XML {
	
	/**
	 * Funkcja, kt�ra zapisuje klas� ListaZdarzen do pliku xml.
	 * Funkcja tworzy plik pod wskazan� �cie�k�, tworzy i otwiera strumie�,
	 * po czym zapisuje klas� do pliku.
	 * Po udanym zapisie wy�wietla okienko z wiadomo�ci� "Zapis wykonany"
	 * W przypadku nie wybrania �cie�ki pliku wy�wietla okienko z napisem "Przerwano zapis"
	 * @param zapis klasa ListaZdarzen, kt�ra ma by� zapisana do pliku
	 * @see ListaZdarzen
	 * @see XML
	 */
	public void Serializacjia(ListaZdarzen zapis) {
		JFileChooser fc =new JFileChooser();
		if(fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
		{
			File xmlP = fc.getSelectedFile();
			XStream xstream = new XStream(new StaxDriver());
			xstream.alias("Zdarzenie", Zdarzenie.class);    
			xstream.alias("Alarm", Alarm.class);
			String xml = xstream.toXML(zapis);
			
			try	{
				xmlP.createNewFile();					// Utworzenie pliku pod sciezka zapisana w plik 
				FileWriter strumienZapisu = new FileWriter(xmlP);	// Konstrukcja i otwarcie strumienia
				strumienZapisu.write(xml);		// Zapis do pliku liter od 0 do 7 z txt  
				strumienZapisu.close(); 
				JOptionPane.showMessageDialog(null,"Zapis wykonany");// Zamkniecie strumienia
			}
			catch (FileNotFoundException io)												
			{System.out.println(io.getMessage());}

			catch (IOException io)												
			{System.out.println(io.getMessage());}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Przerwano zapis");
		}

	}
	/**
	 * Funkcja, kt�ra wczytuje dane z wybranego pliku i zapisuje je do klasy ListaZdarzen.
	 * Funkcja tworzy i otwiera strumie�, po czym wczytuje wybrany plik.
	 * Nast�pnie zapisuje dane z pliku do klasy ListaZdarzen i przy powodzeniu wy�wietla okienko z napisem "Wczytywanie zako�czone".
	 * Je�li plik nie istnieje, wy�wietla okienko z napisem "Brak pliku".
	 * W przypadku zaniechania wczytywania wy�wietla okienko z napisem "Przerwano wczytywanie".
	 * @return klasa ListaZdarzen 
	 * @see ListaZdarzen
	 * @see XML
	 */
	public ListaZdarzen Deserializacjia() {
		JFileChooser fc =new JFileChooser();
		if(fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
		{
			File xmlP = fc.getSelectedFile();
			ListaZdarzen op;
			XStream xstream = new XStream(new StaxDriver());
			xstream.alias("Zdarzenie", Zdarzenie.class);    
			xstream.alias("Alarm", Alarm.class);
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
				op = (ListaZdarzen)xstream.fromXML(xmlod);
				JOptionPane.showMessageDialog(null," Wczytywanie zakoniczone");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Brak pliku");
				op= null;
			}
			return op;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Przerwano wczytywanie");
			return null;
		}
	}

}
