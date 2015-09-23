package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteContactService extends CrudService<Contact, Long> {

}
