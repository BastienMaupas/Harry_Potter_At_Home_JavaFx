package Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Scene2 extends Scene {
    public Scene2(Stage stage, String playerName) {

        // Créez la scène avec un VBox comme racine
        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        // Créez les éléments de l'interface utilisateur pour afficher le texte
        Label label1 = new Label("Welcome to Hogwards : " + playerName);
        Font fontScene1 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label1.setFont(fontScene1);
        Button backButton = new Button("Back to the name's selection");
        Button nextButton = new Button("Start your adventure");

        // Gestionnaire d'événements des boutons
        backButton.setOnAction(event -> {
            Scene1 scene1 = new Scene1(stage);
            stage.setScene(scene1);
        });

        nextButton.setOnAction(event -> {
            Scene3 scene3 = new Scene3(stage,playerName);
            stage.setScene(scene3);
        });

        // Ajoutez les éléments au VBox
        root.getChildren().addAll(label1, backButton, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");
    }
}