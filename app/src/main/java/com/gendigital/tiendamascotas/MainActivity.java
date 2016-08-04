package com.gendigital.tiendamascotas;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gendigital.petstore.R;
import com.gendigital.tiendamascotas.adapter.PageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager mLayoutManager;

    //public ArrayList<PetInfo> listaData;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        //Toolbar toolbar = (Toolbar)findViewById(R.id.Toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager();

        //setSupportActionBar(actionBar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        /*ImageButton imageButton = (ImageButton) actionBar.findViewById(R.id.btn_Fav5);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();
                verFavoritos(view);
            }
        });

       // mRecyclerView = (RecyclerView) findViewById(R.id.rvPetInfo);
        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new GridLayoutManager(this, 2);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       // mRecyclerView.setLayoutManager(mLayoutManager);
       //cargaLista();

        //mRecyclerView.setAdapter(mAdapter);*/

    }

    private ArrayList<Fragment> agregarFragments() {

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setUpViewPager() {
        vp.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(vp);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
    }


    public void verFavoritos(View v) {
        Intent ventanaFav = new Intent(this, Prueba.class);
        ventanaFav.putExtra("i1", 4);
        ventanaFav.putExtra("i2", 1);
        ventanaFav.putExtra("i3", 0);
        ventanaFav.putExtra("i4", 7);
        ventanaFav.putExtra("i5", 9);
        startActivity(ventanaFav);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.contacto:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.acercaDe:
                Intent intent1 = new Intent(this, AcercaDe.class);
                startActivity(intent1);
                break;

            case R.id.action_favorite:
                Intent intent2 = new Intent(this, pets_favoritos.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}