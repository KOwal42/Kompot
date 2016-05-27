package Kalendarz;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Dodaj extends JPanel {
	private JTextField txtDodajzdarzenie;

	/**
	 * Create the panel.
	 */
	public Dodaj() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{182, 86, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setSize(800,800);
		
		final JButton contentb1 = new JButton("New button");
		GridBagConstraints gbc_contentb1 = new GridBagConstraints();
		gbc_contentb1.insets = new Insets(0, 0, 0, 5);
		gbc_contentb1.gridx = 0;
		gbc_contentb1.gridy = 2;
		add(contentb1, gbc_contentb1);
		contentb1.setMnemonic(KeyEvent.VK_D);
		contentb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource()== contentb1)
				{
					txtDodajzdarzenie.setText("dodaj");
				}
			}
		});
		txtDodajzdarzenie = new JTextField();
		txtDodajzdarzenie.setText("DodajZdarzenie");
		txtDodajzdarzenie.setEditable(false);
		GridBagConstraints gbc_txtDodajzdarzenie = new GridBagConstraints();
		gbc_txtDodajzdarzenie.insets = new Insets(0, 0, 0, 5);
		gbc_txtDodajzdarzenie.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDodajzdarzenie.gridx = 1;
		gbc_txtDodajzdarzenie.gridy = 2;
		add(txtDodajzdarzenie, gbc_txtDodajzdarzenie);
		txtDodajzdarzenie.setColumns(10);
		
		final JButton coontentB = new JButton("Content");
		GridBagConstraints gbc_coontentB = new GridBagConstraints();
		gbc_coontentB.gridx = 3;
		gbc_coontentB.gridy = 2;
		add(coontentB, gbc_coontentB);
		coontentB.setMnemonic(KeyEvent.VK_D);
		coontentB.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource()== coontentB)
				{
					txtDodajzdarzenie.setText("Wart");
				}
			}
		});

	}

}
