package cl.samf.store.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.samf.store.data.Repository
import cl.samf.store.data.local.StoreDatabase
import cl.samf.store.data.remote.StoreRetrofit
import kotlinx.coroutines.launch

class StoreViewModel(application: Application): AndroidViewModel(application) {

    private val repository : Repository

    fun productsLiveData () = repository.getProducts()

    fun detailsIdLiveData (id: Int) = repository.getDetailsIdStore(id)

    init {
        val storeApi = StoreRetrofit.getRetrofitClient()
        val storeDatabase = StoreDatabase.getDatabase(application).getProductsDao()
        repository = Repository(storeApi, storeDatabase)

    }

    fun loadProduct() = viewModelScope.launch {
        repository.loadProducts()
    }
    fun loadDetailsStore(id: Int) = viewModelScope.launch {
        repository.detailsStore(id)
    }
}