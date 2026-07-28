package com.lukas.estoque.controller;

import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {


    @FXML
    protected void aoVisualizarEstoque (ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "estoque.fxml", "Sistema de Estoque - estoque");
    }
    @FXML
    protected  void aoCadastrarProdutos (ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "produto.fxml", "Sistema de Estoque - Produtos");
    }

    @FXML
    protected  void aoGerarRelatorio (ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "relatorio.fxml", "Sistema de Estoque - Relatório");
    }

    @FXML
    protected void aoSair(ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "login.fxml", "Sistema de Estoque - Menu");
    }
}