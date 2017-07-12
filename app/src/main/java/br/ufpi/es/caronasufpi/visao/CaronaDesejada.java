package br.ufpi.es.caronasufpi.visao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.controle.ControladorCarona;
import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.RepositorioUsuarios;
import br.ufpi.es.caronasufpi.dados.Usuario;

/**
 * Created by Penafort on 12/07/2017.
 */

public class CaronaDesejada extends AppCompatActivity{
    private ListView lista;
    Carona carona;
    Usuario usuario = new Usuario();

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caronadesejada);

        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            usuario = new RepositorioUsuarios().buscaUsuario(dados.getString("emailUsuario"));
            carona = new ControladorCarona().pesquisarId(dados.getInt("id"));
        }

        lista = (ListView) findViewById(R.id.listViewCaronas);
        ArrayList<String> array = new ArrayList<String>();

        TextView nome = (TextView)findViewById(R.id.textView17);
        String s = usuario.getNome();
        System.out.println(s);
        nome.setText(s);
        TextView email = (TextView)findViewById(R.id.textView18);
        email.setText(usuario.getEmail());
        TextView sexo = (TextView)findViewById(R.id.textView19);
        sexo.setText(usuario.getSexo());

        for(Usuario u: carona.getCaroneiros()){
            array.add(u.getNome());
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        lista.setAdapter(adapter);

        botao = (Button) findViewById(R.id.button3);
        botao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                efetivar(view);
            }
        });

    }

    public void efetivar(View view){

        Bundle bundle = new Bundle();
        bundle.putString("nomeUsuario",usuario.getNome());
        bundle.putString("emailUsuario",usuario.getEmail());
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}

