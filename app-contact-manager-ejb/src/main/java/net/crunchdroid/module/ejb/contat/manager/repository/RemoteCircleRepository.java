package net.crunchdroid.module.ejb.contat.manager.repository;

import javax.ejb.Remote;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;

/**
 *
 * @author cdi316
 */
@Remote
public interface RemoteCircleRepository extends CrudRepository<Circle, Long> {

}
