package vue;

import constantes.ConstanteIHM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class GridPaneSelectionAlgo extends GridPane implements ConstanteIHM {

    public ComboBox comboScenarios;

    public GridPaneSelectionAlgo() {

        Label labelTitre = new Label("SAE JAVA IHM");

        ToggleGroup radioGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Algo 1");
        RadioButton radioButton2 = new RadioButton("Algo 2");
        RadioButton radioButton3 = new RadioButton("Algo 3");

        radioButton1.setSelected(true);

        radioGroup.getToggles().addAll(radioButton1, radioButton2, radioButton3);

        comboScenarios = peupleComboBox(SCENARIOS);

        Button boutonAnnuler = new Button("Annuler");
        Button bouttonValider = new Button("Valider");

        bouttonValider.setOnAction(HBoxRoot.getControleur());

        this.add(labelTitre, 0, 0);

        this.add(radioButton1, 0, 1);
        this.add(radioButton2, 0, 2);
        this.add(radioButton3, 0, 3);

        this.add(comboScenarios, 1, 1);

        this.add(boutonAnnuler, 0, 5);
        this.add(bouttonValider, 1, 5);

        boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                radioButton1.setSelected(true);
                comboScenarios.setValue(SCENARIOS[0]);
            }
        });
    }

    private ComboBox<String> peupleComboBox(String[] strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings) {
            comboBox.getItems().add(string);
        }
        comboBox.setValue(strings[0]);
        return comboBox;
    }
}
