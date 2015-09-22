package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Local;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;

/**
 *
 * @author cdi316
 */
@Local
public interface LocalCircleRepository extends CrudRepository<Circle, Long> {

}
