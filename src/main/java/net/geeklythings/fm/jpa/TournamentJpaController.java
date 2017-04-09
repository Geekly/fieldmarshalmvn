/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.geeklythings.fm.jpa.exceptions.NonexistentEntityException;
import net.geeklythings.fm.model.entity.Tournament;

/**
 * This is the generated JPA controller that handles create, persist, edit
 * and destroy commands to the DB.
 * @author khooks
 */
public class TournamentJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;
    
    public TournamentJpaController(EntityManagerFactory emf) {
        if( emf!=null )
        {
            this.emf = emf;
        } 
        else 
        {
            System.err.println("EntityManagerFactory does not exist");
        }
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tournament tournament) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tournament);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tournament tournament) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tournament = em.merge(tournament);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tournament.getId();
                if (findTournament(id) == null) {
                    throw new NonexistentEntityException("The tournament with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tournament tournament;
            try {
                tournament = em.getReference(Tournament.class, id);
                tournament.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tournament with id " + id + " no longer exists.", enfe);
            }
            em.remove(tournament);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tournament> findTournamentEntities() {
        return findTournamentEntities(true, -1, -1);
    }

    public List<Tournament> findTournamentEntities(int maxResults, int firstResult) {
        return findTournamentEntities(false, maxResults, firstResult);
    }

    private List<Tournament> findTournamentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tournament.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tournament findTournament(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tournament.class, id);
        } finally {
            em.close();
        }
    }

    public int getTournamentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tournament> rt = cq.from(Tournament.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
