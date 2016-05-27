package FirstWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Window extends JFrame {
	
	private ActionControle actionControle;
	private JMenuBar menuBar;
	private JMenu menuKalendarz, menuObsluga, menuOpcje, menuZapis, menuWczytaj;
	private JMenuItem mWyswietl, mDodaj, mZapXML, mZapBaz, mWczXML, mWczBaz, mKasuj, mOProgramie,mOpcje,mWyjscie;
	private JPanel panel;
	public static void main(String[] args) {
		
					Window frame = new Window();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		actionControle = new ActionControle();
		setTitle("Organizator");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		menuKalendarz = new JMenu("Kalendarz");
		
		mWyswietl = new JMenuItem("Wyswietl", 'W');
		mWyswietl.addActionListener(actionControle);
		mWyswietl.setAccelerator(KeyStroke.getKeyStroke("ctrl W"));
		mDodaj  = new JMenuItem("Dodaj Zdarzenie", 'D');
		mDodaj.addActionListener(actionControle);
		mDodaj.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));

		menuObsluga = new JMenu("Obs³uga");
		menuZapis  = new JMenu("Zapisz");
		
		mZapXML  = new JMenuItem("Zapisz do XML", 'X');
		mZapXML.addActionListener(actionControle);
		mZapXML.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		mZapBaz = new JMenuItem("Zapisz do bazy danych",'B');
		mZapBaz.addActionListener(actionControle);
		mZapBaz.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
		
		menuWczytaj  = new JMenu("Wczytaj");
		
		mWczXML  = new JMenuItem("Wczytaj z  XML",'X');
		mWczXML.addActionListener(actionControle);
		mWczXML.setAccelerator(KeyStroke.getKeyStroke("alt X"));
		mWczBaz = new JMenuItem("Wczytaj z bazy danych",'B');
		mWczBaz.addActionListener(actionControle);
		mWczBaz.setAccelerator(KeyStroke.getKeyStroke("alt B"));
		
		mKasuj = new JMenuItem("Kasuj",'K');
		mKasuj.addActionListener(actionControle);
		mKasuj.setAccelerator(KeyStroke.getKeyStroke("ctrl K"));
		
		menuOpcje = new JMenu("Opcje");
		
		mOProgramie = new JMenuItem("O programie",'O');
		mOProgramie.addActionListener(actionControle);
		mOProgramie.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		mOpcje  = new JMenuItem("Opcje",'P');
		mOpcje.addActionListener(actionControle);
		mOpcje.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		mWyjscie = new JMenuItem("Wyjscie", 'W');
		mWyjscie.addActionListener(actionControle);
		mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl F4"));
		
		
		setJMenuBar(menuBar);
		menuBar.add(menuKalendarz);
		
		menuKalendarz.add(mWyswietl);
		menuKalendarz.addSeparator();
		menuKalendarz.add(mDodaj);
		
		menuBar.add(menuObsluga);
		menuObsluga.add(menuZapis);

		menuZapis.add(mZapXML);
		menuZapis.add(mZapBaz);
		
		menuObsluga.add(menuWczytaj);

		menuWczytaj.add(mWczXML);
		menuWczytaj.add(mWczBaz);
		
		menuObsluga.addSeparator();
		menuObsluga.add(mKasuj);
		
		menuBar.add(menuOpcje);
		menuOpcje.add(mOProgramie);
		menuOpcje.add(mOpcje);
		menuOpcje.addSeparator();
		menuOpcje.add(mWyjscie);
		
	}
	class ActionControle implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object z = e.getSource();
			if(z == mWyswietl)
			{
				
			}
			if(z == mDodaj)
			{
				
			}
			if(z == mOProgramie)
			{
				JOptionPane.showMessageDialog(null, "Organizator  z mo¿liwoscia zapisu do XML i bazy danych 'n Wersija 1.0","O programie",JOptionPane.INFORMATION_MESSAGE);
			}
			if(z == mWyjscie)
			{
				int odp =JOptionPane.showConfirmDialog(null, "Czy napewno wyjœæ?","Wyjscie",JOptionPane.YES_NO_OPTION);
				if(odp == JOptionPane.YES_OPTION)
				{
					dispose();
				}
				else if(odp == JOptionPane.NO_OPTION)
				{
					JOptionPane.showMessageDialog(null,"Zamykanie przewane");
				}
			}
			
		}
		
	}

}
