package fr.thmarie.parisf1.payload.response;

import fr.thmarie.parisf1.model.BetRacePosition;
import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.model.Player;
import lombok.Data;

import java.util.List;

@Data
public class BetResponse {

    private Long id;

    private Player player;

    private GrandPrixEvent grandPrixEvent;

    private List<BetRacePosition> betRacePositions;

}
