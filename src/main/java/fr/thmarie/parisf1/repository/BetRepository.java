package fr.thmarie.parisf1.repository;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.model.GrandPrixEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByGrandPrixEventId(Long grandPrixEventId);

    List<Bet> findByGrandPrixEventIdAndPlayerId(Long grandPrixEventId, Long playerId);
}
