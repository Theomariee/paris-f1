package fr.thmarie.parisf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.thmarie.parisf1.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

}
