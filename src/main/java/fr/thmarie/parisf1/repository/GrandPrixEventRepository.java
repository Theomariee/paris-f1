package fr.thmarie.parisf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.thmarie.parisf1.model.GrandPrixEvent;

import java.util.Date;
import java.util.List;

@Repository
public interface GrandPrixEventRepository extends JpaRepository<GrandPrixEvent, Long> {
    @Query("SELECT gpe FROM GrandPrixEvent gpe WHERE gpe.eventEndDate > :fromDate")
    List<GrandPrixEvent> findAllFromDate(Date fromDate);
}
