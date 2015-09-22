package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalContactRepository extends CrudRepository<Contact, Long> {

}
