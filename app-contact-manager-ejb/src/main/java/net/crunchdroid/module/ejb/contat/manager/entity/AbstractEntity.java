/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Riad YOUSFI
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    protected Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    protected Date updated;

    public AbstractEntity build(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object entity) {
        String class1 = this.getClass().getName();
        String class2 = entity.getClass().getName();

        if (!class2.equals(class1)) {
            return false;
        }

        AbstractEntity other = (AbstractEntity) entity;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getCreated() {
        return created;
    }

    /**
     *
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     *
     * @return
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     *
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     *
     */
    @PrePersist
    public void prePersist() {
        this.created = new Date();
        this.updated = new Date();
    }

    /**
     *
     */
    @PreUpdate
    public void preUpdate() {
        this.updated = new Date();
    }

}
