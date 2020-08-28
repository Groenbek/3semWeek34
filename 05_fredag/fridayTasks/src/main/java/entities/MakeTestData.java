/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author groen
 */
public class MakeTestData {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {
        EntityManager ef = emf.createEntityManager();
        BankCustomer bm1 = new BankCustomer("Svend", "Henriksen", "82394", 10000, 91929292, "very decent kekw");
        BankCustomer bm2 = new BankCustomer("John", "Henriksen", "12312", 5000, 91929292, "very lol kekw");
        BankCustomer bm3 = new BankCustomer("Henrik", "Henriksen", "12312321", 3000, 91929292, "very good kekw");
        BankCustomer bm4 = new BankCustomer("Morfar", "Henriksen", "123412", 10, 91929292, "very bad kekw");
        try {
            ef.getTransaction().begin();
            ef.persist(bm1);
            ef.persist(bm2);
            ef.persist(bm3);
            ef.persist(bm4);
            ef.getTransaction().commit();
        } finally {
            ef.clear();
        }

    }
}
