package com.lukas.estoque.controller;

import com.lukas.estoque.service.RecuperacaoSenhaService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.awt.*;

public class NovaSenhaController {

    @FXML
    private PasswordField novaSenha;

    @FXML
    private PasswordField confirmarSenha;

    @FXML
    private Label senhaDiferente;

    private RecuperacaoSenhaService service ;

    public void novaSenha( RecuperacaoSenhaService service){
        this.service = service;
    }
    @FXML
    protected void aoConfirmarSenha(){

        String novaSenhaText = novaSenha.getText();

        String confirmaSenhaText = confirmarSenha.getText();

        if(novaSenhaText.isBlank()){
            senhaDiferente.setText("A nova senha não pode ficar em branco");
            senhaDiferente.setVisible(true);
            return;
        }
        if(!novaSenhaText.equals(confirmaSenhaText)){
            senhaDiferente.setVisible(true);
            return;
        }

        service.redeFinirSenha(novaSenhaText);
        ((Stage) novaSenha.getScene().getWindow()).close();

        service.redeFinirSenha(novaSenhaText);
        mostrarAlerta("Senha Alterada com sucesso!");
        ((Stage) novaSenha.getScene().getWindow()).close();

    }

    public void mostrarAlerta(String mensagem){


        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensagem);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
