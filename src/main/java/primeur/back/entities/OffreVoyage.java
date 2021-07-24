package primeur.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OffreVoyage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date dateDepart;
	private Date dateRetour;
	private String lieuDepart;
	private String lieuArrivee;
	private Integer nbPlaces;
	private boolean disponibiliteOffre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrivee() {
		return lieuArrivee;
	}

	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public boolean isDisponibiliteOffre() {
		return disponibiliteOffre;
	}

	public void setDisponibiliteOffre(boolean disponibiliteOffre) {
		this.disponibiliteOffre = disponibiliteOffre;
	}
}
