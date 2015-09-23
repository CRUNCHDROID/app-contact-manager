package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.User;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteUserService extends CrudService<User, Long> {

}
