package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.testjpa.domain.EE;
import test.testjpa.domain.Person;
import test.testjpa.domain.Residence;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Residence getResidence() {
    	Residence h = new Residence();
        h.setPerson(new Person("toto", "tata", "titi"));
        EE h1 = new EE();
        h1.setConso(500);
        EE h2 = new EE();
        h2.setConso(600);
        ArrayList<EE> ee = new ArrayList<EE>();
        ee.add(h1);
        ee.add(h2);
        h.setEe(ee);

        return h;
    }

}
