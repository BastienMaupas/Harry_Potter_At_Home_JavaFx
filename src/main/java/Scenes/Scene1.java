package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Scene1 extends Scene {
    public Scene1(Stage stage) {

        // Créez la scène avec un VBox comme racine
        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        // Créez la zone de texte et le bouton + texte explicatif
        Label label1 = new Label("What is your name ?");
        //Font fontScene1 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        //label1.setFont(fontScene1);
        label1.setStyle("-fx-text-fill: red");
        TextField textField = new TextField();
        textField.setMaxWidth(350);
        textField.setMinHeight(40);
        textField.setPromptText("Please enter your name");
        Button validateName = new Button("Validate");

        // Gestionnaire d'événements du bouton
        EventHandler<ActionEvent> buttonHandler = event -> {
            if(textField.getText().length() > 0){
                String playerName = textField.getText();
                Wizard wizard = new Wizard(playerName,100,100,100,null,null,null,null,null);
                Scene2 scene2 = new Scene2(stage, wizard);
                stage.setScene(scene2);
            }
        };
        validateName.setOnAction(buttonHandler);
        // Gestionnaire d'événements de la touche "Entrée" sur la zone de texte
        EventHandler<KeyEvent> enterHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if(textField.getText().length() > 0){
                    buttonHandler.handle(new ActionEvent());
                }
            }
        };
        textField.setOnKeyPressed(enterHandler);

        //Alignement horizontal du bouton
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        hbox.getChildren().addAll(leftSpacer, validateName, rightSpacer);

        // Ajoutez les éléments au VBox
        root.getChildren().addAll(label1, textField, hbox);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");

    }
}