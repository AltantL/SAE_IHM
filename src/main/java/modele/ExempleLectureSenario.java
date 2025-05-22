package modele;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExempleLectureSenario {
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
            if (dico.get(membre.get(i))!=null) {
                String ville = dico.get(membre.get(i)).toString();
                regroupement.put(ville, new ArrayList<>());
            }
            regroupement.get(dico.get(membre.get(i))).add(membre.get(i));
        }
        System.out.println(regroupement);
    }

    public static void lectureScenarioVille (String scenrio) throws IOException {


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
        System.out.println(vendeurm);
        System.out.println(achteurm);

        lectureScenarioMembreCible(achteurm);
        lectureScenarioMembreCible(vendeurm);

    }
    public static void lectureDistance(String scenario) throws IOException {
        File file = new File("ressources" + File.separator + scenario );
        Scanner scannerFile = new Scanner(file);
        Scanner scannerLine;
        HashMap<String, ArrayList<Integer>> villesDistances = new HashMap<>();
        ArrayList<String> listeVille = new ArrayList<>();
        while (scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            scannerLine = new Scanner(line);
            String ville = scannerLine.next();
            listeVille.add(ville);
            ArrayList<Integer> distances = new ArrayList<>();
            while (scannerLine.hasNextInt()) {
                distances.add(scannerLine.nextInt());
            }
            villesDistances.put(ville, distances);
            System.out.println("Ville: " + ville + " -> Distances: " + villesDistances.get(ville) + listeVille);
            scannerLine.close();
        }
        scannerFile.close();

    }



}