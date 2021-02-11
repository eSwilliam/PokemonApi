package com.example.pokemonapi.domain.model

import com.google.gson.annotations.SerializedName

data class Pokemon (
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)