package com.maf.availablehotel.parameter;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author izreqat
 * This class represents the source of MAF/BestHotelProvider parameters mapping, and how we
 * mapped the values from/to MAF/BestHotelProvider. This class mainly reflects the Database design of parameters mappings  
 */
public class BestHotelProviderParameter {
	
	static ValueHandler defaultHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			return object;
		}
	};
	
	static ValueHandler providerHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			return "BestHotel";
		}
	};
	
	static ValueHandler stringToArrayHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			String commaSeparated = (String) object;
			return commaSeparated.split(",");
		}
	};
	
	static ValueHandler towDecimalFare = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			DecimalFormat df = new DecimalFormat("#.##"); 
			Double fare = (Double) object;
			return Double.valueOf(df.format(fare));
		}
	};
	
	public static class RequestParameter {
		public static final String CITY = "city";
		public static final String FROM_DATE = "fromDate";
		public static final String TO_DATE = "toDate";
		public static final String NUMBER_OF_ADULTS = "numberOfAdults";
		
		public static final HotelProviderParameter CITY_PARAM = new HotelProviderParameter(CITY, defaultHandler);
		public static final HotelProviderParameter FROM_DATE_PARAM = new HotelProviderParameter(FROM_DATE, defaultHandler);
		public static final HotelProviderParameter TO_DATE_PARAM = new HotelProviderParameter(TO_DATE, defaultHandler);
		public static final HotelProviderParameter NUMBER_OF_ADULTS_PARAM = new HotelProviderParameter(NUMBER_OF_ADULTS, defaultHandler);
		
		public static Map<String, HotelProviderParameter> bestHotelRequestParametersMapping = new HashMap<>();
		
		static {
			bestHotelRequestParametersMapping.put(InternalParameter.RequestParameter.CITY, CITY_PARAM);
			bestHotelRequestParametersMapping.put(InternalParameter.RequestParameter.FROM_DATE, FROM_DATE_PARAM);
			bestHotelRequestParametersMapping.put(InternalParameter.RequestParameter.TO_DATE, TO_DATE_PARAM);
			bestHotelRequestParametersMapping.put(InternalParameter.RequestParameter.NUMBER_OF_ADULTS, NUMBER_OF_ADULTS_PARAM);
		}
	}
	
	public static class ResponseParameter {
		public static final String PROVIDER = "provider";
		public static final String HOTEL = "hotel";
		public static final String HOTEL_RATE = "hotelRate";
		public static final String HOTEL_FARE = "hotelFare";
		public static final String ROOM_AMENITIES = "roomAmenities";
		
		public static final HotelProviderParameter PROVIDER_PARAM = new HotelProviderParameter(PROVIDER, providerHandler);
		public static final HotelProviderParameter HOTEL_PARAM = new HotelProviderParameter(HOTEL, defaultHandler);
		public static final HotelProviderParameter HOTEL_RATE_PARAM = new HotelProviderParameter(HOTEL_RATE, defaultHandler);
		public static final HotelProviderParameter HOTEL_FARE_PARAM = new HotelProviderParameter(HOTEL_FARE, towDecimalFare);
		public static final HotelProviderParameter ROOM_AMENITIES_PARAM = new HotelProviderParameter(ROOM_AMENITIES, stringToArrayHandler);
		
		public static Map<String, HotelProviderParameter> bestHotelResponseParametersMapping = new HashMap<>();
		
		static {
			bestHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.PROVIDER, PROVIDER_PARAM);
			bestHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.HOTEL_NAME, HOTEL_PARAM);
			bestHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.RATE, HOTEL_RATE_PARAM);
			bestHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.FARE, HOTEL_FARE_PARAM);
			bestHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.AMENITIES, ROOM_AMENITIES_PARAM);
		}
	}
}
