/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.model.entity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.geeklythings.fm.model.PlayerStatus;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


/**
 *
 * @author khooks
 */
@Entity
@Table(name="TOURNAMENT")
public class Tournament extends AbstractEntityModel implements Serializable, PropertyChangeListener {
    
    private static final long serialVersionUID = 1L;
   // private final static Logger logger = LogManager.getLogger(Tournament.class);    
    
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TOURNAMENT_ID")
    private Long id;   
    
    public static final String STORE = "storeChange";
    public static final String ORGANIZER = "organizerChange";
    public static final String ADDPLAYER = "addPlayer";
    public static final String REMOVEPLAYER = "removePlayer";
    public static final String ADDROUND = "addRound";
    public static final String REMOVEROUND = "removeRound";
    public static final String DROPPLAYER = "dropPlayer";
    public static final String FORMAT = "formatChange";
    public static final String TODAYSDATE = "dateChange";
    

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TODAYSDATE")
    private Date todaysDate = new Date();
    @Column(name="LOCATION")
    private String location = "Fort Bourne";
    @Column(name="ORGANIZER")
    private String organizer = "Anastasia deBray";
    @Column(name="NUMROUNDS")
    private int numRounds = 3;
    
    @Embedded  // don't create a seperate table for it
    private EventFormat format;// = new EventFormat();
        
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="OWNER_ID", referencedColumnName="TOURNAMENT_ID")
    private List<Player> players;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true)
    @JoinColumn(name="OWNER_ID", referencedColumnName="TOURNAMENT_ID")
    private List<Round> rounds;   
         
    @Transient
    private int currentRound = 1;
    
    @Transient
    public String eventFormatType;
    
    public String getEventFormatType()
    {
        if( format != null )
        {
            return format.getFormatType();
        }
        return null;
    }

        
    public List<Player> getPlayers()
    {
        return players;
    }    
   
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        firePropertyChange("id", oldId, id);
    }
    
    public void setPlayers( List<Player> players) throws Exception
    {
        throw new Exception("Can't change the players list directly");
        //this.players = (ObservableList<Player>) FXCollections.observableList(players);
    }
    
    /**
    *   Don't call this constructor manually.  Instead, use the factory
    *   createTournament
    **/
    public Tournament() {
        // initialize with dummy variables to reduce chance of null exceptions in the ui
        //setFormat( new EventFormat() );
        //format.addPropertyChangeListener(this);
        players = new ArrayList<>();
        rounds = new ArrayList<>(numRounds);
    }
    
    public static Tournament createTournament(int numRounds) 
    {

        Tournament tournament = new Tournament(); 
        tournament.setNumRounds(numRounds);
        //tournament.addPropertyChangeListener(this);  //the manager that creates it will listen to it
        
        tournament.setFormat( new EventFormat() );       
        //ef.setNumRounds(numRounds);
        //tournament.setFormat( ef );  // setters need to register listeners      
        tournament.players = new ArrayList<>();       
        tournament.rounds = new ArrayList<>();
           
        for( int i=1; i<=numRounds; i++)
        {
            tournament.addNewRound();
        }

        Date today = new Date();
        tournament.setTodaysDate(today);
        tournament.setOrganizer("Coleman Stryker");
        tournament.setLocation("Corvis Convention Center");
       
        //TODO: Set up Rounds first

        return tournament;
    }
         
    public int getCurrentRound() {
        return currentRound;
    }
    
    public EventFormat getFormat() {
        return format;
    }

    public void setFormat(EventFormat format) {
        EventFormat oldformat = this.format;
        this.format = format;
        //logger.debug("Tournament: setFormat: {}", format);
        format.addPropertyChangeListener(this);
        firePropertyChange(FORMAT, oldformat, format);
        
    }

    public List<Player> getActivePlayers()
    {
        List<Player> activePlayers = new ArrayList<>();
        
        for( Player e : players )
        {
            if( e.getActiveStatus() == PlayerStatus.ACTIVE)
            {
                activePlayers.add(e);
            }
        }
        return activePlayers;
    }
    
    public Date getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(Date todaysDate) {
        Date oldTodaysDate = this.todaysDate;
        this.todaysDate = todaysDate;
        firePropertyChange(TODAYSDATE, oldTodaysDate, todaysDate);
    }
    
    /*public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        Date oldStartTime = this.startTime;
        this.startTime = startTime;
        firePropertyChange("startTime", oldStartTime, startTime);
    }*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String store) {
        String oldLocation = this.location;
        this.location = store;
        firePropertyChange(STORE, oldLocation, store);
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        String oldOrganizer = this.organizer;
        this.organizer = organizer;
        firePropertyChange(ORGANIZER, oldOrganizer, organizer);
    }

    public void setNumRounds(int targetRounds) {
        
        int oldRounds = this.numRounds;
        // Empty and recreate
        while (targetRounds < rounds.size())
        {
            removeLastRound();

        }
        while ( targetRounds > rounds.size())
        {
            addNewRound();
        }
        numRounds = rounds.size();
        //this.persist(this);
        firePropertyChange("numRounds", oldRounds, numRounds);
    }
    
    public int getNumRounds() {
        return numRounds;
    }


    public boolean addPlayer(Player player) {
        //List<Player> oldPlayers = new ArrayList<>( this.getPlayers() );
        if( players.contains(player))
        {   
            return false; 
        }
        else {
            players.add(player);
            player.addPropertyChangeListener(this);        
            firePropertyChange(ADDPLAYER, null, this.getPlayers());
            return true;
        }
    }
    /**
     * Remove the player from the tournament
     * @param player
     * @return success Returns true if player was found and removed, false
     * otherwise
     */
    public boolean removePlayer( Player player)
    {
        if( players.contains(player))
        {
            players.remove(player);
            return true;
        }
        else { return false; }
    }

    public List<Round> getRounds()
    {
        return rounds;
    }
    
    public void addNewRound()
    {
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds);     
        rounds.add( new Round() );
        firePropertyChange(ADDROUND, oldRounds, rounds);
    }
        
    public void removeLastRound()
    {
        // TODO: change this to utilize the observable list properties
        List<Round> oldRounds = this.rounds;
        this.rounds = new ArrayList<>(this.rounds );
        int lastRoundIndex = rounds.size()-1;
        this.rounds.remove( lastRoundIndex );
        this.numRounds = rounds.size();
//        logger.debug("Tournament: RemoveLastRound #{}", lastRoundIndex);
        firePropertyChange(REMOVEROUND, oldRounds, rounds);
    }
    
    /**
     * Change the players status to dropped
     * @param dropped Player to drop
     */
    public void dropPlayer(Player dropped)
    {
  //      logger.debug("Tournament: Dropping Player: {}", dropped);
        if( players.contains(dropped) )
        {
        //keep the player in the tournament, but eliminate from pairings
            dropped.setActiveStatus(PlayerStatus.INACTIVE);
            firePropertyChange(DROPPLAYER, null, true);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournament{ todaysDate=" + todaysDate + ", store=" + location + ", organizer=" + organizer + ", numRounds=" + numRounds + ", format=" + format + ", players=" + players + ", rounds=" + rounds + ", currentRound=" + currentRound + ", id=" + id + '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        //logger.debug("PropertChange event in Tournament: {}", pce);
        firePropertyChange(pce);
    }

   
}
