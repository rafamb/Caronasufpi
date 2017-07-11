package br.ufpi.es.caronasufpi.controle;

import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.RepositorioCaronas;
import br.ufpi.es.caronasufpi.dados.Usuario;


public class ControladorCarona {
    RepositorioCaronas r;
    public void listarViagens(Usuario usuario){
        //TODO: implementar servico de listar viagens de um usuario
        System.out.println("chama o servico que lista viagens do usuario " + usuario.getNome());
    }

    public void novaCarona(String horario,String origem, String destino, Usuario u){
        Carona c = new Carona(horario,origem,destino,u);
        r = new RepositorioCaronas();
        r.insereCarona(c);
    }
}
