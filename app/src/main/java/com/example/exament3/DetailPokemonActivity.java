package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.exament3.Model.PokemonClass;
import com.squareup.picasso.Picasso;

public class DetailPokemonActivity extends AppCompatActivity {

    ImageView image_poke;
    EditText namePoke, typePoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);
        image_poke = findViewById(R.id.image_poke);
        namePoke = findViewById(R.id.namePoke);
        typePoke = findViewById(R.id.typePoke);

        PokemonClass pokemon = (PokemonClass) getIntent().getSerializableExtra("poke");

        namePoke.setText(pokemon.getNombre());
        typePoke.setText(pokemon.getTipo());

        Picasso.get().load(pokemon.getUrl_imagen()).into(image_poke);

        String la = String.valueOf(pokemon.getLatitude());
        String lo = String.valueOf(pokemon.getLongitude());

        findViewById(R.id.location_poke).setOnClickListener(view -> {
            Intent intent = new Intent(this, MapActivity.class);
            intent.putExtra("lati", la);
            intent.putExtra("long", lo);
            intent.putExtra("name", pokemon.getNombre());
            startActivity(intent);
        });
    }
}