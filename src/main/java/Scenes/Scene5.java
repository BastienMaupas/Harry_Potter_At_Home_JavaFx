package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene5 extends Scene {
    public Scene5(Stage stage, Wizard wizard) {

        // Créez la scène avec un VBox comme racine
        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("YOUR CHARACTER INFORMATIONS");

        Label label2 = new Label("Your name: "+wizard.getName()+"\nYour house: "+wizard.getHouse().getName()+"\nYour wand: "+wizard.getWand().getCore()+" "+wizard.getWand().getSize()+"\nYour Pet: "+wizard.getPet()+"\nYour HP: "+wizard.getMaxhp()+"\nYour attack: "+wizard.getAtk()+"\nYour def: "+wizard.getDef());

        root.getChildren().addAll(label1, label2);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");


    }
}
