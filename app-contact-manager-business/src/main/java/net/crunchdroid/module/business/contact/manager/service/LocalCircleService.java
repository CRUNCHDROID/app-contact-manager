package net.crunchdroid.module.business.contact.manager.service;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalCircleService extends CrudService<Circle, Long> {

}
