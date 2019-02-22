package com.maf.availablehotel.responsehandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.maf.availablehotel.dto.AvailableHotelResponse;
import com.maf.availablehotel.parameter.HotelProviderParameter;
import com.maf.availablehotel.util.Util;

/**
 * 
 * @author izreqat
 * This class specify how to convert HotelProvider parameters/values to MAF parameter/value
 */
public class HotelProviderResponseHandlerImpl implements HotelProviderResponseHandler {

	@Override
	public AvailableHotelResponse convertToMafResponseParameter(Map<String, Object> hotelProviderResponse,
			Map<String, HotelProviderParameter> hotelProviderResponseParameters) {
		
		Map<String, Object> hotelResponse = new HashMap<>();
		Set<Entry<String, HotelProviderParameter>> entrySet = hotelProviderResponseParameters.entrySet();
		
		
		entrySet.forEach(entry -> {
			
			Object providerValue = hotelProviderResponse.get(entry.getValue().getParamName());
			
			Object value = entry.getValue().getValueHandler().handle(providerValue);
			
			hotelResponse.put(entry.getKey(), value);
		});
		
		return getAvailableHotelResponse(hotelResponse);
	}
	
	private AvailableHotelResponse getAvailableHotelResponse(Map<String, Object> map) {
		return Util.convertToObject(map, AvailableHotelResponse.class);
	}

}
