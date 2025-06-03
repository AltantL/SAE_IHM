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

        Map<String, String> dicoMembresVilles = LectureScenario.lectureVilleDesMembres();  // contient touts les couple vendeur -> acheteur
        Map<String, ArrayList<String>> graphe = new HashMap<>();
        ArrayList<String> villesContenantPlus = new ArrayList<>();
        ArrayList<String> membre = new ArrayList<>();
        String villeDuMembreAvecMoins = new String();
        ArrayList<String> villeDuMembreAvecMoinsAjout = new ArrayList<>();


        for (String villeAvecPlus : villeVendeurPlus.keySet()) {
            villesContenantPlus.add(villeAvecPlus);

        }
        graphe.put("Velizy+", (ArrayList<String>) villesContenantPlus);
        for (String villePlusDuGraphe : graphe.get("Velizy+")) {
            membre = villeVendeurPlus.get(villePlusDuGraphe); // on recupère les membres pour chaque villes +
            for (String membreParcours : membre) {
                villeDuMembreAvecMoins = dicoMembresVilles.get(membre) + "-";
                villeDuMembreAvecMoinsAjout.add(villeDuMembreAvecMoins);
                graphe.put(villePlusDuGraphe,villeDuMembreAvecMoinsAjout);
            }




        }
        System.out.println(dicoMembresVilles);
        System.out.println(graphe);
        System.out.println(villeAcheteurMoins);
        System.out.println(villeVendeurPlus);

    }
}
