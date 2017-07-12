package br.ufpi.es.caronasufpi.visao;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.Activity;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.controle.ControladorCarona;
import br.ufpi.es.caronasufpi.controle.ControladorUsuarios;
import br.ufpi.es.caronasufpi.dados.Carona;
import br.ufpi.es.caronasufpi.dados.RepositorioUsuarios;
import br.ufpi.es.caronasufpi.dados.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Gerenciar extends Activity {
    private ListView lista;
    Carona carona;
    Usuario usuario = new Usuario();

    private TextView nome;
    private TextView email;
    private TextView sexo;


    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar);

        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            usuario = new RepositorioUsuarios().buscaUsuario(dados.getString("emailUsuario"));
        }

        nome = (TextView)findViewById(R.id.nome);
        nome.setText(usuario.getNome());
        email = (TextView)findViewById(R.id.email);
        email.setText(usuario.getEmail());
        sexo = (TextView)findViewById(R.id.sexo);
        sexo.setText(usuario.getSexo());

        /*lista = (ListView) findViewById(R.id.listViewCaronas);
        ArrayList<String> array = new ArrayList<String>();



        for(Usuario u: carona.getCaroneiros()){
            array.add(u.getNome());
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        lista.setAdapter(adapter);
*/
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