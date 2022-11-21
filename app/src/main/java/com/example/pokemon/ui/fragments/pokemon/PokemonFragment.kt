package com.example.pokemon.ui.fragments.pokemon

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemon.R
import com.example.pokemon.base.BaseFragment
import com.example.pokemon.common.Resource
import com.example.pokemon.databinding.FragmentPokemonBinding
import com.example.pokemon.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : BaseFragment<PokemonViewModel, FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupRequest() {
        viewModel.fetchPokemon()
    }

    override fun setupSubscribe() {
        viewModel.pokemonState.observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Error -> {
                    Log.e("pokemon", it.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    pokemonAdapter.submitList(it.data?.pokemonModel)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvPokemon.adapter = pokemonAdapter
    }
}