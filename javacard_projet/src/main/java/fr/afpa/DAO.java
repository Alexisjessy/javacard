package fr.afpa;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    
    public Connection connection = ConnectionBDD.getInstance();
    
    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T getById(long id);
    
    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T addContact(T obj);
    
    /**
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     */
    public abstract T update(T obj);
    
    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract void delete(T obj);

     /**
     * Permet de selectionner tous les contacts d'une entrée de la base
     * @param obj
     */
    public abstract List<Contact> getAll();
}


