/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table(name = "messaging")
public class Messaging extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "messaging_address")
    private String messagingAddress;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public Messaging() {
    }

    public Messaging(String messagingAddress) {
        this.messagingAddress = messagingAddress;
    }

    public Messaging(String messagingAddress, Type type) {
        this.messagingAddress = messagingAddress;
        this.type = type;
    }

    public String getMessagingAddress() {
        return messagingAddress;
    }

    public void setMessagingAddress(String messagingAddress) {
        this.messagingAddress = messagingAddress;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return String.format("\nInstantMessaging ::: [ id = %s, messagingAddress = %s, created = %s, updated = %s ] %s",
                id, messagingAddress, created, updated, type);
    }

}
