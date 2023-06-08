package com.example.Follicare.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialists")
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String fullName;

    @Column(name = "last_name")
    private String title;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(mappedBy = "favorites")
    private List<Profiles> profiles;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Specialist() {
    }

    public Specialist(Long id, String fullName, String title, String specialty, String zipCode, String email, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.specialty = specialty;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String lastName) {
        this.title = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profiles> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", specialty='" + specialty + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
