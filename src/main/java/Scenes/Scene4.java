package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Pet;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wand.Core;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wand.Wand;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;

public class Scene4 extends Scene {
    public Scene4(Stage stage, Wizard wizard) {

        // Créez la scène avec un VBox comme racine
        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        // Créez les éléments de l'interface utilisateur pour afficher le texte
        Label label1 = new Label("Welcome to Hogwards : " + wizard.getName());
        Label label2 = new Label("You have been assigned to the House " + wizard.getHouse().getName()+" Congratulation");
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")){
            label2.setTextFill(Color.GREEN);
        } else if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
            label2.setTextFill(Color.RED);
        } else if (Objects.equals(wizard.getHouse().getName(), "Hufflepuff")){
            label2.setTextFill(Color.YELLOW);
        } else if (Objects.equals(wizard.getHouse().getName(), "Ravenclaw")){
            label2.setTextFill(Color.BLUE);
        }

        int size = 20 + (int) (Math.random() * ((35 - 20) + 1));

        Wand wand = new Wand(size, Core.assignCore());
        wizard.setWand(wand);
        Font fontScene4 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20);
        label2.setFont(fontScene4);

        // Créer les boutons radio
        Label label3 = new Label("Now, choose your Pet");
        RadioButton option1 = new RadioButton("Owl");
        RadioButton option2 = new RadioButton("Cat");
        RadioButton option3 = new RadioButton("Rat");
        RadioButton option4 = new RadioButton("Toad");

// Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        Button submitButtons = new Button("Submit");
        submitButtons.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                wizard.setPet(Pet.Owl);
            } else if (selectedOption == option2) {
                wizard.setPet(Pet.Cat);
            } else if (selectedOption == option3) {
                wizard.setPet(Pet.Rat);
            } else if (selectedOption == option4) {
                wizard.setPet(Pet.Toad);
            }
            Scene5 scene5 = new Scene5(stage,wizard);
            stage.setScene(scene5);
        });

        // Ajoutez les éléments au VBox
        root.getChildren().addAll(label1, label2, label3, option1, option2, option3, option4, submitButtons);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");
    }
}