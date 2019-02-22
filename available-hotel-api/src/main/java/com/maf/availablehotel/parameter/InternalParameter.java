package com.maf.availablehotel.parameter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author izreqat
 * This class represents the source of internal parameters we use 
 * these parameters to map from/to HotelProvider parameters
 */
public class InternalParameter {

	public static class RequestParameter {
		public static final String CITY = "city";
		public static final String FROM_DATE = "fromDate";
		public static final String TO_DATE = "toDate";
		public static final String NUMBER_OF_ADULTS = "numberOfAdults";
		public static Map<String, Class<?>> mafRequestParameters = new HashMap<>();
		
		static {
			mafRequestParameters.put(CITY, String.class);
			mafRequestParameters.put(FROM_DATE, LocalDate.class);
			mafRequestParameters.put(TO_DATE, LocalDate.class);
			mafRequestParameters.put(NUMBER_OF_ADULTS, Integer.class);
		}
	}
	
	public static class ResponseParameter {
		public static final String PROVIDER = "provider";
		public static final String HOTEL_NAME = "hotelName";
		public static final String FARE = "fare";
		public static final String AMENITIES = "amenities";
		public static final String RATE = "rate";
		public static final String DISCOUNT = "discount";
		public static Map<String, Class<?>> mafResponseParameters = new HashMap<>();
		
		static {
			mafResponseParameters.put(PROVIDER, String.class);
			mafResponseParameters.put(HOTEL_NAME, String.class);
			mafResponseParameters.put(FARE, Double.class);
			mafResponseParameters.put(AMENITIES, String[].class);
			mafResponseParameters.put(RATE, String.class);
			mafResponseParameters.put(DISCOUNT, Integer.class);
		}
	}
}
