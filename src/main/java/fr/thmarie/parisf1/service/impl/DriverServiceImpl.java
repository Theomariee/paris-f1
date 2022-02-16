package fr.thmarie.parisf1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.exception.ResourceNotFoundException;
import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.payload.response.DriverResponse;
import fr.thmarie.parisf1.repository.DriverRepository;
import fr.thmarie.parisf1.repository.TeamRepository;
import fr.thmarie.parisf1.service.DriverService;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;

	@Autowired
	TeamRepository teamRepository;

	@Override
	public List<DriverResponse> getAllDrivers() {
		List<DriverResponse> allDrivers = new ArrayList<>();

		for (Driver returnedDriver : driverRepository.findAll()) {
			DriverResponse driverResponse = new DriverResponse();

			driverResponse.setId(returnedDriver.getId());
			driverResponse.setFirstName(returnedDriver.getFirstName());
			driverResponse.setSecondName(returnedDriver.getSecondName());
			driverResponse.setTeam(returnedDriver.getTeam());

			allDrivers.add(driverResponse);
		}

		return allDrivers;
	}

	@Override
	public Driver getDriver(Long id) {
		Driver driver = driverRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Driver", "id", id));

		return driver;
	}

	@Override
	public Driver addDriver(DriverRequest driverRequest) {
		Driver driver = new Driver();
		driver.setFirstName(driverRequest.getFirstName());
		driver.setSecondName(driverRequest.getFirstName());
		driver.setTeam(teamRepository.getById(driverRequest.getTeamName()));

		Driver newDriver = driverRepository.save(driver);

		return newDriver;
	}
}
