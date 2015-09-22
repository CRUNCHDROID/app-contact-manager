package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.User;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalUserRepository extends CrudRepository<User, Long> {

}
