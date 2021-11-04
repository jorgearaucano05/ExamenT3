package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exament3.Model.EntrenadorClass;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarEntrenadorActivity extends AppCompatActivity {

    EditText nombreEntrenador, puebloEntre, urlEntrena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrenador);

        nombreEntrenador = findViewById(R.id.nameEntrenador);
        puebloEntre = findViewById(R.id.puebloEntrenador);
        urlEntrena = findViewById(R.id.urlEntrenador);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/entrenador/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service Service = retrofit.create(Service.class);


        findViewById(R.id.RegistrarEntrena).setOnClickListener(view -> {

            String nombre = nombreEntrenador.getEditableText().toString().trim();
            String pueblo = puebloEntre.getEditableText().toString().trim();
            String img = urlEntrena.getEditableText().toString().trim();

            EntrenadorClass pok = new EntrenadorClass(nombre,pueblo,img);

            Call<Void> entre = Service.postCreateEntrenador(pok);
            entre.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    String respuesta = String.valueOf(response.code());
                    if (respuesta.equals("200")) {
                        Toast.makeText(getApplicationContext(), "Entrenador Registrado", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), " Entrenador no Registrado", Toast.LENGTH_SHORT).show();
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