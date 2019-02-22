package com.maf.availablehotel.parameter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author izreqat
 * This class represents the source of MAF/CrazyHotelProvider parameters mapping, and how we
 * mapped the values from/to MAF/CrazyHotelProvider. This class mainly reflects the Database design of parameters mappings  
 */
public class CrazyHotelProviderParameter {
	
	static ValueHandler defaultHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			return object;
		}
	};
	
	static ValueHandler dateHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			String date = (String) object;
			LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
			Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
//			String format = localDate.format(DateTimeFormatter.ISO_INSTANT);
			return instant;
		}
	};
	
	static ValueHandler providerHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			return "CrazyHotel";
		}
	};
	
	static ValueHandler rateHandler = new ValueHandler() {
		@Override
		public Object handle(Object object) {
			String rate = (String) object;
			return rate.length();
		}
	};
	
	public static class RequestParameter {
		public static final String CITY = "city";
		public static final String FROM = "from";
		public static final String TO = "to";
		public static final String ADULTS_COUNT = "adultsCount";
		
		public static final HotelProviderParameter CITY_PARAM = new HotelProviderParameter(CITY, defaultHandler);
		public static final HotelProviderParameter FROM_DATE_PARAM = new HotelProviderParameter(FROM, dateHandler);
		public static final HotelProviderParameter TO_DATE_PARAM = new HotelProviderParameter(TO, dateHandler);
		public static final HotelProviderParameter NUMBER_OF_ADULTS_PARAM = new HotelProviderParameter(ADULTS_COUNT, defaultHandler);
		
		public static Map<String, HotelProviderParameter> crazyHotelRequestParametersMapping = new HashMap<>();
		
		static {
			crazyHotelRequestParametersMapping.put(InternalParameter.RequestParameter.CITY, CITY_PARAM);
			crazyHotelRequestParametersMapping.put(InternalParameter.RequestParameter.FROM_DATE, FROM_DATE_PARAM);
			crazyHotelRequestParametersMapping.put(InternalParameter.RequestParameter.TO_DATE, TO_DATE_PARAM);
			crazyHotelRequestParametersMapping.put(InternalParameter.RequestParameter.NUMBER_OF_ADULTS, NUMBER_OF_ADULTS_PARAM);
		}
	}
	
	public static class ResponseParameter {
		public static final String PROVIDER = "provider";
		public static final String HOTEL_NAME = "hotelName";
		public static final String RATE = "rate";
		public static final String PRICE = "price";
		public static final String ROOM_AMENITIES = "amenities";
		public static final String DISCOUNT = "discount";
		
		public static final HotelProviderParameter PROVIDER_PARAM = new HotelProviderParameter(PROVIDER, providerHandler);
		public static final HotelProviderParameter HOTEL_PARAM = new HotelProviderParameter(HOTEL_NAME, defaultHandler);
		public static final HotelProviderParameter HOTEL_RATE_PARAM = new HotelProviderParameter(RATE, rateHandler);
		public static final HotelProviderParameter HOTEL_FARE_PARAM = new HotelProviderParameter(PRICE, defaultHandler);
		public static final HotelProviderParameter DICOUNT_PARAM = new HotelProviderParameter(DISCOUNT, defaultHandler);
		public static final HotelProviderParameter ROOM_AMENITIES_PARAM = new HotelProviderParameter(ROOM_AMENITIES, defaultHandler);
		
		public static Map<String, HotelProviderParameter> crazyHotelResponseParametersMapping = new HashMap<>();
		
		static {
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.PROVIDER, PROVIDER_PARAM);
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.HOTEL_NAME, HOTEL_PARAM);
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.RATE, HOTEL_RATE_PARAM);
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.FARE, HOTEL_FARE_PARAM);
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.AMENITIES, ROOM_AMENITIES_PARAM);
			crazyHotelResponseParametersMapping.put(InternalParameter.ResponseParameter.DISCOUNT, DICOUNT_PARAM);
		}
	}
}
