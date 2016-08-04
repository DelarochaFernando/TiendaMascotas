package com.gendigital.tiendamascotas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gendigital.petstore.R;
import com.gendigital.tiendamascotas.adapter.MyAdapter;
import com.gendigital.tiendamascotas.pojo.PetInfo;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView rvPetInfo;
    private RecyclerView.Adapter mAdapter;
    ArrayList<PetInfo> mascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvPetInfo = (RecyclerView)v.findViewById(R.id.rvPetInfo);
        //generarLinearLayout()
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetInfo.setLayoutManager(llm);
        cargaLista();
        inicializarAdaptador();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void cargaLista() {
        //PetInfo MisDatos = new PetInfo(); // para guardar el arreglo en la clase
        mascotas = new ArrayList<PetInfo>();

        mascotas.add(new PetInfo("Perro", R.drawable.perro, 0));
        mascotas.add(new PetInfo("Gato", R.drawable.gato, 0));
        mascotas.add(new PetInfo("Loro", R.drawable.loro, 0));
        mascotas.add(new PetInfo("Tortuga", R.drawable.tortuga, 0));
        mascotas.add(new PetInfo("Pez", R.drawable.pez, 0));
        mascotas.add(new PetInfo("Serpiente", R.drawable.serpiente));
        mascotas.add(new PetInfo("Otro Perro", R.drawable.perro, 0));
        mascotas.add(new PetInfo("Otro Gato", R.drawable.gato, 0));
        mascotas.add(new PetInfo("Otro Loro", R.drawable.loro));
        mascotas.add(new PetInfo("Otra Tortuga", R.drawable.tortuga, 0));
        mascotas.add(new PetInfo("Otro Pez", R.drawable.pez, 0));
        mascotas.add(new PetInfo("Otra Serpiente", R.drawable.serpiente));

        for (PetInfo pet : mascotas) {
            PetInfo.setItem(pet);
        }
    }

    public void inicializarAdaptador(){
        mAdapter = new MyAdapter(mascotas, getActivity());
        rvPetInfo.setAdapter(mAdapter);
    }
}
