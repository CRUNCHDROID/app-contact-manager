/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "type")
public class Type extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "label")
    private Label label;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Type() {
    }

    public Type(Label label, String name, User user) {
        this.label = label;
        this.name = name;
        this.user = user;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("\nType ::: [ id = %s, name = %s, label = %s, created = %s, updated = %s ] %s",
                id, name, label, created, updated, user);
    }

}
