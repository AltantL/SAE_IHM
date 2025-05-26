package vue;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {

    private static GridPaneSelectionAlgo gridPaneSelectionAlgo;

    public HBoxRoot() {

        gridPaneSelectionAlgo = new GridPaneSelectionAlgo();

        this.getChildren().add(gridPaneSelectionAlgo);
    }

    public static GridPaneSelectionAlgo getGridPaneSelectionAlgo() {
        return gridPaneSelectionAlgo;
    }
}
