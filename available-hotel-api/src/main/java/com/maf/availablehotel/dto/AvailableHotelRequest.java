package com.maf.availablehotel.dto;

/**
 * 
 * @author izreqat
 * This class represents the main request of the system.
 * 
 */
public class AvailableHotelRequest {

	private String fromDate;
	private String toDate;
	private String city;
	private int numberOfAdults;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	@Override
	public String toString() {
		return "AvailableHotelRequest [fromDate=" + fromDate + ", toDate=" + toDate + ", city=" + city
				+ ", numberOfAdults=" + numberOfAdults + "]";
	}

}
