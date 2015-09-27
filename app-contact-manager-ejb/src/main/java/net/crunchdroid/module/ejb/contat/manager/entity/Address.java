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
@Table(name = "address")
public class Address extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "street")
    private String street;

    @Size(min = 1, max = 10)
    @Column(name = "post_code")
    private String postCode;

    @Size(min = 1, max = 80)
    @Column(name = "city")
    private String city;

    @Size(min = 1, max = 60)
    @Column(name = "country")
    private String country;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }

    public Address(String street, Type type) {
        this.street = street;
        this.type = type;
    }

    public Address(String street, String postCode, String city, String country) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public Address(String street, String postCode, String city, String country, Type type) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return String.format("\nAddress ::: [ id = %s, street = %s, postCode = %s, city = %s, country = %s, created = %s, updated = %s ] %s",
                id, street, postCode, city, country, created, updated, type);
    }

}
