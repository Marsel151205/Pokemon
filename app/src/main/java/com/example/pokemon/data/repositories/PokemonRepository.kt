package com.example.pokemon.data.repositories

import com.example.pokemon.base.BaseRepository
import com.example.pokemon.data.remote.apiservices.PokemonApiService
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val service: PokemonApiService) : BaseRepository() {

     fun fetchPokemon() = doRequest {
        service.fetchPokemon()
    }
}