package com.maf.availablehotel;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maf.availablehotel.util.Util;

/**
 * 
 * @author izreqat
 * A dummy BestHotel provider API
 * 
 */
@RestController()
@RequestMapping("besthotel")
public class BestHotelProvider {

	@SuppressWarnings("unchecked")
	@GetMapping
	public Map<String, Object> getBestHotelProvider(Map<String, Object> request) {
		String response = "{\"hotel\" : \"Hotel2\", "
				+ "\"hotelRate\" : 3, "
				+ "\"hotelFare\" : 70.9, "
				+ "\"roomAmenities\" : \"F1, F2, F3, F4, F5\"}";
		return Util.toJson(response, Map.class);
	}
}
