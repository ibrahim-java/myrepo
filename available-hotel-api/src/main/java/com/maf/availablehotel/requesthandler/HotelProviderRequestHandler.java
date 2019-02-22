package com.maf.availablehotel.requesthandler;

import java.util.Map;

import com.maf.availablehotel.parameter.HotelProviderParameter;

/**
 * 
 * @author izreqat
 * This class specify how to convert MAF parameters/values to HotelProvider parameter/value
 */
public interface HotelProviderRequestHandler {

	Map<String, Object> convertToHotelProviderParameters(Map<String, Object> availableHotelRequest, Map<String, HotelProviderParameter> hotelProviderRequestParameters);
	
}
