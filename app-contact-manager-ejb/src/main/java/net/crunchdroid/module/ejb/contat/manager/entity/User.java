/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.crunchdroid.module.ejb.contat.manager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;

    @Size(max = 120)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 60)
    @Column(name = "token")
    private String token;

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("User ::: id -> %s, username -> %s, firstName -> %s, lastName -> %s, created -> %s, updated -> %s, role -> %s",
                id, username, firstName, lastName, created, updated, role);
    }

}
