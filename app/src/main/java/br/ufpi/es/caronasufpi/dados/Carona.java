package br.ufpi.es.caronasufpi.dados;


import java.util.ArrayList;
import java.util.List;

public class Carona {
    private int id;
    private String horario;
    private String origem;
    private String destino;
    private Usuario motorista;
    private int vagas;
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

    public int getVagas(){ return vagas; }

    public Usuario getMotorista() {
        return motorista;
    }

    public void adicionarCaroneiro(Usuario u){
        caroneiros.add(u);
    }

    public void removerCaroneiro(Usuario u){
        caroneiros.remove(u);
    }

    public List<Usuario> getCaroneiros(){
        return caroneiros;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Carona(String horario,String origem, String destino, int vagas , Usuario u){
        this.horario = horario;
        this.origem = origem;
        this.destino = destino;
        this.motorista = u;
        this.vagas = vagas;
        this.caroneiros = new ArrayList<Usuario>();
    }
}
