package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Enemy;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Potion;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class Scene12 extends Scene {
    public Scene12(Stage stage, Wizard wizard, Enemy troll) {

        super(new VBox(), 600, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Button backButton = new Button("Go back");
        Button drinkButton = new Button("Drink Potion");

        ToggleGroup potions = new ToggleGroup();
        for (Potion potion : wizard.getPotionsOwned()) {
            RadioButton bouton = new RadioButton(potion.getName());
            bouton.setToggleGroup(potions);
        }

        for (Potion potion : wizard.getPotionsOwned()) {
            RadioButton bouton = new RadioButton(potion.getName());
            bouton.setToggleGroup(potions);
            root.getChildren().add(bouton);
        }

        drinkButton.setOnAction(event -> {
            RadioButton selectedPotionButton = (RadioButton) potions.getSelectedToggle();
            if (selectedPotionButton != null) {
                String selectedPotionName = selectedPotionButton.getText();
                Potion selectedPotion = wizard.getPotionByName(selectedPotionName);
                if(Objects.equals(wizard.getHouse().getName(), "Hufflepuff")) {
                    wizard.setHp(wizard.getHp() + selectedPotion.getHp() + 10);
                    System.out.println("You have been healed by "+ (selectedPotion.getHp())+" plus 10 additional hp beacause you are Hufflepuff");
                }else{
                    wizard.setHp(wizard.getHp() + selectedPotion.getHp());
                    System.out.println("You have been healed by "+ selectedPotion.getHp());
                }
                List<Potion> ownedPotions = wizard.getPotionsOwned();
                ownedPotions.remove(selectedPotion);
                wizard.setPotionsOwned(ownedPotions);
                if (wizard.getHp() >= 100){
                    wizard.setHp(100);
                }
                Scene10 scene10 = new Scene10(stage,wizard,troll);
                stage.setScene(scene10);
            }
        });

        backButton.setOnAction(event -> {
            Scene10 scene10 = new Scene10(stage,wizard,troll);
            stage.setScene(scene10);
        });

        root.getChildren().addAll(backButton, drinkButton);



    }
}
