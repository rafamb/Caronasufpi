package br.ufpi.es.caronasufpi.visao;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.dados.Usuario;

public class MapasCaronas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Usuario usuario = new Usuario();

    private LatLng l1;
    private LatLng l2;
    String local1;
    String local2;
    int flag;
    private Bundle bundle;
    String horario;
    int vagas;

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_caronas);

        Bundle pontos = getIntent().getExtras();
        if (pontos != null){
            l1 = new LatLng(pontos.getDouble("lat1"),pontos.getDouble("long1"));
            l2 = new LatLng(pontos.getDouble("lat2"),pontos.getDouble("long2"));
            local1 = pontos.getString("local1");
            local2 = pontos.getString("local2");
            flag = pontos.getInt("flag");
            usuario.setNome(pontos.getString("nomeUsuario"));
            usuario.setEmail(pontos.getString("emailUsuario"));
            if(flag != 0){
                horario = pontos.getString("horario");
                vagas = pontos.getInt("vagas");
            }
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(l1).title(local1));
        mMap.addMarker(new MarkerOptions().position(l2).title(local2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(l1));
        mMap.setMinZoomPreference(15);
    }

    public void efetivar(View view){
        bundle = new Bundle();
        bundle.putString("origem",local1);
        bundle.putString("destino",local2);
        bundle.putString("nomeUsuario",usuario.getNome());
        bundle.putString("emailUsuario",usuario.getEmail());
        if(flag==0){
            Intent intent = new Intent(this, ListarCaronas.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            bundle.putString("horario",horario);
            bundle.putInt("vagas",vagas);
            Intent intent = new Intent(this, NovaCarona.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
