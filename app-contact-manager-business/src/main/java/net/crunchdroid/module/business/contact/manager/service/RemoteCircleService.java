package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteCircleService extends CrudService<Circle, Long> {

}
