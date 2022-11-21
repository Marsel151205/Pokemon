package com.example.pokemon.models

import com.example.pokemon.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class PokemonModel(
    override val id: Int,
    @SerializedName("name")
    val name: String
) : IBaseDiffModel<Int>
