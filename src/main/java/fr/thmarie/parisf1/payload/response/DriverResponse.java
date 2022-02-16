package fr.thmarie.parisf1.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import fr.thmarie.parisf1.model.Team;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverResponse {
	private Long id;

	private String firstName;

	private String secondName;

	private Team team;
}
