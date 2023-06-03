package com.example.Follicare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "favorites", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Specialist> specialist;



    // Many favorites can belong to one profile
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profiles profile;


    public Profiles getProfile() {
        return profile;
    }

    public void setProfile(Profiles profile) {
        this.profile = profile;
    }

    public Favorites(Long id) {
        this.id = id;
    }

    public Favorites() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Specialist> getSpecialist() {
        return specialist;
    }

    public void setSpecialist(List<Specialist> specialist) {
        this.specialist = specialist;
    }


    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                '}';
    }
}
