package com.maf.availablehotel.requesthandler;

import java.util.HashMap;
import java.util.Map;

import com.maf.availablehotel.parameter.HotelProviderParameter;

/**
 * 
 * @author izreqat
 * This class specify how to convert MAF parameters/values to HotelProvider parameter/value
 */
public class HotelProviderRequestHandlerImpl implements HotelProviderRequestHandler {

	@Override
	public Map<String, Object> convertToHotelProviderParameters(Map<String, Object> availableHotelRequest, Map<String, HotelProviderParameter> hotelProviderRequestParameters) {
		Map<String, Object> hotelProviderRequest = new HashMap<>();
		availableHotelRequest.entrySet().forEach(entry -> {
			
			HotelProviderParameter hotelProviderParameter = hotelProviderRequestParameters.get(entry.getKey());
			
			Object value = hotelProviderParameter.getValueHandler().handle(entry.getValue());
			
			hotelProviderRequest.put(hotelProviderParameter.getParamName(), value);
			
		});
		return hotelProviderRequest;
	}

}
