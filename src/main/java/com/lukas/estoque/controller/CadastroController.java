package com.lukas.estoque.controller;

import com.lukas.estoque.model.Usuario;
import com.lukas.estoque.model.UsuarioDAO;
import com.lukas.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

import java.io.IOException;


public class CadastroController {

    @FXML
    private TextField usuarioCadastrar;

    @FXML
    private PasswordField senhaCadastrar;

    @FXML
    private PasswordField confirmarSenha;

    @FXML
    private Label usuarioInvalido;

    @FXML
    private TextFlow erroSenha;

    @FXML
    private Label senhaInvalida;

    private static UsuarioDAO dbUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected  void aoConfirmarCadastro(ActionEvent event) throws IOException {
        String usuario = usuarioCadastrar.getText();
        if(usuario.isBlank()){
            usuarioInvalido.setVisible(true);
            return;
        }
        String senha = senhaCadastrar.getText();
        if(senha.isBlank()){
            senhaInvalida.setVisible(true);
            return;
        }

        String senhaConfirmacao = confirmarSenha.getText();
        if(!senhaConfirmacao.equals(senha)){
            erroSenha.setVisible(true);
            return;
        }

        Usuario novoUsuario = new Usuario(usuario, senha);
        dbUsuario.cadastrarUsuario(novoUsuario);

        GerenciadorTela.getIntancia().trocarTela(event, "login.fxml","Sistema de Estoque - Login");

    }

    @FXML
    protected  void aoAcessarLogin(){

    }

}
