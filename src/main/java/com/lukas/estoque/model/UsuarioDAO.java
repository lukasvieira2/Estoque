package com.lukas.estoque.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsuarioDAO {

    private static UsuarioDAO instancia;

    private Set<Usuario> bdUsuarios = new HashSet<>();

    public UsuarioDAO (){

        bdUsuarios = new HashSet<>();
        cadastrarUsuario(new Usuario("lukas@gmail.com","123"));
        cadastrarUsuario(new Usuario("admin@gmail.com","012"));
    }

    public static UsuarioDAO getInstancia(){
        if(instancia == null){
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public Set<Usuario> getBdUsuarios(){
        return bdUsuarios;

    }
    public Optional<Usuario> buscarProEmail(String email){
        return bdUsuarios.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }
    public void cadastrarUsuario(Usuario usuario){
        bdUsuarios.add(usuario);
    }
}

