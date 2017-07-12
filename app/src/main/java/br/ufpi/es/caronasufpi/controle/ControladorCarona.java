package br.ufpi.es.caronasufpi.controle;

import java.util.List;

import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.RepositorioCaronas;
import br.ufpi.es.caronasufpi.dados.Usuario;


public class ControladorCarona {
    RepositorioCaronas r;
    public List<Carona> listarCaronas(String origem, String destino){
        r = new RepositorioCaronas();
        List<Carona> caronas = r.buscaCaronas(origem,destino);
        return caronas;
    }

    public void novaCarona(String horario,String origem, String destino, int vagas, Usuario u){
        Carona c = new Carona(horario,origem,destino,vagas,u);
        r = new RepositorioCaronas();
        r.insereCarona(c);
    }
}
