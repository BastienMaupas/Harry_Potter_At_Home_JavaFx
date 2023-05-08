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

public class Scene20 extends Scene {
    public Scene20(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("THE CHAMBER OF SECRETS");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        //label1.setStyle("-fx-background-color: blue;");
        Label label2 = new Label("Your year was going well until you heard about the Chamber of Secrets...");
        Label label3 = new Label("You went therefore there but you now face the terrible basilisk and he seems so strong, not sure you can beat him in a fair fight.");
        Label label4 = new Label("You also find a diary next to him. Maybe you could try to find something to destroy it.");

        GameMethod mygameMethod= new GameMethod();

        Enemy basilisk;
        basilisk = new Enemy("Basilisk",1000,30,300);
        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(mygameMethod.setupSpells().get(3));
        wizard.setSpellsKnown(knownSpells);
        Label label5 = new Label("You just have learnt the spell Accio");
        wizard.setHp(wizard.getMaxhp());

        Button nextButton = new Button("Fight the basilik");


        nextButton.setOnAction(event -> {
            Scene21 scene21 = new Scene21(stage, wizard, basilisk);
            stage.setScene(scene21);
        });


        root.getChildren().addAll(label1, label2, label3, label4, label5, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");


    }
}
