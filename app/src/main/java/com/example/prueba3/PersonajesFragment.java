package com.example.prueba3;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.prueba3.DTO.Personaje;
import com.example.prueba3.adapters.PersonajesListAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonajesFragment} factory method to
 * create an instance of this fragment.
 */
public class PersonajesFragment extends Fragment {

    private RequestQueue queue;
    private List<Personaje> personajes = new ArrayList<>();
    private ListView lvPersonajes;
    private PersonajesListAdapter adapter;
    private Button consejo;

    public PersonajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        queue = Volley.newRequestQueue(this.getActivity());
        this.lvPersonajes = getView().findViewById(R.id.listaPersonajesF);
        this.adapter = new PersonajesListAdapter(this.getActivity(),R.layout.list_personajes,this.personajes);
        this.lvPersonajes.setAdapter(this.adapter);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://thesimpsonsquoteapi.glitch.me/quotes", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            personajes.clear();
                             Personaje[] personajesObt =new Gson()
                                     .fromJson(response.getString("resultado")
                                    ,Personaje[].class);
                            personajes.addAll(Arrays.asList(personajesObt));
                        }catch (Exception e){
                            personajes = null;
                        }finally {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                personajes = null;
                adapter.notifyDataSetChanged();
            }
        });
        queue.add(jsonObjectRequest);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personajes, container, false);
    }
}