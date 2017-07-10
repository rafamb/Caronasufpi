package br.ufpi.es.caronasufpi.controle;

import br.ufpi.es.caronasufpi.dados.Usuario;

public class ControladorUsuarios {
    public Usuario carregaDadosUsuario(String email){
        //TODO: implementar servico de busca de usuario por email
        Usuario usuario = new Usuario();
        //Procurar usuario...
        //se usuario existe
        if (email.equals("rafael@gmail.com")){
            usuario.setNome("Rafael Martins");
            usuario.setEmail("rafael@gmail.com");
            usuario.setEndereco("Rua 31 de Março");
            usuario.setSenha("123");
            usuario.setSexo("Masculino");
        }else {
            String mensagem="Usuario não existe!";
            System.out.println(mensagem);
            return null;
        }
        return usuario;
    }
}
