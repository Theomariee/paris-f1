package fr.thmarie.parisf1.payload.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import fr.thmarie.parisf1.model.Driver;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse {
	private String name;

	private List<Driver> drivers;
}
