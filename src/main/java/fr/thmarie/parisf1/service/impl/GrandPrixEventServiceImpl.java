package fr.thmarie.parisf1.service.impl;

import fr.thmarie.parisf1.exception.ResourceNotFoundException;
import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.payload.GrandPrixEventRequest;
import fr.thmarie.parisf1.payload.response.ApiResponse;
import fr.thmarie.parisf1.payload.response.GrandPrixEventResponse;
import fr.thmarie.parisf1.repository.GrandPrixEventRepository;
import fr.thmarie.parisf1.service.GrandPrixEventService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            grandPrixEventResponse.setHostingCountryAlphaTwoCode(
                returnedGrandPrixEvent.getHostingCountryAlphaTwoCode());
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
        GrandPrixEvent grandPrixEvent =
            grandPrixEventRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GrandPrixEvent", "id", id));

        return grandPrixEvent;
    }

    @Override
    public GrandPrixEvent addGrandPrixEvent(GrandPrixEventRequest grandPrixEventRequest) {
        GrandPrixEvent grandPrixEvent =
            GrandPrixEvent.builder()
                .hostingCountry(grandPrixEventRequest.getHostingCountry())
                .hostingCountryAlphaTwoCode(grandPrixEventRequest.getHostingCountryAlphaTwoCode())
                .hostingCity(grandPrixEventRequest.getHostingCity())
                .eventName(grandPrixEventRequest.getEventName())
                .eventStartDate(grandPrixEventRequest.getEventStartDate())
                .eventEndDate(grandPrixEventRequest.getEventEndDate())
                .betEndDate(grandPrixEventRequest.getBetEndDate())
                .build();

        GrandPrixEvent newGrandPrixEvent = grandPrixEventRepository.save(grandPrixEvent);

        return newGrandPrixEvent;
    }

    @Override
    public GrandPrixEvent updateGrandPrixEvent(Long id,
        GrandPrixEventRequest grandPrixEventRequest) {
        GrandPrixEvent grandPrixEvent =
            grandPrixEventRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GrandPrixEvent", "id", id));

        grandPrixEvent =
            GrandPrixEvent.builder()
                .id(grandPrixEvent.getId())
                .hostingCountry(grandPrixEventRequest.getHostingCountry())
                .hostingCountryAlphaTwoCode(grandPrixEventRequest.getHostingCountryAlphaTwoCode())
                .hostingCity(grandPrixEventRequest.getHostingCity())
                .eventName(grandPrixEventRequest.getEventName())
                .eventStartDate(grandPrixEventRequest.getEventStartDate())
                .eventEndDate(grandPrixEventRequest.getEventEndDate())
                .betEndDate(grandPrixEventRequest.getBetEndDate())
                .build();

        GrandPrixEvent updatedGrandPrixEvent = grandPrixEventRepository.save(grandPrixEvent);

        return updatedGrandPrixEvent;
    }

    @Override
    public ApiResponse deleteGrandPrixEvent(Long id) {
        GrandPrixEvent grandPrixEvent =
            grandPrixEventRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GrandPrixEvent", "id", id));

        grandPrixEventRepository.delete(grandPrixEvent);

        return new ApiResponse(Boolean.TRUE, "Successfully deleted GrandPrixEvent.");
    }
}
