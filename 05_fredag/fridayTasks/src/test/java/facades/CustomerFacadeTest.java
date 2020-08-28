package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerFacadeTest {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");
    private static final CustomerFacade CF = CustomerFacade.getFacadeExample(EMF);

    public CustomerFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
//        Add code to setup entities for test before running any test methods
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
//        Put the test database in a proper state before each test is run
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    /**
     * Test a method here.
     */
    @Test
    public void testGetCustomerByName() {
        List<CustomerDTO> svend = CF.getCustomerByName("Svend");
        for (CustomerDTO cust : svend) {
            assertEquals(cust.getAccountNumber(), "82394");
        }
    }

    @Test
    public void testAddCustomer() {
        BankCustomer bm1 = new BankCustomer("Svend", "Henriksen", "82394", 10000, 91929292, "very decent kekw");
        CF.addCustomer(bm1);
        assertEquals(bm1.getAccountNumber(), "82394");
    }

    @Test
    public void testGetCustomerByid() {
        BankCustomer bm1 = new BankCustomer("johneren", "asdasdasen", "82394", 10000, 91929292, "very decent kekw");
        CF.addCustomer(bm1);
        System.out.println(bm1.getId());
        CustomerDTO c1 = CF.getCustomerByID(bm1.getId());
        assertEquals(bm1.getAccountNumber(), c1.getAccountNumber());
    }

}
