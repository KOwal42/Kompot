package FirstWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kalendarz.Modyfikuj;

import dane.Zdarzenie;

public class ModyfikujOnko extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ModyfikujOnko(Zdarzenie e) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane =new Modyfikuj(e);
		setContentPane(contentPane);
	}

}
