package com.gendigital.tiendamascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gendigital.tiendamascotas.pojo.PetInfo;
import com.gendigital.petstore.R;

import java.util.ArrayList;

/**
 * Created by Gaby on 10/06/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<PetInfo> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<PetInfo> myDataset, Activity activity) {
        this.mDataset = myDataset;
        this.activity = activity;
    }

    //Inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvMeGusta;
        private ImageButton btnMegusta;

        public ViewHolder(View itemView) {
            //it works as Activty onCreate(), declaring views allocated in.
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
            btnMegusta = (ImageButton) itemView.findViewById(R.id.btnMegusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        ViewHolder vh = new ViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position

        final PetInfo petinfo = mDataset.get(position);
        holder.imgFoto.setImageResource(petinfo.getFoto());
        holder.tvNombreCV.setText(petinfo.getNombre());
        holder.tvMeGusta.setText(petinfo.getMeGusta());
        holder.btnMegusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + petinfo.getNombre(), Toast.LENGTH_SHORT).show();
                petinfo.incrementaMeGusta();
                holder.tvMeGusta.setText(petinfo.getMeGusta());
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
