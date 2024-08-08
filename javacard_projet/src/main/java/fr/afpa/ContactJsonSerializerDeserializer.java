package fr.afpa;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ContactJsonSerializerDeserializer {
    
    // Sérialisation Objet Java vers JSON
    public void serialize(List<Contact> contacts, String filename) throws IOException {

        Contact contact = new Contact("Toto", "Tata", "69 rue toto", "Male", LocalDate.of(2020, 5, 13), "Tota",
                "123456789",
                "987654321", "john.doe@example.com", "Bordeaux", "12345", "https://github.com/Hadja-Hawa-BAH/");

                // Contact contacts = new Contact();
                // contacts.getName().


        ObjectMapper mapper = new ObjectMapper();
        // activation du module Jackson pour les LocalDate

        mapper.registerModule(new JavaTimeModule());
        try {
            // Création du fichier json
            File file = new File("contacts.json");

            mapper.writeValue(file, contact);
            System.out.println("les données sont enregistrées dans: " + file.getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // // Déserialisation du contenu JSON en un objet java
        // Contact deserializedContact = mapper.readValue(new File(filePath),
        // Contact.class);
        // System.out.println(deserializedContact.getName());

    }

}
