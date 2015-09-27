package net.crunchdroid.module.ejb.contat.manager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@Entity
@Table(name = "contact")
public class Contact extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

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

    @Column(name = "note")
    private String note;

    @Column(name = "favorite")
    private Boolean favorite;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "civility_id")
    private Civility civility;

    @ManyToMany
    @JoinTable(name = "circle_contact", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "circle_id"))
    private List<Circle> circles = new ArrayList();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Website> websites = new ArrayList();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Messaging> messagings = new ArrayList();

    public Contact() {
    }

    public Contact(String firstName, User user) {
        this.firstName = firstName;
        this.user = user;
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
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    public List<Circle> getCircles() {
        return circles;
    }

    public void setCircles(List<Circle> circles) {
        this.circles = circles;
    }

    public void addCircle(Circle circle) {
        this.circles.add(circle);
    }

    public void addCircles(List<Circle> circles) {
        for (Circle circle : circles) {
            addCircle(circle);
        }
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    public void addWebsite(Website website) {
        this.websites.add(website);
        website.setContact(this);
    }

    public void addWebsites(List<Website> websites) {
        for (Website website : websites) {
            addWebsite(website);
        }
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setContact(this);
    }

    public void addAddresses(List<Address> addresses) {
        for (Address addresse : addresses) {
            addAddress(addresse);
        }
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void addEmail(Email email) {
        this.emails.add(email);
        email.setContact(this);
    }

    public void addEmails(List<Email> emails) {
        for (Email email : emails) {
            addEmail(email);
        }
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
        phone.setContact(this);
    }

    public void addPhones(List<Phone> phones) {
        for (Phone phone : phones) {
            addPhone(phone);
        }
    }

    public List<Messaging> getMessagings() {
        return messagings;
    }

    public void setMessagings(List<Messaging> messagings) {
        this.messagings = messagings;
    }

    public void addMessaging(Messaging messaging) {
        this.messagings.add(messaging);
        messaging.setContact(this);
    }

    public void addMessagings(List<Messaging> messagings) {
        for (Messaging messaging : messagings) {
            addMessaging(messaging);
        }
    }

    @Override
    public String toString() {
        return String.format("\nContact ::: [ id = %s, firstName = %s, lastName = %s, birthday = %s, company = %s, job = %s, note = %s, isFavorite = %s, isDelete = %s, created = %s, updated = %s ] %s %s",
                id, firstName, lastName, birthday, company, job, note, favorite, deleted, created, updated, civility, user);
    }

}
