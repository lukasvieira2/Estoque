module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.lukas.estoque to javafx.fxml;
    exports com.lukas.estoque;
}