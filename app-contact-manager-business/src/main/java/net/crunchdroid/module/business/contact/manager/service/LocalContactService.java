package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalContactService extends CrudService<Contact, Long> {

}
