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

import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.payload.response.DriverResponse;
import fr.thmarie.parisf1.service.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	@Autowired
	private DriverService driverService;

	@GetMapping
	public ResponseEntity<List<DriverResponse>> getAllDrivers() {
		List<DriverResponse> allDrivers = driverService.getAllDrivers();
		return new ResponseEntity<>(allDrivers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Driver> getTeam(@PathVariable(name = "id") Long id) {
		Driver retrievedDriver = driverService.getDriver(id);
		return new ResponseEntity<>(retrievedDriver, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Driver> addDriver(@Valid @RequestBody DriverRequest driverRequest) {
		Driver newDriver = driverService.addDriver(driverRequest);
		return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
	}
}
