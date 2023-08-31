package cl.samf.store.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.samf.store.data.local.DetailsStoreEntity
import cl.samf.store.data.local.RatingDetail
import cl.samf.store.data.local.RatingEntity
import cl.samf.store.data.local.StoreDao
import cl.samf.store.data.local.StoreEntity
import cl.samf.store.data.remote.DetailStore
import cl.samf.store.data.remote.StoreApi

class Repository(private val storeApi: StoreApi, private val storeDao: StoreDao) {

    fun getProducts(): LiveData<List<StoreEntity>> = storeDao.getProducts()
    fun getDetailsIdStore(id: Int): LiveData<DetailsStoreEntity> = storeDao.getDetailsIdStore(id)

    suspend fun loadProducts() {
        val response = storeApi.getData()
        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let { products ->
                val productosEntity = products.map { it.transformed() }
                storeDao.insertProducts(productosEntity)
            }
        }
    }

    suspend fun detailsStore(id: Int) {
        try {
            val response = storeApi.getDataDetails(id)
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let { storeDetail ->
                    val detailsStoreEntity = storeDetail.convertDetail()
                    storeDao.insertDetailsStore(detailsStoreEntity)
                    Log.d("ok_details", "${response.message()}")
                }
            } else {
                Log.d("Error_details", "${response.errorBody()} ${response.code()}")
            }
        } catch (e: Exception) {
            Log.d("Error_details", "${e.message}")
        }
    }
}


fun DetailStore.convertDetail(): DetailsStoreEntity =
    DetailsStoreEntity(
        this.id,
        this.title,
        this.price,
        this.description,
        this.category,
        this.image,
        RatingDetail(this.rating.rate, this.rating.count)
    )


