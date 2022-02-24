package fr.thmarie.parisf1.payload;

import lombok.Data;

@Data
public class BetRequest {
	private Long playerId;

	private Long grandPrixEventId;

	private Long driverId;

	private int racePosition;
}
