package Kalendarz;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.toedter.calendar.JDateChooser;

import dane.ListaZdarzen;
import dane.Zdarzenie;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
/**
 * Klasa odpowiedzialna za wyświetlanie okienka Dodaj pozwalające na
 * dodanie nowego Zdarzenia do listy i podanie wszystkich paramatrów go opisujące.
 * @see Zdarzenie
 * @see ListaZdarzen
 *
 */
public class Dodaj extends JPanel {
	private ListaZdarzen  lista;
	private int sizex = 500;
	private JTextField txtWybierzDate;
	private JTextField txtPodajMiejsce;
	private JTextField textField;
	private JTextField txtDodajNoweZdarzenie;
	private JSpinner spinner;
	private JTextField txtPodajGodzine;
	private JTextField txtPodajOpis;
	private JTextField txtAlarmy;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextArea textArea;
	private Date date;
	private JButton btnNewButton;
	private JDateChooser dateChooser;
	private JTextField txtPodajNazwe;
	private JTextField textField_1;
	/**
	 * Konstruktor klasy Dodaj inicjalizująca początkowy rozmiar i
	 * położenie elementów interfejsu
	 * @param list Klasa ListaZdarzen
	 * @see ListaZdarzen
	 * @see Dodaj
	 */
	public Dodaj(ListaZdarzen list) 
	{
		lista = list;
		setSize(sizex,sizex);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60, 0};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 0, 30, 30, 30, 30, 30, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtDodajNoweZdarzenie = new JTextField();
		txtDodajNoweZdarzenie.setEditable(false);
		txtDodajNoweZdarzenie.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		txtDodajNoweZdarzenie.setText("Dodaj nowe zdarzenie");
		GridBagConstraints gbc_txtDodajNoweZdarzenie = new GridBagConstraints();
		gbc_txtDodajNoweZdarzenie.gridheight = 2;
		gbc_txtDodajNoweZdarzenie.gridwidth = 4;
		gbc_txtDodajNoweZdarzenie.insets = new Insets(0, 0, 5, 5);
		gbc_txtDodajNoweZdarzenie.fill = GridBagConstraints.BOTH;
		gbc_txtDodajNoweZdarzenie.gridx = 2;
		gbc_txtDodajNoweZdarzenie.gridy = 1;
		add(txtDodajNoweZdarzenie, gbc_txtDodajNoweZdarzenie);
		txtDodajNoweZdarzenie.setColumns(10);
		
		txtPodajNazwe = new JTextField();
		txtPodajNazwe.setText("Podaj nazwe");
		txtPodajNazwe.setEditable(false);
		GridBagConstraints gbc_txtPodajNazwe = new GridBagConstraints();
		gbc_txtPodajNazwe.gridwidth = 2;
		gbc_txtPodajNazwe.insets = new Insets(0, 0, 5, 5);
		gbc_txtPodajNazwe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPodajNazwe.gridx = 1;
		gbc_txtPodajNazwe.gridy = 3;
		add(txtPodajNazwe, gbc_txtPodajNazwe);
		txtPodajNazwe.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		txtWybierzDate = new JTextField();
		txtWybierzDate.setText("Wybierz date");
		txtWybierzDate.setEditable(false);
		GridBagConstraints gbc_txtWybierzDate = new GridBagConstraints();
		gbc_txtWybierzDate.gridwidth = 2;
		gbc_txtWybierzDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtWybierzDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWybierzDate.gridx = 1;
		gbc_txtWybierzDate.gridy = 4;
		add(txtWybierzDate, gbc_txtWybierzDate);
		txtWybierzDate.setColumns(10);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 4;
		add(dateChooser, gbc_dateChooser);
		dateChooser.setDate(new Date());
		
		txtAlarmy = new JTextField();
		txtAlarmy.setEditable(false);
		txtAlarmy.setText("Alarmy:");
		GridBagConstraints gbc_txtAlarmy = new GridBagConstraints();
		gbc_txtAlarmy.gridwidth = 2;
		gbc_txtAlarmy.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlarmy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlarmy.gridx = 5;
		gbc_txtAlarmy.gridy = 3;
		add(txtAlarmy, gbc_txtAlarmy);
		txtAlarmy.setColumns(10);
		
		txtPodajMiejsce = new JTextField();
		txtPodajMiejsce.setEditable(false);
		txtPodajMiejsce.setText("Podaj miejsce");
		GridBagConstraints gbc_txtPodajMiejsce = new GridBagConstraints();
		gbc_txtPodajMiejsce.gridwidth = 2;
		gbc_txtPodajMiejsce.insets = new Insets(0, 0, 5, 5);
		gbc_txtPodajMiejsce.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPodajMiejsce.gridx = 1;
		gbc_txtPodajMiejsce.gridy = 5;
		add(txtPodajMiejsce, gbc_txtPodajMiejsce);
		txtPodajMiejsce.setColumns(10);
		
