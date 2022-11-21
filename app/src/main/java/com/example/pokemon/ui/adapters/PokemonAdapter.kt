package com.example.pokemon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokemon.base.BaseDiffUtilItemCallback
import com.example.pokemon.databinding.ItemPokemonBinding
import com.example.pokemon.models.PokemonModel

class PokemonAdapter : ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonViewHolder(
        ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding) : ViewHolder(binding.root) {
        fun onBind(model: PokemonModel) {
            binding.tvName.text = model.name
        }
    }
}