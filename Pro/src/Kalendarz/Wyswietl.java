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

import javax.swing.JList;

public class Wyswietl extends JPanel {
	private Opcjie op;
	private ZapisOpcji zap;
	private ListaZdarzen lista;
	private ButtonGroup domSortowanie;
	private JCheckBox data,miejsce,nazwa;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JCalendar calendar;
	private int  sizex = 460;
	private int  sizey = 700;
	private JList<Zdarzenie> jlist;
	private JScrollPane scrol;
	private JPopupMenu popup;
	private JMenuItem modyfikuj;
	public int getSizey() {
		return sizey;
	}
	public Wyswietl(ListaZdarzen list) {
		lista = list;
		GridBagLayout gridBagLayout = new GridBagLayout();
		domSortowanie = new ButtonGroup();
		setSize(sizex,sizey);
		gridBagLayout.columnWidths = new int[] {100, 30, 100, 30, 30, 30, 30, 30, 0, 30, 29, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 100, 100, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		nazwa = new JCheckBox("Nazwa", true);
		nazwa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujNazwa();
			}
			
		});
		
		btnNewButton_1 = new JButton("Sortuj");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == btnNewButton_1)
				{
					jlist.setModel(lista.ChoseDate(calendar.getDate()));
				}
			}
			
		});
		domSortowanie.add(nazwa);
		GridBagConstraints gbc_nazwa = new GridBagConstraints();
		gbc_nazwa.insets = new Insets(0, 0, 5, 5);
		gbc_nazwa.gridx = 10;
		gbc_nazwa.gridy = 2;
		add(nazwa, gbc_nazwa);
		miejsce = new JCheckBox("Miejsce");
		miejsce.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujMiejsce();
			}
			
		});
		domSortowanie.add(miejsce);
		GridBagConstraints gbc_miejsce = new GridBagConstraints();
		gbc_miejsce.insets = new Insets(0, 0, 5, 5);
		gbc_miejsce.gridx = 11;
		gbc_miejsce.gridy = 2;
		add(miejsce, gbc_miejsce);
		data = new JCheckBox("Data");
		data.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lista.sortujData();
			}
			
		});
		GridBagConstraints gbc_data = new GridBagConstraints();
		gbc_data.insets = new Insets(0, 0, 5, 5);
		gbc_data.gridx = 12;
		gbc_data.gridy = 2;
		add(data, gbc_data);
		domSortowanie.add(data);
		
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
						jlist.setModel(lista.ChoseDate(calendar.getDate()));
						System.out.println(lista.ChoseDate(calendar.getDate()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Brak zdarzeni");
					}
				}
			}
		});
		
		jlist = new JList<Zdarzenie>();
		jlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrol = new JScrollPane(jlist);
		GridBagConstraints gbc_scrol = new GridBagConstraints();
		gbc_scrol.fill = GridBagConstraints.BOTH;
		gbc_scrol.gridy = 3;
		gbc_scrol.gridx = 8;
		gbc_scrol.gridwidth = 5;
		gbc_scrol.gridheight = 4;
		add(scrol, gbc_scrol);
		popup  = new JPopupMenu();
		modyfikuj = new JMenuItem("Modyfikuj");
		modyfikuj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ModyfikujOnko ok =new  ModyfikujOnko(jlist.getSelectedValue());
				ok.show();
			}
			
		});
		popup.add(modyfikuj);
	}	
	public int getSizex() {
		return sizex;
	}
	public void setSizex(int sizex) {
		this.sizex = sizex;
	}

}
