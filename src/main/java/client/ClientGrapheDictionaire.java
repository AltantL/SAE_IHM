package client;

import modele.GrapheDictionaire;
import modele.GrapheLivraison;
import modele.Scenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientGrapheDictionaire {
    public static void main(String[] args) throws IOException {
        Map<String, ArrayList<String>> donnees = GrapheLivraison.grapheLivraison("scenario_0.txt");
        GrapheDictionaire graphe = new GrapheDictionaire(donnees);
        List<String> ordre = graphe.triTopologique();
        System.out.println(ordre);

    }
}

