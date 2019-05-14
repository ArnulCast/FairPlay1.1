/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.Control;

import JPA.Control.exceptions.NonexistentEntityException;
import JPA.Control.exceptions.PreexistingEntityException;
import JPA.Control.exceptions.RollbackFailureException;
import JPA.Entidades.JPA_Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Developer
 */
public class JPA_UsuarioJpaController implements Serializable {

    public JPA_UsuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(JPA_Usuario JPA_Usuario) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(JPA_Usuario);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findJPA_Usuario(JPA_Usuario.getCodigo()) != null) {
                throw new PreexistingEntityException("JPA_Usuario " + JPA_Usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(JPA_Usuario JPA_Usuario) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            JPA_Usuario = em.merge(JPA_Usuario);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = JPA_Usuario.getCodigo();
                if (findJPA_Usuario(id) == null) {
                    throw new NonexistentEntityException("The jPA_Usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            JPA_Usuario JPA_Usuario;
            try {
                JPA_Usuario = em.getReference(JPA_Usuario.class, id);
                JPA_Usuario.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The JPA_Usuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(JPA_Usuario);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<JPA_Usuario> findJPA_UsuarioEntities() {
        return findJPA_UsuarioEntities(true, -1, -1);
    }

    public List<JPA_Usuario> findJPA_UsuarioEntities(int maxResults, int firstResult) {
        return findJPA_UsuarioEntities(false, maxResults, firstResult);
    }

    private List<JPA_Usuario> findJPA_UsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(JPA_Usuario.class));
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

    public JPA_Usuario findJPA_Usuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(JPA_Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getJPA_UsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<JPA_Usuario> rt = cq.from(JPA_Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
