package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Accueil extends GridPane {
    public Accueil(Stage stage) {

        AnchorPane content = new AnchorPane();

        ImageView background = new ImageView(new Image("file:image/echangePokemon.jpg"));
        background.setFitWidth(658);
        background.setFitHeight(306);
        background.setPreserveRatio(false);

        Label labelTitreAccueil = new Label("Accueil de L'APPLI");
        labelTitreAccueil.setStyle("-fx-text-fill: white;");

        Button boutonCreerSenario = new Button("Créer Scenario");
        boutonCreerSenario.setOnAction(e -> getChildrenCreation());

        Button boutonModifierSenario = new Button("Modifier Scenario");
        boutonModifierSenario.setOnAction(e -> getChildrenModifier());

        Button boutonUtiliserSenario = new Button("Utiliser Scenario");
        boutonUtiliserSenario.setOnAction(e -> getChildrenSelection());

        Button boutonCredit =  new Button("Credit");
        boutonCredit.setOnAction(e -> onBouttonCredit());

        Button boutonQuitter = new Button("Quitter");
        boutonQuitter.setOnAction(e -> {stage.close();});


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

        AnchorPane.setBottomAnchor(boutonQuitter, 10.0);
        AnchorPane.setRightAnchor(boutonQuitter, 10.0);

        content.getChildren().addAll(labelTitreAccueil, boutonCreerSenario, boutonModifierSenario, boutonUtiliserSenario, boutonCredit, boutonQuitter);

        StackPane root = new StackPane();
        root.getChildren().addAll(background,content);

        this.getChildren().add(root);

    }

    private boolean getChildrenSelection() {
        return Accueil.this.getChildren().add(new ScrollPane(new HBoxSelectionAlgo(this.getChildren())));
    }

    private boolean getChildrenModifier() {
        return Accueil.this.getChildren().add(new ScrollPane(new VBoxModifierScenario(this.getChildren())));
    }

    private boolean getChildrenCreation() {
        return Accueil.this.getChildren().add(new ScrollPane(new VBoxCreationScenario(this.getChildren())));
    }

    private void onBouttonCredit() {
        GridPane gridPane = new GridPane();

        Label nom1 = new Label("Antoine LAPLUYE");
        Label nom2 = new Label("Julien MATHIAS");

        Button boutonRetour = new Button("Retour");
        boutonRetour.setOnAction(e -> this.getChildren().removeLast());

        gridPane.add(nom1, 0, 0);
        gridPane.add(nom2, 0, 1);
        gridPane.add(boutonRetour, 0, 2);

        this.getChildren().add(new ScrollPane(gridPane));
    }

}
