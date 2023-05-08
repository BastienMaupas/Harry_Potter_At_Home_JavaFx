package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.House;
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

import java.util.concurrent.atomic.AtomicReference;

public class Scene3 extends Scene {
    public Scene3(Stage stage, Wizard wizard){
        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

// Créer les boutons radio
        Label label1 = new Label("We will now assign you an house\nWhich of these character traits define you the best?");
        RadioButton option1 = new RadioButton("Determination");
        RadioButton option2 = new RadioButton("Bravery");
        RadioButton option3 = new RadioButton("Loyalty");
        RadioButton option4 = new RadioButton("Wisdom");

// Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        GameMethod mygameMethod= new GameMethod();
        mygameMethod.setupHouse();

// Créer un gestionnaire d'événements pour le bouton "Soumettre"
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
                if (selectedOption == option1) {
                    wizard.setHouse(mygameMethod.setupHouse().get(0));
                    wizard.setAtk(120);
                } else if (selectedOption == option2) {
                    wizard.setHouse(mygameMethod.setupHouse().get(1));
                    wizard.setDef(120);
                } else if (selectedOption == option3) {
                    wizard.setHouse(mygameMethod.setupHouse().get(2));
                } else if (selectedOption == option4) {
                    wizard.setHouse(mygameMethod.setupHouse().get(3));
                }
            if (selectedOption != null) {
                Scene4 scene4 = new Scene4(stage, wizard);
                stage.setScene(scene4);
            }
        });

// Ajouter les boutons radio et le bouton "Soumettre" à un conteneur
        root.getChildren().addAll(label1, option1, option2, option3, option4, submitButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");


    }


}
