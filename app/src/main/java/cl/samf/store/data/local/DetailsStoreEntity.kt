package cl.samf.store.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_details_store")
data class DetailsStoreEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    @Embedded val rating: RatingDetail
)

data class RatingDetail (
    val rate: Double,
    val count: Int
)
