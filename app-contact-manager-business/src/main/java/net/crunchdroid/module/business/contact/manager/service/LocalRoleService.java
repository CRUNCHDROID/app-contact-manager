package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalRoleService extends CrudService<Role, Long> {

}
