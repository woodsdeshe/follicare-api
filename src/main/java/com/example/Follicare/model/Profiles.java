package com.example.Follicare.model;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profiles {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String hairDisorder;

    @Column
    private String disorderDescription;

    @Column
    private Character zipCode;

    public Profiles() {
    }

    public Profiles(Long id, String firstName, String lastName, String hairDisorder, String disorderDescription, Character zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hairDisorder = hairDisorder;
        this.disorderDescription = disorderDescription;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getHairDisorder() {
        return hairDisorder;
    }

    public void setHairDisorder(String hairDisorder) {
        this.hairDisorder = hairDisorder;
    }

    public String getDisorderDescription() {
        return disorderDescription;
    }

    public void setDisorderDescription(String disorderDescription) {
        this.disorderDescription = disorderDescription;
    }

    public Character getZipCode() {
        return zipCode;
    }

    public void setZipCode(Character zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hairDisorder='" + hairDisorder + '\'' +
                ", disorderDescription='" + disorderDescription + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
