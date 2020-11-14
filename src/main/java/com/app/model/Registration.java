package com.app.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registration {
    private String firstName;
    private String email;
    private String password;
    private String lastName;
    private String phone;
    private String cardNr;

  // private Date birthDate;
    private LocalDate birthDate;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.birthDate = LocalDate.parse(birthDate,formatter);
    }

//public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

}



