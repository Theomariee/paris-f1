package fr.thmarie.parisf1.payload.response;

import fr.thmarie.parisf1.EGrandPrixEventLiveStatus;
import lombok.Data;

import java.util.Date;

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

    private EGrandPrixEventLiveStatus liveStatus;

}
