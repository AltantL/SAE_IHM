package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javax.swing.*;

public class Accueil extends GridPane {
    public Accueil() {

        ImageView background = new ImageView(new Image("file:image/echangePokemon.jpg"));
        background.setFitWidth(800);
        background.setFitHeight(600);
        background.setPreserveRatio(false);

        Label labelTitreAccueil = new Label("Accueil de L'APPLI");
        Label espace = new Label(" ");
        Label espace2 = new Label(" ");
        Label espace3 = new Label(" ");

        Button boutonCreerSenario = new Button("Creer Senario");
        Button boutonModifierSenario = new Button("Modifier Senario");
        Button boutonUtiliserSenario = new Button("Utiliser Senario");
        Button boutonCredit =  new Button("Credit");

        StackPane root = new StackPane();
        root.getChildren().add(background);

        this.getChildren().addAll(root,labelTitreAccueil,boutonCreerSenario,boutonModifierSenario,boutonUtiliserSenario,boutonCredit);

//        this.add(labelTitreAccueil, 1, 1 ,3,1);
//        this.add(espace, 2, 2 ,3,1);
//        this.add(boutonCreerSenario, 0,3);
//        this.add(espace2, 1,3);
//        this.add(boutonModifierSenario, 2,3);
//        this.add(espace3, 3,4);
//        this.add(boutonUtiliserSenario, 4,3);
//        this.add(boutonCredit, 2,5);



    }
}
