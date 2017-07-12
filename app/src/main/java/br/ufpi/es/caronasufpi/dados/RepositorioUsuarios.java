package br.ufpi.es.caronasufpi.dados;

import java.util.LinkedList;
import java.util.List;


public class RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuarios(){
        this.usuarios = new LinkedList<Usuario>();
        popoulaRepositorioUsuarios();
    }

    public void insereUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public Usuario buscaUsuario(String email){
        Usuario auxiliar=null;

        for (Usuario u : usuarios){
            if (u.getEmail().equals(email)){
                auxiliar = u;
                break;
            }else{
                auxiliar = null;
            }
        }
        return auxiliar;
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void popoulaRepositorioUsuarios(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Rafael Martins Barros");
        usuario1.setEmail("rafael");
        usuario1.setEndereco("Rua 31 de Março");
        usuario1.setSenha("123");
        usuario1.setSexo("Masculino");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Mauricio Boaventura");
        usuario2.setEmail("mauboa");
        usuario2.setEndereco("Rua 31 de Março");
        usuario2.setSenha("123");
        usuario2.setSexo("Masculino");

        insereUsuario(usuario1);
        insereUsuario(usuario2);
    }
}