package Obsluga;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import dane.ListaZdarzen;

import java.awt.GridBagConstraints;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Klasa odpowiedzialna za wyœwietlanie okienka umo¿liwiaj¹cego usuwanie zdarzeñ sprzed podanej daty.
 * U¿ytkownik wybiera datê i po naciœniêciu przycisku usuñ, z listy usuwane s¹ te zdarzenia,
 * które spe³niaj¹ warunek.
 *
 */
public class Kasuj extends JPanel {
	private JTextField txtUsuniZdarzeniaZ;
	private int sizex = 300;
	private JButton btnKasuj;
	private JDateChooser dateChooser;
	private ListaZdarzen lista;
	public int getSizex() {
		return sizex;
	}
	public void setSizex(int sizex) {
		this.sizex = sizex;
	}
	/**
	 * Konstruktor klasy Kasuj inicjalizuj¹ca pocz¹tkowy rozmiar i
	 * po³o¿enie elementów interfejsu.
	 * @param list Klasa ListaZdarzen przechowuj¹ca zdarzenia u¿ytkownika.
	 */
	public Kasuj(ListaZdarzen list) {
		setSize(sizex,sizex);
		lista = list;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtUsuniZdarzeniaZ = new JTextField();
		txtUsuniZdarzeniaZ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuniZdarzeniaZ.setText("Usuni zdarzenia z przed:");
		txtUsuniZdarzeniaZ.setEditable(false);
		txtUsuniZdarzeniaZ.setHorizontalAlignment(JTextField.CENTER);
		GridBagConstraints gbc_txtUsuniZdarzeniaZ = new GridBagConstraints();
		gbc_txtUsuniZdarzeniaZ.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuniZdarzeniaZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuniZdarzeniaZ.gridwidth = 12;
		gbc_txtUsuniZdarzeniaZ.gridx = 0;
		gbc_txtUsuniZdarzeniaZ.gridy = 0;
		add(txtUsuniZdarzeniaZ, gbc_txtUsuniZdarzeniaZ);
		txtUsuniZdarzeniaZ.setColumns(10);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 5;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 1;
		add(dateChooser, gbc_dateChooser);
		
		btnKasuj = new JButton("Kasuj");
		GridBagConstraints gbc_btnKasuj = new GridBagConstraints();
		gbc_btnKasuj.gridwidth = 5;
		gbc_btnKasuj.insets = new Insets(0, 0, 5, 5);
		gbc_btnKasuj.gridx = 3;
		gbc_btnKasuj.gridy = 2;
		add(btnKasuj, gbc_btnKasuj);
		btnKasuj.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int odp =JOptionPane.showConfirmDialog(null, "Czy napewno chcesz skasowaæ dane?","Kasowanie",JOptionPane.YES_NO_OPTION);
				if(odp == JOptionPane.YES_OPTION)
				{
					lista.UsunZdarzenia(dateChooser.getDate());
				}
				else if(odp == JOptionPane.NO_OPTION)
				{
					JOptionPane.showMessageDialog(null,"Anulowano kasowanie");
				}
				
			}
			
		});
		
	}

}
