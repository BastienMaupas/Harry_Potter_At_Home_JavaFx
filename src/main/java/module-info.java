module isep.a1.harry_potter_at_home_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens isep.a1.harry_potter_at_home_javafx to javafx.fxml;
    exports isep.a1.harry_potter_at_home_javafx;
}