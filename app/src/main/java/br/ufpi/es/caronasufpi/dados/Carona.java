package br.ufpi.es.caronasufpi.dados;


import java.util.ArrayList;
import java.util.List;

public class Carona {
    private String horario;
    private String origem;
    private String destino;
    private Usuario motorista;
    private List<Usuario> caroneiros;

    public String getHorario() {
        return horario;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }


    public void adicionarCaroneiro(Usuario u){
        caroneiros.add(u);
    }

    public void removerCaroneiro(Usuario u){
        caroneiros.remove(u);
    }

    public Carona(String horario,String origem, String destino, Usuario u){
        this.horario = horario;
        this.origem = origem;
        this.destino = destino;
        this.motorista = u;
        this.caroneiros = new ArrayList<Usuario>();
    }
}
