package com.evelyn.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evelyn.infogram.R;
import com.evelyn.infogram.adapter.CardViewAdapter;
import com.evelyn.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment), false,view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir, View view) {
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://www.noticiasfides.com/voces-que-cuentan/conoce-la-imagen-mas-grande-de-la-virgen-del-socavon-de-bolivia", "Carlos Valdivia", "2 dias", "1 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/Samaipata#/media/Archivo:Samaipata,_Bolivia,_March_2016.jpg", "Luis Perez", "3 dias", "5 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/Colomi#/media/Archivo:Laguna_Corani_(Represa)_Chapare_Bolivia.jpg", "Fernando Torrico", "6 dias", "4 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/c/c1/El_paisaje_de_la_Serrania_de_Santiago_de_Chiquitos.jpg", "Maria Flores", "5 dias", "6 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/Telef%C3%A9rico#/media/Archivo:Estaci%C3%B3n_Irpawi_de_la_l%C3%ADnea_verde_de_Mi_Telef%C3%A9rico.jpg", "Rolando Morales", "3 dias", "2 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/d/d1/Los_Chorros%2C_Ray%C3%B3n%2C_S.L.P..jpg", "William Jaime", "4 dias", "5 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/R%C3%ADo_Aguas_Calientes#/media/Archivo:R%C3%ADo_Aguas_Calientes_(SE)_-_Robor%C3%A9,_Bolivia.jpg", "Roberto Paniagua", "2 dias", "3 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/Choch%C3%ADs#/media/Archivo:La_Muela_del_Diablo.jpg", "Lorena Herrera", "2 dias", "8 me gusta"));
        images.add(new Image("https://es.wikipedia.org/wiki/Cristo_de_la_Concordia#/media/Archivo:Cristo_de_la_Concordia_02.jpg", "Laura Caceres", "6 dias", "3 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/7/74/Cruzando_el_r%C3%ADo_Beni%2C_Bolivia.JPG", "Marcelo Rojas", "9 dias", "1 me gusta"));

        return images;
    }
}