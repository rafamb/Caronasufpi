package br.ufpi.es.caronasufpi.visao;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.controle.ControladorUsuarios;
import br.ufpi.es.caronasufpi.dados.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Gerenciar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String email = bundle.getString("emailUsuario");

        ControladorUsuarios controladorUsuarios = new ControladorUsuarios();
        Usuario usuario= controladorUsuarios.carregaDadosUsuario(email);
        System.out.println(email);

        String nome= usuario.getNome();
        String sexo= usuario.getSexo();

        TextView nomeTxt = (TextView) findViewById(R.id.nome);
        TextView emailTxt = (TextView) findViewById(R.id.email);
        TextView sexoTxt = (TextView) findViewById(R.id.sexo);

        nomeTxt.setText(nome);
        emailTxt.setText(email);
        sexoTxt.setText(sexo);

       // Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        //btnVoltar.setOnClickListener(oncli);
    }

    private OnClickListener oncli = new OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };
}
