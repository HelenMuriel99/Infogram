package com.evelyn.infogram.adapter;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.evelyn.infogram.R;
import com.evelyn.infogram.model.Image;
import com.evelyn.infogram.view.ImageDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends Adapter<CardViewAdapter.CardViewHolder> {
    //Lista de Imagenes
    private ArrayList<Image> images;
    private  int resource;
    private Activity activity;

    public CardViewAdapter(ArrayList<Image> images, int resource, Activity activity){
        this.images = images;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);


        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Image image = images.get(position);
        //image
        Picasso.get().load(image.getUrlImagen()).into(holder.imageCardView);
        holder.usernameCardView.setText(image.getUsername());
        holder.cantidadDiasCardView.setText(image.getCantidadDias());
        holder.cantidadMeGustaCardView.setText(image.getCantidadMeGusta());


        //onclickKistener
        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ImageDetailActivity.class);

                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);

                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.imageCardView, activity.getString(R.string.transitionName_imageCardView)).toBundle());

                }else {
                    activity.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageCardView;
        private TextView usernameCardView;
        private TextView cantidadDiasCardView;
        private TextView cantidadMeGustaCardView;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCardView = itemView.findViewById(R.id.imageCardView);
            usernameCardView = itemView.findViewById(R.id.usernameCardView);
            cantidadDiasCardView = itemView.findViewById(R.id.cantidadDiasCardView);
            cantidadMeGustaCardView = itemView.findViewById(R.id.cantidadMeGuastaCardView);
        }
    }
}
