package Obsluga;

import java.util.Date;

import dane.ListaZdarzen;
/**
 * Umozliwa sprzwdzanie alarm�w w nowym w�tku.
 *@see ListaZdarzen
 */
public class Wywo�anie implements Runnable {
	
	private ListaZdarzen list;
	/**
	 * Konstruktor klasy umozliwja�cy operacjie na liscie.
	 *@see ListaZdarzen
	 */
	public Wywo�anie(ListaZdarzen lista)
	{
		list=lista;
	}
	/**
	 * Metoda porzebna do uruchomiea w nowym w�tku sprawdzania alamu.
	 *@see ListaZdarzen
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			Date tym = new Date();
			list.alarm(tym);
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
