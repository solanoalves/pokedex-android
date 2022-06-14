package com.solano.pokedex_android.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.solano.pokedex_android.R
import com.solano.pokedex_android.domain.Pokemon

class PokemonAdapter (
    private val items: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            with(item) {
                tvNumber.text = "Nº $formattedNumber";
                tvName.text = name;
                tvType1.text = types[0].name;
                tvType2.text = "";
                if(types.size > 1) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = types[1].name
                } else {
                    tvType2.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    override fun getItemCount() = items.size
}