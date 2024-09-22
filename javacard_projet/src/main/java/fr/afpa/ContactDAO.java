package fr.afpa;

import java.util.List;

public interface ContactDAO {
    void saveContact(Contact contact);      // Sauvegarder un contact
    Contact getContactById(int id);         // Obtenir un contact par ID
    List<Contact> getAllContacts();         // Obtenir tous les contacts
    void addContact(Contact contact);       //Ajouter un nouveau contact
    void updateContact(Contact contact);    // Mettre à jour un contact
    void deleteContact(int id);             // Supprimer un contact
}
