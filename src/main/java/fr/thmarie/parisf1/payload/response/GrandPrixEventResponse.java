package fr.thmarie.parisf1.payload.response;

import java.util.Date;
import java.util.List;

import fr.thmarie.parisf1.model.Bet;
import lombok.Data;

@Data
public class GrandPrixEventResponse {

	private Long id;

	private String hostingCountry;

	private String hostingCountryAlphaTwoCode;

	private String hostingCity;

	private String eventName;

	private Date eventStartDate;

	private Date eventEndDate;

	private Date betEndDate;

}
