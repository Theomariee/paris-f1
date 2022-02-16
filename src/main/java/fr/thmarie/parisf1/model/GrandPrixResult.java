package fr.thmarie.parisf1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "grand_prix_result")
public class GrandPrixResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grand_prix_event_id")
	private GrandPrixEvent grandPrixEvent;

	public GrandPrixResult(@NotNull Driver driver, @NotNull GrandPrixEvent grandPrixEvent) {
		this.driver = driver;
		this.grandPrixEvent = grandPrixEvent;
	}
}
