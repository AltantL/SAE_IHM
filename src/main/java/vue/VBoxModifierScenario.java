package vue;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.LectureScenario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static constantes.ConstanteIHM.SCENARIOS;

public class VBoxModifierScenario extends VBox {

    private static ComboBox<String> comboCreationScenarios1;
    private static ComboBox<String> comboCreationScenarios2;

    private static ComboBox comboScenarios;

    private static String scenario;

    private static Button buttonValider;

    public VBoxModifierScenario() {

        Label labelTitle = new Label("Modification de scenarios");

        comboScenarios = peupleComboBox(SCENARIOS);

        scenario = quelScenario(comboScenarios);

        buttonValider = new Button("Valider");
        buttonValider.setOnAction(e -> {
            try {
                poseDeScenario(scenario);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button buttonAnnuler = new Button("Annuler");
        Button buttonRetour = new Button("Retour");

        Button bouttonPlus = new Button("+");
        Button bouttonMoins = new Button("-");

        comboCreationScenarios1 = new ComboBox<>();
        comboCreationScenarios2 = new ComboBox<>();

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();

        hBox1.getChildren().addAll(bouttonPlus, bouttonMoins);
        hBox2.getChildren().addAll(buttonValider, buttonAnnuler, buttonRetour);
        hBox3.getChildren().addAll(comboScenarios);

        this.getChildren().addAll(labelTitle,hBox3,hBox1,hBox2);

    }

    private static String quelScenario(ComboBox<String> comboScenarios) {
        scenario = comboScenarios.getSelectionModel().getSelectedItem().toString();
        return scenario;
    }

    private void poseDeScenario(String scenrio) throws IOException {

        scenrio = scenrio+".txt";

        ArrayList pose = LectureScenario.lectureScenario(scenrio);

//        System.out.println(pose);

        ArrayList pose1 = (ArrayList) pose.get(0);
        ArrayList pose2 = (ArrayList) pose.get(1);

        Label labelEspace = new Label(" -> ");


        for (int i=0; i < pose1.size() ; i++) {
            Label pose11 = new Label(pose1.get(i).toString());
            Label pose22 = new Label(pose2.get(i).toString());

//            System.out.println(pose11);
//            System.out.println(pose22);

            HBox hBox = new HBox(pose11, labelEspace, pose22);

            System.out.println(hBox);

            this.getChildren().add(hBox);
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

}
