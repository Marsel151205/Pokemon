package com.example.pokemon.data.remote.apiservices

import com.example.pokemon.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon() : Response<PokemonResponse>
}