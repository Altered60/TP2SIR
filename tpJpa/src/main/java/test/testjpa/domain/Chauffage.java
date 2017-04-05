package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//public class Chauffage extends SmartDevice{
public class Chauffage{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Residence residence;
	
	public Chauffage(Residence r){
		this.residence = r;
	}
	
	public Chauffage(){
	
	}
	
	@Id
	@GeneratedValue
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
        this.id = id;
    }
	
	@ManyToOne
    public Residence getResidence() {
        return this.residence;
    }

	public void setResidence(Residence residence) {
		this.residence = residence;
	}
}
