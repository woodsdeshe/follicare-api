package com.example.Follicare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "favoritesList_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "zipCode")
    private Specialist specialist;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorites> favoritesList;

    public List<Favorites> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }


    public Profiles() {
    }

    public Profiles(Long id, String firstName, String lastName, String hairDisorder, String disorderDescription, String zipCode) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
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
