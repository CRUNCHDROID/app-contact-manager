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
@Table(name = "website")
public class Website extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "url")
    private String url;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public Website() {
    }

    public Website(String url) {
        this.url = url;
    }

    public Website(String url, Type type) {
        this.url = url;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return String.format("\nWebsite ::: [ id = %s, url = %s, created = %s, updated = %s ] %s",
                id, url, created, updated, type);
    }

}
