package fr.thmarie.parisf1.controller;

import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.payload.GrandPrixEventRequest;
import fr.thmarie.parisf1.payload.response.ApiResponse;
import fr.thmarie.parisf1.payload.response.GrandPrixEventResponse;
import fr.thmarie.parisf1.service.GrandPrixEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/grand-prix-events")
public class GrandPrixEventController {
    @Autowired
    private GrandPrixEventService grandPrixEventService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<GrandPrixEventResponse>> getAllGrandPrixEvents() {
        List<GrandPrixEventResponse> allGrandPrixEvents = grandPrixEventService.getAllGrandPrixEvents();
        return new ResponseEntity<>(allGrandPrixEvents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<GrandPrixEvent> getGrandPrixEvent(@PathVariable(name = "id") Long id) {
        GrandPrixEvent retrievedGrandPrixEvent = grandPrixEventService.getGrandPrixEvent(id);
        return new ResponseEntity<>(retrievedGrandPrixEvent, HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<GrandPrixEvent> addGrandPrixEvent(
            @Valid @RequestBody GrandPrixEventRequest grandPrixEventRequest) {
        GrandPrixEvent newGrandPrixEvent = grandPrixEventService.addGrandPrixEvent(grandPrixEventRequest);
        return new ResponseEntity<>(newGrandPrixEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<GrandPrixEvent> updateGrandPrixEvent(@PathVariable(name = "id") Long id, @Valid @RequestBody GrandPrixEventRequest grandPrixEventRequest) {
        GrandPrixEvent updatedGrandPrixEvent = grandPrixEventService.updateGrandPrixEvent(id, grandPrixEventRequest);
        return new ResponseEntity<>(updatedGrandPrixEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ApiResponse> deleteGrandPrixEvent(@PathVariable(name = "id") Long id) {
        ApiResponse apiResponse = grandPrixEventService.deleteGrandPrixEvent(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
