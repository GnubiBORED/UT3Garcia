package com.politecnico.dam;


import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> centroNombres;
    ArrayList<String> Direcciones;
    ArrayList<String> Localidades;
    ArrayList<Integer> Telefonos;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> centroNombres, ArrayList<String> Direcciones, ArrayList<String> Localidades,ArrayList<Integer> Telefono) {
        this.context = context;
        this.centroNombres = centroNombres;
        this.Direcciones = Direcciones;
        this.Localidades = Localidades;
        this.Telefonos = Telefono;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.name.setText(centroNombres.get(position));
        holder.direccion.setText(Direcciones.get(position));
        holder.localidad.setText(Localidades.get(position));
        holder.telefono.setText(String.valueOf(Telefonos.get(position)));

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person centroNombre on item click
                Toast.makeText(context, String.valueOf(Telefonos.get(position)), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return centroNombres.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, direccion, localidad,telefono;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.centroNombre);
            direccion = (TextView) itemView.findViewById(R.id.calleDireccion);
            localidad = (TextView) itemView.findViewById(R.id.poblacionLocalidad);
            telefono =  (TextView) itemView.findViewById(R.id.numTelefono);

        }
    }
}