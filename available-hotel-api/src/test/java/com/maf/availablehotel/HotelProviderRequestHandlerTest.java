package com.maf.availablehotel;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.maf.availablehotel.parameter.BestHotelProviderParameter;
import com.maf.availablehotel.parameter.HotelProviderParameter;
import com.maf.availablehotel.requesthandler.HotelProviderRequestHandlerImpl;

@RunWith(MockitoJUnitRunner.class)
public class HotelProviderRequestHandlerTest {

	@Mock
	private HotelProviderRequestHandlerImpl hotelProviderRequestHandlerImpl;

	@Test
	public void testBestHotelProviderRequestHandler() {
		Map<String, Object> hotelProviderRequest = hotelProviderRequestHandlerImpl.convertToHotelProviderParameters(prepareAvailableHotelRequest(), prepareHotelProviderRequestParameters());
		System.out.println(hotelProviderRequest);
	}

	private Map<String, Object> prepareAvailableHotelRequest() {
		Map<String, Object> availableHotelRequest = new HashMap<>();
		availableHotelRequest.put("fromDate", "2019-02-21");
		availableHotelRequest.put("toDate", "2019-02-24");
		availableHotelRequest.put("city", "AUH");
		availableHotelRequest.put("numberOfAdults", 2);
		return availableHotelRequest;
	}
	
	private Map<String, HotelProviderParameter> prepareHotelProviderRequestParameters(){
		return BestHotelProviderParameter.ResponseParameter.bestHotelResponseParametersMapping;
	}

}
