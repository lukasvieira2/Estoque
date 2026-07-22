package com.lukas.estoque;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private BorderPane telaMenu;

    @FXML
    private ImageView minhaImagem;

    @FXML
    public void initialize() {
        // Mantém a proporção da imagem sem distorcer
        minhaImagem.setPreserveRatio(true);

        // Cria um Binding reativo que calcula a largura com base na janela
        DoubleBinding larguraCalculada = Bindings.createDoubleBinding(() -> {
            double larguraAtual = telaMenu.getWidth();
            double larguraProporcional = larguraAtual * 0.3; // 30% da largura do painel

            // Trava entre o mínimo de 100 e o máximo de 200
            return Math.max(100.0, Math.min(200.0, larguraProporcional));
        }, telaMenu.widthProperty());

        // Vincula a propriedade fitWidth diretamente ao Binding reativo
        minhaImagem.fitWidthProperty().bind(larguraCalculada);
    }

    @FXML
    protected void aoSair(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}