package command;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import etc.FixPoint;
import etc.XMLHandler;

/**
 * A SAX Parser (see Java documentation/tutorials), specifically for an XML file
 * following the "command.dtd".
 * 
 * It is used for parsing commands and their respective parameters from the XML file.
 * 
 * @author Maxmanski
 * @version 1.0
 *
 */
public class CommandHandler extends XMLHandler {

	private List<Command> commandList;
	private List<Parameter> paramList; // temporary list of parameters
	private String commandName; // temporary string containing the command name
	private int commandID; // temporary integer containing the command id

	public CommandHandler(){
		this.commandList = new ArrayList<Command>();
		this.paramList = new ArrayList<Parameter>();
		this.commandName = null;
		this.commandID = -1;
	}

	@Override
	public void startDocument() {

	}

	@Override
	public void endDocument() {

	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) {

		if(qName.toLowerCase().equals("command")){

			this.commandName = atts.getValue("name");
			this.commandID = Integer.parseInt(atts.getValue("id"));
			
		}else if(qName.toLowerCase().equals("param")){
			
			String pname = null;
			int offset = -1, length = -1, fixpoint = -1;
			FixPoint defaultVal = new FixPoint("0.0");
			
			if(atts.getValue("name") != null){
				pname = atts.getValue("name");
			}
			if(atts.getValue("offset") != null){
				offset = Integer.parseInt(atts.getValue("offset"));
			}
			if(atts.getValue("length") != null){
				length = Integer.parseInt(atts.getValue("length"));
			}
			if(atts.getValue("fixpoint") != null){
				fixpoint = Integer.parseInt(atts.getValue("fixpoint"));
			}
			if(atts.getValue("default") != null){
				defaultVal = new FixPoint(atts.getValue("default"));
			}
			
			Parameter p = new Parameter(pname, offset, length, fixpoint, defaultVal);
			this.paramList.add(p);
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) {

		if(qName.toLowerCase().equals("command")){

			if((this.commandID == -1) || (this.commandName == null)){
				// TODO error!
			}

			this.commandList.add(new Command(this.commandName, this.commandID, this.paramList));
			this.commandName = null;
			this.commandID = -1;
			this.paramList = new ArrayList<Parameter>();

		}else if(qName.toLowerCase().equals("param")){

		}
	}

	/**
	 * Returns the resulting List of Commands with their respective Parameters.
	 * 
	 * @return A List containing those Commands which were parsed from the XML file
	 */
	@Override
	public List<Command> getResult(){
		return this.commandList;
	}
}
