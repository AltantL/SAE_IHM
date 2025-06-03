package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.LectureScenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Resultat extends VBox {

    private static ArrayList<Map> testResultat1;

    public Resultat() {
        Label labelTitre = new Label("Resultat");

        this.getChildren().add(labelTitre);

    }

    public void affichageResultat (String senario) throws IOException {

        ArrayList<Map> testResultat;
        testResultat = LectureScenario.regrouperParVille(senario+".txt");
        System.out.println(testResultat);
        testResultat1 = testResultat;
        Label testResultat2 = new Label(testResultat1.toString());
        this.getChildren().add(testResultat2);

    }
}
