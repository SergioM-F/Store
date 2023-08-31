package cl.samf.store.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreRetrofit {

    companion object{
        private val URL_BASE = "https://fakestoreapi.com/"

        fun getRetrofitClient(): StoreApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create((StoreApi::class.java))
        }
    }
}