package cl.samf.store.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {

    @GET("products")
    suspend fun getData(): Response<List<StoreList>>

    @GET("products/{id}")
    suspend fun getDataDetails(@Path("id") id: Int): Response<DetailStore>
}