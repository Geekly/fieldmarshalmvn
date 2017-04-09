package net.geeklythings.fm.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ROUND")
public class Round extends AbstractEntityModel implements Serializable {


    @Column(name="ROUNDNUMBER")
    private int roundNumber;
    
    //@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    // TODO: make this persisted
    @Transient
    private List<MatchPairing> pairings = new ArrayList<>();
    
    //@Transient
    //private List<MatchResult> roundResults = new ArrayList<>();
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROUND_ID")
    private Long id;

    @Override
    public String toString() {
        return "Round{" + "roundNumber=" + roundNumber + ", id=" + id + '}';
    }
      
    public Round()
    {

    }
    
    public Round(int number) {
        roundNumber = number;
        pairings = new ArrayList<>();
        
    }
    
    public Round(Round rnd)
    {
        id = rnd.getId();
        roundNumber = rnd.getRoundNumber();
        pairings = new ArrayList<>(rnd.getPairings());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        firePropertyChange("id", oldId, id);
    }    
    
    public List<MatchResult> getRoundResults()
    {
        List<MatchResult> allResults = new ArrayList<>();
        for( MatchPairing m : pairings)
        {
            allResults.add( m.getResult());
        }
        return allResults;
    }
        
    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        int oldRoundNumber = this.roundNumber;
        this.roundNumber = roundNumber;
        firePropertyChange("roundNumber", oldRoundNumber, roundNumber);
    }

    public List<MatchPairing> getPairings() {
        return pairings;
    }

    public void setPairings(List<MatchPairing> pairings) {
        this.pairings = pairings;
    }
    
    public void addPairing( MatchPairing pairing)
    {
        if( this.pairings == null ) return;
        this.pairings.add(pairing);
    }
}
