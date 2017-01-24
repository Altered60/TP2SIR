package tpJpa;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {
	
	EntityManagerFactory factory;
	EntityManager manager;
	JpaTest test;
	EntityTransaction tx;

	public void addBDD(String s1, String s2, String s3) {
		System.out.println("entrée bdd");
		tx.begin();
		try {
			Person person = new Person(s1,s2,s3);
	        manager.persist(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		System.out.println(".. done");
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addBDD(request.getParameter("name"), request.getParameter("firstname"), request.getParameter("mail"));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Mail: " + request.getParameter("mail") + "\n" + "</UL>\n" + "</BODY></HTML>");
	}
	
@Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	System.out.println("entrée init");
	super.init(config);
	
	this.factory = Persistence.createEntityManagerFactory("example");
	this.manager = factory.createEntityManager();
	this.test = new JpaTest(manager);

	this.tx = manager.getTransaction();
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	System.out.println("entrée destroy");
	super.destroy();
	
	manager.close();
	factory.close();
}
}
