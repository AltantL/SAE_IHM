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

    public List<String> triTopologique() {
        Map<String, Integer> degresEntrant = degreEntrant();
        List<String> sources = degreEntrantZero();
        List<String> resultat = new ArrayList<>();

        while (!sources.isEmpty()) {
            String source = sources.remove(0);
            resultat.add(source);

            for (String voisin : mapSommetsVoisins.getOrDefault(source, Collections.emptyList())) {
                degresEntrant.put(voisin, degresEntrant.get(voisin) - 1);
                if (degresEntrant.get(voisin) == 0) {
                    sources.add(voisin);
                }
            }
        }

        if (resultat.size() != mapSommetsVoisins.size()) {
            throw new IllegalStateException("Le graphe contient un cycle, tri topologique impossible");
        }

        return resultat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sommets : ").append(getSommets().size()).append("\n");
        for (Map.Entry<String, List<String>> entry : mapSommetsVoisins.entrySet()) {
            sb.append("Sommet ").append(entry.getKey())
                    .append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

