/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.managers;

import java.util.ArrayList;
import java.util.List;
import net.geeklythings.fm.model.entity.MatchPairing;
import net.geeklythings.fm.model.entity.Round;
import net.geeklythings.fm.model.entity.Tournament;

/**
 * This is used to manage Pairing Lists for a tournament
 * Do not interact with the JPA/Database at all
 * @author khooks
 */
public class PairingManager {
    
    public List<MatchPairing> generatePairings(Tournament tournament,
            Round round /*criteria*/)
    {
        
        List<MatchPairing> pairings = new ArrayList<>();
        
        /* 
         * get activeplayers
         * tournament.getActivePlayers()
         * tournament.getStandings( round - 1 ) 
         * create random pairings based on standings
         * return list of pairings
        */
        
        System.out.println(pairings.toString());
        
        return pairings;
    
    }
    
}
