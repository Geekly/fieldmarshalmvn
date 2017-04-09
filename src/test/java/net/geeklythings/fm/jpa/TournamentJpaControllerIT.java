/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.geeklythings.fm.model.entity.Tournament;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
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
public class TournamentJpaControllerIT  {
    
    private static EntityManagerFactory emf = null;
    
    private Tournament tournament = null;
    private TournamentJpaController instance = null;
    
    public TournamentJpaControllerIT() {
        System.out.println("TournamentJpaContollerIT.constructor");
    }
    

    
    @BeforeClass
    public static void setUpClass() {  
        System.out.println("TournamentJpaContollerIT.setUpClass");
        if (emf == null ) {
            emf = (EntityManagerFactory) Persistence.createEntityManagerFactory("DerbyTestPU");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("TournamentJpaContollerIT.tearDownClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("TournamentJpaContollerIT.setUp");
        instance = new TournamentJpaController(emf);
        System.out.println(instance.toString());
        tournament = Tournament.createTournament(3);
        System.out.println(tournament.toString());
    }
    
    @After
    public void tearDown() {
        System.out.println("TournamentJpaContollerIT.tearDown()");
    }
    
    /**
     * Test of getEntityManager method, of class TournamentJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("TournamentJpaContollerIT.testGetEntityManager()");
    }

    /**
     * Test of create method, of class TournamentJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("TournamentJpaContollerIT.testCreate()");
        System.out.println(instance.toString());
        System.out.println(tournament.toString());
        instance.create(tournament);
    }

    /**
     * Test of edit method, of class TournamentJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("TournamentJpaContollerIT.testEdit()");
    }

    /**
     * Test of destroy method, of class TournamentJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("TournamentJpaContollerIT.testDestroy()");
    }

    /**
     * Test of findTournamentEntities method, of class TournamentJpaController.
     */
    @Test
    public void testFindTournamentEntities_0args() {
        System.out.println("TournamentJpaContollerIT.testFindTournamentEntities(0arg)");
    }

    /**
     * Test of findTournamentEntities method, of class TournamentJpaController.
     */
    @Test
    public void testFindTournamentEntities_int_int() {
        
        System.out.println("TournamentJpaContollerIT.testFindTournamentEntities(int)");
    }

    /**
     * Test of findTournament method, of class TournamentJpaController.
     */
    @Test
    public void testFindTournament() {
        System.out.println("TournamentJpaContollerIT.testFindTournamentEntities()");
    }

    /**
     * Test of getTournamentCount method, of class TournamentJpaController.
     */
    @Test
    public void testGetTournamentCount() {
        System.out.println("TournamentJpaContollerIT.testTournamentCount");
    }



    
    
}
