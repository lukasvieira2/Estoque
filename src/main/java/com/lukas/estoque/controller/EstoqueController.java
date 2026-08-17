package com.lukas.estoque.controller;

import com.lukas.estoque.model.EstoqueDAO;
import com.lukas.estoque.model.Produto;
import com.lukas.estoque.util.GerenciadorTela;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        tabelaProdutos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
    protected void adcionarProduto(ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "produto.fxml", "Sistema de Estoque - Adcionar Produto");
    }

    @FXML
    protected void editarProduto(ActionEvent event) throws IOException {
        Produto produtoSelecionado = ( Produto ) tabelaProdutos.getSelectionModel().getSelectedItem();
        if( produtoSelecionado == null){
            mostrarAlerta("Selecione um produto para editar!");
            return;
        }
        GerenciadorTela.getIntancia().telaEdicao(event, "produto.fxml","Sistema de Estoque - Editar Produto", (ProdutoController controller) -> controller.preencherParaEdicao(produtoSelecionado));
    }

    public void mostrarAlerta(String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensagem);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }


    @FXML
    protected void removerProduto() {

        ObservableList produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItems();
        if (produtoSelecionado.isEmpty()) {
            mostrarAlerta("Selecione um produto para remover !");
            return;
        }

        List<Produto> listaProduto = new ArrayList<>(produtoSelecionado);
        String produtosExcluidos = "";
        for (var p : listaProduto){
            produtosExcluidos += p.getId() +" " + p.getNome()+"\n";
        }
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION, "Remover o produto \n" + produtosExcluidos + "\ndo estoque? ");
        confirmacao.setHeaderText(null);
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");
        confirmacao.getButtonTypes().setAll(btnSim, btnNao);
        confirmacao.showAndWait().ifPresent(botao -> {
            if (botao == btnSim) {
                dadosEstoque.remover(listaProduto);
            }
        });
}


    @FXML
    protected void  aoVoltarMenu(ActionEvent event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event, "menu.fxml", "Sistema de Estoque - Menu");
    }

}