package modele;

import java.util.*;

public class GrapheDictionaire {
    private TreeMap<Integer, Set<Integer>> mapSommetsVoisins;
    private Map<String, Integer> nomToIndice;
    private Map<Integer, String> indiceToNom;
    private Graphe graphe;
    public GrapheDictionaire(Map<String, ArrayList<String>> villeVendeurPlus) {
        mapSommetsVoisins = new TreeMap<>();
        nomToIndice = new HashMap<>();
        indiceToNom = new HashMap<>();
        int index = 0;
    }
}
