package controleur;


import javafx.scene.control.ComboBox;
import vue.GridPaneCreationScenario;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControleurCreation {

    private GridPaneCreationScenario root;

    public void setRoot(GridPaneCreationScenario root) {
        this.root = root;
    }

    private void instanciateButtons(){
        this.instanciationCreerScenario();
    }

    public final void instanciationCreerScenario() {
        this.root.getBouttonValider().setOnAction(event -> {
            try {
                creationScenario();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void creationScenario() throws IOException {
        String text = this.root.getTextFieldNomScenario().toString();

        ComboBox comboCreationScenarios1 = GridPaneCreationScenario.getComboBoxCreationScenarios1();
        ComboBox comboCreationScenarios2 = GridPaneCreationScenario.getComboBoxCreationScenarios2();

        String comboCreationScenarios11 = comboCreationScenarios1.getSelectionModel().toString();
        String comboCreationScenarios22 = comboCreationScenarios2.getSelectionModel().toString();

        String[] test = new String[]{comboCreationScenarios11 + " --> " + comboCreationScenarios22 + "\n"};

        String test2 = test.toString();

        String fileData = test2;
        FileOutputStream fos = new FileOutputStream("scenarioCreer/" + File.separator + text + ".txt");
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();

    }

}
