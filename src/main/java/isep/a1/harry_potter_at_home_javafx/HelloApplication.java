package isep.a1.harry_potter_at_home_javafx;

import Scenes.Scene1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Harry Potter RPG");
        Scene scene = new Scene1(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}