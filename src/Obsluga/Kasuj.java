package Obsluga;

import javax.swing.JPanel;

import dane.ListaZdarzen;
import java.awt.GridBagLayout;
import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Kasuj extends JPanel {
	private JTextField txtWybierzDateOd;
	private ListaZdarzen listazdarzen;
	private JButton btnKasuj;
	private JDateChooser dateChooser;
	private int x=300;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Create the panel.
	 * @param list 
	 */
	public Kasuj(ListaZdarzen list) {
		setSize(400,300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 55, 51, 54, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		listazdarzen = list;
		
		
		txtWybierzDateOd = new JTextField();
		txtWybierzDateOd.setText("Wybierz date od kt\u00F3rej chcesz skasowa\u0107");
		txtWybierzDateOd.setEditable(false);
		GridBagConstraints gbc_txtWybierzDateOd = new GridBagConstraints();
		gbc_txtWybierzDateOd.gridwidth = 7;
		gbc_txtWybierzDateOd.insets = new Insets(0, 0, 5, 0);
		gbc_txtWybierzDateOd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWybierzDateOd.gridx = 1;
		gbc_txtWybierzDateOd.gridy = 1;
		add(txtWybierzDateOd, gbc_txtWybierzDateOd);
		txtWybierzDateOd.setColumns(10);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 2;
		add(dateChooser, gbc_dateChooser);
		dateChooser.setDate(new Date());
		
		btnKasuj = new JButton("Kasuj");
		GridBagConstraints gbc_btnKasuj = new GridBagConstraints();
		gbc_btnKasuj.insets = new Insets(0, 0, 5, 5);
		gbc_btnKasuj.gridx = 2;
		gbc_btnKasuj.gridy = 3;
		add(btnKasuj, gbc_btnKasuj);
		btnKasuj.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == btnKasuj)
				{

					int odp =JOptionPane.showConfirmDialog(null, "ZCy napewno chcesz skasowaæ zdarzenia z przed tej daty?","Kasowanie",JOptionPane.YES_NO_OPTION);
					if(odp == JOptionPane.YES_OPTION)
					{
						listazdarzen.UsunZdarzenia(dateChooser.getDate());
					}
					else if(odp == JOptionPane.NO_OPTION)
					{
						JOptionPane.showMessageDialog(null,"Kasowanie anulowane");
					}
				}
			}
			
		});

	}

}
