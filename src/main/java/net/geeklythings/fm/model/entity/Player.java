package net.geeklythings.fm.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.geeklythings.fm.model.PlayerStatus;
import net.geeklythings.fm.type.Faction;

@Entity
@Table(name = "PLAYER")
@NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.firstName LIKE :first AND p.lastName LIKE :last")
public class Player extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    public static final String EMAIL = "email";
    public static final String HOMETOWN = "hometown";
    public static final String FACTION = "faction";
    public static final String LASTROUNDPLAYED = "lastRoundPlayed";
    public static final String ACTIVESTATUS = "activeStatus";
           
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLAYER_ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HOMETOWN")
    private String homeTown;
    @Enumerated(EnumType.STRING)
    @Column(name = "FACTION")
    private Faction faction;
    @Column(name = "LASTROUNDPLAYED")
    private int lastRoundPlayed = 1;
    //@OneToMany(cascade = {CascadeType.ALL}) 
    // TODO: make this persisted
    @Transient
    private List<PlayerResult> results = new ArrayList<>();
    @Transient
    private PlayerStatus activeStatus = PlayerStatus.ACTIVE;

    public Player() {
    }

    public Player(String firstName, String lastName, Faction addfaction) {
        //When creating a new Player, we don't want to use an existing person if possible

        this.firstName = firstName;
        this.lastName = lastName;
        this.faction = addfaction;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", homeTown=" + homeTown + ", faction=" + faction + ", lastRoundPlayed=" + lastRoundPlayed + ", activeStatus=" + activeStatus + '}';
    }

    /**
     * Get the value of results
     *
     * @return the value of results
     */
    public List<PlayerResult> getResults() {
        return results;
    }

    /**
     * Set the value of results
     *
     * @param results new value of results
     */
    public void setResults(List<PlayerResult> results) {
        this.results = results;
    }

    public int getLastRoundPlayed() {
        return lastRoundPlayed;
    }

    public void setLastRoundPlayed(int lastRoundPlayed) {
        int oldValue = this.lastRoundPlayed;
        this.lastRoundPlayed = lastRoundPlayed;
        firePropertyChange(LASTROUNDPLAYED, oldValue, this.lastRoundPlayed);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWins() {
        return 0;
    }

    public int getLosses() {
        return 0;
    }

    public int getStandings() {
        return 0;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        Faction oldFaction = this.faction;
        this.faction = faction;
        firePropertyChange(FACTION, oldFaction, this.faction);
    }

    public PlayerStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(PlayerStatus activeStatus) {
        PlayerStatus oldValue = this.activeStatus;
        this.activeStatus = activeStatus;
        firePropertyChange(ACTIVESTATUS, oldValue, this.activeStatus);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldValue = this.firstName;
        this.firstName = firstName;
        firePropertyChange(FIRSTNAME, oldValue, this.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldValue = this.lastName;
        this.lastName = lastName;
        firePropertyChange(LASTNAME, oldValue, this.lastName);
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        String oldValue = this.homeTown;
        this.homeTown = homeTown;
        firePropertyChange(HOMETOWN, oldValue, this.homeTown);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldValue = this.email;
        this.email = email;
        firePropertyChange(EMAIL, oldValue, this.email);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        //Player player = (Player)obj;
        if (this.hashCode() == obj.hashCode()) {
            return true;
        }

        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
}
