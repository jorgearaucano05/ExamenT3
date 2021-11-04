package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exament3.Model.PokemonClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarPokemonActivity extends AppCompatActivity {

    EditText nombrePokemon, tipoPokemon, LatitudPokemon, LongitudPokemon, URLPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pokemon);
        nombrePokemon = findViewById(R.id.namePoke);
        tipoPokemon = findViewById(R.id.typePoke);
        LatitudPokemon = findViewById(R.id.latitudePoke);
        LongitudPokemon = findViewById(R.id.longitudePoke);
        URLPokemon = findViewById(R.id.urlPoke);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service Service = retrofit.create(Service.class);


        findViewById(R.id.registrarPoke).setOnClickListener(view -> {

            String nombre = nombrePokemon.getEditableText().toString().trim();
            String tipo = tipoPokemon.getEditableText().toString().trim();
            String lat = LatitudPokemon.getEditableText().toString().trim();
            String lon = LongitudPokemon.getEditableText().toString().trim();
            String img = URLPokemon.getEditableText().toString().trim();

            PokemonClass pok = new PokemonClass(nombre, tipo, img, Float.parseFloat(lat), Float.parseFloat(lon));

            Call<Void> entre = Service.postCreatePokemon(pok);
            entre.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    String respuesta = String.valueOf(response.code());
                    if (respuesta.equals("200")) {
                        Toast.makeText(getApplicationContext(), "Pokemon Registrado", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), " Pokemon no Registrado", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });


    }
}