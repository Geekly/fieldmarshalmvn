/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fm.model.entity.Tournament;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Keith
 */
public class TournamentJpaControllerTest {
    
    private static EntityManagerFactory emf = null;
    private static Tournament tournament = null;
    
    public TournamentJpaControllerTest() {
    }
    
    @BeforeClass // These happen before class setup, before any instances of the class are built
    public static void setUpClass() {
        if (emf == null ) {
            emf = (EntityManagerFactory) Persistence.createEntityManagerFactory("DerbyTestPU");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class TournamentJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
       
        TournamentJpaController instance = new TournamentJpaController(emf);
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TournamentJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        tournament = Tournament.createTournament(3);
        TournamentJpaController instance = new TournamentJpaController(emf);
        instance.create(tournament);
        //assertNotNull(null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TournamentJpaController.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Tournament tournament = null;
//        TournamentJpaController instance = null;
//        instance.edit(tournament);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of destroy method, of class TournamentJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Long id = null;
//        TournamentJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findTournamentEntities method, of class TournamentJpaController.
     */
//    @Test
//    public void testFindTournamentEntities_0args() {
//        System.out.println("findTournamentEntities");
//        TournamentJpaController instance = null;
//        List<Tournament> expResult = null;
//        List<Tournament> result = instance.findTournamentEntities();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findTournamentEntities method, of class TournamentJpaController.
     */
//    @Test
//    public void testFindTournamentEntities_int_int() {
//        System.out.println("findTournamentEntities");
//        int maxResults = 0;
//        int firstResult = 0;
//        TournamentJpaController instance = null;
//        List<Tournament> expResult = null;
//        List<Tournament> result = instance.findTournamentEntities(maxResults, firstResult);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findTournament method, of class TournamentJpaController.
     */
//    @Test
//    public void testFindTournament() {
//        System.out.println("findTournament");
//        Long id = null;
//        TournamentJpaController instance = null;
//        Tournament expResult = null;
//        Tournament result = instance.findTournament(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getTournamentCount method, of class TournamentJpaController.
     */
//    @Test
//    public void testGetTournamentCount() {
//        System.out.println("getTournamentCount");
//        TournamentJpaController instance = null;
//        int expResult = 0;
//        int result = instance.getTournamentCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
