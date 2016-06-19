package Kalendarz;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JToggleButton;

import FirstWindow.ModyfikujOnko;

import dane.ListaZdarzen;
import dane.Zdarzenie;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasa odpowiedzialna za wyœwietlanie okna z list¹ wszystkich
 * zdarzeñ zainicjowanych przez u¿ytkownika. Po klikniêciu na dowolne zdarzenie prawym przyciskiem u¿ytkownik ma mo¿liwoœæ
 * modyfikacji wybranego zdarzenia.
 * Otwiera siê wtedy okienko Modyfikuj w którym siê wprowadza zmiany.
 * @see Modyfikuj
 * 
 *
 */
public class WszystkieZdarzenia extends JPanel {
	private ButtonGroup domSortowanie;
	private JCheckBox data,miejsce,nazwa;
	private ListaZdarzen lista;
	private JList<Zdarzenie> jlist;
	private JScrollPane scrol;
	private JPopupMenu popup;
	private JMenuItem modyfikuj;
	private int sizex= 350;
	
	public int getSizex() {
		return sizex;
	}

	public void setSizex(int sizex) {
		this.sizex = sizex;
	}
	/**
	 * Konstruktor klasy WszystkieZdarzenia inicjuj¹ca pocz¹tkowy rozmiar i rozmieszczenie
	 * elementów interfejsu. Nastêpnie wypisuje na liœcie wszystkie zdarzenia wprowadzone przez u¿ytkownika.
	 * 
	 * @param list Klasa ListaZdarzen
	 * @see ListaZdarzen
	 */
	public WszystkieZdarzenia(ListaZdarzen list) {
		setSize(485,350);
		lista = list;
		domSortowanie = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{71, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		nazwa = new JCheckBox("Nazwa", true);
		GridBagConstraints gbc_nazwa = new GridBagConstraints();
		gbc_nazwa.insets = new Insets(0, 0, 5, 5);
		gbc_nazwa.gridx = 1;
		gbc_nazwa.gridy = 1;
		add(nazwa, gbc_nazwa);
		nazwa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujNazwa();
				jlist.setModel(lista.ChoseAll());
			}
			
		});
		domSortowanie.add(nazwa);
		data = new JCheckBox("Data");
		data.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujData();
				jlist.setModel(lista.ChoseAll());
			}
			
		});
		GridBagConstraints gbc_data = new GridBagConstraints();
		gbc_data.insets = new Insets(0, 0, 5, 5);
		gbc_data.gridx = 2;
		gbc_data.gridy = 1;
		add(data, gbc_data);
		domSortowanie.add(data);
		
		miejsce = new JCheckBox("Miejsce");
		miejsce.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujMiejsce();
				jlist.setModel(lista.ChoseAll());
			}
			
		});
		domSortowanie.add(miejsce);
		GridBagConstraints gbc_miejsce = new GridBagConstraints();
		gbc_miejsce.insets = new Insets(0, 0, 5, 5);
		gbc_miejsce.gridx = 3;
		gbc_miejsce.gridy = 1;
		add(miejsce, gbc_miejsce);
		jlist = new JList<Zdarzenie>(lista.ChoseAll());
		scrol = new JScrollPane(jlist);
		GridBagConstraints gbc_scrol = new GridBagConstraints();
		gbc_scrol.fill = GridBagConstraints.BOTH;
		gbc_scrol.insets = new Insets(0, 0, 5, 5);
		gbc_scrol.gridy = 2;
		gbc_scrol.gridx = 1;
		gbc_scrol.gridwidth = 5;
		gbc_scrol.gridheight = 3;
		add(scrol, gbc_scrol);
		popup  = new JPopupMenu();
		modyfikuj = new JMenuItem("Modyfikuj");
		modyfikuj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ModyfikujOnko ok =new  ModyfikujOnko(jlist.getSelectedValue());
				ok.show();
			}
			
		});
		popup.add(modyfikuj);
		jlist.setComponentPopupMenu(popup);
		
			 
	}

}
