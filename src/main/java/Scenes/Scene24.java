package Scenes;

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

public class Scene24 extends Scene {
    public Scene24(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("END OF LEVEL2");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("You won! You can now go rest");

        Button nextButton = new Button("Continue");

        nextButton.setOnAction(event -> {
            Scene25 scene25 = new Scene25(stage,wizard);
            stage.setScene(scene25);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");

    }
}
