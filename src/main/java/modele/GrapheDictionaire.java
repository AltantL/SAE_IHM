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
    public Set<String> getSommets() {
        return mapSommetsVoisins.keySet();
    }

    public Map<String, Integer> degreEntrant() {
        Map<String, Integer> degresEntrant = new HashMap<>();
        for (String sommet : getSommets()) {
            degresEntrant.put(sommet, 0);
        }
        for (List<String> voisins : mapSommetsVoisins.values()) {
            for (String voisin : voisins) {
                degresEntrant.put(voisin, degresEntrant.getOrDefault(voisin, 0) + 1);
            }
        }

        return degresEntrant;
    }
    public List<String> degreEntrantZero() {
        Map<String, Integer> degresEntrant = degreEntrant();
        List<String> sources = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : degresEntrant.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        return sources;
    }



}
