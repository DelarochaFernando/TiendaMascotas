package com.gendigital.tiendamascotas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gendigital.petstore.R;
import com.gendigital.tiendamascotas.adapter.MyAdapter;
import com.gendigital.tiendamascotas.pojo.PetInfo;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by Fernado De la Rocha on 22/06/2016.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView rvPetInfo2;
    private RecyclerView.Adapter adaptador;
    ArrayList<PetInfo> listaData;
    private TextView tvNombrePet;
    private CircularImageView ivPet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvPetInfo2 = (RecyclerView)v.findViewById(R.id.rvPetInfo2);
        ivPet = (CircularImageView)v.findViewById(R.id.cIVPet);
        tvNombrePet = (TextView)v.findViewById(R.id.tvNombrePet);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetInfo2.setLayoutManager(glm);
        cargaLista();
        inicializarAdaptador();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void cargaLista() {
        //PetInfo MisDatos = new PetInfo(); // para guardar el arreglo en la clase
        listaData = new ArrayList<PetInfo>();

        listaData.add(new PetInfo("Gato", R.drawable.gato, 3));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 5));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 4));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 2));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 8));
        listaData.add(new PetInfo("Gato", R.drawable.gato,6));


        for (PetInfo pet : listaData) {
            PetInfo.setItem(pet);
        }
    }

    public void inicializarAdaptador(){
        adaptador = new MyAdapter(listaData, getActivity());
        rvPetInfo2.setAdapter(adaptador);
    }
}
