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

    private ArrayList<Contacto> coleccion;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Contacto contacto);
    }


    public AdaptadorContacto(ArrayList<Contacto> coleccion, OnItemClickListener listener) {
        this.coleccion = coleccion;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout del item (contacto.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto, parent, false);
        return new ContactoViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = coleccion.get(position);
        holder.bind(contacto, listener);
    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }



    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nombre, apellidos, email, telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.nombre);
            apellidos = itemView.findViewById(R.id.apellidos);
            email = itemView.findViewById(R.id.email);
            telefono = itemView.findViewById(R.id.telefono);
        }

        public void bind(final Contacto contacto, final OnItemClickListener listener) {
            imageView.setImageResource(contacto.getFoto());
            nombre.setText(contacto.getNombre());
            apellidos.setText(contacto.getApellidos());
            email.setText(contacto.getEmail());
            telefono.setText(contacto.getTelefono());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(contacto);
                }
            });
        }
    }
}
