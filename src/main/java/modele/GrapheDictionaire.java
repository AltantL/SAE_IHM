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

    public List<String> degreEntrantZero(Map<String, Integer> degresEntrant) {
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
        List<String> sources = degreEntrantZero(degresEntrant);
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
            throw new IllegalStateException("Le graphe contient un cycle");
        }

        return resultat;
    }

    //  Heuristique Gloutonne

    public List<String> heuristique() {
        Map<String, Integer> degresEntrant = degreEntrant();
        PriorityQueue<String> sources = new PriorityQueue<>(); // ordre alphabétique
        sources.addAll(degreEntrantZero(degresEntrant));
        List<String> resultat = new ArrayList<>();

        while (!sources.isEmpty()) {
            String source = sources.poll(); // plus petit (ex: par nom)
            resultat.add(source);

            for (String voisin : mapSommetsVoisins.getOrDefault(source, Collections.emptyList())) {
                degresEntrant.put(voisin, degresEntrant.get(voisin) - 1);
                if (degresEntrant.get(voisin) == 0) {
                    sources.add(voisin);
                }
            }
        }

        if (resultat.size() != mapSommetsVoisins.size()) {
            throw new IllegalStateException("Cycle détecté dans l'heuristique rapide");
        }

        return resultat;
    }

    // Meilleures Solutions

    public List<String> triAStar(HashMap<String, HashMap<String, Integer>> distances) {
        class Etat implements Comparable<Etat> {
            List<String> chemin;
            int coutG; // distance réelle
            int coutF; // f(n) = g(n) + h(n)

            Etat(List<String> chemin, int coutG, int coutF) {
                this.chemin = chemin;
                this.coutG = coutG;
                this.coutF = coutF;
            }

            public int compareTo(Etat autre) {
                return Integer.compare(this.coutF, autre.coutF);
            }
        }

        Map<String, Integer> degresEntrant = degreEntrant();

        PriorityQueue<Etat> openSet = new PriorityQueue<>();
        for (String source : degreEntrantZero(degresEntrant)) {
            List<String> cheminInit = new ArrayList<>();
            cheminInit.add(source);
            openSet.add(new Etat(cheminInit, 0, 0));
        }

        while (!openSet.isEmpty()) {
            Etat courant = openSet.poll();
            List<String> chemin = courant.chemin;

            if (chemin.size() == mapSommetsVoisins.size()) {
                return chemin;
            }

            Map<String, Integer> degresActuels = degreEntrant();
            for (String s : chemin) {
                for (String voisin : mapSommetsVoisins.get(s)) {
                    degresActuels.put(voisin, degresActuels.get(voisin) - 1);
                }
                degresActuels.put(s, -1); // marquer comme déjà pris
            }

            List<String> sourcesPossibles = new ArrayList<>();
            for (String sommet : mapSommetsVoisins.keySet()) {
                if (degresActuels.get(sommet) != null && degresActuels.get(sommet) == 0 && !chemin.contains(sommet)) {
                    sourcesPossibles.add(sommet);
                }
            }

            for (String next : sourcesPossibles) {
                List<String> nouveauChemin = new ArrayList<>(chemin);
                nouveauChemin.add(next);

                int distanceG = LectureScenario.calculerDistanceTotale(nouveauChemin, distances);
                int heuristique = 0; // heuristique admissible minimale
                int distanceF = distanceG + heuristique;

                openSet.add(new Etat(nouveauChemin, distanceG, distanceF));
            }
        }

        return new ArrayList<>(); // aucun chemin trouvé (si cycles ou données invalides)
    }
}



