package Kalendarz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import FirstWindow.ModyfikujOnko;

import com.toedter.calendar.JCalendar;

import dane.ListaZdarzen;
import dane.Opcjie;
import dane.ZapisOpcji;
import dane.Zdarzenie;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Wyswietl extends JPanel {
	private Opcjie op;
	private ZapisOpcji zap;
	private ListaZdarzen lista;
	private ButtonGroup domSortowanie;
	private JCheckBox data,miejsce,nazwa;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JCalendar calendar;
	private int  sizex = 600;
	private int  sizey = 700;
	private JTable jlist;
	private JScrollPane scrol;
	private JPopupMenu popup;
	private JMenuItem modyfikuj;
	private Vector dane, colum;

	public int getSizey() {
		return sizey;
	}
	public Wyswietl(ListaZdarzen list) {
		dane = new Vector();
		colum =new Vector();
		colum.add("Nazwa");
		colum.add("Miejsce");
		colum.add("Data");
		lista = list;
		GridBagLayout gridBagLayout = new GridBagLayout();
		domSortowanie = new ButtonGroup();
		setSize(sizex,sizey);
		gridBagLayout.columnWidths = new int[] {100, 30, 100, 30, 30, 30, 30, 30, 0, 30, 29, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 100, 100, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnNewButton = new JButton("Wyswietl wybrane");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		
		calendar = new JCalendar();
		calendar.setTodayButtonVisible(true);
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridheight = 4;
		gbc_calendar.gridwidth = 8;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 0;
		gbc_calendar.gridy = 3;
		add(calendar, gbc_calendar);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()== btnNewButton)
				{
					if(lista.NotZero()== true)
					{
						dane=lista.ChoseDate(calendar.getDate());
						DefaultTableModel model = (DefaultTableModel) jlist.getModel();
						for(int  z=0 ;z <dane.size();z++)
						{
							model.addRow(new Object[]{((Vector) dane.get(z)).get(0),((Vector) dane.get(z)).get(1),((Vector) dane.get(z)).get(2),});
						}				
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Brak zdarzeni");
					}
				}
			}
		});
		TableModel model = new DefaultTableModel(dane,colum);
		TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(model);
		jlist = new JTable(model);
		jlist.setRowSorter(sort);
		scrol = new JScrollPane(jlist);
		GridBagConstraints gbc_scrol = new GridBagConstraints();
		gbc_scrol.insets = new Insets(0, 0, 5, 0);
		gbc_scrol.fill = GridBagConstraints.BOTH;
		gbc_scrol.gridy = 3;
		gbc_scrol.gridx = 8;
		gbc_scrol.gridwidth = 6;
		gbc_scrol.gridheight = 4;
		add(scrol, gbc_scrol);
		popup  = new JPopupMenu();
		modyfikuj = new JMenuItem("Modyfikuj");
		modyfikuj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
		jlist.setComponentPopupMenu(popup);
	}	
	public int getSizex() {
		return sizex;
	}
	public void setSizex(int sizex) {
		this.sizex = sizex;
	}

}
