package com.example.exament3;

import com.example.exament3.Model.EntrenadorClass;
import com.example.exament3.Model.PokemonClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    @GET("N00179858")
    Call<List<PokemonClass>> getListPokemones();

    @POST("N00179858/crear")
    Call<Void> postCreatePokemon(@Body PokemonClass pokemon);

    @GET("N00179858")
    Call<List<EntrenadorClass>> getListEntrenador();

    @POST("N00179858/crear")
    Call<Void> postCreateEntrenador(@Body EntrenadorClass entrenador);
}
