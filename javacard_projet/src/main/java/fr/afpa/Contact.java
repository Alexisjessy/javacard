package fr.afpa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Contact {

    private StringProperty name;
    private StringProperty surname;
    private StringProperty address;
    private StringProperty gender;
    private ObjectProperty<LocalDate> birthday;
    private StringProperty phoneNumber;
    private StringProperty phoneNumberProfessional;
    private StringProperty nickname;
    private StringProperty email;
    private StringProperty city;
    private StringProperty postalCode;
    private StringProperty github;

    public Contact() {
        this.name = new SimpleStringProperty("");
        this.surname = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.birthday = new SimpleObjectProperty<>(LocalDate.now());
        this.nickname = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.phoneNumberProfessional = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.postalCode = new SimpleStringProperty("");
        this.github = new SimpleStringProperty("");
    }

    public Contact(String name, String surname, String address, String gender, LocalDate birthday, String nickname, String phoneNumber, String phoneNumberProfessional, String email, String city, String postalCode, String github) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.nickname = new SimpleStringProperty(nickname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.phoneNumberProfessional = new SimpleStringProperty(phoneNumberProfessional);
        this.email = new SimpleStringProperty(email);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.github = new SimpleStringProperty(github);
    }

    public StringProperty getCity() {
        return city;
    }

    public void setCity(StringProperty city) {
        this.city = city;
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
}
