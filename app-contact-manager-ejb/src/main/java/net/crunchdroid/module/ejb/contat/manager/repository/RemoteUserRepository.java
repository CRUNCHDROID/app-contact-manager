package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.User;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteUserRepository extends CrudRepository<User, Long> {

}
