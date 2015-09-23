package net.crunchdroid.module.business.contact.manager.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import net.crunchdroid.module.business.contact.manager.service.LocalCircleService;
import net.crunchdroid.module.business.contact.manager.service.RemoteCircleService;
import net.crunchdroid.module.ejb.contat.manager.entity.Circle;
import net.crunchdroid.module.ejb.contat.manager.repository.LocalCircleRepository;

/**
 *
 * @author cdi316
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CircleServiceImp implements LocalCircleService, RemoteCircleService, Serializable {

    @EJB
    private LocalCircleRepository circleRepository;

    public CircleServiceImp() {
    }
    
    @Override
    public Circle save(Circle circle) {
        return circleRepository.save(circle);
    }

    @Override
    public List<Circle> save(List<Circle> circles) {
        return circleRepository.save(circles);
    }

    @Override
    public Circle update(Circle circle) {
        return circleRepository.update(circle);
    }

    @Override
    public List<Circle> update(List<Circle> circles) {
        return circleRepository.update(circles);
    }

    @Override
    public Circle findOne(Long id) {
        return circleRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return circleRepository.exists(id);
    }

    @Override
    public List<Circle> findAll() {
        return circleRepository.findAll();
    }

    @Override
    public List<Circle> findAll(List<Long> ids) {
        return circleRepository.findAll(ids);
    }

    @Override
    public Long count() {
        return circleRepository.count();
    }

    @Override
    public void delete(Long id) {
        circleRepository.delete(id);
    }

    @Override
    public void delete(Circle circle) {
        circleRepository.delete(circle);
    }

    @Override
    public void delete(List<Circle> circles) {
        circleRepository.delete(circles);
    }

    @Override
    public void deleteAll() {
        circleRepository.deleteAll();
    }

}
