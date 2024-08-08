package fr.afpa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE
)

public class Contact implements Comparable<Contact>, Serializable {

  
//     private StringProperty name;
//     private StringProperty surname;
//     private StringProperty city;
//     private StringProperty gender;
//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//     private ObjectProperty<LocalDate> birthday;

//    // private ObjectProperty<LocalDate> birthday;
//     ///private StringProperty birthday;
    
//     private StringProperty phoneNumber;

//     private StringProperty phoneNumberProfessional;
    
//     private StringProperty nickname;
   
//     private StringProperty email;
//     private StringProperty postalCode;
//     private StringProperty github;
//     private StringProperty address;

    private transient StringProperty name;
    private transient StringProperty surname;
    private transient StringProperty city;
    private transient StringProperty gender;
    private transient ObjectProperty<LocalDate> birthday;
    private transient StringProperty phoneNumber;
    private transient StringProperty phoneNumberProfessional;
    private transient StringProperty nickname;
    private transient StringProperty email;
    private transient StringProperty postalCode;
    private transient StringProperty github;
    private transient StringProperty address;

    /* Fields for serialization binaire */
    private String nameSerialized;
    private String surnameSerialized;
    private String citySerialized;
    private String genderSerialized;
    private LocalDate birthdaySerialized;
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
        this.birthday = new SimpleObjectProperty<>(LocalDate.now()); 
        this.nickname = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.phoneNumberProfessional = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.postalCode = new SimpleStringProperty("");
        this.github = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
    }
    
    public Contact(String name, String surname, String address, String gender, LocalDate birthday, String nickname,
            String phoneNumber, String phoneNumberProfessional, String email, String city, String postalCode,
            String github) {
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

        this.nameSerialized = name;
        this.surnameSerialized = surname;
        this.addressSerialired = address;
        this.genderSerialized = gender;
        this.birthdaySerialized = birthday;
        this.nicknameSerialized  = nickname;
        this.phoneNumberSerialized = phoneNumber;
        this.phoneNumberProfessionalSerialized = phoneNumberProfessional;
        this.emailSerialized = email;
        this.citySerialized = city;
        this.postalCodeSerialized = postalCode;
        this.githubSerialized = github;

    }

    public String getNameSerialized() {
        return nameSerialized;
    }

    public void setNameSerialized(String nameSerialized) {
        this.nameSerialized = nameSerialized;
    }

    public String getSurnameSerialized() {
        return surnameSerialized;
    }

    public void setSurnameSerialized(String surnameSerialized) {
        this.surnameSerialized = surnameSerialized;
    }

    public String getCitySerialized() {
        return citySerialized;
    }

    public void setCitySerialized(String citySerialized) {
        this.citySerialized = citySerialized;
    }

    public String getGenderSerialized() {
        return genderSerialized;
    }

    public void setGenderSerialized(String genderSerialized) {
        this.genderSerialized = genderSerialized;
    }

    public LocalDate getBirthdaySerialized() {
        return birthdaySerialized;
    }

    public void setBirthdaySerialized(LocalDate birthdaySerialized) {
        this.birthdaySerialized = birthdaySerialized;
    }

    public String getPhoneNumberSerialized() {
        return phoneNumberSerialized;
    }

    public void setPhoneNumberSerialized(String phoneNumberSerialized) {
        this.phoneNumberSerialized = phoneNumberSerialized;
    }

    public String getPhoneNumberProfessionalSerialized() {
        return phoneNumberProfessionalSerialized;
    }

    public void setPhoneNumberProfessionalSerialized(String phoneNumberProfessionalSerialized) {
        this.phoneNumberProfessionalSerialized = phoneNumberProfessionalSerialized;
    }

    public String getNicknameSerialized() {
        return nicknameSerialized;
    }

    public void setNicknameSerialized(String nicknameSerialized) {
        this.nicknameSerialized = nicknameSerialized;
    }

    public String getEmailSerialized() {
        return emailSerialized;
    }

    public void setEmailSerialized(String emailSerialized) {
        this.emailSerialized = emailSerialized;
    }

    public String getPostalCodeSerialized() {
        return postalCodeSerialized;
    }

    public void setPostalCodeSerialized(String postalCodeSerialized) {
        this.postalCodeSerialized = postalCodeSerialized;
    }

    public String getGithubSerialized() {
        return githubSerialized;
    }

    public void setGithubSerialized(String githubSerialized) {
        this.githubSerialized = githubSerialized;
    }

    public String getAddressSerialired() {
        return addressSerialired;
    }

    public void setAddressSerialired(String addressSerialired) {
        this.addressSerialired = addressSerialired;
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

   
    @Override
    public int compareTo(Contact o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
