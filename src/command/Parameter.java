package command;

import etc.FixPoint;

/**
 * The internal representation of a Parameter, as used by Commands.
 * 
 * It has a name, a value and the properties needed in order to translate the Command into a CAN message.
 * These properties are:
 * 
 * - name:
 * 			The alphanumeric String used to identify the Parameter
 * 
 * - offset:
 * 			The amount of bits in the CAN message left of the parameter
 * 
 * - length:
 * 			The amount of bits in the CAN message available for the parameter
 * 
 * - fixpoint:
 * 			The position of the fixed decimal point in the parameter's value.
 * 			E.g. A fixpoint of 1 means that there is 1 bit for the integral part of the value
 * 				and the rest is the fractional part.
 * 			Hint: A fixpoint of -1 means that there is no fractional part.
 * 
 * - default value:
 * 			The parameter's default value.
 * 			Will be used when no other value is specified.
 * 
 * - value:
 * 			The parameter's actual value, also referred to as "real value".
 * 			This can be changed to an arbitrary value at any time as well as back to default.
 * 
 * @author Maxmanski
 * @version 1.0
 *
 */
public class Parameter {

	private final String name;
	// offset: The bit at which the parameter's value should start (in the CAN message)
	// length: The length of the parameter's value, in Bits
	// fixpoint: The position of the decimal point (because it's a fixed point value)
	private final int offset, length, fixpoint;
	private final FixPoint defaultValue;
	private FixPoint value;
	
	public Parameter(Parameter toClone){
		this.name = toClone.name;
		this.offset = toClone.offset;
		this.length = toClone.length;
		this.fixpoint = toClone.fixpoint;
		this.defaultValue = toClone.defaultValue;
		this.value = toClone.value;
	}
	
	public Parameter(String name, int offset, int length, int fixpoint, FixPoint defaultVal){
		this.name = name;
		this.offset = offset;
		this.length = length;
		this.fixpoint = fixpoint;
		this.defaultValue = defaultVal;
		this.value = defaultVal;
	}
	
	/**
	 * Takes this parameter as template for the construction of a new Parameter.
	 * The only difference is the new Parameter's real value.
	 * 
	 * This can be used for instantiating real-use Parameters from template Parameters.
	 * 
	 * @param realValue The real value of the newly constructed Parameter
	 * @return A deep copy of this Parameter, with another real value.
	 */
	public Parameter clone(FixPoint realValue){
		Parameter ret = new Parameter(this);
		ret.value = realValue;
		return ret;
	}
	
	public FixPoint getDefaultValue() {
		return defaultValue;
	}
	
	public int getFixpoint() {
		return fixpoint;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getName(){
		return this.name;
	}

	public int getOffset() {
		return offset;
	}

	public FixPoint getValue(){
		return this.value;
	}

	public void setValue(FixPoint val){
		this.value = val;
	}
	
	/**
	 * Sets the parameter's value back to its default value.
	 */
	public void setValueToDefault(){
		this.value = this.defaultValue;
	}

	public String toString(){
		StringBuffer buf = new StringBuffer();
		
		buf.append("\"" + this.name + "\": ");
		buf.append("O:" + this.offset + ", ");
		buf.append("L:" + this.length + ", ");
		buf.append("F:" + this.fixpoint + ", ");
		buf.append("D:" + this.defaultValue + ", ");
		buf.append("V:" + this.value);
		
		return buf.toString();
	}
}
