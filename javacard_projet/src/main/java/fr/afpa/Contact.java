package fr.afpa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect

public class Contact implements Comparable<Contact>, Serializable {

    private StringProperty name;
    private StringProperty surname;
    private StringProperty city;
    private StringProperty gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthday;
    ///private StringProperty birthday;
    private StringProperty phoneNumber;
    private StringProperty phoneNumberProfessional;
    private StringProperty nickname;
    private StringProperty email;
    private StringProperty postalCode;
    private StringProperty github;
    private StringProperty address;

    // private transient StringProperty name;
    // private transient StringProperty surname;
    // private transient StringProperty city;
    // private transient StringProperty gender;
    // private transient ObjectProperty<LocalDate> birthday;
    // private transient StringProperty phoneNumber;
    // private transient StringProperty phoneNumberProfessional;
    // private transient StringProperty nickname;
    // private transient StringProperty email;
    // private transient StringProperty postalCode;
    // private transient StringProperty github;
    // private transient StringProperty address;

    // /* Fields for serialization binaire */
    private String nameSerialized;
    private String surnameSerialized;
    private String citySerialized;
    private String genderSerialized;
    private String birthdaySerialized;
    private String phoneNumberSerialized;
    private String phoneNumberProfessionalSerialized;
    private String nicknameSerialized;
    private String emailSerialized;
    private String postalCodeSerialized;
    private String githubSerialized;
    private String addressSerialired;

    public Contact() {
        this.name = new SimpleStringProperty("");
        this.surname = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.birthday = new SimpleObjectProperty<T>(LocalDate);
        // if (this.birthday != null){

        // }
        this.nickname = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.phoneNumberProfessional = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.postalCode = new SimpleStringProperty("");
        this.github = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
    }

    public Contact(String name, String surname, String address, String gender, String birthday, String nickname,
            String phoneNumber, String phoneNumberProfessional, String email, String city, String postalCode,
            String github) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        // if (this.birthday != null){

        // }
        // this.birthday.get().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.birthday = new SimpleStringProperty(birthday);
        this.nickname = new SimpleStringProperty(nickname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.phoneNumberProfessional = new SimpleStringProperty(phoneNumberProfessional);
        this.email = new SimpleStringProperty(email);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.github = new SimpleStringProperty(github);
    }

    public String getCity() {
        return this.city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return this.surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getAddress() {
        return this.address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getGender() {
        return this.gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public StringProperty getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public StringProperty birthdayProperty() {
        return birthday;
    }

    public String getPhoneNumber() {
        return this.phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getPhoneNumberProfessional() {
        return this.phoneNumberProfessional.get();
    }

    public void setPhoneNumberProfessional(String phoneNumberProfessional) {
        this.phoneNumberProfessional.set(phoneNumberProfessional);
    }

    public StringProperty phoneNumberProfessionalProperty() {
        return phoneNumberProfessional;
    }

    public String getNickname() {
        return this.nickname.get();
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    public StringProperty nicknameProperty() {
        return nickname;
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPostalCode() {
        return this.postalCode.get();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public String getGithub() {
        return this.github.get();
    }

    public void setGithub(String github) {
        this.github.set(github);
    }

    public StringProperty githubProperty() {
        return github;
    }

    // // //Serialisation JSON
    // private void writeObject(ObjectOutputStream oos) throws IOException {
    // nameSerialized = name.get();
    // surnameSerialized = surname.get();
    // citySerialized = city.get();
    // genderSerialized = gender.get();
    // if (birthday.get() != null) {
    // birthdaySerialized = birthday.get().format(DateTimeFormatter.ISO_LOCAL_DATE);
    // }

    // phoneNumberSerialized = phoneNumber.get();
    // phoneNumberProfessionalSerialized = phoneNumberProfessional.get();
    // nicknameSerialized = nickname.get();
    // emailSerialized = email.get();
    // postalCodeSerialized = postalCode.get();
    // githubSerialized = github.get();
    // addressSerialired = address.get();
    // oos.defaultWriteObject();
    // }

    // private void readObject(ObjectInputStream ois) throws ClassNotFoundException,
    // IOException {
    // ois.defaultReadObject();
    // this.name = new SimpleStringProperty(nameSerialized);
    // this.surname = new SimpleStringProperty(surnameSerialized);
    // this.city = new SimpleStringProperty(citySerialized);
    // this.gender = new SimpleStringProperty(genderSerialized);
    // if (birthdaySerialized != null) {
    // this.birthday = new SimpleObjectProperty<>(
    // LocalDate.parse(birthdaySerialized, DateTimeFormatter.ISO_LOCAL_DATE));
    // }

    // this.phoneNumber = new SimpleStringProperty(phoneNumberSerialized);
    // this.phoneNumberProfessional = new
    // SimpleStringProperty(phoneNumberProfessionalSerialized);
    // this.nickname = new SimpleStringProperty(nicknameSerialized);
    // this.email = new SimpleStringProperty(emailSerialized);
    // this.postalCode = new SimpleStringProperty(postalCodeSerialized);
    // this.github = new SimpleStringProperty(githubSerialized);
    // this.address = new SimpleStringProperty(addressSerialired);
    // }

    @Override
    public int compareTo(Contact o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
