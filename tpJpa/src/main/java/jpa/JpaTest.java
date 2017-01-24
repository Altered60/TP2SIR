package jpa;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import test.testjpa.domain.Chauffage;
////import test.testjpa.domain.Department;
//import test.testjpa.domain.EE;
////import test.testjpa.domain.Employee;
//import test.testjpa.domain.Person;
//import test.testjpa.domain.Residence;
//
//
//public class JpaTest {
//
//	private EntityManager manager;
//
//	public JpaTest(EntityManager manager) {
//		this.manager = manager;
//	}

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("example");
//		
//		EntityManager manager = factory.createEntityManager();
//		
//		JpaTest test = new JpaTest(manager);
//		
//		
//			
//		
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//
//		Person p = new Person("L", "FR", "LEDEUS@FRL.com");
//		Residence e = new Residence(65, 3, p); 
//		EE ee = new EE(400, e);
//		Chauffage c = new Chauffage(e);
////		Department d = new Department("Oise");
////		Employee em = new Employee("Jérôme", d);
//		
//		manager.persist(p);
//		manager.persist(e);
//		manager.persist(ee);
//		manager.persist(c);
////		manager.persist(d);
////		manager.persist(em);
//		
//		tx.commit();
//		
//		
//		// TODOs
//		
//		
//		
//		
//		manager.close();
//		System.out.println("done");
//	}
//
//	

	
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;

	import test.testjpa.domain.Residence;
	import test.testjpa.domain.Person;

	public class JpaTest {

	    private EntityManager manager;

	    public JpaTest(EntityManager manager) {
	        this.manager = manager;
	    }
	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        EntityManagerFactory factory =   
	              Persistence.createEntityManagerFactory("example");
	        EntityManager manager = factory.createEntityManager();
	        JpaTest test = new JpaTest(manager);

	        EntityTransaction tx = manager.getTransaction();
	        tx.begin();
	        try {
	            test.createResidences();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        tx.commit();

	        test.listResidences();
	            
	        manager.close();
	        System.out.println(".. done");
	    }

	    private void createResidences() {
	        int numOfResidences = manager.createQuery("Select a From Residence a", Residence.class).getResultList().size();
	        if (numOfResidences == 0) {
	            Person person = new Person("smith","john","js@gmail.com");
	            manager.persist(person);

	            manager.persist(new Residence(45, 2, person));
	            manager.persist(new Residence(120, 5, person));

	        }
	    }

	    private void listResidences() {
	        List<Residence> resultList = manager.createQuery("Select a From Residence a", Residence.class).getResultList();
	        System.out.println("num of residences:" + resultList.size());
	        for (Residence next : resultList) {
	            System.out.println("next residence: " + next);
	        }
	    }
	
	
}
