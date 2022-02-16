package fr.thmarie.parisf1.payload;

import java.util.Date;

import lombok.Data;

@Data
public class GrandPrixEventRequest {

	private String hostingCountry;

	private String hostingCountryFlagAsset;

	private String hostingCity;

	private String eventName;

	private Date eventStartDate;

	private Date eventEndDate;

	private Date betEndDate;

}
