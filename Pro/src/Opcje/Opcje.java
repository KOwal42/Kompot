package Opcje;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import dane.Opcjie;
import dane.ZapisOpcji;


public class Opcje extends JPanel {
	private Opcjie op;
	private ZapisOpcji zapisOpcji;
	private ButtonGroup domSerializacjia;
	private JRadioButton brak,baza,xml;
	private JTextField txtWybierzDomyslnePobieranie;
	private int  sizex = 500;
	public Opcje() {
		zapisOpcji = new ZapisOpcji();
		op = new Opcjie(zapisOpcji.Deserialize());
		setSize(sizex,sizex);
		domSerializacjia = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{64, 218, 83, 95, 0};
		gridBagLayout.rowHeights = new int[]{0, 23, 23, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtWybierzDomyslnePobieranie = new JTextField();
		txtWybierzDomyslnePobieranie.setEditable(false);
		txtWybierzDomyslnePobieranie.setText("Wybierz domyslne pobieranie danych");
		GridBagConstraints gbc_txtWybierzDomyslnePobieranie = new GridBagConstraints();
		gbc_txtWybierzDomyslnePobieranie.insets = new Insets(0, 0, 5, 5);
		gbc_txtWybierzDomyslnePobieranie.fill = GridBagConstraints.BOTH;
		gbc_txtWybierzDomyslnePobieranie.gridx = 1;
		gbc_txtWybierzDomyslnePobieranie.gridy = 1;
		add(txtWybierzDomyslnePobieranie, gbc_txtWybierzDomyslnePobieranie);
		txtWybierzDomyslnePobieranie.setColumns(10);
		brak = new JRadioButton("Brak automatycznego ponierania danych");
		domSerializacjia.add(brak);
		brak.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				op.setWybur(0);
				zapisOpcji.Serialize(op);
			}
			
		});
		GridBagConstraints gbc_brak = new GridBagConstraints();
		gbc_brak.anchor = GridBagConstraints.NORTHWEST;
		gbc_brak.insets = new Insets(0, 0, 5, 5);
		gbc_brak.gridwidth = 2;
		gbc_brak.gridx = 1;
		gbc_brak.gridy = 2;
		add(brak, gbc_brak);
		baza = new JRadioButton("Pobieraj z bazy danych");
		baza.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				op.setWybur(1);
				zapisOpcji.Serialize(op);
			}
			
		});
		domSerializacjia.add(baza);
		GridBagConstraints gbc_baza = new GridBagConstraints();
		gbc_baza.anchor = GridBagConstraints.NORTHWEST;
		gbc_baza.insets = new Insets(0, 0, 5, 5);
		gbc_baza.gridwidth = 2;
		gbc_baza.gridx = 1;
		gbc_baza.gridy = 3;
		add(baza, gbc_baza);
		xml = new JRadioButton("Pobieraj z XML");
		domSerializacjia.add(xml);
		xml.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				op.setWybur(2);
				zapisOpcji.Serialize(op);
			}
			
		});
		GridBagConstraints gbc_xml = new GridBagConstraints();
		gbc_xml.insets = new Insets(0, 0, 5, 5);
		gbc_xml.anchor = GridBagConstraints.NORTHWEST;
		gbc_xml.gridx = 1;
		gbc_xml.gridy = 4;
		add(xml, gbc_xml);
		int data= op.getWybur();
		if(data == 0)
		{
			brak.setSelected(true);
		}
		if(data == 1)
		{
			baza.setSelected(true);
		}
		if(data == 2)
		{
			xml.setSelected(true);
		}
		
	}
	public int getSizeX() {
		return sizex;
	}
	public void setSizeX(int size) {
		this.sizex = size;
	}

}
