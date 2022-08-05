package com.example.usercrudspringbootapp.request;

public class UserRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String dateOfBrith;
    private Integer height;
    private Integer weight;
    private Integer preferencesId;
    private Integer roleId ;
    private Boolean preferencesInfoSms = true;

    public Boolean getPreferencesInfoSms() {
        return preferencesInfoSms;
    }

    public void setPreferencesInfoSms(Boolean preferencesInfoSms) {
        this.preferencesInfoSms = preferencesInfoSms;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDateOfBrith() {
        return dateOfBrith;
    }
    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    // piti preferences sarqvi save arvi nor id trvi userin
    public Integer getPreferencesId() {
        return preferencesId;
    }
    public void setPreferencesId(Integer preferencesId) {
        this.preferencesId = preferencesId;
    }
}
