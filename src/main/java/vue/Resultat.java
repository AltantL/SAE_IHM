package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.GrapheDictionaire;
import modele.GrapheLivraison;
import modele.LectureScenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultat extends VBox {

    public Resultat() {
        Label labelTitre = new Label("Resultat");
        this.getChildren().add(labelTitre);
    }

    public void nettoyage(){
        this.getChildren().clear();
    }

    public void affichageResultat (String senario) throws IOException {

        String algo = HBoxSelectionAlgo.getComboAlgo();

        Map<String, ArrayList<String>> donnees = GrapheLivraison.grapheLivraison(senario);
        GrapheDictionaire graphe = new GrapheDictionaire(donnees);
        List<String> testResultat = null;
        HashMap<String, HashMap<String, Integer>> distance = LectureScenario.lectureDistance();

        if (algo.equals("triTopologique")){
            testResultat = graphe.triTopologique();
        }
        if (algo.equals("heuristique")){
            testResultat = graphe.heuristique();
        }
        if (algo.equals("triAStar")){
            testResultat = graphe.triAStar(distance);
        }

        List<String> ordre = testResultat;

        Integer testDistance = LectureScenario.calculerDistanceTotale(ordre,distance);

        Label labelalgo = new Label("Algorithme utiliser : " + algo);
        Label labelDistance = new Label("Distance : " + testDistance);
        Label testResultat2 = new Label("Trajet : " + testResultat);

        this.getChildren().add(labelalgo);
        this.getChildren().add(labelDistance);
        this.getChildren().add(testResultat2);

    }
}
