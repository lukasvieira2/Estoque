module com.lukas.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;


    opens com.lukas.estoque to javafx.fxml;
    opens com.lukas.estoque.controller to javafx.fxml;
    opens com.lukas.estoque.model to javafx.base;

    exports com.lukas.estoque;
}