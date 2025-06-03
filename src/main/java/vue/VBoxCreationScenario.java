package vue;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.LectureScenario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VBoxCreationScenario extends VBox {

    private static ComboBox<String> comboCreationScenarios1;
    private static ComboBox<String> comboCreationScenarios2;

    private ScrollPane scrollPane;

    private static Button bouttonValider;
    private TextField textFieldNomScenario;

    public VBoxCreationScenario() {
        Label labelTitre = new Label("Création de Scénario");

        Button bouttonPlus = new Button("+");
        bouttonPlus.setOnAction(e -> {
            try {
                ajouterPersonnage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bouttonValider = new Button("Valider");
        bouttonValider.setOnAction(e -> {
            try {
                creationScenario();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Label labelEspace = new Label("               ");

        Button bouttonMoins = new Button("-");
        bouttonMoins.setOnAction(e -> {retirerEchange();});

        Button bouttonRetour = new Button("Retour");
        bouttonRetour.setOnAction(e -> {this.getChildren().removeLast();});

        Label nomScenario = new Label("Nom Scenario");
        textFieldNomScenario = new TextField();

        HBox hBox = new HBox();
        hBox.getChildren().addAll(bouttonPlus,bouttonMoins,labelEspace,bouttonRetour);

        this.getChildren().addAll(labelTitre, hBox, bouttonValider, nomScenario, textFieldNomScenario);
    }

    private void retirerEchange() {
        if (this.getChildren().size() > 5){
            this.getChildren().removeLast();
        }

    }

    public void ajouterPersonnage() throws IOException {

        HBox hBox = new HBox();

        ArrayList achven = LectureScenario.lectureScenarioMembre();

        comboCreationScenarios1 = peupleComboBox(achven);
        comboCreationScenarios2 = peupleComboBox(achven);

        Label creationScenario = new Label(" -> ");


        hBox.getChildren().addAll(comboCreationScenarios1,creationScenario,comboCreationScenarios2);

        this.getChildren().add(hBox);

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

    private void creationScenario() throws IOException {
        String text = this.textFieldNomScenario.getText();
        String scenario = "";
        List<Node> hboxes = this.getChildren().subList(5, this.getChildren().size());
        for(Node hbox : hboxes){
            ComboBox<String> truc = (ComboBox) ((HBox) hbox).getChildren().get(0);
            ComboBox<String> truc2 = (ComboBox) ((HBox) hbox).getChildren().get(2);

            String chose = truc.getSelectionModel().getSelectedItem();
            String chose2 = truc2.getSelectionModel().getSelectedItem();

            scenario += chose + " --> " + chose2 + "\n";

        }
        FileOutputStream fos = new FileOutputStream("./scenarioCreer" + File.separator + text + ".txt");
        fos.write(scenario.getBytes());
        fos.flush();
        fos.close();
    }
}
