package com.maf.availablehotel.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author izreqat
 * This class represents the result of searching.
 * 
 */
@JsonInclude(Include.NON_NULL)
public class AvailableHotelResponse implements Comparable<AvailableHotelResponse>{

	private String provider;
	private String hotelName;
	private Double fare;
	private String[] amenities;
	private Integer discount;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Integer rate;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String[] getAmenities() {
		return amenities;
	}

	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "AvailableHotelResponse [provider=" + provider + ", hotelName=" + hotelName + ", fare=" + fare
				+ ", amenities=" + Arrays.toString(amenities) + "]";
	}

	@Override
	public int compareTo(AvailableHotelResponse o) {
		if(this.getRate() > o.getRate()) {
			return -1;
		}else if(this.getRate() < o.getRate()) {
			return 1;
		}
		return 0;
	}

}
