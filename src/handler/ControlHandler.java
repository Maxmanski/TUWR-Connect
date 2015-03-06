package handler;

import etc.FixPoint;
import gui.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import command.CommandProxy;

/**
 * Version History: </b>
 * V1.1: Changed the handler to serve the purpose of sending control information
 *    ID50 -> left motor
 *    ID60 -> right motor
 * by pressing enter.
 * 
 * 
 * @author Iorgreths
 * @version 1.1
 *
 */

public class ControlHandler implements ActionListener {
	
	private GUI gui;
	
	public ControlHandler(GUI gui){
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("HANDLE");
		
		/* Send information about left motor */
		if(gui.leftStarted()){
			
			ControlInformation info = gui.leftInformation();
			HashMap<String,FixPoint> params = new HashMap<String,FixPoint>();
			
			if(info.controlWithTorque()){
				
				params.put("modl", new FixPoint("0"));
				params.put("fixpoint", new FixPoint("6"));
				
			}else{
				
				params.put("modl", new FixPoint("1"));
				params.put("fixpoint", new FixPoint("1"));
				
			}
			
			params.put("left", new FixPoint(String.valueOf(info.value())));
			CommandProxy.getInstance().sendCommand("control", params);
			
		}
		
		/* Send information about right motor */
		if(gui.rightStarted()){
			
			ControlInformation info = gui.rightInformation();
			HashMap<String,FixPoint> params = new HashMap<String,FixPoint>();
			
			if(info.controlWithTorque()){
				
				params.put("modr", new FixPoint("0"));
				params.put("fixpoint", new FixPoint("6"));
				
			}else{
				
				params.put("modr", new FixPoint("1"));
				params.put("fixpoint", new FixPoint("1"));
				
			}
			
			params.put("right", new FixPoint(String.valueOf(info.value())));
			CommandProxy.getInstance().sendCommand("control_r", params);
			
		}
		
		//@deprecated
		/*if(gui.leftStarted()){
			
			ControlInformation info = gui.leftInformation();
			ControlInformation info2 = gui.rightInformation();
			
			HashMap<String,FixPoint> params = new HashMap<String,FixPoint>();
			
			if(info.controlWithTorque()){
				
				params.put("modl", new FixPoint("0"));
				params.put("fixpoint", new FixPoint("6"));
				
			}else{
				
				params.put("modl", new FixPoint("1"));
				params.put("fixpoint", new FixPoint("1"));
				
			}
			
			params.put("left", new FixPoint(String.valueOf(info.value())));
			
			if(info2.controlWithTorque()){
				
				params.put("modr", new FixPoint("0"));
				params.put("fixpoint", new FixPoint("6"));
				
			}else{
				
				params.put("modr", new FixPoint("1"));
				params.put("fixpoint", new FixPoint("1"));
				
			}
			
			params.put("right", new FixPoint(String.valueOf(info2.value())));
			
			CommandProxy.getInstance().sendCommand("control", params);
			
		}*/

	}

}
