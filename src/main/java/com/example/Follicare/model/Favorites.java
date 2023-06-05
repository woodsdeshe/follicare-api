//package com.example.Follicare.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "favorites")
//public class Favorites {
//
//    @Column
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "profile_id")
//    private Profiles profile;
//
//    @ManyToOne
//    @JoinColumn(name = "specialist_id")
//    private Specialist specialist;
//
//
//    public Favorites(Long id) {
//        this.id = id;
//    }
//
//    public Favorites() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Profiles getProfile() {
//        return profile;
//    }
//
//    public void setProfile(Profiles profile) {
//        this.profile = profile;
//    }
//
//    public Specialist getSpecialist() {
//        return specialist;
//    }
//
//    public void setSpecialist(Specialist specialist) {
//        this.specialist = specialist;
//    }
//
//    @Override
//    public String toString() {
//        return "Favorites{" +
//                "id=" + id +
//                '}';
//    }
//}
