package net.crunchdroid.module.ejb.contat.manager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table(name = "contact")
public class Contact extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "circle_contact", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "circle_id"))
    private List<Circle> circles = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Website> websites = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<InstantMessaging> instantMessagings = new ArrayList<>();

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Size(max = 120)
    @Column(name = "company")
    private String company;

    @Size(max = 100)
    @Column(name = "job")
    private String job;

    @Lob
    @Size(max = 65535)
    @Column(name = "note")
    private String note;

    @Column(name = "is_favorite")
    private Boolean isFavorite;

    @Column(name = "is_delete")
    private Boolean isDelete;

    public Contact() {
    }

    public Contact(User user, String firstName) {
        this.user = user;
        this.firstName = firstName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Circle> getCircles() {
        return circles;
    }

    public void setCircles(List<Circle> circles) {
        this.circles = circles;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<InstantMessaging> getInstantMessagings() {
        return instantMessagings;
    }

    public void setInstantMessagings(List<InstantMessaging> instantMessagings) {
        this.instantMessagings = instantMessagings;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Boolean isDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return String.format("Contact ::: id -> %s, firstName -> %s, lastName -> %s, birthday -> %s, company -> %s, job -> %s, note -> %s, isFavorite -> %s, isDelete -> %s, created -> %s, updated -> %s, user -> %s",
                id, firstName, lastName, birthday, company, job, note, isFavorite, isDelete, created, updated, user);
    }

}
