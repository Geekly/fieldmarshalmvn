package net.geeklythings.fm.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MatchResult implements Serializable {
  
    private int roundNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Override
    public String toString() {
        return "RoundResult{" + "roundNumber=" + roundNumber + '}';
    }
    
    @OneToOne
    private MatchPairing pairing;
    
    @OneToMany
    private List<Player> players = new ArrayList<>(2);  //two players
    
    //private PlayerResult player1Result;
    //private PlayerResult player2Result;
    // result
    //player 1 results
    //player 2 results
    public Player getWinner(){
            return null;
    }
    public int getRoundNumber() {
            return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
            this.roundNumber = roundNumber;
    }
    
    public List<PlayerResult> getPlayerResults()
    {
        List<PlayerResult> results = new ArrayList<>();
        results.add( (PlayerResult)players.get(0).getResults());
        results.add( (PlayerResult)players.get(1).getResults());
        return results;
    }
    
    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof MatchResult)) {
            return false;
        }
        MatchResult other = (MatchResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public Long getId() {
        return id;
    }

    
}
