package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wizard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene6 extends Scene {
    public Scene6(Stage stage, Wizard wizard) {

        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);



        ObservableList<Spell> spells = FXCollections.observableList(wizard.getSpellsKnown());

        // Créer un ListView avec une cellule personnalisée
        ListView<Spell> listView = new ListView<>(spells);
        listView.setCellFactory(param -> new ListCell<Spell>() {
            @Override
            protected void updateItem(Spell spell, boolean empty) {
                super.updateItem(spell, empty);

                if (empty || spell == null) {
                    setText(null);
                } else {
                    setText(spell.getName() + " - " + spell.getEffect() + " - Damages: " + spell.getDamage());
                }
            }
        });

        Button nextButton = new Button("Go to level 1");

        nextButton.setOnAction(event -> {
            Scene7 scene7 = new Scene7(stage, wizard);
            stage.setScene(scene7);
        });

        /*ObservableList<String> items = FXCollections.observableArrayList();
        for (Spell spell : wizard.getSpellsKnown()) {
            items.add(spell.getName());
        }

        ListView<String> listView = new ListView<>(items);*/

        root.getChildren().addAll(listView, nextButton);
        root.setStyle("-fx-background-color: #FFFAAA; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Confirm your name - Harry Potter RPG");

    }
}
