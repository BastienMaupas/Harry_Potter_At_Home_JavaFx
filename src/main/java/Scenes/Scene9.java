package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Enemy;
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

public class Scene9 extends Scene {
    public Scene9(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("THE PHILOSOPHER'S STONE");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        //label1.setStyle("-fx-background-color: blue;");
        Label label2 = new Label("You were just going to the toilets but a troll has just left the dungeon!");
        Label label3 = new Label("You are now in front of him but you are not strong enough to beat him in a fair fight...");
        Label label4 = new Label("Try to find a trick with the spells you have learned to beat him!");

        Enemy troll;
        troll = new Enemy("Troll", 100, 40, 200);

        Button nextButton = new Button("Fight the troll");

        nextButton.setOnAction(event -> {
            Scene10 scene10 = new Scene10(stage, wizard, troll);
            stage.setScene(scene10);
        });


        root.getChildren().addAll(label1, label2, label3, label4, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");


    }
}
