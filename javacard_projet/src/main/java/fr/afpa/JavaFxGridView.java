
package fr.afpa;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class JavaFxGridView extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(JavaFxGridView.class.getResource("contact.-2.fxml"));
        Parent root = (Parent) loader.load();
        final FXMLViewController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Formulaire de Contact");
        stage.getIcons().add(new Image("https://th.bing.com/th/id/R.89027f344393f7a12327413b4aa7cb26?rik=h9mPqEYfhctGfw&riu=http%3a%2f%2f1000logos.net%2fwp-content%2fuploads%2f2017%2f05%2fPlayboy-symbol.jpg&ehk=NMh359TsTdB6FXv9waahFuPIsWTVguYN9pzXUnaVvTM%3d&risl=&pid=ImgRaw&r=0"));
        stage.show();
       
    }

    public static void main(String[] args) {
        launch(args);
    }

}