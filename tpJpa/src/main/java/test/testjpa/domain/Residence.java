package test.testjpa.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Residence {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int taille, nbpieces;
	@Transient
	private Collection<Chauffage> chauffages;
	@Transient
	private Collection<EE> ee;

	private Person person;

	public Residence(int t, int np, Person p) {
		this.taille = t;
		this.nbpieces = np;
		this.person = p;
	}

	public Residence() {

	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNbpieces() {
		return nbpieces;
	}

	public void setNbpieces(int nbpieces) {
		this.nbpieces = nbpieces;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Collection<EE> getEe() {
		return ee;
	}

	public void setEe(Collection<EE> ee) {
		this.ee = ee;
	}

	public void setChauffages(Collection<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	public Person getPerson() {
		return this.person;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Collection<Chauffage> getChauffages() {
		return this.chauffages;
	}

}
