/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

/**
 * A Pairing represents two players
 * @author khooks
 */
@Entity
public class MatchPairing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade=CascadeType.MERGE)
    Set<Player> pairs = new HashSet<>();

    @OneToOne(cascade=CascadeType.ALL)
    MatchResult result = new MatchResult();

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }
    
    public Set<Player> getPairs() {
        return pairs;
    }
    
    public boolean addPlayer(Player player)
    {      
        //check if Player is persisted.  
        try {
            if ( pairs.size() < 2 )
            {          
                if (player.getId() == null) // not persisted yet
                {
                    //persist(player);
                    throw new Exception("Player should be persisted before adding to Pairing");
                }                      
                pairs.add(player);
                return true;
            }
            else
            { 
                throw new Exception("Cannot exceed two players per pairing");
            }
        } catch (Exception e) {e.printStackTrace();}
        return false;
    }
    
    public void removePlayer(Player player)
    {
        pairs.remove(player);
    }
    
    public Long getId() {
        return id;
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
        if (!(object instanceof MatchPairing)) {
            return false;
        }
        MatchPairing other = (MatchPairing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pairing{" + "id=" + id + ", pairs=" + pairs + '}';
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("net.geeklythings_fieldmarshal_jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
    
}
