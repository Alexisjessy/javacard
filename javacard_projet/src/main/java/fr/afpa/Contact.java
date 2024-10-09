package fr.afpa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Contact implements Comparable<Contact>, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
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
    // private String nameSerialized;
    // private String surnameSerialized;
    // private String citySerialized;
    // private String adressSerialized;
    // private String genderSerialized;
    // private String birthdaySerialized;
    // private String phoneNumberSerialized;
    // private String phoneNumberProfessionalSerialized;
    // private String nicknameSerialized;
    // private String emailSerialized;
    // private String postalCodeSerialized;
    // private String githubSerialized; 

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

    public Contact(String name, String surname, String city, String adress, String gender, LocalDate birthday,
            String nickname,
            String phoneNumber, String phoneNumberProfessional, String email, String postalCode, String github) {
        this.name = new SimpleStringProperty(name);
        // this.nameSerialized = name;

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

    // Getters and Setters
    
    public String getName() {
        return name.get();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getPhoneNumberProfessional() {
        return phoneNumberProfessional.get();
    }

    public void setPhoneNumberProfessional(String phoneNumberProfessional) {
        this.phoneNumberProfessional.set(phoneNumberProfessional);
    }

    public String getNickname() {
        return nickname.get();
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getGithub() {
        return github.get();
    }

    public void setGithub(String github) {
        this.github.set(github);
    }

    // // Serialization methods
    // private void writeObject(ObjectOutputStream oos) throws IOException {
    //     nameSerialized = name.get();
    //     surnameSerialized = surname.get();
    //     citySerialized = city.get();
    //     adressSerialized = adress.get();
    //     genderSerialized = gender.get();
    //     if (birthday.get() != null) {
    //         birthdaySerialized = birthday.get().format(DateTimeFormatter.ISO_LOCAL_DATE);
    //     }
    //     phoneNumberSerialized = phoneNumber.get();
    //     phoneNumberProfessionalSerialized = phoneNumberProfessional.get();
    //     nicknameSerialized = nickname.get();
    //     emailSerialized = email.get();
    //     postalCodeSerialized = postalCode.get();
    //     githubSerialized = github.get();

    //     oos.defaultWriteObject();
    // }

    // private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    //     // lecture par défaut de tous les attributs "non-transient" (tous les attributs
    //     // suffixés de "Serialized")
    //     ois.defaultReadObject();

    //     // intialisation des champs "StringProperty"
    //     this.name = new SimpleStringProperty(nameSerialized != null ? nameSerialized : "");
    //     this.surname = new SimpleStringProperty(surnameSerialized != null ? surnameSerialized : "");
    //     this.city = new SimpleStringProperty(citySerialized != null ? citySerialized : "");
    //     this.adress = new SimpleStringProperty(adressSerialized != null ? adressSerialized : "");
    //     this.gender = new SimpleStringProperty(genderSerialized != null ? genderSerialized : "");
    //     this.birthday = birthdaySerialized != null
    //             ? new SimpleObjectProperty<>(LocalDate.parse(birthdaySerialized, DateTimeFormatter.ISO_LOCAL_DATE))
    //             : new SimpleObjectProperty<>(null);
    //     this.phoneNumber = new SimpleStringProperty(phoneNumberSerialized != null ? phoneNumberSerialized : "");
    //     this.phoneNumberProfessional = new SimpleStringProperty(
    //             phoneNumberProfessionalSerialized != null ? phoneNumberProfessionalSerialized : "");
    //     this.nickname = new SimpleStringProperty(nicknameSerialized != null ? nicknameSerialized : "");
    //     this.email = new SimpleStringProperty(emailSerialized != null ? emailSerialized : "");
    //     this.postalCode = new SimpleStringProperty(postalCodeSerialized != null ? postalCodeSerialized : "");
    //     this.github = new SimpleStringProperty(githubSerialized != null ? githubSerialized : "");
    // }

    public void exportToVCard(String filePath) {
        StringBuilder vCardBuilder = new StringBuilder();
        vCardBuilder.append("BEGIN:VCARD\n");
        vCardBuilder.append("VERSION:4.0\n");
        vCardBuilder.append("FN:").append(getName()).append(" ").append(getSurname()).append("\n");
        vCardBuilder.append("N:").append(getSurname()).append(";").append(getName()).append(";;;\n");
        vCardBuilder.append("ADR:;;").append(getAdress()).append(";").append(getCity()).append(";")
                .append(getPostalCode()).append(";;\n");
        vCardBuilder.append("TEL:").append(getPhoneNumber()).append("\n");
        vCardBuilder.append("TEL;TYPE=WORK:").append(getPhoneNumberProfessional()).append("\n");
        vCardBuilder.append("EMAIL:").append(getEmail()).append("\n");
        if (getGithub() != null && !getGithub().isEmpty()) {
            vCardBuilder.append("URL:").append(getGithub()).append("\n");
        }
        if (getBirthday() != null) {
            vCardBuilder.append("BDAY:").append(getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE)).append("\n");
        }
        if (getGender() != null && !getGender().isEmpty()) {
            vCardBuilder.append("GENDER:").append(getGender()).append("\n");
        }
        vCardBuilder.append("END:VCARD\n");

        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            fos.write(vCardBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.get().compareTo(o.getName());
    }
}
