package client;

import modele.ExempleLectureSenario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClientExempleSenario {

    static ArrayList<String> liste = new ArrayList<>();

    public static void main(String[] args) {
        liste.add("Psykokwak");
        liste.add("Jungko");
        liste.add("Méditikka");
        liste.add("Spinda");
        try {
//            ExempleLectureSenario.lectureScenario("scenario_0.txt");
//            ExempleLectureSenario.lectureScenarioVille("scenario_0.txt");
//            ExempleLectureSenario.lectureScenarioMembre();
//            ExempleLectureSenario.lectureScenarioMembreCible(liste);
            ExempleLectureSenario.regroupementParVille(liste);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}