package com.maf.availablehotel.responsehandler;

import java.util.Map;

import com.maf.availablehotel.dto.AvailableHotelResponse;
import com.maf.availablehotel.parameter.HotelProviderParameter;

/**
 * 
 * @author izreqat
 * This class specify how to convert HotelProvider parameters/values to MAF parameter/value
 */
public interface HotelProviderResponseHandler {

	AvailableHotelResponse convertToMafResponseParameter(Map<String, Object> hotelProviderResponse, Map<String, HotelProviderParameter> hotelProviderResponseParameters);
}
