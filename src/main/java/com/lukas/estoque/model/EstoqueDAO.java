package com.lukas.estoque.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.PublicKey;

public class EstoqueDAO {
    private static EstoqueDAO instancia;
    private final ObservableList<Produto> listaProduto;
    private int idproduto = 1;

    private EstoqueDAO(){
        this.listaProduto = FXCollections.observableArrayList();
    }
    public static EstoqueDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstoqueDAO();}
        return instancia;
    }

    public void adcionar(Produto produto){
        produto.setId(idproduto++);
        listaProduto.add(produto);
    }
    public ObservableList<Produto> listarProdutos(){
        return listarProdutos();
    }
    public void remover(Produto produto){
        listaProduto.remove(produto);
    }
}
