package cl.samf.store.data.remote

data class DetailStore (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDetail
)
data class RatingDetail(
    val rate: Double,
    val count: Int
)