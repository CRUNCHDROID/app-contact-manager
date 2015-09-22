/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import net.crunchdroid.module.ejb.contat.manager.entity.AbstractEntity;
import net.crunchdroid.module.ejb.contat.manager.entity.Contact;
import net.crunchdroid.module.ejb.contat.manager.entity.InstantMessagingType;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table(name = "instant_messaging")
public class InstantMessaging extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "instant_messaging_type_id")
    private InstantMessagingType instantMessagingType;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "name")
    private String name;

    public InstantMessaging() {
    }

    public InstantMessagingType getInstantMessagingType() {
        return instantMessagingType;
    }

    public void setInstantMessagingType(InstantMessagingType instantMessagingType) {
        this.instantMessagingType = instantMessagingType;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("InstantMessaging ::: id -> %s, name -> %s, created -> %s, updated -> %s, instantMessagingType -> %s",
                id, name, created, updated, instantMessagingType);
    }

}
