package com.lukas.estoque.controller;

import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class RelatorioController {
    @FXML
    protected void aoVoltarMenu(ActionEvent event) throws IOException{
        GerenciadorTela.getIntancia().trocarTela(event,"menu.fxml", "Sistema de Estoque - Menu");
    }
}