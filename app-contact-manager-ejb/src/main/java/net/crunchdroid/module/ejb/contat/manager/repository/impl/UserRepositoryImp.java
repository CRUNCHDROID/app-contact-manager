package net.crunchdroid.module.ejb.contat.manager.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.crunchdroid.module.ejb.contat.manager.entity.User;
import net.crunchdroid.module.ejb.contat.manager.exception.ContactManagerException;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalUserRepository;
import net.crunchdroid.module.ejb.contat.manager.repository.RemoteUserRepository;

/**
 *
 * @author cdi316
 */
@Singleton(mappedName = "userRepository")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserRepositoryImp implements LocalUserRepository, RemoteUserRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        try {
            em.persist(user);
            return user;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<User> save(List<User> users) {
        try {
            for (User user : users) {
                save(user);
            }
            return users;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public User update(User user) {
        try {
            return em.merge(user);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<User> update(List<User> users) {
        try {
            for (User user : users) {
                update(user);
            }
            return users;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public User findOne(Long id) {
        try {
            return em.find(User.class, id);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public boolean exists(Long id) {
        try {
            User user = findOne(id);
            return user != null;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try {
            String query = "SELECT u FROM User u";
            return em.createQuery(query, User.class).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        try {
            String query = "SELECT u FROM User u WHERE u.id IN :ids";
            return em.createQuery(query, User.class).setParameter("ids", ids).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Long count() {
        try {
            String query = "SELECT COUNT(u) FROM User u";
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
    public void delete(User user) {
        try {
            em.remove(user);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(List<User> users) {
        try {
            for (User user : users) {
                em.remove(user);
            }
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            String query = "TRUNCATE TABLE user";
            em.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

}
