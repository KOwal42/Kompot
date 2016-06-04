package dane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class ZapisOpcji {
	File xmlP = new File("C:/Data/Projekt/Opcjie.xml");
	
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
