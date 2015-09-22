package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteRoleRepository extends CrudRepository<Role, Long> {

}
