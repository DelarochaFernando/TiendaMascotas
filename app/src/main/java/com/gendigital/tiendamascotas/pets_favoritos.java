package com.gendigital.tiendamascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gendigital.petstore.R;
import com.gendigital.tiendamascotas.adapter.MyAdapter;
import com.gendigital.tiendamascotas.pojo.PetInfo;

import java.util.ArrayList;

public class pets_favoritos extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<PetInfo> listaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_favoritos);

        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(pets_favoritos.this, "Regresando", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rvPetInfo);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new GridLayoutManager(this, 2);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        cargaLista();
        mAdapter = new MyAdapter(listaData, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void cargaLista () {
        listaData = new ArrayList<PetInfo>();

        listaData.add(new PetInfo("Perro",R.drawable.perro));
        listaData.add(new PetInfo("Gato", R.drawable.gato));
        listaData.add(new PetInfo("Loro",R.drawable.loro));
        listaData.add(new PetInfo("Tortuga",R.drawable.tortuga));
        listaData.add(new PetInfo("Pez",R.drawable.pez));
        listaData.add(new PetInfo("Serpiente",R.drawable.serpiente));
    }
}
