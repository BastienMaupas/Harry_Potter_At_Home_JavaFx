package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class SortingHat {

    /*public House assignHouse() {
        int housenum = (int) (Math.random() * 4);
        if (housenum == 0 ){
            return House.Gryffindor;
        }
        if (housenum == 1 ){
            return House.Slytherin;
        }
        if (housenum == 2 ){
            return House.Hufflepuff;
        }
        else{
            return House.Ravenclaw;
        }
    }*/

    public House assignHouse() {
// Créer les boutons radio
        RadioButton option1 = new RadioButton("Option 1");
        RadioButton option2 = new RadioButton("Option 2");
        RadioButton option3 = new RadioButton("Option 3");
        RadioButton option4 = new RadioButton("Option 4");

// Ajouter les boutons radio à un groupe
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

// Créer un gestionnaire d'événements pour le bouton "Soumettre"
        Button submitButton = new Button("Soumettre");
        submitButton.setOnAction(event -> {
            // Récupérer l'option sélectionnée
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption != null) {
                System.out.println("Option sélectionnée : " + selectedOption.getText());
            } else {
                System.out.println("Aucune option sélectionnée");
            }
        });

// Ajouter les boutons radio et le bouton "Soumettre" à un conteneur
        VBox vbox = new VBox(10, option1, option2, option3, option4, submitButton);
        vbox.setPadding(new Insets(10));
        return null;
    }

}
