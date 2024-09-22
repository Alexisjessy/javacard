package fr.afpa;

import java.time.LocalDate;
import java.util.List;

public class ContactService {

    private ContactDAO contactDAO;

    public ContactService() {
        this.contactDAO = new ContactDAOImpl(); 
    }

    public void addContact(String name, String surname, String city, String adress, String gender, LocalDate birthday, String nickname, String phoneNumber, String phoneNumberProfessional, String email, String postalCode, String github) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setCity(city);
        contact.setAdress(adress);
        contact.setGender(gender);
        contact.setBirthday(birthday);
        contact.setNickname(nickname);
        contact.setPhoneNumber(phoneNumber);
        contact.setPhoneNumberProfessional(phoneNumberProfessional);
        contact.setEmail(email);
        contact.setPostalCode(postalCode);
        contact.setGithub(github);
        
        contactDAO.addContact(contact);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    public void updateContact(int id, String name, String surname, String city, String adress, String gender, LocalDate birthday, String nickname, String phoneNumber, String phoneNumberProfessional, String email, String postalCode, String github) {
        Contact contact = contactDAO.getContactById(id);
        if (contact != null) {
            contact.setName(name);
            contact.setSurname(surname);
            contact.setCity(city);
            contact.setAdress(adress);
            contact.setGender(gender);
            contact.setBirthday(birthday);
            contact.setNickname(nickname);
            contact.setPhoneNumber(phoneNumber);
            contact.setPhoneNumberProfessional(phoneNumberProfessional);
            contact.setEmail(email);
            contact.setPostalCode(postalCode);
            contact.setGithub(github);

            contactDAO.updateContact(contact);
        } else {
            System.out.println("Contact not found with ID: " + id);
        }
    }

    public void deleteContact(int id) {
        contactDAO.deleteContact(id);
    }

    public Contact getContactById(int id) {
        return contactDAO.getContactById(id);
    }
}
