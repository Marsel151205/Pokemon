package com.example.pokemon.ui.fragments.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemon.base.BaseViewModel
import com.example.pokemon.common.Resource
import com.example.pokemon.data.repositories.PokemonRepository
import com.example.pokemon.models.PokemonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository): BaseViewModel() {

    private val pokemonList = MutableLiveData<Resource<PokemonResponse>>()
    val pokemonState: LiveData<Resource<PokemonResponse>> = pokemonList

    fun fetchPokemon() = repository.fetchPokemon().collectRequest(pokemonList)

}