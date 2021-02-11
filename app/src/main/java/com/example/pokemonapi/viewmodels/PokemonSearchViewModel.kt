package com.example.pokemonapi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pokemonapi.data.PokeRepository
import com.example.pokemonapi.domain.model.PokemonList

class PokemonSearchViewModel(application: Application) : AndroidViewModel(application) {
    var pokeRepository: PokeRepository? = null
    var pokemonResponseLiveData: LiveData<PokemonList?>? = null

    fun BookSearchViewModelJava(application: Application) {
        super(application)
    }

    fun init() {
        pokeRepository = PokeRepository()
        pokemonResponseLiveData = pokeRepository?.pokemonResponseLiveData
    }

    fun searchVolumes() {
        pokeRepository?.searchPokemon()
    }

//    fun getPokemonResponseLiveData(): LiveData<PokemonList?>? {
//        return pokemonResponseLiveData
//    }
}
