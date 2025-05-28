package vue;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {

    private static GridPaneSelectionAlgo gridPaneSelectionAlgo;
    private static Resultat resultat;

    public HBoxRoot() {

        super(30);

        gridPaneSelectionAlgo = new GridPaneSelectionAlgo();
        resultat = new Resultat();

        this.getChildren().addAll(gridPaneSelectionAlgo, resultat);
    }

    public static GridPaneSelectionAlgo getGridPaneSelectionAlgo() {
        return gridPaneSelectionAlgo;
    }
    public static Resultat getResultat() {return resultat;}
}
