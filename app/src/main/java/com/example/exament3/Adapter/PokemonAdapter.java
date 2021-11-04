package com.example.exament3.Adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exament3.R;
import com.example.exament3.DetailPokemonActivity;
import com.example.exament3.Model.PokemonClass;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.viewHolderPokemon> {
    private final List<PokemonClass> list;
    private final Context mContext;

    public PokemonAdapter(List<PokemonClass> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public viewHolderPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolderPokemon(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.image_pokemones, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.viewHolderPokemon holder, int position) {

        PokemonClass pokemon = list.get(position);
        Picasso.get().load(pokemon.getUrl_imagen()).into(holder.image_anime);
        holder.text_anime.setText(pokemon.getNombre());
        holder.text_description.setText(pokemon.getTipo());

        holder.button_detail.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailPokemonActivity.class);
            intent.putExtra("poke", (Parcelable) pokemon);
            mContext.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewHolderPokemon extends RecyclerView.ViewHolder {

        ImageView image_anime;
        TextView text_anime, text_description;
        Button button_detail;

        public viewHolderPokemon(@NonNull View itemView) {
            super(itemView);

            image_anime = itemView.findViewById(R.id.image_anime);
            button_detail = itemView.findViewById(R.id.button_detail);
            text_anime = itemView.findViewById(R.id.text_anime);
            text_description = itemView.findViewById(R.id.text_description);
        }
    }
}
