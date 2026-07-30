package com.lukas.estoque.controller;

import com.lukas.estoque.model.EstoqueDAO;
import com.lukas.estoque.model.Produto;
import com.lukas.estoque.util.GerenciadorTela;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;

public class EstoqueController {

    @FXML
    private TextField campoBusca;

    @FXML
    private TableView tabelaProdutos;

    @FXML
    private TableColumn colunaId;

    @FXML
    private TableColumn colunaNome;

    @FXML
    private TableColumn colunaCategoria;

    @FXML
    private TableColumn colunaQuantidade;

    @FXML
    private TableColumn colunaPreco;

    private final EstoqueDAO dadosEstoque = EstoqueDAO.getInstancia();
    private FilteredList<Produto> ListaFiltrada;

    @FXML
    public void initialize(){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome") );
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));

        ListaFiltrada = new FilteredList<>(dadosEstoque.listarProdutos(), p -> true);
        tabelaProdutos.setItems(ListaFiltrada);

        campoBusca.textProperty().addListener( (obs, textoAntigo, textoNovo)->{
            String filtro = textoNovo == null ? "" : textoNovo.toLowerCase();
            ListaFiltrada.setPredicate( produto -> filtro.isEmpty() || produto.getNome().toLowerCase().contains(filtro) || produto.getCategoria().toLowerCase().contains(filtro) || String.valueOf(produto.getPreco()).contains(filtro));
        });
    }












    @FXML
    protected void adcionarProduto(){

    }

    @FXML
    protected void editarProduto(){

    }

    @FXML
    protected void removerProduto(){

    }

    @FXML
    protected void  aoVoltarMenu(ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "menu.fxml", "Sistema de Estoque - Menu");
    }

}