package client;

import modele.GrapheDictionaire;
import modele.GrapheLivraison;
import modele.LectureScenario;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientGrapheDictionaire {
    public static void main(String[] args) throws IOException {
        Map<String, ArrayList<String>> donnees = GrapheLivraison.grapheLivraison("scenario_0.txt");
        HashMap<String, HashMap<String, Integer>> distance = LectureScenario.lectureDistance();

        Integer test = LectureScenario.getDistance(distance,"Amiens","Amiens");

        System.out.println(test);
        GrapheDictionaire graphe = new GrapheDictionaire(donnees);
        List<String> ordre = graphe.triTopologique();  // contient le tri
        Integer testDistanceTot = LectureScenario.calculerDistanceTotale(ordre,distance); // contient la distance total du tri
        System.out.println(testDistanceTot);
        System.out.println(ordre);


    }
}

