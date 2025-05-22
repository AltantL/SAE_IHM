package vue;

import modele.Scenario;

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

    public static void lectureScenarioMembreCible (ArrayList<String> membre) throws IOException {

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


        //return scenario;
        for (int i=0; i<dico.size(); i++) {
            while (scannerFile.hasNextLine()) {
                if (dico.containsKey(membre.get(i))){
                    System.out.println("pseaudo: " + dico.get(membre.get(i)) + " -> " + " ville: " + dico.get(membre.size()));
                }
                scannerFile.close();
            }

        }

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
}