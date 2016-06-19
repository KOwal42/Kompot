package FirstWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kalendarz.Modyfikuj;

import dane.Zdarzenie;
/**
 * Klasa odpowiedzialna za wy�wietlanie okienka umo�liwiaj�cego modyfikacj� zdarzenia.
 * @see Modyfikuj
 * @see Zdarzenie
 *
 */
public class ModyfikujOnko extends JFrame {
	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	/**
	 * Konstruktor klasy ModyfikujOnko wykorzystuj�cy klas� Modyfikuj.
	 * 
	 * @param e Modyfikowane Zdarzenie
	 * @see ModyfikujOkno
	 * @see Modyfikuj
	 * @see Zdarzenie
	 */
	public ModyfikujOnko(Zdarzenie e) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane =new Modyfikuj(e);
		setContentPane(contentPane);
	}

}
