package br.ufpi.es.caronasufpi.visao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.controle.ControladorCarona;
import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.RepositorioCaronas;

/**
 * Created by Penafort on 12/07/2017.
 */

public class ListarCaronas extends AppCompatActivity {
    private ListView lista;
    String origem;
    String destino;
    List<Carona> caronas = new LinkedList<Carona>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listacaronas);

        Bundle dados = getIntent().getExtras();
        if (dados != null){
            origem = dados.getString("origem");
            destino = dados.getString("destino");
        }

        this.listarCaronas();

        lista = (ListView) findViewById(R.id.listViewCaronas);
        ArrayList<String> array = new ArrayList<String>();

        for(Carona c: caronas){
            array.add("Horario: "+c.getHorario());
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        lista.setAdapter(adapter);

    }

    private void listarCaronas(){
        caronas = new ControladorCarona().listarCaronas(origem,destino);
    }

}
