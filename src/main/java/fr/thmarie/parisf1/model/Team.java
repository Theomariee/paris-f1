package fr.thmarie.parisf1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private List<Driver> drivers;

	public Team(@NotBlank String name) {
		this.name = name;
	}
}
