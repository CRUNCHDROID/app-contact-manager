/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table(name = "circle")
public class Circle extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "circles")
    private Set<Contact> contacts = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "is_delete")
    private Boolean isDelete;

    public Circle() {
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return String.format("Circle ::: id -> %s, name -> %s, isDelete -> %s, created -> %s, updated -> %s",
                id, name, isDelete, created, updated);
    }

}
