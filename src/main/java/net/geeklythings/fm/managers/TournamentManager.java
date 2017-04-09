/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import net.geeklythings.fm.jpa.TournamentJpaController;
import net.geeklythings.fm.jpa.exceptions.NonexistentEntityException;
import net.geeklythings.fm.model.entity.Tournament;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * ToournamentManager keeps the active Tournament and manages interaction with it.  It 
 * also notifies observers to changes and is notified by the Tournament object when it changes.
 * @author khooks
 */
public class TournamentManager implements PropertyChangeListener {

    // tournament notifies the manager of a change, and the manager persists it
    
//    private static final Logger logger = LogManager.getLogger(TournamentManager.class.getName());
    private final PropertyChangeSupport changeSupport = new java.beans.PropertyChangeSupport(this);
    
    //public static final String LOAD_TOURNAMENT_ID = "LoadTournamentId";
    public TournamentJpaController jpaController; 
    private Tournament tournament;
    //private PlayerManager playerManager;
    
    public TournamentManager( TournamentJpaController jpaController)
    {
        this.jpaController = jpaController;
        //playerManager = new PlayerManager();    
    }
    public Tournament getActiveTournament()
    {
        return tournament;
    }
    
    public List<Tournament> getAllTournaments()
    {
        return jpaController.findTournamentEntities();
    }
         
    public void setTournament(Tournament t)
    /* Assumes that t does not exist in the database yet
     */
    {      
        if( this.tournament != null )
        {
            // We don't want the tournament to listen to our events anymore
            this.tournament.removePropertyChangeListener(this);
        }
        if( t.getId() == null ) {
            // if the new tournament is not persisted, create it
            jpaController.create(t);
        }
        this.tournament = t;
        t.addPropertyChangeListener(this);
        changeSupport.firePropertyChange("setTournament", null, this.tournament);

    }
    
    public void newTournament(Tournament t) throws EntityExistsException
    {
        //TODO:  prevent creation of duplicate tournaments
        if( t != null ) {
            if( jpaController.findTournament(t.getId()) == null )
            {
                jpaController.create(this.tournament);
            } else {
                throw new EntityExistsException("Can't create, tournament is already persisted");
            }
        }
    }
    
    public void updateTournament(Tournament t) throws EntityNotFoundException
    {
        //this.tournament = t;
        //playerManager.setTournament(t);
        //this.tournament.addPropertyChangeListener(this);
        ///changeSupport.firePropertyChange("setTournament", null, this.tournament);
        if( jpaController.findTournament(t.getId()) != null )
            {
//            logger.debug("Updating Tournament " + t.toString());
            try {
                jpaController.edit(t);        
            } catch (NonexistentEntityException e){} catch (Exception ex) { 
                java.util.logging.Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new EntityNotFoundException ("Can't update, tournament has not been persisted");
        }
    
    }
    
    public Tournament loadTournament(long tournamentId) throws EntityNotFoundException
    /* loaded tournament will be persisted by default 
     * 
     */
    {
            if (tournamentId != 0L)
            {
//                logger.debug("Trying to load Tournament {}", tournamentId );
                try {
                    Tournament tournament = jpaController.findTournament(tournamentId);
                    if (tournament != null)
                    {
//                        logger.debug("TournamentManager: NotifyObservers: {}", tournament);
                        //app.setActiveTournament(tournament);
                        changeSupport.firePropertyChange("activeTournament", null, tournament);
                        //setChanged();
                        //notifyObservers(tournament);
                        this.tournament = tournament;
                        
                        return tournament;
                    } 
                } 
                catch (EntityNotFoundException e) 
                {   
                    throw e;
                }
                 
            }
            return null;
    }
    

    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
//        logger.debug("TournamentManager: propertyChange: {} from class: {}", pce.getPropertyName(), pce.getSource().getClass().getName());
        /*
        if( pce.getPropertyName().matches(LoadView.LOAD_TOURNAMENT_ID))
        {
            long tournamentId = (long)pce.getNewValue();
            loadTournament(tournamentId);
            changeSupport.firePropertyChange( "loadTournament", null, tournament);
        }
        else 
        if (pce.getPropertyName().matches(LoadView.NEW_TOURNAMENT_ID))
        {   
            tournament = Tournament.createTournament(0);
            jpaController.create(tournament);
            changeSupport.firePropertyChange( "newTournament", null, tournament);

        }
        else if( pce.getPropertyName().matches(Tournament.ADDPLAYER))
        {   
            try {
                // players were added
                jpaController.edit(tournament);
                changeSupport.firePropertyChange( "addPlayer", null, tournament);
            } catch (NonexistentEntityException ex) {
                java.util.logging.Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        */
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
