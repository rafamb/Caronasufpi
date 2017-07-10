package br.ufpi.es.caronasufpi.controle;

import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.Usuario;


public class ControladorCarona {
    public void listarViagens(Usuario usuario){
        //TODO: implementar servico de listar viagens de um usuario
        System.out.println("chama o servico que lista viagens do usuario " + usuario.getNome());
    }

    public void novaViagem(Usuario usuario, Carona carona){
        //TODO: implementar servico de inserir uma carona de um usuario
        System.out.println("insere nova carona do usuario " + usuario.getNome());
    }
}
