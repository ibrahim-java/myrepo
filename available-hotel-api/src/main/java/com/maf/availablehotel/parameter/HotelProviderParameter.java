package com.maf.availablehotel.parameter;

/**
 * 
 * @author izreqat
 * This class used to hold the parameter name and handler for this parameter value
 */
public class HotelProviderParameter {

	String paramName;
	ValueHandler valueHandler;

	public HotelProviderParameter(String paramName, ValueHandler valueHandler) {
		super();
		this.paramName = paramName;
		this.valueHandler = valueHandler;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public ValueHandler getValueHandler() {
		return valueHandler;
	}

	public void setValueHandler(ValueHandler valueHandler) {
		this.valueHandler = valueHandler;
	}

}
