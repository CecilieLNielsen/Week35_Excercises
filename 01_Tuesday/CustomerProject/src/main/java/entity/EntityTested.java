/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import facade.CustomerFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cecilie
 */
public class EntityTested {
    public static void main(String[] args) {
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
        
        CustomerFacade facade = new CustomerFacade();
        facade.findByID(1);
        facade.findByLastName("Hansen");
        facade.getNumberOfCustomers();
        facade.allCustomers();
        facade.addCustomer("Bobby", "Hansen");
       
        
        
    }
}
