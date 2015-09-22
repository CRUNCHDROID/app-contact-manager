package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Role;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalRoleRepository extends CrudRepository<Role, Long> {

}
