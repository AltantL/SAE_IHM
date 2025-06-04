package modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LectureScenarioTest {

    private HashMap<String, HashMap<String, Integer>> distances;

    @BeforeEach
    void setUp() {
        distances = new HashMap<>();

        HashMap<String, Integer> depuisParis = new HashMap<>();
        depuisParis.put("Lyon", 400);
        depuisParis.put("Marseille", 775);
        distances.put("Paris", depuisParis);

        HashMap<String, Integer> depuisLyon = new HashMap<>();
        depuisLyon.put("Marseille", 350);
        depuisLyon.put("Paris", 400);
        distances.put("Lyon", depuisLyon);

        HashMap<String, Integer> depuisMarseille = new HashMap<>();
        depuisMarseille.put("Paris", 775);
        depuisMarseille.put("Lyon", 350);
        distances.put("Marseille", depuisMarseille);
    }

    @AfterEach
    void tearDown() {
        distances.clear();
    }

    @Test
    void testCheminSimpleAvecPlusEtMoins() {
        List<String> chemin = Arrays.asList("Paris+", "Lyon+", "Marseille-", "Paris-");
        int resultat = LectureScenario.calculerDistanceTotale(chemin, distances);
        // Paris -> Lyon = 400, Lyon -> Marseille = 350, Marseille -> Paris = 775
        assertEquals(1525, resultat);
    }
    @Test
    void testCheminBidirectionnelInverse() {
        List<String> chemin = Arrays.asList("Marseille+", "Lyon-", "Paris-");
        int resultat = LectureScenario.calculerDistanceTotale(chemin, distances);
        // Marseille -> Lyon = 350, Lyon -> Paris = 400
        assertEquals(750, resultat);
    }
}