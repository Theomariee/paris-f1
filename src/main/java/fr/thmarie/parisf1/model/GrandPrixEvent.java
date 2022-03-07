package fr.thmarie.parisf1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "grand_prix_event")
public class GrandPrixEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "hosting_country")
	private String hostingCountry;

	@Column(name = "hosting_country_alpha_two_code")
	private String hostingCountryAlphaTwoCode;

	@Column(name = "hosting_city")
	private String hostingCity;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_start_date")
	private Date eventStartDate;

	@Column(name = "event_end_date")
	private Date eventEndDate;

	@Column(name = "bet_end_date")
	private Date betEndDate;

	public GrandPrixEvent(@NotBlank String hostingCountry, @NotBlank String hostingCountryAlphaTwoCode,
			@NotBlank String hostingCity, @NotBlank String eventName, @NotNull Date eventStartDate,
			@NotNull Date eventEndDate, @NotNull Date betEndDate) {
		this.hostingCountry = hostingCountry;
		this.hostingCountryAlphaTwoCode = hostingCountryAlphaTwoCode;
		this.hostingCity = hostingCity;
		this.eventName = eventName;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.betEndDate = betEndDate;
	}
}
