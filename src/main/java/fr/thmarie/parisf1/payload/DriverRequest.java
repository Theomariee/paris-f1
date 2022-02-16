package fr.thmarie.parisf1.payload;

import lombok.Data;

@Data
public class DriverRequest {
	private String firstName;

	private String secondName;

	private String teamName;
}
