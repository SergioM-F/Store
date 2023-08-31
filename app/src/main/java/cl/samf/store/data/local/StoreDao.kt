package cl.samf.store.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.samf.store.data.remote.DetailStore

@Dao
interface StoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts (storeEntity: List<StoreEntity>)

    @Query("select * from products_table order by id ASC")
    fun getProducts(): LiveData<List<StoreEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailsStore (detailEntity: DetailsStoreEntity)

    @Query("select * from table_details_store where id = :id")
    fun getDetailsIdStore(id: Int): LiveData<DetailsStoreEntity>


}