		textField = new JTextField();
		GridBagConstraints miejsce = new GridBagConstraints();
		miejsce.gridwidth = 2;
		miejsce.insets = new Insets(0, 0, 5, 5);
		miejsce.fill = GridBagConstraints.HORIZONTAL;
		miejsce.gridx = 3;
		miejsce.gridy = 5;
		add(textField, miejsce);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("1:");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		comboBox.addItem("brak");
		comboBox.addItem("15 minut");
		comboBox.addItem("30 minut");
		comboBox.addItem("45 minut");
		comboBox.addItem("1 godzina");
		
		
		txtPodajGodzine = new JTextField();
		txtPodajGodzine.setEditable(false);
		txtPodajGodzine.setText("Podaj godzine");
		GridBagConstraints gbc_txtPodajGodzine = new GridBagConstraints();
		gbc_txtPodajGodzine.gridwidth = 2;
		gbc_txtPodajGodzine.insets = new Insets(0, 0, 5, 5);
		gbc_txtPodajGodzine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPodajGodzine.gridx = 1;
		gbc_txtPodajGodzine.gridy = 6;
		add(txtPodajGodzine, gbc_txtPodajGodzine);
		txtPodajGodzine.setColumns(10);
		date = dateChooser.getDate();
		SpinnerDateModel sm =new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spinner = new JSpinner(sm);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.gridwidth = 2;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 3;
		gbc_spinner.gridy = 6;
		add(spinner, gbc_spinner);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(de);
		spinner.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				spinner.setValue(dateChooser.getDate());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("2:");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 5;
		gbc_textField_3.gridy = 5;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 6;
		gbc_comboBox_1.gridy = 5;
		add(comboBox_1, gbc_comboBox_1);
		comboBox_1.addItem("brak");
		comboBox_1.addItem("15 minut");
		comboBox_1.addItem("30 minut");
		comboBox_1.addItem("45 minut");
		comboBox_1.addItem("1 godzina");
		
		txtPodajOpis = new JTextField();
		txtPodajOpis.setEditable(false);
		txtPodajOpis.setText("Podaj opis");
		GridBagConstraints gbc_txtPodajOpis = new GridBagConstraints();
		gbc_txtPodajOpis.gridwidth = 2;
		gbc_txtPodajOpis.insets = new Insets(0, 0, 5, 5);
		gbc_txtPodajOpis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPodajOpis.gridx = 1;
		gbc_txtPodajOpis.gridy = 7;
		add(txtPodajOpis, gbc_txtPodajOpis);
		txtPodajOpis.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		GridBagConstraints opis = new GridBagConstraints();
		opis.gridwidth = 2;
		opis.gridheight = 2;
		opis.insets = new Insets(0, 0, 5, 5);
		opis.fill = GridBagConstraints.BOTH;
		opis.gridx = 3;
		opis.gridy = 7;
		add(textArea, opis);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("3:");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 6;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 6;
		add(comboBox_2, gbc_comboBox_2);
		comboBox_2.addItem("brak");
		comboBox_2.addItem("15 minut");
		comboBox_2.addItem("30 minut");
		comboBox_2.addItem("45 minut");
		comboBox_2.addItem("1 godzina");
		
		btnNewButton = new JButton("Dodaj zdarzenie");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnNewButton){
					Date zapis = dateChooser.getDate();
					Date hour = (Date) spinner.getValue();
					zapis.setHours(hour.getHours());
					zapis.setMinutes(hour.getMinutes());
					zapis.setSeconds(hour.getSeconds());
					Zdarzenie zdarzenie = new Zdarzenie();
					zdarzenie.setNazwa(textField_1.getText());
					zdarzenie.setMiejsce(textField.getText());
					zdarzenie.setOpis(textArea.getText());
					zdarzenie.setData( zapis);
					DodajAlarm(zdarzenie,comboBox.getSelectedItem().toString());
					DodajAlarm(zdarzenie,comboBox_1.getSelectedItem().toString());
					DodajAlarm(zdarzenie,comboBox_2.getSelectedItem().toString());
					System.out.println(zapis);
					lista.add(zdarzenie);
				}
			}
			
		});

	}

	public int getSizex() {
		return sizex;
	}
	public void setSizex(int sizex) {
		this.sizex = sizex;
	}
	/**
	 * Funkcja odpowiedzialna za dodawanie alarmów do zdarzenia poprzez interfejs
	 * okienka Modyfikuj
	 * @param e Zdarzenie, do którego są dodawane alarmy
	 * @param o zmienna przechowująca wartość wybraną przez użytkownika
	 * @see Zdarzenie
	 * @see Alarm
	 */
	private void DodajAlarm(Zdarzenie e, String o)
	{
		if("15 minut"==o)
		{
			e.addAlarm(15);
		}
		if("30 minut"==o)
		{
			e.addAlarm(30);
		}
		if("45 minut"==o)
		{
			e.addAlarm(45);
		}
		if("1 godzina"==o)
		{
			e.addAlarm(60);
		}
		
	}

}
