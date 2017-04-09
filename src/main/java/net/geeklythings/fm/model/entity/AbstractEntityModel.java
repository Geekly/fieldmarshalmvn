/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.model.entity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Transient;

/**
 * Class for adding PropertyChangeSupport to all jpa entities
 * @author khooks
 */

public abstract class AbstractEntityModel
{
    @Transient
    protected PropertyChangeSupport propertyChangeSupport;

    public AbstractEntityModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected void firePropertyChange(PropertyChangeEvent event)
    {
        propertyChangeSupport.firePropertyChange(event);
    }
}
