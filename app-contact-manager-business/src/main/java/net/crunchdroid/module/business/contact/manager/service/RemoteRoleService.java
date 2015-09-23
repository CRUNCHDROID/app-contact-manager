package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteRoleService extends CrudService<Role, Long> {

}
