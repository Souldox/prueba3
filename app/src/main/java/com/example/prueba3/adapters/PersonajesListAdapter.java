package com.example.prueba3.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prueba3.DTO.Personaje;
import com.example.prueba3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajesListAdapter extends ArrayAdapter<Personaje> {

    private List<Personaje> personajes;
    private Activity contexto;


    public PersonajesListAdapter(@NonNull Activity context, int resource, @NonNull List<Personaje> objects) {
        super(context, resource, objects);
        this.personajes = objects;
        this.contexto = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_personajes,null,true);
        TextView nombreTxt = rowView.findViewById(R.id.nombrePersonaje);
        TextView fraseTxt = rowView.findViewById(R.id.frasePersonaje);
        ImageView imageP = rowView.findViewById(R.id.imgPersonaje);

        nombreTxt.setText(this.personajes.get(position).getPersonaje());
        fraseTxt.setText(this.personajes.get(position).getFrase());
        Picasso.get().load(this.personajes.get(position).getImg()).resize(300,300)
                .centerCrop()
                .into(imageP);
        return rowView;
    }
}
