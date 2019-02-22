package com.maf.availablehotel.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maf.availablehotel.bean.HotelProvider;
import com.maf.availablehotel.bean.HotelProviderCode;
import com.maf.availablehotel.parameter.BestHotelProviderParameter;
import com.maf.availablehotel.parameter.CrazyHotelProviderParameter;

/**
 * 
 * @author izreqat
 * This class act as Database layer, here I initialize the providers we have
 *
 */
@Component
public class HotelProviderDao {
	private static List<HotelProvider> hotelProviders = new ArrayList<>();

	static {
		
		hotelProviders.add(new HotelProvider(1L, HotelProviderCode.BEST, "BestHotel",
				BestHotelProviderParameter.RequestParameter.bestHotelRequestParametersMapping,
				BestHotelProviderParameter.ResponseParameter.bestHotelResponseParametersMapping,
				"http://localhost:8080/besthotel"));
		
		hotelProviders.add(new HotelProvider(2L, HotelProviderCode.CRAZY, "CarzyHotel",
				CrazyHotelProviderParameter.RequestParameter.crazyHotelRequestParametersMapping,
				CrazyHotelProviderParameter.ResponseParameter.crazyHotelResponseParametersMapping,
				"http://localhost:8080/crazyhotel"));
	}

	public List<HotelProvider> getHotelProviderList() {
		return hotelProviders;
	}
}
