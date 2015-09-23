package net.crunchdroid.module.business.contact.manager.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import net.crunchdroid.module.business.contact.manager.service.LocalRoleService;
import net.crunchdroid.module.business.contact.manager.service.RemoteRoleService;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalRoleRepository;

/**
 *
 * @author cdi316
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleServiceImp implements LocalRoleService, RemoteRoleService, Serializable {

    @EJB
    private LocalRoleRepository roleRepository;

    public RoleServiceImp() {
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> save(List<Role> roles) {
        return roleRepository.save(roles);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.update(role);
    }

    @Override
    public List<Role> update(List<Role> roles) {
        return roleRepository.update(roles);
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return roleRepository.exists(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAll(List<Long> ids) {
        return roleRepository.findAll(ids);
    }

    @Override
    public Long count() {
        return roleRepository.count();
    }

    @Override
    public void delete(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void delete(List<Role> roles) {
        roleRepository.delete(roles);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

}
