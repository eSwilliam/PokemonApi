package com.example.pokemonapi.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapi.domain.model.PokemonList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface PokeRepository {
    private val POKEMON_SEARCH_SERVICE_BASE_URL: String
        get() = "https://pokeapi.co/api/v2"

    var pokemonSearchService: PokeService?
    var pokemonResponseLiveData: MutableLiveData<PokemonList>?

    fun PokeRepository() {
        pokemonResponseLiveData = MutableLiveData<PokemonList>()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        pokemonSearchService = Retrofit.Builder()
            .baseUrl(POKEMON_SEARCH_SERVICE_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeService::class.java)
    }

    fun searchPokemon() {
        pokemonSearchService?.getPokemonList()
            ?.enqueue(object : Callback<PokemonList?> {
                override fun onResponse(
                    call: Call<PokemonList?>,
                    response: Response<PokemonList?>
                ) {
                    if (response.body() != null) {
                        pokemonsResponseLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(
                    call: Call<PokemonList?>,
                    t: Throwable
                ) {
                    pokemonsResponseLiveData.postValue(null)
                }
            })
    }

    fun getPokemonResponseLiveData(): LiveData<PokemonList?>? {
        return pokemonResponseLiveData
    }
}