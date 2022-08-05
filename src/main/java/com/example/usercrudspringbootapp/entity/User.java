package com.example.usercrudspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id = 0;
    @Column(name="first_name", columnDefinition = "name")
    private String firstName;
    @Column(name="last_name",  columnDefinition = "name")
    private String lastName;
    @Column(name="user_name",  columnDefinition = "username")
    private String userName;
    @Column(name="password",  columnDefinition = "password")
    private String password;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email",  columnDefinition = "mail")
    private String email;
    @Column(name="date_of_birth")
    private String dateOfBrith;
    @Column(name="height")
    private Integer height;
    @Column(name="weight")
    private Integer weight;
    @Column(name="preferences_id")
    private Integer preferencesId;

    public Integer getId() {
        return id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPreferencesId() {
        return preferencesId;
    }
    public void setPreferencesId(Integer preferencesId){
        this.preferencesId = preferencesId;
    }
}
