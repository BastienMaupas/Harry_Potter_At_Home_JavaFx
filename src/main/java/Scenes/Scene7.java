package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene7 extends Scene {
    public Scene7(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Button charButton = new Button("Character infos");

        charButton.setOnAction(event -> {
            Scene5 scene5 = new Scene5(stage, wizard);
            stage.setScene(scene5);
        });

        Button spellButton = new Button("Spells known");

        spellButton.setOnAction(event -> {
            Scene6 scene6 = new Scene6(stage, wizard);
            stage.setScene(scene6);
        });

        Button continueButton = new Button("Continue your journey");

        continueButton.setOnAction(event -> {
            Scene8 scene8 = new Scene8(stage, wizard);
            stage.setScene(scene8);
        });

        root.getChildren().addAll(charButton, spellButton, continueButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");

    }
}
