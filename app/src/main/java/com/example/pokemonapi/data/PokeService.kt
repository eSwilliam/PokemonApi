package com.example.pokemonapi.data

import com.example.pokemonapi.domain.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("https://pokeapi.co/api/v2/pokemon?limit=25")
    fun getPokemonList(
    ): Call<PokemonList?>?
}