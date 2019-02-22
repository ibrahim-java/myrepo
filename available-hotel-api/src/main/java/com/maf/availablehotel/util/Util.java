package com.maf.availablehotel.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author izreqat
 * This class contains some utils like convert from map to object and back to map. 
 */
public class Util {

	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	static {
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertToMap(Object object){
		return OBJECT_MAPPER.convertValue(object, Map.class);
	}
	
	public static <T> T convertToObject(Map<String, Object> map, Class<T> clazz) {
		return OBJECT_MAPPER.convertValue(map, clazz);
	}
	
	public static <T> T toJson(String string, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(string, clazz);
		} catch (IOException e) {
			return null;
		}
	}
	
}
