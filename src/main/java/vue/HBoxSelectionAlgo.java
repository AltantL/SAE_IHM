package vue;

import constantes.ConstanteIHM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class HBoxSelectionAlgo extends HBox implements ConstanteIHM {

    private static ComboBox comboScenarios;

    public HBoxSelectionAlgo(List<Node> children) {

        Resultat resultat = new Resultat();

        GridPane grid = new GridPane();

        Label labelTitre = new Label("SAE JAVA IHM");

        ToggleGroup radioGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Algo 1");
        RadioButton radioButton2 = new RadioButton("Algo 2");
        RadioButton radioButton3 = new RadioButton("Algo 3");

        radioButton1.setSelected(true);

        radioGroup.getToggles().addAll(radioButton1, radioButton2, radioButton3);

        comboScenarios = peupleComboBox(SCENARIOS);

        Button bouttonAnnuler = new Button("Annuler");

        Button bouttonValider = new Button("Valider");
        bouttonValider.setOnAction(actionEvent -> onBoutonValider(resultat));

        Button bouttonRetour = new Button("Retour");
        bouttonRetour.setOnAction(actionEvent -> children.removeLast());


        grid.add(labelTitre, 0, 0);

        grid.add(radioButton1, 0, 1);
        grid.add(radioButton2, 0, 2);
        grid.add(radioButton3, 0, 3);

        grid.add(comboScenarios, 1, 1);

        grid.add(bouttonAnnuler, 0, 5);
        grid.add(bouttonValider, 1, 5);
        grid.add(bouttonRetour, 0, 6);

        grid.add(resultat, 5, 0);

        bouttonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                radioButton1.setSelected(true);
                comboScenarios.setValue(SCENARIOS[0]);
            }
        });

        this.getChildren().addAll(grid, resultat);
    }

    private static void onBoutonValider(Resultat resultat) {

        ComboBox numScenario = comboScenarios;
        int senario = numScenario.getSelectionModel().getSelectedIndex();
        String testSenario = SCENARIOS[senario];

        try {
            resultat.affichageResultat(testSenario);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private ComboBox<String> peupleComboBox(String[] strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings) {
            comboBox.getItems().add(string);
        }
        comboBox.setValue(strings[0]);
        return comboBox;
    }

    public static ComboBox getComboScenarios() {
        return comboScenarios;
    }
}
