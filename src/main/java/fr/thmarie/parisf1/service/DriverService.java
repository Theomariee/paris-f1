package fr.thmarie.parisf1.service;

import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.DriverRequest;

public interface DriverService {

	Driver addDriver(DriverRequest driverRequest);

}
