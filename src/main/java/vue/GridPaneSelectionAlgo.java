package vue;

import constantes.ConstanteIHM;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class GridPaneSelectionAlgo extends GridPane implements ConstanteIHM {
    public GridPaneSelectionAlgo() {

        Label labelTitre = new Label("SAE JAVA IHM");

        ToggleGroup radioGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Algo 1");
        RadioButton radioButton2 = new RadioButton("Algo 2");
        RadioButton radioButton3 = new RadioButton("Algo 3");

        radioGroup.getToggles().addAll(radioButton1, radioButton2, radioButton3);

        ComboBox comboScenarios = new ComboBox();
        comboScenarios.getItems().addAll(SCENARIOS);

        this.add(labelTitre, 0, 0);

        this.add(radioButton1, 1, 1);
        this.add(radioButton2, 1, 2);
        this.add(radioButton3, 1, 3);

        this.add(comboScenarios, 2, 1);



    }
}
