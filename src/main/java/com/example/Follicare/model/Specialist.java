package com.example.Follicare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialist")
public class Specialist {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String specialty;

    @Column
    private Character zipCode;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "specialist",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorites> favorites;

}
