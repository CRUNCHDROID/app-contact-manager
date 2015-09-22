package net.crunchdroid.module.ejb.contat.manager.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;
import net.crunchdroid.module.ejb.contat.manager.exception.ContactManagerException;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalContactRepository;
import net.crunchdroid.module.ejb.contat.manager.repository.RemoteContactRepository;

/**
 *
 * @author cdi316
 */
@Singleton(mappedName = "contactRepository")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ContactRepositoryImp implements LocalContactRepository, RemoteContactRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Contact save(Contact contact) {
        try {
            em.persist(contact);
            return contact;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Contact> save(List<Contact> contacts) {
        try {
            for (Contact contact : contacts) {
                save(contact);
            }
            return contacts;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Contact update(Contact contact) {
        try {
            return em.merge(contact);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Contact> update(List<Contact> contacts) {
        try {
            for (Contact contact : contacts) {
                update(contact);
            }
            return contacts;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Contact findOne(Long id) {
        try {
            return em.find(Contact.class, id);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public boolean exists(Long id) {
        try {
            Contact contact = findOne(id);
            return contact != null;
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Contact> findAll() {
        try {
            String query = "SELECT c FROM Contact c";
            return em.createQuery(query, Contact.class).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public List<Contact> findAll(List<Long> ids) {
        try {
            String query = "SELECT c FROM Contact c WHERE c.id IN :ids";
            return em.createQuery(query, Contact.class).setParameter("ids", ids).getResultList();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public Long count() {
        try {
            String query = "SELECT COUNT(c) FROM Contact c";
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
    public void delete(Contact contact) {
        try {
            em.remove(contact);
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void delete(List<Contact> contacts) {
        try {
            for (Contact contact : contacts) {
                em.remove(contact);
            }
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            String query = "TRUNCATE TABLE contact";
            em.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            throw new ContactManagerException(e);
        }
    }

}
