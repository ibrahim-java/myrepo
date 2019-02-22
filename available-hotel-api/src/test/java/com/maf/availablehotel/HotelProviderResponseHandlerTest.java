package com.maf.availablehotel;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.maf.availablehotel.dto.AvailableHotelResponse;
import com.maf.availablehotel.parameter.BestHotelProviderParameter;
import com.maf.availablehotel.parameter.HotelProviderParameter;
import com.maf.availablehotel.responsehandler.HotelProviderResponseHandlerImpl;

@RunWith(MockitoJUnitRunner.class)
public class HotelProviderResponseHandlerTest {

	@Mock
	private HotelProviderResponseHandlerImpl hotelProviderResponseHandlerImpl;

	@Test
	public void testBestHotelProviderRequestHandler() {
		AvailableHotelResponse availableHotelResponse = hotelProviderResponseHandlerImpl.convertToMafResponseParameter(prepareHotelProviderResponse(), preparehotelProviderResponseParameters());
		System.out.println(availableHotelResponse);
	}

	private Map<String, Object> prepareHotelProviderResponse() {
		Map<String, Object> availableHotelRequest = new HashMap<>();
		availableHotelRequest.put("hotel", "Hotel1");
		availableHotelRequest.put("hotelRate", 5);
		availableHotelRequest.put("hotelFare", "AUH");
		availableHotelRequest.put("numberOfAdults", 2);
		return availableHotelRequest;
	}
	
	private Map<String, HotelProviderParameter> preparehotelProviderResponseParameters(){
		return BestHotelProviderParameter.ResponseParameter.bestHotelResponseParametersMapping;
	}

}
