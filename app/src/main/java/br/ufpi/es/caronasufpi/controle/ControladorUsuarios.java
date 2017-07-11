package br.ufpi.es.caronasufpi.controle;

import br.ufpi.es.caronasufpi.dados.RepositorioUsuarios;
import br.ufpi.es.caronasufpi.dados.Usuario;

public class ControladorUsuarios {
    public Usuario carregaDadosUsuario(String email){
        Usuario usuario = new Usuario();

        //Recupera informacoes do repositorio ou servico de base de usuarios
        RepositorioUsuarios usuarios = new RepositorioUsuarios();
        usuarios.popoulaRepositorioUsuarios();
        usuario = usuarios.buscaUsuario(email);

        if (usuario != null){
            return usuario;
        }else {
            String mensagem="Usuario não existe!";
            System.out.println(mensagem);
            return null;
        }
    }
}
