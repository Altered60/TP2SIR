package test.testjpa.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom, prenom, mail;
	@Transient
	private Collection<Residence> residences;
	
	public Person(String n, String p, String m){
		this.nom = n;
		this.prenom = p;
		this.mail = m;
	}
	
	public Person(){
		
	}
	
	@Id @GeneratedValue
	public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
        this.id = id;
    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setResidences(Collection<Residence> residences) {
		this.residences = residences;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public Collection<Residence> getResidences(){
		return this.residences;
	}
	
	
}
