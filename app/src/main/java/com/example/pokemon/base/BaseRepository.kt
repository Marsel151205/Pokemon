package com.example.pokemon.base

import com.example.pokemon.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> Response<T>) = flow {
        emit(Resource.Loading())

        try {
            result().let {
                if (it.isSuccessful && it.body() != null) emit(Resource.Success(it.body()!!))
                else emit(Resource.Error(it.message().toString(), null))
            }
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "error", data = null))
        }
    }
}