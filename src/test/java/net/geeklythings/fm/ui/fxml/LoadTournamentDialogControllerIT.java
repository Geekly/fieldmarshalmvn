/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.ui.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
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
public class LoadTournamentDialogControllerIT {
    
    public LoadTournamentDialogControllerIT() {
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
     * Test of showDialog method, of class LoadTournamentDialogController.
     */
    //@Test
    public void testShowDialog() {
        System.out.println("showDialog");
        Stage parentStage = null;
        LoadTournamentDialogController instance = new LoadTournamentDialogController();
        instance.showDialog(parentStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class LoadTournamentDialogController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoadTournamentDialogController instance = new LoadTournamentDialogController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
