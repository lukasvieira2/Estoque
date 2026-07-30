package com.lukas.estoque.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstoqueDAO {
    private static EstoqueDAO instancia;
    private final ObservableList<Produto> listaProdutos;
    private int idproduto = 1;

    private EstoqueDAO(){
        this.listaProdutos = FXCollections.observableArrayList();
    }
    public static EstoqueDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstoqueDAO();}
        return instancia;
    }

    public void adcionar(Produto produto){
        produto.setId(idproduto++);
        listaProdutos.add(produto);
    }
    public ObservableList<Produto> listarProdutos(){
        return listaProdutos;
    }
    public void remover(Produto produto){
        listaProdutos.remove(produto);
    }
}
