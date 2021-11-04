package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.exament3.Adapter.PokemonAdapter;
import com.example.exament3.Model.PokemonClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service Service = retrofit.create(Service.class);
        Call<List<PokemonClass>> listGet = Service.getListPokemones();

        listGet.enqueue(new Callback<List<PokemonClass>>() {
            @Override
            public void onResponse(Call<List<PokemonClass>> call, Response<List<PokemonClass>> response) {

                String code = String.valueOf(response.code());
                if (code.equals("200")) {
                    Toast.makeText(getApplicationContext(), "HAY LISTA", Toast.LENGTH_SHORT).show();
                    List<PokemonClass> myList = response.body();
                    PokemonAdapter adapterList = new PokemonAdapter(myList, ListPokemonActivity.this);
                    recyclerView.setAdapter(adapterList);
                } else {
                    Toast.makeText(getApplicationContext(), "NO HAY LISTA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PokemonClass>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}