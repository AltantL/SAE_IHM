package vue;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.LectureScenario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VBoxModifierScenario extends VBox {

    private static ComboBox<String> comboCreationScenarios1;
    private static ComboBox<String> comboCreationScenarios2;

    private static ComboBox comboScenarios;

    private static String scenario;

    private static Button buttonValider;

    private VBox vBox = new VBox();

    public VBoxModifierScenario(List<Node> children) {

        Label labelTitle = new Label("Modification de scenarios");

        comboScenarios = peupleComboBox(HBoxSelectionAlgo.getListeScenarios());


        buttonValider = new Button("Valider");
        buttonValider.setOnAction(e -> {
            try {
                vBox.getChildren().clear();
                poseDeScenario(quelScenario(comboScenarios));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setOnAction(e -> {vBox.getChildren().clear();});

        Button buttonEnregistrer = new Button("Enregistrer");
        buttonEnregistrer.setOnAction(e -> {
            try {
                creationScenario(scenario);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button buttonRetour = new Button("Retour");
        buttonRetour.setOnAction(e -> {children.removeLast();});

        Button bouttonPlus = new Button("+");
        bouttonPlus.setOnAction(e -> {
            try {
                onPlus(vBox.getChildren());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button bouttonMoins = new Button("-");
        bouttonMoins.setOnAction(e -> {vBox.getChildren().removeLast();});

        comboCreationScenarios1 = new ComboBox<>();
        comboCreationScenarios2 = new ComboBox<>();

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();

        hBox1.getChildren().addAll(bouttonPlus, bouttonMoins);
        hBox2.getChildren().addAll(buttonValider, buttonAnnuler, buttonEnregistrer, buttonRetour);
        hBox3.getChildren().addAll(comboScenarios);

        this.getChildren().addAll(labelTitle,hBox3,hBox1,hBox2);

    }

    private static String quelScenario(ComboBox<String> comboScenarios) {
        scenario = comboScenarios.getSelectionModel().getSelectedItem().toString();
        return scenario;
    }

    private void onPlus(List<Node> nodes) throws IOException {
        HBox hBox = new HBox();

        ArrayList achven = LectureScenario.lectureScenarioMembre();

        comboCreationScenarios1 = peupleComboBox(achven);
        comboCreationScenarios2 = peupleComboBox(achven);

        Label creationScenario = new Label(" -> ");

        hBox.getChildren().addAll(comboCreationScenarios1,creationScenario,comboCreationScenarios2);

        nodes.add(hBox);
    }

    private void poseDeScenario(String scenrio) throws IOException {

        ArrayList pose = LectureScenario.lectureScenario(scenrio);

        ArrayList pose1 = (ArrayList) pose.get(0);
        ArrayList pose2 = (ArrayList) pose.get(1);

        vBox = new VBox();

        ArrayList achven = LectureScenario.lectureScenarioMembre();

        for (int i=0; i < pose1.size() ; i++) {

            HBox hBox = new HBox();

            comboCreationScenarios1 = peupleComboBox(achven);
            comboCreationScenarios1.setValue(pose1.get(i).toString());

            comboCreationScenarios2 = peupleComboBox(achven);
            comboCreationScenarios2.setValue(pose2.get(i).toString());

            Label creationScenario = new Label(" -> ");
            hBox.getChildren().addAll(comboCreationScenarios1,creationScenario,comboCreationScenarios2);
            vBox.getChildren().addAll(hBox);
        }

        this.getChildren().add(vBox);
    }

    private void creationScenario(String scenario1) throws IOException {
        String scenario = "";

        for(Node hBox : vBox.getChildren()){
            ComboBox<String> truc = (ComboBox) ((HBox) hBox).getChildren().get(0);
            ComboBox<String> truc2 = (ComboBox) ((HBox) hBox).getChildren().get(2);

            String chose = truc.getSelectionModel().getSelectedItem();
            String chose2 = truc2.getSelectionModel().getSelectedItem();

            scenario += chose + " -> " + chose2 + "\n";

        }
        FileOutputStream fos = new FileOutputStream("./scenarios" + File.separator + scenario1);
        fos.write(scenario.getBytes());
        fos.flush();
        fos.close();
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

}
