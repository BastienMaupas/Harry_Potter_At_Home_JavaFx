package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Enemy;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class Scene30 extends Scene {
    public Scene30(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("THE PRISONER OF AZKABAN");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        //label1.setStyle("-fx-background-color: blue;");
        Label label2 = new Label("This year was a bit particular since dementors have been running around Hogwarts the whole year.");
        Label label3 = new Label("You are now face to face to a horde of them and will try to use your new spell: Wingardium Leviosa.");

        GameMethod mygameMethod= new GameMethod();

        Enemy dementors;
        dementors = new Enemy("Dementor", 100, 40,50);
        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(mygameMethod.setupSpells().get(4));
        wizard.setSpellsKnown(knownSpells);
        Label label5 = new Label("You just have learnt the spell Expecto Patronum");
        wizard.setHp(wizard.getMaxhp());

        Button nextButton = new Button("Fight the dementors");


        nextButton.setOnAction(event -> {
            Scene31 scene31 = new Scene31(stage, wizard, dementors);
            stage.setScene(scene31);
        });


        root.getChildren().addAll(label1, label2, label3, label5, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");


    }
}
