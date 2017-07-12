package br.ufpi.es.caronasufpi.dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rfeba on 11/07/2017.
 */

public class RepositorioCaronas {
    private List<Carona> caronas;

    public RepositorioCaronas(){
        this.caronas = new LinkedList<Carona>();
    }

    public void insereCarona(Carona c){
        caronas.add(c);
    }

    public List<Carona> buscaCaronas(String origem, String destino){
        List<Carona> c = new ArrayList<Carona>();
        for(Carona carona:caronas){
            if(carona.getOrigem().equals(origem) && carona.getDestino().equals(destino)){
                c.add(carona);
            }
        }
        return c;
    }

    public List<Carona> getCaronas(){
        return caronas;
    }

}
