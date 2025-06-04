package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBoxSelectionAlgo extends HBox {

    private static ComboBox comboScenarios;
    private static ComboBox comboAlgo;

    private static File repertoire = new File("scenarios");
    private static File[] Scenarios = repertoire.listFiles();

    private Resultat resultat = new Resultat();

    public HBoxSelectionAlgo(List<Node> children) {

        GridPane grid = new GridPane();

        Label labelTitre = new Label("SAE JAVA IHM");

        ArrayList arrayListAlgo = new ArrayList();
        arrayListAlgo.add("triTopologique");
        arrayListAlgo.add("heuristique");
        arrayListAlgo.add("triAStar");

        comboAlgo = peupleComboBox(arrayListAlgo);

        comboScenarios = peupleComboBox(getListeScenarios());

        Button bouttonAnnuler = new Button("Annuler");
        //bouttonAnnuler.setOnAction(e -> {Resultat.nettoiage();});

        Button bouttonValider = new Button("Valider");
        bouttonValider.setOnAction(actionEvent -> {
            //Resultat.nettoiage();
            onBoutonValider(resultat);
        });

        Button bouttonRetour = new Button("Retour");
        bouttonRetour.setOnAction(actionEvent -> children.removeLast());


        grid.add(labelTitre, 0, 0);

        grid.add(comboAlgo, 0, 1);

        grid.add(comboScenarios, 1, 1);

        grid.add(bouttonAnnuler, 1, 5);
        grid.add(bouttonValider, 0, 5);
        grid.add(bouttonRetour, 0, 6);

        grid.add(resultat, 5, 0);

        bouttonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboAlgo.setValue("triTopologique");
                comboScenarios.setValue(getListeScenarios().get(0));
            }
        });

        this.getChildren().addAll(grid, resultat);
    }

    private static void onBoutonValider(Resultat resultat) {

        ComboBox numScenario = comboScenarios;
        int senario = numScenario.getSelectionModel().getSelectedIndex();
        String testSenario = getListeScenarios().get(senario);

        try {
            resultat.affichageResultat(testSenario);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private ComboBox<String> peupleComboBox(ArrayList achven) {

        ComboBox<String> comboBox = new ComboBox<>();

        for (int i = 0; i < achven.size(); i++) {
            String string = achven.get(i).toString();
            comboBox.getItems().add(string);
        }
        comboBox.setValue(achven.get(0).toString());
        return comboBox;
    }

    public static ArrayList<String> getListeScenarios() {

        ArrayList<String> liste = new ArrayList<>();
        for (File file : Scenarios) {
            liste.add(file.getName().toString());
        }
        Scenarios = repertoire.listFiles();
        return liste;
    }

    public static String getComboAlgo(){return comboAlgo.getSelectionModel().getSelectedItem().toString();}

    public static ComboBox getComboScenarios() {
        return comboScenarios;
    }
}
