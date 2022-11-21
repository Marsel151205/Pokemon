package com.example.pokemon.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.common.Resource
import com.example.pokemon.models.PokemonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response

abstract class BaseViewModel: ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectRequest(liveData: MutableLiveData<Resource<T>>) {
        viewModelScope.launch {
            collect {
                liveData.postValue(it)
            }
        }
    }
}