package br.ufpi.es.caronasufpi.visao;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.ufpi.es.caronasufpi.controle.ControladorCarona;
import br.ufpi.es.caronasufpi.dados.Usuario;
import br.ufpi.es.caronasufpi.R;


public class NovaCarona extends AppCompatActivity {
    Usuario usuario = new Usuario();

    private EditText horario;
    private EditText vagas;

    Spinner sistema;
    Spinner sistema2;

    private Bundle bundle = new Bundle();

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        //this.inserirViagem();

        sistema = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        sistema.setAdapter(adapter);

        sistema2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.spinner2,android.R.layout.simple_spinner_item);
        sistema2.setAdapter(adapter2);

        horario = (EditText) findViewById(R.id.editText);
        vagas = (EditText) findViewById(R.id.editText2);

        botao = (Button) findViewById(R.id.button3);
        botao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                irMapa(view);
            }
        });
    }

    /*public void inserirViagem(){
        new ControladorCarona().novaCarona(horario.getText().toString(),sistema.getSelectedItem().toString(),
                sistema2.getSelectedItem().toString(),usuario);
    }*/

    static private LatLng localizarPonto(Spinner s){
        long r = s.getSelectedItemId();
        if(r == 0){
            return new LatLng(-5.055872, -42.788638);
        } else if(r == 1){
            return new LatLng( -5.047862, -42.784164);
        } else if(r == 2){
            return new LatLng(-5.058768, -42.795416);
        } else if(r == 3){
            return new LatLng( -5.057734, -42.797452);
        } else if(r == 4){
            return new LatLng( -5.056588, -42.799422);
        } else {
            return new LatLng( -5.060661, -42.796017);
        }
    }

    public void irMapa(View view){

        sistema = (Spinner) findViewById(R.id.spinner);
        sistema2 = (Spinner) findViewById(R.id.spinner2);
        LatLng l1 = localizarPonto(sistema);
        LatLng l2 = localizarPonto(sistema2);
        String local1 = sistema.getSelectedItem().toString();
        String local2 = sistema2.getSelectedItem().toString();

        bundle.putDouble("lat1",l1.latitude);
        bundle.putDouble("long1",l1.longitude);
        bundle.putString("local1",local1);
        bundle.putDouble("lat2",l2.latitude);
        bundle.putDouble("long2",l2.longitude);
        bundle.putString("local2",local2);
        bundle.putInt("flag",1);
        Intent intent = new Intent(this, MapasCaronas.class);
        intent.putExtras(bundle);

        startActivity(intent);

    }

}
