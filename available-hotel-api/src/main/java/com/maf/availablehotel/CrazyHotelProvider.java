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
@RequestMapping("crazyhotel")
public class CrazyHotelProvider {

	@SuppressWarnings("unchecked")
	@GetMapping
	public Map<String, Object> getCrazyHotelProvider(Map<String, Object> request) {
		String response = "{\"hotelName\" : \"Hotel1\", "
				+ "\"rate\" : \"****\", "
				+ "\"price\" : 30.0, "
				+ "\"discount\" : 0, "
				+ "\"amenities\" : [\"F1\", \"F2\", \"F3\", \"F4\"]}";
		return Util.toJson(response, Map.class);
	}
}
