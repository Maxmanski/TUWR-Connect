package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import peak.can.basic.PeakCanHandler;
import peak.can.basic.TPCANBaudrate;
import peak.can.basic.TPCANHandle;
import command.Command;
import command.CommandCenter;
import command.CommandHandler;
import command.CommandToCAN;
import data.DataCenter;
import etc.BinaryToString;
import etc.FixPoint;
import etc.XMLParser;

public class TestMain {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException{

		boolean quit = true;

		PeakCanHandler pcHendl = new PeakCanHandler(TPCANHandle.PCAN_USBBUS1, TPCANBaudrate.PCAN_BAUD_100K);
		CommandCenter cc = new CommandCenter(pcHendl);
		
		try{
			CommandHandler handler = new CommandHandler();
			XMLParser xml = new XMLParser(handler);
			xml.parse("command.xml");
			List<Command> res = handler.getResult();
			for(Command c: res){
				System.out.println(c);
			}
			Command c = res.get(0);
			c.replaceParameter("r2d", new FixPoint("0.0"));
			c.replaceParameter("modl", new FixPoint("1.0"));
			c.replaceParameter("modr", new FixPoint("1.0"));
			c.replaceParameter("left", new FixPoint("100.65"));
			System.out.println(c.getParameter("modl"));
			System.out.println(c.getParameter("modr"));
			System.out.println(c.getParameter("right"));
			byte[] data = CommandToCAN.getData(c);
			System.out.println(c);

			System.out.println("r2d: " + BinaryToString.bytesToString(c.getParameter("r2d").getValue().getFormatted(-1, 1)));
			System.out.println("modl: " + BinaryToString.bytesToString(c.getParameter("modl").getValue().getFormatted(-1, 1)));
			System.out.println("modr: " + BinaryToString.bytesToString(c.getParameter("modr").getValue().getFormatted(-1, 1)));
			System.out.println("data: " + BinaryToString.bytesToString(data));
			System.out.println("left: " + BinaryToString.bytesToString(c.getParameter("left").getValue().getFormatted(6, 16)));

			FixPoint fp = new FixPoint("255.75");
			System.out.println("fp: " + BinaryToString.bytesToString(fp.getFormatted(10, 16)));

			FixPoint fp2 = new FixPoint("1.5");
			System.out.println("fp2: " + BinaryToString.bytesToString(fp2.getFormatted(8, 16)));

		}catch(Exception e){
			e.printStackTrace();
		}

		if(quit){
			System.exit(0);
		}


		PeakCanHandler canHandler = new PeakCanHandler(TPCANHandle.PCAN_USBBUS1, TPCANBaudrate.PCAN_BAUD_1M);
		try {
			new CommandCenter(canHandler);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataCenter dc = DataCenter.getInstance();
		try {
			dc.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
