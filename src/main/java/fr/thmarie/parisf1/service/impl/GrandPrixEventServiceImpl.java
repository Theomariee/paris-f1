package fr.thmarie.parisf1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.exception.ResourceNotFoundException;
import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.payload.GrandPrixEventRequest;
import fr.thmarie.parisf1.payload.response.GrandPrixEventResponse;
import fr.thmarie.parisf1.repository.GrandPrixEventRepository;
import fr.thmarie.parisf1.service.GrandPrixEventService;

@Service
@Transactional
public class GrandPrixEventServiceImpl implements GrandPrixEventService {
	@Autowired
	GrandPrixEventRepository grandPrixEventRepository;

	@Override
	public List<GrandPrixEventResponse> getAllGrandPrixEvents() {
		List<GrandPrixEventResponse> allGrandPrixEvents = new ArrayList<>();

		for (GrandPrixEvent returnedGrandPrixEvent : grandPrixEventRepository.findAll()) {
			GrandPrixEventResponse grandPrixEventResponse = new GrandPrixEventResponse();

			grandPrixEventResponse.setId(returnedGrandPrixEvent.getId());
			grandPrixEventResponse.setHostingCountry(returnedGrandPrixEvent.getHostingCountry());
			grandPrixEventResponse.setHostingCountryFlagAsset(returnedGrandPrixEvent.getHostingCountryFlagAsset());
			grandPrixEventResponse.setHostingCity(returnedGrandPrixEvent.getHostingCity());
			grandPrixEventResponse.setEventName(returnedGrandPrixEvent.getEventName());
			grandPrixEventResponse.setEventStartDate(returnedGrandPrixEvent.getEventStartDate());
			grandPrixEventResponse.setEventEndDate(returnedGrandPrixEvent.getEventEndDate());
			grandPrixEventResponse.setBetEndDate(returnedGrandPrixEvent.getBetEndDate());

			allGrandPrixEvents.add(grandPrixEventResponse);
		}

		return allGrandPrixEvents;
	}

	@Override
	public GrandPrixEvent getGrandPrixEvent(Long id) {
		GrandPrixEvent grandPrixEvent = grandPrixEventRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("GrandPrixEvent", "id", id));

		return grandPrixEvent;
	}

	@Override
	public GrandPrixEvent addGrandPrixEvent(GrandPrixEventRequest grandPrixEventRequest) {
		GrandPrixEvent grandPrixEvent = new GrandPrixEvent();

		grandPrixEvent.setHostingCountry(grandPrixEventRequest.getHostingCountry());
		grandPrixEvent.setHostingCountryFlagAsset(grandPrixEventRequest.getHostingCountryFlagAsset());
		grandPrixEvent.setHostingCity(grandPrixEventRequest.getHostingCity());
		grandPrixEvent.setEventName(grandPrixEventRequest.getEventName());
		grandPrixEvent.setEventStartDate(grandPrixEventRequest.getEventStartDate());
		grandPrixEvent.setEventEndDate(grandPrixEventRequest.getEventEndDate());
		grandPrixEvent.setBetEndDate(grandPrixEventRequest.getBetEndDate());

		GrandPrixEvent newGrandPrixEvent = grandPrixEventRepository.save(grandPrixEvent);

		return newGrandPrixEvent;
	}
}
