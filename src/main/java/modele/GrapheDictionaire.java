package modele;

import java.util.*;

public class GrapheDictionaire {
    private Map<String, List<String>> mapSommetsVoisins;

    public GrapheDictionaire(Map<String, ArrayList<String>> structure) {
        mapSommetsVoisins = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : structure.entrySet()) {
            mapSommetsVoisins.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        for (List<String> voisins : structure.values()) {
            for (String voisin : voisins) {
                mapSommetsVoisins.putIfAbsent(voisin, new ArrayList<>());
            }
        }
    }


}
