
package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxGridView extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(JavaFxGridView.class.getResource("contact.fxml"));
        Parent root = (Parent) loader.load();
        final FXMLViewController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Formulaire de Contact");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}