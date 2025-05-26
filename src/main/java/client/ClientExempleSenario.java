package client;

import modele.*;

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
//            LectureScenario.lectureScenario("scenario_0.txt");
            LectureScenario.lectureScenarioVille("scenario_0.txt");
//            LectureScenario.lectureScenarioMembre();
//            LectureScenario.lectureScenarioMembreCible(liste);
            //LectureScenario.regroupementParVille(liste);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}