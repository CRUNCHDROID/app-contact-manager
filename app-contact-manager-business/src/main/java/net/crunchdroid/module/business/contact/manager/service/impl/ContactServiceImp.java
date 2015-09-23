package net.crunchdroid.module.business.contact.manager.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import net.crunchdroid.module.business.contact.manager.service.LocalContactService;
import net.crunchdroid.module.business.contact.manager.service.RemoteContactService;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalContactRepository;

/**
 *
 * @author cdi316
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ContactServiceImp implements LocalContactService, RemoteContactService, Serializable {

    @EJB
    private LocalContactRepository contactRepository;

    public ContactServiceImp() {
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> save(List<Contact> contacts) {
        return contactRepository.save(contacts);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.update(contact);
    }

    @Override
    public List<Contact> update(List<Contact> contacts) {
        return contactRepository.update(contacts);
    }

    @Override
    public Contact findOne(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return contactRepository.exists(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findAll(List<Long> ids) {
        return contactRepository.findAll(ids);
    }

    @Override
    public Long count() {
        return contactRepository.count();
    }

    @Override
    public void delete(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void delete(List<Contact> contacts) {
        contactRepository.delete(contacts);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }

}
