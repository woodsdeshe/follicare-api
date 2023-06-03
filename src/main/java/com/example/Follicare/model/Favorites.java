package com.example.Follicare.model;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profiles profiles;

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
    }

    public Favorites(Specialist specialist1) {
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

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                '}';
    }
}
