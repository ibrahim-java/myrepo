package com.maf.availablehotel.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maf.availablehotel.bean.HotelProvider;
import com.maf.availablehotel.data.HotelProviderDao;
import com.maf.availablehotel.dto.AvailableHotelRequest;
import com.maf.availablehotel.dto.AvailableHotelResponse;
import com.maf.availablehotel.requesthandler.HotelProviderRequestHandler;
import com.maf.availablehotel.responsehandler.HotelProviderResponseHandler;
import com.maf.availablehotel.util.Util;

/**
 * 
 * @author izreqat
 * This class represents the engine of availablehotel API,
 * here we convert from MAF to HotelProvider parameters/values, send request to HotelProvider
 * and then convert bcak the response from HotelProvider to MAF parameters/values
 */
@Service
public class AvailableHotelService {

	@Autowired
	private HotelProviderDao hotelProviderDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<AvailableHotelResponse> searchFortHotel(AvailableHotelRequest availableHotelRequest) {
		
		List<HotelProvider> hotelProviderList = hotelProviderDao.getHotelProviderList();
		Map<String, Object> availableHotelRequestMap = getAvailableHoteRequestAsMap(availableHotelRequest);
		List<AvailableHotelResponse> availableHotelResponses = new ArrayList<>();
		
		for (HotelProvider hotelProvider : hotelProviderList) {
			HotelProviderRequestHandler hotelProviderRequestHandler = hotelProvider.getHotelProviderCode().getHotelProviderRequestHandler();
			Map<String, Object> hotelProviderRequest = hotelProviderRequestHandler.convertToHotelProviderParameters(availableHotelRequestMap, hotelProvider.getRequestParameters());
			
			//fire request
			ResponseEntity<Map<String, Object>> hotelProviderResponse = restTemplate.exchange(hotelProvider.getUrl(), HttpMethod.GET, new HttpEntity<Map<String, Object>>(hotelProviderRequest), new ParameterizedTypeReference<Map<String, Object>>() {
			});
			
			HotelProviderResponseHandler hotelProviderResponseHandler = hotelProvider.getHotelProviderCode().getHotelProviderResponseHandler();
			AvailableHotelResponse availableHotelResponse = hotelProviderResponseHandler.convertToMafResponseParameter(hotelProviderResponse.getBody(), hotelProvider.getResponseParameters());
			
			availableHotelResponses.add(availableHotelResponse);
		}
		
		orderListByRate(availableHotelResponses);
		
		return availableHotelResponses;
	}

	private void orderListByRate(List<AvailableHotelResponse> availableHotelResponses) {
		availableHotelResponses.sort(new Comparator<AvailableHotelResponse>() {

			@Override
			public int compare(AvailableHotelResponse o1, AvailableHotelResponse o2) {
				if(o1.getRate().equals(o2.getRate())) {
					return 0;
				}
				
				return o1.getRate() > o2.getRate() ? -1 : 1;
			}
		});
	}
	
	private Map<String, Object> getAvailableHoteRequestAsMap(AvailableHotelRequest availableHotelRequest){
		return Util.convertToMap(availableHotelRequest);
	}
	
}
