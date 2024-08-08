package fr.afpa;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public class ContactJsonSerializer {
    // public ContactJsonSerializer(){};
  
    // Sérialisation Objet Java vers JSON
    public void exportToJson(ObservableList<Contact> contacts, String filename) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        // activation du module Jackson pour les LocalDate

        mapper.registerModule(new JavaTimeModule());
        try {
            // Création du fichier json
            File file = new File(filename);

            if (contacts.size() > 1){
                mapper.writeValue(file, contacts);

            } else {
                mapper.writeValue(file, contacts.getFirst());
            }
            System.out.println("les données sont enregistrées dans: " + file.getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}