package com.gendigital.tiendamascotas;

import com.gendigital.tiendamascotas.adapter.MyAdapter;
import com.gendigital.tiendamascotas.pojo.PetInfo;

import java.util.ArrayList;

/**
 * Created by Fernado De la Rocha on 24/07/2016.
 */
public interface IRecyclerViewFragment {

    public void generarLinearLayout();
    public MyAdapter crearAdaptador (ArrayList<PetInfo> pets);
}
