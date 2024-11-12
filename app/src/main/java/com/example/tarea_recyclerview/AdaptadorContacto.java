package com.example.tarea_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorContacto extends RecyclerView.Adapter<AdaptadorContacto.ContactoViewHolder> {

    ArrayList<Contacto> coleccion;

    public AdaptadorContacto(ArrayList<Contacto> coleccion){
        this.coleccion=coleccion;
    }

    @NonNull
    @Override
    public AdaptadorContacto.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdaptadorContacto.ContactoViewHolder contactoViewHolder=
                new ContactoViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto,parent,false)
                );
        return contactoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorContacto.ContactoViewHolder holder, int position) {
        Contacto contacto=coleccion.get(position);
        holder.imageView.setImageResource(contacto.getFoto());
        holder.nombre.setText(contacto.getNombre());
        holder.apellidos.setText(contacto.getApellidos());
        holder.email.setText(contacto.getEmail());
        holder.telefono.setText(contacto.getTelefono());

    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nombre;
        TextView apellidos;
        TextView email;
        TextView telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.nombre);
            apellidos = itemView.findViewById(R.id.apellidos);
            email = itemView.findViewById(R.id.email);
            telefono = itemView.findViewById(R.id.telefono);
        }
    }
}
