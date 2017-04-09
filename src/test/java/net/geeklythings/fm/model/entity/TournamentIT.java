/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.model.entity;

import java.beans.PropertyChangeEvent;
import java.util.Date;
import java.util.List;
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
public class TournamentIT {
    
    public TournamentIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of getEventFormatType method, of class Tournament.
     */
    @Test
    public void testGetEventFormatType() {
        System.out.println("getEventFormatType");
        Tournament instance = new Tournament();
        String expResult = "";
        String result = instance.getEventFormatType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Tournament.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Tournament instance = new Tournament();
        List<Player> expResult = null;
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Tournament.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tournament instance = new Tournament();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tournament.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Tournament instance = new Tournament();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayers method, of class Tournament.
     */
    @Test
    public void testSetPlayers() throws Exception {
        System.out.println("setPlayers");
        List<Player> players = null;
        Tournament instance = new Tournament();
        instance.setPlayers(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTournament method, of class Tournament.
     */
    @Test
    public void testCreateTournament() {
        System.out.println("createTournament");
        int numRounds = 0;
        Tournament expResult = null;
        Tournament result = Tournament.createTournament(numRounds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentRound method, of class Tournament.
     */
    @Test
    public void testGetCurrentRound() {
        System.out.println("getCurrentRound");
        Tournament instance = new Tournament();
        int expResult = 0;
        int result = instance.getCurrentRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormat method, of class Tournament.
     */
    @Test
    public void testGetFormat() {
        System.out.println("getFormat");
        Tournament instance = new Tournament();
        EventFormat expResult = null;
        EventFormat result = instance.getFormat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormat method, of class Tournament.
     */
    @Test
    public void testSetFormat() {
        System.out.println("setFormat");
        EventFormat format = null;
        Tournament instance = new Tournament();
        instance.setFormat(format);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivePlayers method, of class Tournament.
     */
    @Test
    public void testGetActivePlayers() {
        System.out.println("getActivePlayers");
        Tournament instance = new Tournament();
        List<Player> expResult = null;
        List<Player> result = instance.getActivePlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodaysDate method, of class Tournament.
     */
    @Test
    public void testGetTodaysDate() {
        System.out.println("getTodaysDate");
        Tournament instance = new Tournament();
        Date expResult = null;
        Date result = instance.getTodaysDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTodaysDate method, of class Tournament.
     */
    @Test
    public void testSetTodaysDate() {
        System.out.println("setTodaysDate");
        Date todaysDate = null;
        Tournament instance = new Tournament();
        instance.setTodaysDate(todaysDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Tournament.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Tournament instance = new Tournament();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Tournament.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String store = "";
        Tournament instance = new Tournament();
        instance.setLocation(store);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrganizer method, of class Tournament.
     */
    @Test
    public void testGetOrganizer() {
        System.out.println("getOrganizer");
        Tournament instance = new Tournament();
        String expResult = "";
        String result = instance.getOrganizer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrganizer method, of class Tournament.
     */
    @Test
    public void testSetOrganizer() {
        System.out.println("setOrganizer");
        String organizer = "";
        Tournament instance = new Tournament();
        instance.setOrganizer(organizer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumRounds method, of class Tournament.
     */
    @Test
    public void testSetNumRounds() {
        System.out.println("setNumRounds");
        int targetRounds = 0;
        Tournament instance = new Tournament();
        instance.setNumRounds(targetRounds);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumRounds method, of class Tournament.
     */
    @Test
    public void testGetNumRounds() {
        System.out.println("getNumRounds");
        Tournament instance = new Tournament();
        int expResult = 0;
        int result = instance.getNumRounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayer method, of class Tournament.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = null;
        Tournament instance = new Tournament();
        boolean expResult = false;
        boolean result = instance.addPlayer(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePlayer method, of class Tournament.
     */
    @Test
    public void testRemovePlayer() {
        System.out.println("removePlayer");
        Player player = null;
        Tournament instance = new Tournament();
        boolean expResult = false;
        boolean result = instance.removePlayer(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRounds method, of class Tournament.
     */
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
        Tournament instance = new Tournament();
        List<Round> expResult = null;
        List<Round> result = instance.getRounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewRound method, of class Tournament.
     */
    @Test
    public void testAddNewRound() {
        System.out.println("addNewRound");
        Tournament instance = new Tournament();
        instance.addNewRound();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLastRound method, of class Tournament.
     */
    @Test
    public void testRemoveLastRound() {
        System.out.println("removeLastRound");
        Tournament instance = new Tournament();
        instance.removeLastRound();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropPlayer method, of class Tournament.
     */
    @Test
    public void testDropPlayer() {
        System.out.println("dropPlayer");
        Player dropped = null;
        Tournament instance = new Tournament();
        instance.dropPlayer(dropped);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Tournament.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Tournament instance = new Tournament();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Tournament.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Tournament instance = new Tournament();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Tournament.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tournament instance = new Tournament();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of propertyChange method, of class Tournament.
     */
    @Test
    public void testPropertyChange() {
        System.out.println("propertyChange");
        PropertyChangeEvent pce = null;
        Tournament instance = new Tournament();
        instance.propertyChange(pce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
