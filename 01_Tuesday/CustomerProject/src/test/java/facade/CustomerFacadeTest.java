/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cecilie
 */
public class CustomerFacadeTest {

    public CustomerFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Customer cus1 = new Customer("Bobby", "Hansen");
        Customer cus2 = new Customer("Helle", "Hansen");
        Customer cus3 = new Customer("Gitte", "Hansen");
        Customer cus4 = new Customer("Peter", "Hansen");
        Customer cus5 = new Customer("Anders", "Hansen");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cus1);
        em.persist(cus2);
        em.persist(cus3);
        em.persist(cus4);
        em.persist(cus5);
        em.getTransaction().commit();
    }

    @After
    public void tearDown() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Customer c").executeUpdate(); // Fjerner alle rows fra tabellen
        em.createNativeQuery("ALTER TABLE `CUSTOMER` AUTO_INCREMENT = 1").executeUpdate(); // Resetter auto increment tilbage til 1
        em.getTransaction().commit();
    }

    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        long id = 1;
        CustomerFacade instance = new CustomerFacade();
        Customer result = instance.findByID(id);
        assertEquals(id, (long) result.getId());
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String name = "Hansen";
        CustomerFacade instance = new CustomerFacade();
        List<Customer> result = instance.findByLastName(name);
        assertEquals(5, result.size());
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade instance = new CustomerFacade();
        long result = instance.getNumberOfCustomers();
        assertEquals(5, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        CustomerFacade instance = new CustomerFacade();
        List<Customer> result = instance.allCustomers();
        assertEquals(5, result.size());
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String fName = "Bobby";
        String lName = "Hansen";
        CustomerFacade instance = new CustomerFacade();
        Customer result = instance.addCustomer(fName, lName);
        assertEquals(fName, result.getFirstName());

    }

}
