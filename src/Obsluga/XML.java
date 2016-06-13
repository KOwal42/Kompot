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
import dane.Zdarzenie;


public class XML {
	

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
