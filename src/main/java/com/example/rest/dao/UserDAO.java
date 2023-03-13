package com.example.rest.dao;

public class UserDAO {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;

    public UserDAO(Long id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public Long getId() {
        return id;
    }

    public UserDAO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDAO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDAO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserDAO setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }
}
