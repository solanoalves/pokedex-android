package com.solano.pokedex_android.api

import com.solano.pokedex_android.api.model.PokemonApiResult
import com.solano.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151) : PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
//        call.enqueue(object : Callback<PokemonsApiResult> {
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    body?.results?.let {
//
//                    }
//                }
//                Log.d("POKEMON_API", "Pokemons loaded.")
//            }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("Pokemon API", "Error loading pokemons list.")
//            }
//
//        })
    }

    fun getPokemon(number: Int) : PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }
}