package fr.afpa;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContactJsonSerializer {
    private ContactJsonSerializer() {
    }

    public static void main(String[] args) throws IOException {

        // Sérialisation Objet Java vers JSON
        Contact contact = new Contact();
        contact.setName("Toto");
        contact.setSurname("Tata");
        contact.setAddress("69 rue toto");
        contact.setGender("Male");
        contact.setBirthday("2000/01/09");
        contact.setNickname("Tota");
        contact.setPhoneNumber("123456789");
        contact.setPhoneNumberProfessional("987654321");
        contact.setEmail("john.doe@example.com");
        contact.setCity("Bordeaux");
        contact.setPostalCode("12345");
        contact.setGithub("johnDoeGitHub");

        // Chemin du fichier pour stocker nos données JSON (à revoir)
        String filePath = "contact.json";

        // Stockage de l'objet contact dans un fchier JSON à l'aide de la classe
        File fileWriter = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        //String json = mapper.writeValueAsString(contact);
         mapper.writeValue(fileWriter,contact);
        System.out.println(fileWriter);

        // // Déserialisation du contenu JSON en un objet java
        Contact deserializedContact = mapper.readValue(new File(filePath), Contact.class);
        System.out.println(deserializedContact.getName());
    }

}
