package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getCustomerByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            CustomerDTO c = em.find(CustomerDTO.class, id);
            return c;
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("SELECT e FROM BankCustomer e WHERE e.firstName = :name", BankCustomer.class);
            List<BankCustomer> results = query.setParameter("name", name).getResultList();
            List<CustomerDTO> returnList = new ArrayList();
            for (BankCustomer bc : results) {
                CustomerDTO cm = new CustomerDTO(bc);
                returnList.add(cm);
            }
            return returnList;
        } finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankBustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("SELECT e FROM Bankcustomer e", BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
