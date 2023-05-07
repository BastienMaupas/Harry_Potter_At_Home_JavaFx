package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene8 extends Scene {
    public Scene8(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        // Créer les boutons radio
        Label label1 = new Label("Choose an upgrade");
        RadioButton option1 = new RadioButton("Attack upgrade");
        RadioButton option2 = new RadioButton("Defense upgrade");

// Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);

// Créer un gestionnaire d'événements pour le bouton "Soumettre"
        Button submitButton = new Button("Continue");
        submitButton.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                wizard.setAtk(wizard.getAtk()+10);
            } else if (selectedOption == option2) {
                wizard.setDef(wizard.getDef()+10);
            }
            Scene9 scene9 = new Scene9(stage,wizard);
            stage.setScene(scene9);
        });

// Ajouter les boutons radio et le bouton "Soumettre" à un conteneur
        root.getChildren().addAll(label1, option1, option2, submitButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");


    }
}
