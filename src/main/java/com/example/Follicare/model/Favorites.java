package com.example.Follicare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "specialist_id")
//    @JsonIgnore
//    private Specialist specialist;


    public Favorites() {
    }

    public Favorites(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                '}';
    }
}
