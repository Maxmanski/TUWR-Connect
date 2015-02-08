package command;

import java.util.ArrayList;
import java.util.List;

import peak.can.basic.PeakCanHandler;

/**
 * The Torque mode.
 * It will validate commands-to-be-sent against compliance with the torque mode
 * (valid ID and valid parameters) before sending them over CAN.
 * 
 * @author Maxmanski
 * @version 1.0
 *
 */
public class TorqueMode implements Mode {

	private PeakCanHandler canHandler;
	private List<Integer> validIDs;

	public TorqueMode(PeakCanHandler canHandler){
		this.canHandler = canHandler;
		this.validIDs = new ArrayList<Integer>();
	}

	@Override
	public boolean sendData(byte id, byte[] data) {

		boolean isValidID = false, isValidMsg = false;

		isValidID = this.isValidId(id);
		isValidMsg = this.isValidMessage(data);

		if((isValidID == false) || (isValidMsg == false)){
			return false;
		}else{
			return this.canHandler.write((byte)id, (byte)data.length, (byte)0, data);
		}
	}

	@Override
	public void setCanHandler(PeakCanHandler canHandler) {
		this.canHandler = canHandler;
	}

	@Override
	public boolean isValidId(int id) {
		return this.validIDs.contains(id);
	}

	@Override
	public boolean isValidMessage(byte[] msg) {
		boolean valid = true;
		valid = msg.length == 8;
		// the mode bits for both MODL & MODR must be 0!
		valid = valid && ((msg[1] & 0x4) == 0);
		valid = valid && ((msg[1] & 0x2) == 0);
		return valid;
	}

}
