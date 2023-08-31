package cl.samf.store.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class StoreEntity(
    @PrimaryKey val id: Int,
    val titulo: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    @Embedded val rating: RatingEntity
)

data class RatingEntity (
    val rate: Double,
    val count: Int
)
