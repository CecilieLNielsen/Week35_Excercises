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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author cecilie
 */
public class CustomerFacade {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Customer findByID(long id) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.lastName = :name", Customer.class);
        query.setParameter("name", name);

        return query.getResultList();
    }

    public long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();

        TypedQuery <Long> q1 = em.createQuery("SELECT COUNT(c) FROM Customer c", Long.class);

        return q1.getSingleResult();
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();

    }

    public Customer addCustomer(String fName, String lName) {
        EntityManager em = emf.createEntityManager();

        Customer cus = new Customer(fName, lName);
        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();

        return cus;
    }

}
