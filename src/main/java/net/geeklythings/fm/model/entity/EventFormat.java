/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.model.entity;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author khooks
 */
//@Entity
@Embeddable
public class EventFormat extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @Column(name="FORMATTYPE")
    protected String formatType = "Steamroller 2013"; //Steamroller, etc..

    @Column(name="DESCRIPTION")
    protected String description;  
    @Column(name="CLOCKTYPE")
    protected String clockType = "Death Clock";
    @Column(name="CLOCKTIME")
    protected int clockTime = 37;  //either turn time or death clock time depending on type
    //@Column(name="NUMROUNDS")
    //protected int numRounds = 6;
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="EVENTFORMAT_ID")
    //private Long id;

    public EventFormat()
    {
    }
    
    public EventFormat(EventFormat ef)
    {
        formatType = ef.formatType;
        clockType = ef.clockType;
        clockTime = ef.clockTime;
        
    }
    //TODO: make this work and make the field transient
    @Access(AccessType.PROPERTY)  //this happens automatically when the @Column is placed above the getter()
    @Column(name = "DESCRIPTION")
    public String getDescription()
    {
        return String.format("%s, %s,  Time: %d min", formatType, clockType, clockTime);
    }
      
    public String getFormatType() {
        return this.formatType;
    }

    public void setFormatType(String formatType) {
        String oldValue = this.formatType;
        this.formatType = formatType;      
        firePropertyChange("formatType", oldValue, formatType);
    }

    public String getClockType() {
        return this.clockType;
    }

    public void setClockType(String clockType) {
        String oldValue = this.clockType;
        this.clockType = clockType;
        firePropertyChange("clockType", oldValue, clockType);
    }

    public int getClockTime() {
        return this.clockTime;
    }

    public void setClockTime(int turnLength) {
        int oldValue = this.clockTime;
        this.clockTime = turnLength;
        firePropertyChange("clockTime", oldValue, clockTime);
    }

    public int getDeathClockTime() {
        return this.clockTime;
    }

    public void setDeathClockTime(int deathClockTime) {
        int oldValue = this.clockTime;
        this.clockTime = deathClockTime;
        firePropertyChange("clockTime", oldValue, clockTime);
    }
    
    /*
     * Embedded doesn't need
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventFormat)) {
            return false;
        }
        EventFormat other = (EventFormat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/ 

    @Override
    public String toString() {
        return  getDescription();
    }
    
    
}
