package Kalendarz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Insets;

public class Wyswietl extends JPanel {
	private JTextField txtKalendarz;

	/**
	 * Create the panel.
	 */
	public Wyswietl() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtKalendarz = new JTextField();
		txtKalendarz.setText("Kalendarz");
		txtKalendarz.setEditable(false);
		GridBagConstraints gbc_txtKalendarz = new GridBagConstraints();
		gbc_txtKalendarz.insets = new Insets(0, 0, 5, 5);
		gbc_txtKalendarz.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKalendarz.gridx = 5;
		gbc_txtKalendarz.gridy = 3;
		add(txtKalendarz, gbc_txtKalendarz);
		txtKalendarz.setColumns(10);

	}

}
