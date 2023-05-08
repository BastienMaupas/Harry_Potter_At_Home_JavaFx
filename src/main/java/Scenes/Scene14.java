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

public class Scene14 extends Scene {
    public Scene14(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("END OF LEVEL1");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("Nice one! You beat him! You now can go back to your common room to rest a bit and finish your year quietly.");

        Button nextButton = new Button("Continue");

        nextButton.setOnAction(event -> {
            Scene15 scene15 = new Scene15(stage,wizard);
            stage.setScene(scene15);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");

    }
}
