package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Scene27 extends Scene {
    public Scene27(Stage stage, Wizard wizard) {

        // Créez la scène avec un VBox comme racine
        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("YOUR CHARACTER INFORMATIONS");

        Label label2 = new Label("Your name: "+wizard.getName()+"\nYour house: "+wizard.getHouse().getName()+"\nYour wand: "+wizard.getWand().getCore()+" "+wizard.getWand().getSize()+"\nYour Pet: "+wizard.getPet()+"\nYour HP: "+wizard.getMaxhp()+"\nYour attack: "+wizard.getAtk()+"\nYour def: "+wizard.getDef());

        Button nextButton = new Button("Continue");

        nextButton.setOnAction(event -> {
            Scene26 scene26 = new Scene26(stage, wizard);
            stage.setScene(scene26);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");


    }
}
