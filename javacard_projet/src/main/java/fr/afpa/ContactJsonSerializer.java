// package fr.afpa;

// import java.io.File;
// import java.io.IOException;
// import java.time.LocalDate;
// import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// public class ContactJsonSerializer {
  
//     // Sérialisation Objet Java vers JSON
//     public void serialize(List<Contact> contacts, String filename) throws IOException {

//         Contact contacts = new Contact(name, surname, city, adress, gender, birthday, nickname, phoneNumber,
//         phoneNumberProfessional, email, postalCode, github);

//         contacts.add(contacts);


//         ObjectMapper mapper = new ObjectMapper();
//         // activation du module Jackson pour les LocalDate

//         mapper.registerModule(new JavaTimeModule());
//         try {
//             // Création du fichier json
//             File file = new File("contacts.json");

//             mapper.writeValue(file, contacts);
//             System.out.println("les données sont enregistrées dans: " + file.getAbsolutePath());

//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }

//         // // Déserialisation du contenu JSON en un objet java
//         // Contact deserializedContact = mapper.readValue(new File(filePath),
//         // Contact.class);
//         // System.out.println(deserializedContact.getName());

//     }

// }