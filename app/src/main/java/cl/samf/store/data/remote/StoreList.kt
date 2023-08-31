package cl.samf.store.data.remote

import com.google.gson.annotations.SerializedName


data class StoreList(
    val id: Int,
    @SerializedName("title") val titulo: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)
data class Rating(
    val rate: Double,
    val count: Int
)
