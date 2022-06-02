package com.bf.projectgiphy.api

import com.bf.projectgiphy.domain.models.Data
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface GiphyServiceInterface {
    @ExperimentalCoroutinesApi
    suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data
}

class GiphyService @Inject constructor(
    private val retrofit: Retrofit
) : GiphyServiceInterface {

    private var giphyInterface: GiphyInterface =
        retrofit.create(GiphyInterface::class.java)

    @ExperimentalCoroutinesApi
    override suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data =
        suspendCancellableCoroutine { cancellableContinuation ->
            val call = giphyInterface.getGifs(query, limit, offset, rating, language)

            call.enqueue(object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    response.body()?.let {
                        cancellableContinuation.resume(it)
                    } ?: run {
                        cancellableContinuation.resumeWithException(
                            Throwable(response.message())
                        )
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    cancellableContinuation.resumeWithException(t)
                }

            })

        }
}