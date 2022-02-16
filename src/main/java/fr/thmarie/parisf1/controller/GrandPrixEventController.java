package fr.thmarie.parisf1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.payload.GrandPrixEventRequest;
import fr.thmarie.parisf1.payload.response.GrandPrixEventResponse;
import fr.thmarie.parisf1.service.GrandPrixEventService;

@RestController
@RequestMapping("/api/grand-prix-events")
public class GrandPrixEventController {
	@Autowired
	private GrandPrixEventService grandPrixEventService;

	@GetMapping
	public ResponseEntity<List<GrandPrixEventResponse>> getAllGrandPrixEvents() {
		List<GrandPrixEventResponse> allGrandPrixEvents = grandPrixEventService.getAllGrandPrixEvents();
		return new ResponseEntity<>(allGrandPrixEvents, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GrandPrixEvent> getGrandPrixEvent(@PathVariable(name = "id") Long id) {
		GrandPrixEvent retrievedGrandPrixEvent = grandPrixEventService.getGrandPrixEvent(id);
		return new ResponseEntity<>(retrievedGrandPrixEvent, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GrandPrixEvent> addGrandPrixEvent(
			@Valid @RequestBody GrandPrixEventRequest grandPrixEventRequest) {
		GrandPrixEvent newGrandPrixEvent = grandPrixEventService.addGrandPrixEvent(grandPrixEventRequest);
		return new ResponseEntity<>(newGrandPrixEvent, HttpStatus.CREATED);
	}
}
