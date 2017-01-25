package tpJpa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JpaTest;
import test.testjpa.domain.Person;

@WebServlet(name = "getuser", urlPatterns = { "/GetUsers" })
public class GetUsers extends HttpServlet {
	
	EntityManager manager;


public GetUsers(){
	manager = NoteEntityManager.getInstance().getEntityManager();
}
	
	public List<Person> test(){
		return manager.createQuery("SELECT p FROM PERSON as p").getResultList();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entrée bdd");
	

		try {			
			List<Person> l = test();
			
			
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			
			for(int i = 0; i < l.size(); i++){
				
			out.println("<HTML>\n<BODY>\n" + "<H1>Personnes</H1>\n" + "<UL>\n" + " <LI>Nom: "
						+ l.get(i).getNom() + "\n" + " <LI>Prenom: " + l.get(i).getPrenom() + "\n"
						+ " <LI>Mail: " + l.get(i).getMail() + "\n" + "</UL>\n" + "</BODY></HTML>");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	
	
		
	}
	

}