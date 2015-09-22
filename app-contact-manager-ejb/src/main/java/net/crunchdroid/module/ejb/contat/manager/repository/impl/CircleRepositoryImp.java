package net.crunchdroid.module.ejb.contat.manager.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;
import net.crunchdroid.module.ejb.contat.manager.exception.ContactManagerException;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalCircleRepository;
import net.crunchdroid.module.ejb.contat.manager.repository.RemoteCircleRepository;

/**
 *
 * @author cdi316
 */
@Singleton(mappedName = "circleRepository")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CircleRepositoryImp implements LocalCircleRepository, RemoteCircleRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Circle save(Circle circle) {
        try {
            em.persist(circle);
            return circle;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Circle> save(List<Circle> circles) {
        try {
            for (Circle circle : circles) {
                save(circle);
            }
            return circles;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Circle update(Circle circle) {
        try {
            return em.merge(circle);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Circle> update(List<Circle> circles) {
        try {
            for (Circle circle : circles) {
                update(circle);
            }
            return circles;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Circle findOne(Long id) {
        try {
            return em.find(Circle.class, id);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public boolean exists(Long id) {
        try {
            Circle circle = findOne(id);
            return circle != null;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Circle> findAll() {
        try {
            String query = "SELECT c FROM Circle c";
            return em.createQuery(query, Circle.class).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Circle> findAll(List<Long> ids) {
        try {
            String query = "SELECT c FROM Circle c WHERE c.id IN :ids";
            return em.createQuery(query, Circle.class).setParameter("ids", ids).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Long count() {
        try {
            String query = "SELECT COUNT(c) FROM Circle c";
            return em.createQuery(query, Long.class).getSingleResult();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.remove(findOne(id));
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(Circle circle) {
        try {
            em.remove(circle);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(List<Circle> circles) {
        try {
            for (Circle circle : circles) {
                em.remove(circle);
            }
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            String query = "TRUNCATE TABLE circle";
            em.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

}
