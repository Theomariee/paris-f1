package fr.thmarie.parisf1.service;

import java.util.List;

import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.payload.GrandPrixEventRequest;
import fr.thmarie.parisf1.payload.response.ApiResponse;
import fr.thmarie.parisf1.payload.response.GrandPrixEventResponse;

public interface GrandPrixEventService {

	List<GrandPrixEventResponse> getAllGrandPrixEvents();

	GrandPrixEvent getGrandPrixEvent(Long id);

	GrandPrixEvent addGrandPrixEvent(GrandPrixEventRequest grandPrixEventRequest);

	GrandPrixEvent updateGrandPrixEvent(Long id, GrandPrixEventRequest grandPrixEventRequest);

	ApiResponse deleteGrandPrixEvent(Long id);

}
