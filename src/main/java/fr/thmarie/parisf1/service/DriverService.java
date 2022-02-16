package fr.thmarie.parisf1.service;

import java.util.List;

import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.payload.response.DriverResponse;

public interface DriverService {

	List<DriverResponse> getAllDrivers();

	Driver getDriver(Long id);

	Driver addDriver(DriverRequest driverRequest);

}
