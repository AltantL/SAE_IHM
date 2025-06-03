package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {

    private static VBoxSelectionAlgo gridPaneSelectionAlgo;
    private static Resultat resultat;
    private static Controleur controleur;

    public HBoxRoot() {

        super(30);

        gridPaneSelectionAlgo = new VBoxSelectionAlgo();
        resultat = new Resultat();
        controleur = new Controleur();

        this.getChildren().addAll(gridPaneSelectionAlgo, resultat);
    }

    public static VBoxSelectionAlgo getGridPaneSelectionAlgo() {
        return gridPaneSelectionAlgo;
    }
    public static Resultat getResultat() {return resultat;}
    public static Controleur getControleur() {return controleur;}
}
