package fr.thmarie.parisf1.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse {
	private Long id;

	private String username;

	private Long score;
}
