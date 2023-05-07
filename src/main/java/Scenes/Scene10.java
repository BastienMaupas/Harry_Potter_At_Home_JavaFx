package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Enemy;
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
import javafx.stage.Stage;

public class Scene10 extends Scene {
    public Scene10(Stage stage, Wizard wizard, Enemy troll) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);


        Label label1 = new Label(troll.getName() + "\nHP: " + troll.getHp() + "/" + troll.maxHp);
        label1.setTextFill(Color.RED);
        Label label2 = new Label("VS");
        Label label3 = new Label(wizard.getName() + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);

        if (wizard.getHp() >= 65){
            label3.setTextFill(Color.GREEN);
        } else if (64 >= wizard.getHp() && wizard.getHp() >= 32){
            label3.setTextFill(Color.YELLOW);
        } else if (wizard.getHp() <= 31){
            label3.setTextFill(Color.RED);
        }

        Label label4 = new Label("Choose an action");

        // Créer les boutons radio
        RadioButton option1 = new RadioButton("Fight");
        RadioButton option2 = new RadioButton("Potion");
        RadioButton option3 = new RadioButton("Surrender");

        // Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);

        Button submitButton = new Button("Continue");
        submitButton.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                Scene11 scene11 = new Scene11(stage,wizard, troll);
                stage.setScene(scene11);
            } /*else if (selectedOption == option2) {
                Scene12 scene12 = new Scene12(stage,wizard, troll);
                stage.setScene(scene12);
            } */ else if (selectedOption == option3) {
                Scene13 scene13 = new Scene13(stage,wizard, troll);
                stage.setScene(scene13);
            }

        });

        root.getChildren().addAll(label1, label2, label3, label4, option1, option2, option3, submitButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Choose your house - Harry Potter RPG");

    }
}
