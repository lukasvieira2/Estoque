module com.lukas.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.lukas.estoque to javafx.fxml;
    exports com.lukas.estoque;
    exports com.lukas.estoque.controller;
    opens com.lukas.estoque.controller to javafx.fxml;
}