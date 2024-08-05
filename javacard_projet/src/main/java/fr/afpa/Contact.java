package fr.afpa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Contact implements Comparable<Contact>, Serializable {

    private transient StringProperty name;
    private transient StringProperty surname;
    private transient StringProperty city;
    private transient StringProperty adress;
    private transient StringProperty gender;
    private transient ObjectProperty<LocalDate> birthday;
    private transient StringProperty phoneNumber;
    private transient StringProperty phoneNumberProfessional;
    private transient StringProperty nickname;
    private transient StringProperty email;
    private transient StringProperty postalCode;
    private transient StringProperty github;

    /* Fields for serialization */
    private String nameSerialized;
    private String surnameSerialized;
    private String citySerialized;
    private String adressSerialized;
    private String genderSerialized;
    private String birthdaySerialized;
    private String phoneNumberSerialized;
    private String phoneNumberProfessionalSerialized;
    private String nicknameSerialized;
    private String emailSerialized;
    private String postalCodeSerialized;
    private String githubSerialized;

    public Contact() {
        this.name = new SimpleStringProperty("");
        this.surname = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.adress = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.birthday = new SimpleObjectProperty<>(LocalDate.now());
        this.nickname = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.phoneNumberProfessional = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.postalCode = new SimpleStringProperty("");
        this.github = new SimpleStringProperty("");
    }

    public Contact(String name, String surname, String city, String adress, String gender, LocalDate birthday, String nickname,
            String phoneNumber, String phoneNumberProfessional, String email, String postalCode, String github) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.city = new SimpleStringProperty(city);
        this.adress = new SimpleStringProperty(adress);
        this.gender = new SimpleStringProperty(gender);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.nickname = new SimpleStringProperty(nickname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.phoneNumberProfessional = new SimpleStringProperty(phoneNumberProfessional);
        this.email = new SimpleStringProperty(email);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.github = new SimpleStringProperty(github);
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

    public String getCity() {
        return this.city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getAdress() {
        return this.adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public StringProperty adressProperty() {
        return adress;
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

    public LocalDate getBirthday() {
        return this.birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
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

    private void writeObject(ObjectOutputStream oos) throws IOException {
        nameSerialized = name.get();
        surnameSerialized = surname.get();
        citySerialized = city.get();
        adressSerialized = adress.get();
        genderSerialized = gender.get();
        if (birthday.get() != null) {

            birthdaySerialized = birthday.get().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        phoneNumberSerialized = phoneNumber.get();
        phoneNumberProfessionalSerialized = phoneNumberProfessional.get();
        nicknameSerialized = nickname.get();
        emailSerialized = email.get();
        postalCodeSerialized = postalCode.get();
        githubSerialized = github.get();
        oos.defaultWriteObject();
    }
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.name = new SimpleStringProperty(nameSerialized != null ? nameSerialized : "");
        this.surname = new SimpleStringProperty(surnameSerialized != null ? surnameSerialized : "");
        this.city = new SimpleStringProperty(citySerialized != null ? citySerialized : "");
        this.adress = new SimpleStringProperty(adressSerialized != null ? adressSerialized : "");
        this.gender = new SimpleStringProperty(genderSerialized != null ? genderSerialized : "");
        this.birthday = birthdaySerialized != null ? new SimpleObjectProperty<>(LocalDate.parse(birthdaySerialized, DateTimeFormatter.ISO_LOCAL_DATE)) : new SimpleObjectProperty<>(null);
        this.phoneNumber = new SimpleStringProperty(phoneNumberSerialized != null ? phoneNumberSerialized : "");
        this.phoneNumberProfessional = new SimpleStringProperty(phoneNumberProfessionalSerialized != null ? phoneNumberProfessionalSerialized : "");
        this.nickname = new SimpleStringProperty(nicknameSerialized != null ? nicknameSerialized : "");
        this.email = new SimpleStringProperty(emailSerialized != null ? emailSerialized : "");
        this.postalCode = new SimpleStringProperty(postalCodeSerialized != null ? postalCodeSerialized : "");
        this.github = new SimpleStringProperty(githubSerialized != null ? githubSerialized : "");
    }
    
 
    @Override
    public int compareTo(Contact o) {
        return this.name.get().compareTo(o.getName());
    }
}
