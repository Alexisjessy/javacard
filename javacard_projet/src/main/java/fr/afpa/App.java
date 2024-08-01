package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("contact"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

        //Sérialisation Objet Java vers JSON
        Contact contact = new Contact("Titi", "Tutu", "56 rue titi", "Female", LocalDate.of(2002, 9, 24), "Titu",
                "123456789", "987654321", "jane.doe@example.com", "Begles", "12345", "janeDoeGitHub");
var mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).registerModule(new JavaTimeModule());


    //     Contact contact = new Contact();
    //     contact.setName("Toto");
    //     contact.setSurname("Tata");
    //     contact.setAddress("69 rue toto");
    //     contact.setGender("Male");
    //     contact.setBirthday(LocalDate.of(2000, 2, 4));
    //     contact.setNickname("Tota");
    //     contact.setPhoneNumber("123456789");
    //     contact.setPhoneNumberProfessional("987654321");
    //     contact.setEmail("john.doe@example.com");
    //    // contact.setCity("Bordeaux");
    //     contact.setPostalCode("12345");
    //     contact.setGithub("johnDoeGitHub");

     //Chemin du fichier pour stocker nos données JSON  (à revoir)
    String filePath = "scr/test/resources/protocols/jackson_contact.json";
        
    //Stockage de l'objet contact dans un fchier JSON à l'aide de la classe ObjectMapper
    File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, contact);

        //Déserialisation du contenu JSON en un objet java
        Contact deserializedContact = mapper.readValue(new File(filePath), Contact.class);
        assertEquals("Toto", deserializedContact.getName());
    }

   

}