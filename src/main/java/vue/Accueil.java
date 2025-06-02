package vue;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.List;


public class Accueil extends GridPane {
    public Accueil() {

        AnchorPane content = new AnchorPane();

        ImageView background = new ImageView(new Image("file:image/echangePokemon.jpg"));
        background.setFitWidth(658);
        background.setFitHeight(306);
        background.setPreserveRatio(false);

        Label labelTitreAccueil = new Label("Accueil de L'APPLI");
        labelTitreAccueil.setStyle("-fx-text-fill: white;");

        Button boutonCreerSenario = new Button("Créer Senario");
        boutonCreerSenario.setOnAction(e -> Accueil.this.getChildren().add(new ScrollPane(new GridPaneCreationScenario())));

        Button boutonModifierSenario = new Button("Modifier Senario");
        boutonModifierSenario.setOnAction(e -> Accueil.this.getChildren().add(new ScrollPane(new GridPaneCreationScenario())));

        Button boutonUtiliserSenario = new Button("Utiliser Senario");
        boutonUtiliserSenario.setOnAction(e -> Accueil.this.getChildren().add(new ScrollPane(new GridPaneCreationScenario())));

        Button boutonCredit =  new Button("Credit");
        boutonCredit.setOnAction(e -> onBouttonCredit());


        AnchorPane.setTopAnchor(labelTitreAccueil, 112.6);
        AnchorPane.setLeftAnchor(labelTitreAccueil,280.0);

        AnchorPane.setTopAnchor(boutonCreerSenario, 180.0);
        AnchorPane.setLeftAnchor(boutonCreerSenario, 112.6);

        AnchorPane.setTopAnchor(boutonModifierSenario, 180.0);
        AnchorPane.setLeftAnchor(boutonModifierSenario, 290.0);

        AnchorPane.setTopAnchor(boutonUtiliserSenario, 180.0);
        AnchorPane.setRightAnchor(boutonUtiliserSenario, 112.6);

        AnchorPane.setBottomAnchor(boutonCredit, 10.0);
        AnchorPane.setLeftAnchor(boutonCredit, 10.0);

        content.getChildren().addAll(labelTitreAccueil, boutonCreerSenario, boutonModifierSenario, boutonUtiliserSenario, boutonCredit);

        StackPane root = new StackPane();
        root.getChildren().addAll(background,content);

        this.getChildren().add(root);

    }

    private void onBouttonCredit() {
        GridPane gridPane = new GridPane();

        Label nom1 = new Label("Antoine LAPLUYE");
        Label nom2 = new Label("Julien MATHIAS");

        Button boutonRetour = new Button("Retour");
        boutonRetour.setOnAction(e -> this.getChildren().remove(this.getChildren().size()-1));

        gridPane.add(nom1, 0, 0);
        gridPane.add(nom2, 0, 1);
        gridPane.add(boutonRetour, 0, 2);

        this.getChildren().add(new ScrollPane(gridPane));
    }

}
