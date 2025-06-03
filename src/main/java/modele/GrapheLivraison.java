package modele;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static modele.LectureScenario.*;


public class GrapheLivraison {
    public static void grapheLivraison(String scenario) throws IOException {
        List[] achven = lectureScenarioVille(scenario);

        List achteurL = achven[0];
        List vendeurL = achven[1];

        ArrayList<String> acheteur = new ArrayList<>();
        ArrayList<String> vendeur = new ArrayList<>();

        for (int i = 0; i < achteurL.size(); i++) {
            acheteur.add(achteurL.get(i).toString());
            vendeur.add(vendeurL.get(i).toString());
        }

        Map<String ,ArrayList<String>> villeAcheteur = regroupementParVille(acheteur); // -
        Map<String ,ArrayList<String>> villeVendeur = regroupementParVille(vendeur); // +

        Map<String ,ArrayList<String>> villeAcheteurMoins = new HashMap<>();
        Map<String ,ArrayList<String>> villeVendeurPlus = new HashMap<>();
//        for(int i = 0; i < villeAcheteur.size(); i++){
//            villeAcheteurMoins.put(String.valueOf(villeAcheteur.get(i)) + "-",new ArrayList<>());
//            villeAcheteurMoins.get(.put(villeAcheteur.get(i)));
//
//        }
        for (String ville : villeAcheteur.keySet()) {
            String villeMoins = ville + "-";
            ArrayList<String> listeAcheteurs = villeAcheteur.get(ville);
            villeAcheteurMoins.put(villeMoins, new ArrayList<>(listeAcheteurs));
        }
        for (String ville : villeVendeur.keySet()) {
            String villeMoins = ville + "+";
            ArrayList<String> listeVendeurs = villeVendeur.get(ville);
            villeVendeurPlus.put(villeMoins, new ArrayList<>(listeVendeurs));
        }

        Map<String, String> dicoMembresVilles = LectureScenario.lectureVilleDesMembres();  // contient touts les couple membres -> villes
        Map<String, String> dicoAcheteurVersVendeur = LectureScenario.lectureVendeurVersAcheteur(scenario);
        System.out.println(dicoMembresVilles);
        Map<String, ArrayList<String>> graphe = new HashMap<>();
        ArrayList<String> villesContenantPlus = new ArrayList<>();
        for (String villeAvecPlus : villeVendeurPlus.keySet()) {
            villesContenantPlus.add(villeAvecPlus);

        }
        graphe.put("Velizy+", (ArrayList<String>) villesContenantPlus);

        for (String villePlusDuGraphe : graphe.get("Velizy+")) {
            ArrayList<String> membresAjouts = new ArrayList<>();
            ArrayList<String> membresQuiAchete = new ArrayList<>();
            ArrayList<String> villeDesMembresQuiAchete = new ArrayList<>();

            List<String> membre = villeVendeurPlus.get(villePlusDuGraphe);// on recupère les membres pour chaque villes +

            for (String membreParcours : membre) {
                membresAjouts.add(membreParcours);
            }
            for (String vendeursDesVillesPlus : membresAjouts){
                //System.out.println(dicoAcheteurVersVendeur.get(vendeursDesVillesPlus));
                membresQuiAchete.add(dicoAcheteurVersVendeur.get(vendeursDesVillesPlus));// on regarde pour chauqe vendeur à qui ils vendent
            }
            for (String parcoursMembresQuiAchete : membresQuiAchete) {
                villeDesMembresQuiAchete.add(dicoMembresVilles.get(parcoursMembresQuiAchete) + "-");

            }

            graphe.put(villePlusDuGraphe,villeDesMembresQuiAchete);
        }
        //Boucle qui va parcourir la liste de tous les villes achteurs et va mettre un lien avec Velizy-
        for (String ville : villeAcheteurMoins.keySet()) {
            ArrayList<String> velizyMoin = new ArrayList<>();
            velizyMoin.add("Velizy-");
            graphe.put(ville,velizyMoin);
        }
        System.out.println(villeAcheteurMoins);
        System.out.println(villeVendeurPlus);
        System.out.println(graphe);

    }
}
