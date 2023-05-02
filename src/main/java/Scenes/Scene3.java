package Scenes;

import isep.a1.harry_potter_at_home_javafx.modele.Wizard.SortingHat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene3 extends Scene {
    public Scene3(Stage stage, String playerName){

        super(new VBox(), 600, 300);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);


        SortingHat mysortingHat = new SortingHat();
        mysortingHat.assignHouse();

    }


}
