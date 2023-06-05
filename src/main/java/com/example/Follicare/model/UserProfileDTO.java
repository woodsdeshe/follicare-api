package com.example.Follicare.model;

public class UserProfileDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String hairDisorder;
    private String disorderDescription;
    private String zipcode;

    public UserProfileDTO(String username, String email, String firstName, String lastName,
                          String hairDisorder, String disorderDescription, String zipcode) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hairDisorder = hairDisorder;
        this.disorderDescription = disorderDescription;
        this.zipcode = zipcode;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
