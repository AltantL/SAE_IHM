package modele;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LectureScenario {


    public static void lectureScenario (String scenrio) throws IOException {

        File file = new File("scenarios" + File.separator + scenrio);
        Scanner scannerFile = new Scanner(file);
        Scanner scannerLine;


        while(scannerFile.hasNextLine()) {
            String Line = scannerFile.nextLine();
            scannerLine = new Scanner(Line).useDelimiter(" ");
            String vendeur = scannerLine.next();
            scannerLine.next(); // "->"
            String achteur = scannerLine.next();
            System.out.println("vendeur: " + vendeur + " -> " + " achteur: " + achteur);
            scannerLine.close();
        }
        scannerFile.close();
        //return scenario;
    }

    public static void lectureScenarioMembre () throws IOException {

        File file = new File("ressources" + File.separator + "membres_APPLI.txt");

        Scanner scannerFile = new Scanner(file);
        Scanner scannerLine;


        while(scannerFile.hasNextLine()) {
            String Line = scannerFile.nextLine();
            scannerLine = new Scanner(Line);
            String pseaudo = scannerLine.next();
            String ville = scannerLine.next();
            System.out.println("pseaudo: " + pseaudo + " -> " + " ville: " + ville);
            scannerLine.close();
        }
        scannerFile.close();
        //return scenario;
    }

    public static Map lectureScenarioMembreCible (ArrayList<String> membre) throws IOException {

        Map<String, String> dico = new HashMap<>();

        File file = new File("ressources" + File.separator + "membres_APPLI.txt");

        Scanner scannerFile = new Scanner(file);
        Scanner scannerLine;

        while(scannerFile.hasNextLine()) {
            String Line = scannerFile.nextLine();
            scannerLine = new Scanner(Line);
            String pseaudo = scannerLine.next();
            String ville = scannerLine.next();
            dico.put(pseaudo, ville);
            scannerLine.close();
        }

        for (int i=0; i<membre.size(); i++) {
            if (dico.containsKey(membre.get(i))){
                System.out.println("pseaudo: " + membre.get(i) + " -> " + " ville: " + dico.get(membre.get(i)));
            }
        }
        return dico;
    }

    public static void regroupementParVille(ArrayList<String> membre) throws IOException {
        Map dico = lectureScenarioMembreCible(membre);

        Map<String ,ArrayList<String>> regroupement = new HashMap<>();

        for (int i=0; i<membre.size(); i++) {
            String ville = dico.get(membre.get(i)).toString();
            if (!regroupement.containsKey(ville)) {
                regroupement.put(ville, new ArrayList<>());
            }
            regroupement.get(dico.get(membre.get(i))).add(membre.get(i));
        }
        System.out.println(regroupement);
    }

    public static List[] lectureScenarioVille (String scenrio) throws IOException {


        File file = new File("scenarios" + File.separator + scenrio);

        Scanner scannerFile = new Scanner(file);
        Scanner scannerLine;

        ArrayList<String> achteurm = new ArrayList<>();
        ArrayList<String> vendeurm = new ArrayList<>();

        while(scannerFile.hasNextLine()) {
            String Line = scannerFile.nextLine();
            scannerLine = new Scanner(Line).useDelimiter(" ");
            String vendeur = scannerLine.next();
            vendeurm.add(vendeur);
            scannerLine.next(); // "->"
            String achteur = scannerLine.next();
            achteurm.add(achteur);
            System.out.println("vendeur: " + vendeur + " -> " + " achteur: " + achteur);
            scannerLine.close();
        }

        scannerFile.close();
        //return scenario;
        //System.out.println(vendeurm);
        //System.out.println(achteurm);

        lectureScenarioMembreCible(achteurm);
        lectureScenarioMembreCible(vendeurm);


        return new List[] {achteurm, vendeurm};

    }

    public static void lectureDistance() throws IOException {
        File file = new File("ressources" + File.separator + "distances.txt");
        Scanner scannerFile = new Scanner(file);
        HashMap<String, ArrayList<Integer>> villesDistances = new HashMap<>(); // nomville : listdistance
        ArrayList<String> listeVille = new ArrayList<>(); // liste de toutes les villes
        while (scannerFile.hasNextLine()) {
            Scanner scannerLine = new Scanner(scannerFile.nextLine());
            String ville = scannerLine.next();
            listeVille.add(ville);
            ArrayList<Integer> distances = new ArrayList<>();
            while (scannerLine.hasNextInt()) {
                distances.add(scannerLine.nextInt());
            }
            villesDistances.put(ville, distances);
            scannerLine.close();
        }
        scannerFile.close();
        HashMap<String, HashMap<String, Integer>> distancesParVille = new HashMap<>();
        for (String villeSource : listeVille) {
            ArrayList<Integer> distances = villesDistances.get(villeSource);
            HashMap<String, Integer> versAutres = new HashMap<>();
            for (int i = 0; i < listeVille.size(); i++) {
                versAutres.put(listeVille.get(i), distances.get(i));
            }
            distancesParVille.put(villeSource, versAutres);
        }
        for (String ville : listeVille) {
            System.out.print(ville + " : ");
            for (String autreVille : listeVille) {
                System.out.print(autreVille + "=" + distancesParVille.get(ville).get(autreVille) + "km, ");
            }
            System.out.println();
        }
    }

    public static void regrouperParVilleEtDistance(String scenario) throws IOException {
        List[] achven = lectureScenarioVille(scenario);

        List achteurL = achven[0];
        List vendeurL = achven[1];

        ArrayList<String> achteur = new ArrayList<>();
        ArrayList<String> vendeur = new ArrayList<>();

        for (int i = 0; i < achteurL.size(); i++) {
            achteur.add(achteurL.get(i).toString());
            vendeur.add(vendeurL.get(i).toString());
        }

        System.out.println(achteur);
        System.out.println(vendeur);

        regroupementParVille(achteur);
        regroupementParVille(vendeur);
    }



}