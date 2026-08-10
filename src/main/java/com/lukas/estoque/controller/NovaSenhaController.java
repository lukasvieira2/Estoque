package com.lukas.estoque.controller;

import com.lukas.estoque.service.RecuperacaoSenhaService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class NovaSenhaController {

    @FXML
    private PasswordField novaSenha;

    @FXML
    private PasswordField confirmarSenha;

    @FXML
    private Label senhaDiferente;

    private  RecuperacaoSenhaService service = new RecuperacaoSenhaService();

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


    }

}
