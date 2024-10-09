package fr.afpa;

import java.time.LocalDate;
import java.util.List;

public class ContactService {

    private DAOInterface contactDAO;

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
        
        contactDAO.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAll();
    }

    public void updateContact(int id, String name, String surname, String city, String adress, String gender, LocalDate birthday, String nickname, String phoneNumber, String phoneNumberProfessional, String email, String postalCode, String github) {
        Contact contact = (Contact) contactDAO.getById(id);
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

            contactDAO.update(contact);
        } else {
            System.out.println("Contact not found with ID: " + id);
        }
    }

    public void deleteContact(int id) {
        contactDAO.delete(id);
    }

    public Contact getContactById(int id) {
        return (Contact) contactDAO.getById(id);
    }
}
