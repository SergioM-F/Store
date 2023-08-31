package cl.samf.store.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StoreEntity::class, DetailsStoreEntity::class], version = 1)
abstract class StoreDatabase : RoomDatabase() {

    abstract fun getProductsDao(): StoreDao

    companion object {
        @Volatile
        private var INSTANCE: StoreDatabase? = null

        fun getDatabase(context: Context): StoreDatabase {
            val temInstance = INSTANCE
            if(temInstance !=null){
                return temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StoreDatabase::class.java,
                    "store_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


