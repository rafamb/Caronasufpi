package br.ufpi.es.caronasufpi.visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.dados.Usuario;

public class Dashboard extends AppCompatActivity {
    private Usuario usuario = new Usuario();
    private Bundle bundleUsuario = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        //carrega o bundle de Usuario para passar dados entre as Activities
        bundleUsuario.putString("nomeUsuario", usuario.getNome());
        bundleUsuario.putString("emailUsuario", usuario.getEmail());
    }

    @Override
    public void onBackPressed() {
        String mensagem="Usuário " + usuario.getNome().toString() + " já logado";
        Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

    //listarViagens
    public void listarViagens(View v){
        //chama a Tela de listar viagens ja registradas
        Intent intentListarViagens = new Intent(this, ListaCaronas.class);
        intentListarViagens.putExtras(bundleUsuario);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentListarViagens);
    }

    //inserirViagem
    public void inserirViagem(View v){
        //chama a Tela de inserir uma nova viagem
        // pode ser viagem de lazer ou de negocios
        Intent intentInserirViagens = new Intent(this, NovaCarona.class);
        intentInserirViagens.putExtras(bundleUsuario);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentInserirViagens);
    }

    //inserirGasto
    public void inserirGasto(View v){
        // TODO: chama a Tela de inserir um gasto de acordo com uma categoria (refeicao, combustivel, cinema, ...)
    }

    //fazConfiguracoes
    public void fazConfiguracoes(View v){
        // TODO: chama a tela que faz a configuracao do aplicativo
        // as configuracoes sao locais
    }

    public void sobre(View v){
        Intent intentSobre = new Intent(this,Sobre.class);
        startActivity(intentSobre);
    }
}
