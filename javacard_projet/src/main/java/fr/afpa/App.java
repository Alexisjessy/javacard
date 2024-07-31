package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

        //Sérialisation JSON
        Contact contact = new Contact()
        contact.setName("Toto");
        contact.setSurname("Tata");
        contact.setAddress("69 rue toto");
        contact.setGender("Male");
        contact., LocalDate.of(2000, 2, 4), "Tota", "123456789",
                "987654321", "john.doe@example.com", "Bordeaux", "12345", "johnDoeGitHub");
    }

}