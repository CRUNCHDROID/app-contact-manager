package net.crunchdroid.module.ejb.contat.manager.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;
import net.crunchdroid.module.ejb.contat.manager.exception.ContactManagerException;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalRoleRepository;
import net.crunchdroid.module.ejb.contat.manager.repository.RemoteRoleRepository;

/**
 *
 * @author cdi316
 */
@Singleton(mappedName = "roleRepository")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleRepositoryImp implements LocalRoleRepository, RemoteRoleRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role save(Role role) {
        try {
            em.persist(role);
            return role;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Role> save(List<Role> roles) {
        try {
            for (Role role : roles) {
                save(role);
            }
            return roles;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Role update(Role role) {
        try {
            return em.merge(role);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Role> update(List<Role> roles) {
        try {
            for (Role role : roles) {
                update(role);
            }
            return roles;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Role findOne(Long id) {
        try {
            return em.find(Role.class, id);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public boolean exists(Long id) {
        try {
            Role role = findOne(id);
            return role != null;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Role> findAll() {
        try {
            String query = "SELECT r FROM Role r";
            return em.createQuery(query, Role.class).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Role> findAll(List<Long> ids) {
        try {
            String query = "SELECT r FROM Role r WHERE r.id IN :ids";
            return em.createQuery(query, Role.class).setParameter("ids", ids).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Long count() {
        try {
            String query = "SELECT COUNT(r) FROM Role r";
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
    public void delete(Role role) {
        try {
            em.remove(role);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(List<Role> roles) {
        try {
            for (Role role : roles) {
                em.remove(role);
            }
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            String query = "TRUNCATE TABLE role";
            em.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

}
