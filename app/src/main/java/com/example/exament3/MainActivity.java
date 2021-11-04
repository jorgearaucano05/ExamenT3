package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mis_pokemones).setOnClickListener(view -> startActivity(new Intent(this, ListPokemonActivity.class)));
        findViewById(R.id.RegistrarPokemon).setOnClickListener(view -> startActivity(new Intent(this, RegistrarPokemonActivity.class)));
        findViewById(R.id.RegistrarEntrenador).setOnClickListener(view -> startActivity(new Intent(this, RegistrarEntrenadorActivity.class)));
    }
}