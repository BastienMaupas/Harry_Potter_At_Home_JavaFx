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

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Scene22 extends Scene {
    public Scene22(Stage stage, Wizard wizard, Enemy basilisk) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Which spell do you want to use?");

        // Créer les boutons radio
        RadioButton option1 = new RadioButton("Expelliarmus");
        RadioButton option2 = new RadioButton("Wingardium Leviosa");
        RadioButton option3 = new RadioButton("Accio");

        // Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);

        Label label2 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();

        AtomicInteger i = new AtomicInteger();

        Button submitButton = new Button("Submit");
        Button backButton = new Button("Go back");
        Button nextButton = new Button("Continue");
        Button endButton = new Button("Continue");
        nextButton.setVisible(false);
        endButton.setVisible(false);
        submitButton.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(0), basilisk);
                basilisk.takeDamage(damage);
                label4.setText("You have dealt "+damage+" damage");
                if (damage == 0){
                    label4.setTextFill(Color.RED);
                } else {
                    label4.setTextFill(Color.GREEN);
                }
                submitButton.setVisible(false);
                backButton.setVisible(false);
                nextButton.setVisible(true);
            } else if (selectedOption == option2) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(1), basilisk);
                basilisk.takeDamage(damage);
                basilisk.setDef(10);
                label4.setText("You have dealt "+damage+" damage");
                label4.setTextFill(Color.RED);
                submitButton.setVisible(false);
                backButton.setVisible(false);
                nextButton.setVisible(true);
            } else if (selectedOption == option3) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(2), basilisk);
                basilisk.takeDamage(damage);
                if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
                    basilisk.setHp(0);
                    label7.setText("You have grabbed the Gryffindor sword, you now can kill the basilisk");
                    label7.setTextFill(Color.ORANGE);
                } else {
                    label4.setText("You have dealt " + damage + " damage");
                    label4.setTextFill(Color.RED);
                    label8.setText("You have grabbed a basilisk's fang, you will now have to survive until you reach the diary to destroy it");

                }
                submitButton.setVisible(false);
                backButton.setVisible(false);
                endButton.setVisible(true);
            }





            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("The basilisk has dealt you "+damage1+" damage");
            label6.setTextFill(Color.RED);
        });





        Label labelend = new Label();
        Label labelend2 = new Label();
        Button endButton2 = new Button("Get closer");
        Button endButton3 = new Button("Destroy the diary");
        endButton2.setVisible(false);
        endButton3.setVisible(false);

        endButton.setOnAction(event -> {
            labelend.setText("You are getting closer to the diary");
            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("The basilisk has dealt you "+damage1+" damage");
            label6.setTextFill(Color.RED);
            endButton2.setVisible(true);
        });

        endButton2.setOnAction(event -> {
            labelend2.setText("One more step and you will be able to reach it!");
            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("The basilisk has dealt you "+damage1+" damage");
            label6.setTextFill(Color.RED);
            endButton3.setVisible(true);
        });

        endButton2.setOnAction(event -> {
            labelend2.setText("You have reached the diary! You destroy it and it kills the basilisk, you have won!");
            basilisk.setHp(0);
            nextButton.setVisible(true);
        });

        backButton.setOnAction(event -> {
            Scene21 scene21 = new Scene21(stage,wizard,basilisk);
            stage.setScene(scene21);
        });

        nextButton.setOnAction(event -> {
            if (basilisk.getHp() == 0){
                Scene23 scene23 = new Scene23(stage,wizard);
                stage.setScene(scene23);
            } else if (wizard.getHp() == 0) {
                Scene100 scene100 = new Scene100(stage,wizard);
                stage.setScene(scene100);
            }
            else {
                Scene21 scene21 = new Scene21(stage, wizard, basilisk);
                stage.setScene(scene21);
            }
        });

        option1.setOnAction(e -> {
            if (option1.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(0).getEffect() + " deals "+wizard.getSpellsKnown().get(0).getDamage()+" damage");
            }
        });


        option2.setOnAction(e -> {
            if (option2.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(1).getEffect() + " deals "+wizard.getSpellsKnown().get(1).getDamage()+" damage");
            }
        });

        option3.setOnAction(e -> {
            if (option3.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(2).getEffect() + " deals "+wizard.getSpellsKnown().get(2).getDamage()+" damage");
            }
        });

        root.getChildren().addAll(label1, option1, option2, option3, submitButton, backButton, label2, label5, label4, label6, label7, label8, labelend, labelend2, endButton, endButton2, endButton3, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter RPG");


    }
}
