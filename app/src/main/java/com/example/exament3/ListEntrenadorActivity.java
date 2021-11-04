package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.exament3.Adapter.PokemonAdapter;
import com.example.exament3.Model.EntrenadorClass;
import com.example.exament3.Model.PokemonClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_entrenador);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(" https://upn.lumenes.tk/entrenador/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service Service = retrofit.create(Service.class);
        Call<List<EntrenadorClass>> listGet = Service.getListEntrenador();

        listGet.enqueue(new Callback<List<EntrenadorClass>>() {
            @Override
            public void onResponse(Call<List<EntrenadorClass>> call, Response<List<EntrenadorClass>> response) {

                String code = String.valueOf(response.code());

            }

            @Override
            public void onFailure(Call<List<EntrenadorClass>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}