package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteContactRepository extends CrudRepository<Contact, Long> {

}
