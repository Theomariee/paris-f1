package fr.thmarie.parisf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.thmarie.parisf1.model.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

}
