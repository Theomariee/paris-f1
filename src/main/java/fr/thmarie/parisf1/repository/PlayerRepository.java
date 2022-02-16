package fr.thmarie.parisf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.thmarie.parisf1.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
