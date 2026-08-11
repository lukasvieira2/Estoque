package com.lukas.estoque.controller;

import com.lukas.estoque.model.UsuarioDAO;
import com.lukas.estoque.service.RecuperacaoSenhaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class EnviarEmailController {

    @FXML
    private TextField emailRecuperacao;

    @FXML
    private Label emailNaoCadastrado;

    private final RecuperacaoSenhaService service = new RecuperacaoSenhaService();
    private final UsuarioDAO baseUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected void aoValidarEmail(ActionEvent event) throws IOException {

        String email = emailRecuperacao.getText().trim();

        String codigo = service.solicitarRecuperacao(email, baseUsuario);



        if(codigo == null){
            emailNaoCadastrado.setVisible(true);
            return;
        }


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/lukas/estoque/codigo.fxml"));
        Parent root = fxmlLoader.load();

        CodigoConfirmacaoController controller = fxmlLoader.getController();
        controller.codigoConfirmacao(service, codigo);

        Scene scene = new Scene(root);
        Stage stage = (Stage) emailRecuperacao.getScene().getWindow();
        stage.setTitle("Código Confirmação");
        stage.setScene(scene);
        stage.show();







    }

}
