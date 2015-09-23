package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.User;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalUserService extends CrudService<User, Long> {

}
