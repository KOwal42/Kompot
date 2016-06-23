package Kalendarz;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import FirstWindow.ModyfikujOnko;

import dane.ListaZdarzen;
import dane.Zdarzenie;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
/**
 * Klasa odpowiedzialna za wyœwietlanie okna z list¹ wszystkich
 * zdarzeñ zainicjowanych przez u¿ytkownika.
 * Okienko pozwala równie¿ na posortowanie listy wed³ug nazwy, daty i miejsca.
 * Po klikniêciu na dowolne zdarzenie prawym przyciskiem u¿ytkownik ma mo¿liwoœæ
 * modyfikacji wybranego zdarzenia.
 * Otwiera siê wtedy okienko Modyfikuj w którym siê wprowadza zmiany.
 * @see Modyfikuj
 * 
 *
 */
public class WszystkieZdarzenia extends JPanel {
	private ButtonGroup domSortowanie;
	private ListaZdarzen lista;
	private JTable jlist;
	private JScrollPane scrol;
	private JPopupMenu popup;
	private JMenuItem modyfikuj;
	private int sizex= 500;
	private Vector dane, colum;
	
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
	 * @see WszystkieZdarzenia
	 * @see ListaZdarzen
	 */
	public WszystkieZdarzenia(ListaZdarzen list) {
		dane = new Vector();
		colum =new Vector();
		colum.add("Nazwa");
		colum.add("Miejsce");
		colum.add("Data");
		setSize(sizex,sizex);
		lista = list;
		domSortowanie = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{71, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		lista = list;
		dane = list.ChoseAll();
		TableModel model = new DefaultTableModel(dane,colum);
		TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(model);
		popup  = new JPopupMenu();
		modyfikuj = new JMenuItem("Modyfikuj");
		modyfikuj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean select=false;
				for(int z = 0; z<jlist.getRowCount();z++)
				{
					if(jlist.isRowSelected(z)== true)
					{
						select=true;
					}
				}
				if(select==true)
				{
					ModyfikujOnko ok =new  ModyfikujOnko(lista.find((String)jlist.getValueAt(jlist.getSelectedRow(), 0),(String)jlist.getValueAt(jlist.getSelectedRow(), 1),(String)jlist.getValueAt(jlist.getSelectedRow(), 2)));
					ok.show();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Brak wybranego zdarzenia");
				}
			}
			
		});
		popup.add(modyfikuj);
		jlist = new JTable(model);
		jlist.setRowSorter(sort);
		scrol = new JScrollPane(jlist);
		GridBagConstraints gbc_scrol = new GridBagConstraints();
		gbc_scrol.fill = GridBagConstraints.BOTH;
		gbc_scrol.insets = new Insets(0, 0, 5, 5);
		gbc_scrol.gridy = 1;
		gbc_scrol.gridx = 0;
		gbc_scrol.gridwidth = 7;
		gbc_scrol.gridheight = 5;
		add(scrol, gbc_scrol);
		jlist.setComponentPopupMenu(popup);
		
			 
	}

}
