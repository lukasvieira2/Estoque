package com.lukas.estoque.controller;

import com.lukas.estoque.model.Usuario;
import com.lukas.estoque.model.UsuarioDAO;
import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextFlow erroDados;

    private final UsuarioDAO bdUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected  void aoApertarBotao(Event event) throws IOException{

        String usuarioDigitado = usuario.getText().toLowerCase();
        String senhaDigitada = senha.getText();
        Optional<Usuario> usuarioEncontrado = bdUsuario.buscarProEmail(usuarioDigitado);

        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(senhaDigitada) ){

            GerenciadorTela.getIntancia().trocarTela(event, "menu.fxml", "Sistema Estoque - Menu");

    } else {
            erroDados.setVisible(true);
        }
    }


    @FXML
    protected void aoCadastrar(Event event) throws IOException {
        GerenciadorTela.getIntancia().trocarTela(event,"cadastro.fxml", "Sistemade Estoque - cadastrar estoque");
    }




    @FXML
    protected  void aoEsquecerSenha() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/lukas/estoque/esqueceuSenha.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sistema de Estoque - Esqueceu a senha");
        stage.show();
    }


}
