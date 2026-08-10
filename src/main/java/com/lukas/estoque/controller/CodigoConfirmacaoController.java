package com.lukas.estoque.controller;

import com.lukas.estoque.model.UsuarioDAO;
import com.lukas.estoque.service.RecuperacaoSenhaService;
import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;

public class CodigoConfirmacaoController {

    @FXML
    private Label codigoInformado;

    @FXML
    private TextField codigoRecuperacao;

    @FXML
    private Label codigoInvalido;

    private final RecuperacaoSenhaService service = new RecuperacaoSenhaService();

    @FXML
    protected void aoValidarCodigo(ActionEvent event) throws IOException {

        String codigo = codigoInformado.getText();

        if(!service.validarCodigo(codigo)){

            codigoInvalido.setVisible(true);
            return;
        }
        GerenciadorTela.getIntancia().trocarTela(event,"senhaRecuperacao.fxml","Recuperação de senha");
    }


}
