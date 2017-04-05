package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//public class EE extends SmartDevice{
public class EE{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int conso;
	private Residence residence;
	
	public EE(int c, Residence r){
		this.conso = c;
		this.residence = r;
	}
	
	public EE(){
		
	}
	
	@Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
        this.id = id;
    }
	
	public int getConso() {
        return conso;
    }
	
	public void setConso(int conso) {
        this.conso = conso;
    }
	
	@ManyToOne
    public Residence getResidence() {
        return this.residence;
    }

	@ManyToOne
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	
	
}
