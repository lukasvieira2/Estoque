package com.lukas.estoque.controller;

import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextFlow erroDados;

    private final String usuarioCadastrado = "lukas@gmail.com";
    private final String senhaCadastrada = "123456";

    @FXML
    protected void aoApertarBotao(ActionEvent event) throws IOException {

        if ( usuarioCadastrado.equalsIgnoreCase(usuario.getText()) && senhaCadastrada.equals(senha.getText())){
            GerenciadorTela.getIntancia().trocarTela(event, "menu.fxml", "Sistema de Estoque - login");
        } else {
            erroDados.setVisible(true);
        }
    }

    @FXML
    protected  void aoEsquecerSenha(){
        System.out.println(" Você esqueceu! Já não é problema meu.");
    }

}
