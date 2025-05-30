package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.LectureScenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Resultat extends VBox {

    public ArrayList<Map> testResultat1;

    public Resultat() {
        Label labelTitre = new Label("Resultat");

        testResultat1 = new ArrayList<>();
        String testResultat2 = testResultat1.toString();
        Label testResultat3 = new Label(testResultat2);

        this.getChildren().add(labelTitre);
        this.getChildren().add(testResultat3);


    }

    public void affichageResultat (String senario) throws IOException {

        ArrayList<Map> testResultat;
        testResultat = LectureScenario.regrouperParVille(senario);
        System.out.println(testResultat);
        testResultat1 = testResultat;
    }
}
