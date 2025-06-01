package modele;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
        for (String ville : villeVendeurPlus.keySet()) {
            if (!nomToIndice.containsKey(ville)) {
                nomToIndice.put(ville, index);
                indiceToNom.put(index, ville);
                index++;
            }
            for (String voisin : villeVendeurPlus.get(ville)) {
                if (!nomToIndice.containsKey(voisin)) {
                    nomToIndice.put(voisin, index);
                    indiceToNom.put(index, voisin);
                    index++;
                }
            }
        }

        int nbSommets = nomToIndice.size();
        int[][] tableauVoisins = new int[nbSommets][];
        for (int i = 0; i < nbSommets; i++) {
            tableauVoisins[i] = new int[0];
        }
        for (String ville : villeVendeurPlus.keySet()) {
            int sommet = nomToIndice.get(ville);
            ArrayList<String> voisinsNoms = villeVendeurPlus.get(ville);
            int[] voisinsIndices = new int[voisinsNoms.size()];
            for (int i = 0; i < voisinsNoms.size(); i++) {
                voisinsIndices[i] = nomToIndice.get(voisinsNoms.get(i));
            }
            tableauVoisins[sommet] = voisinsIndices;
        }
        graphe = new Graphe(tableauVoisins);
    }



}