package fr.afpa;

import java.sql.Connection;
import java.util.List;


public interface DAOInterface<T> {
    public Connection conn = DbConnection.getInstance();

    T getById(int id);         // Obtenir un contact par ID
    List<T> getAll();         // Obtenir tous les contacts
    void add(T object);       //Ajouter un nouveau contact
    void update(T object);    // Mettre à jour un contact
    void delete(int id);             // Supprimer un contact
}
