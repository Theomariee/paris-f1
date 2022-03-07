package fr.thmarie.parisf1.payload;

import fr.thmarie.parisf1.model.BetRacePosition;
import lombok.Data;

import java.util.List;

@Data
public class BetRequest {

    private Long playerId;

    private Long grandPrixEventId;

    private List<BetRacePosition> betRacePositions;

}
