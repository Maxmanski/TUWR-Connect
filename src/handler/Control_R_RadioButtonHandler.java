package handler;

import gui.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Iorgreths
 * @version 1.0
 *
 */

public class Control_R_RadioButtonHandler implements ActionListener {

	private GUI gui;
	
	public Control_R_RadioButtonHandler(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		gui.adaptControlRight();

	}

}
