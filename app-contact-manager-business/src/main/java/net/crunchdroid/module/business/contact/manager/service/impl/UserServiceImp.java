package net.crunchdroid.module.business.contact.manager.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import net.crunchdroid.module.business.contact.manager.service.LocalUserService;
import net.crunchdroid.module.business.contact.manager.service.RemoteUserService;
import net.crunchdroid.module.ejb.contat.manager.entity.User;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalUserRepository;

/**
 *
 * @author cdi316
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceImp implements LocalUserService, RemoteUserService, Serializable {

    @EJB
    private LocalUserRepository userRepository;

    public UserServiceImp() {
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> save(List<User> users) {
        return userRepository.save(users);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> update(List<User> users) {
        return userRepository.update(users);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.exists(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return userRepository.findAll(ids);
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(List<User> users) {
        userRepository.delete(users);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
