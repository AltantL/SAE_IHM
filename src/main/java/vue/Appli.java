package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.File;

public class Appli extends Application {

    public void start(Stage stage) {

        stage.setTitle("APPLI");
        Accueil accueil = new Accueil();

        Scene scene = new Scene(accueil,690, 338);
        File [] css = new File("css").listFiles();
        for(File fichier : css){
            scene.getStylesheets().add(fichier.toURI().toString());
         }
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}