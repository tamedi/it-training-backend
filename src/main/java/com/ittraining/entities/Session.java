package com.ittraining.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	

	@Column(name="date_debut")

	private String date_debut;

	

	@Column(name="date_fin")
	private String date_fin;

	@Column(name="prix")
	private String prix;

	@Column(name="lieu")
	private String lieu;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	



	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}



	@ManyToOne
	@JoinColumn(name="formation_id", referencedColumnName = "id")
	private Formation formation;


	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
