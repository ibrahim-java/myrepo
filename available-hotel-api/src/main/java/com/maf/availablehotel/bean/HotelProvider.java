package com.maf.availablehotel.bean;

import java.util.Map;

import com.maf.availablehotel.parameter.HotelProviderParameter;

/**
 * 
 * @author izreqat
 * HotelProvider contains the provider request/response parameters 
 * and information about this provider like URL used to fire the request.
 * 
 */
public class HotelProvider {

	private Long id;
	private String name;
	private HotelProviderCode hotelProviderCode;
	private Map<String, HotelProviderParameter> requestParameters;
	private Map<String, HotelProviderParameter> responseParameters;
	private String url;
	
	public HotelProvider(Long id, HotelProviderCode hotelProviderCode, String name, Map<String, HotelProviderParameter> requestParameters, Map<String, HotelProviderParameter> responseParameters,
			String url) {
		this.id = id;
		this.hotelProviderCode = hotelProviderCode;
		this.name = name;
		this.requestParameters = requestParameters;
		this.responseParameters = responseParameters;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public HotelProviderCode getHotelProviderCode() {
		return hotelProviderCode;
	}
	
	public void setHotelProviderCode(HotelProviderCode hotelProviderCode) {
		this.hotelProviderCode = hotelProviderCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, HotelProviderParameter> getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(Map<String, HotelProviderParameter> requestParameters) {
		this.requestParameters = requestParameters;
	}

	public Map<String, HotelProviderParameter> getResponseParameters() {
		return responseParameters;
	}

	public void setResponseParameters(Map<String, HotelProviderParameter> responseParameters) {
		this.responseParameters = responseParameters;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "HotelProvider [id=" + id + ", name=" + name + ", requestParameters=" + requestParameters
				+ ", responseParameters=" + responseParameters + ", url=" + url + "]";
	}

}
