package com.maf.availablehotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maf.availablehotel.dto.AvailableHotelRequest;
import com.maf.availablehotel.dto.AvailableHotelResponse;
import com.maf.availablehotel.service.AvailableHotelService;

/**
 * 
 * @author izreqat
 * Available Hotel API: this API to search the available hotels
 */
@RestController()
@RequestMapping("availablehotel")
public class AvailableHotelApi {

	@Autowired
	private AvailableHotelService availableHotelService;
	
	@PostMapping(value = "/search")
	public @ResponseBody List<AvailableHotelResponse> searchAvailableHotel(@RequestBody AvailableHotelRequest availableHotelRequest) {
		return availableHotelService.searchFortHotel(availableHotelRequest);
	}
	
	
}
