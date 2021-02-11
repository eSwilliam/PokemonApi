package com.example.pokemonapi.domain.model

import com.google.gson.annotations.SerializedName

data class PokemonList (
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val pokemon:List<Pokemon>? = null
)