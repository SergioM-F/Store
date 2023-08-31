package cl.samf.store.data

import cl.samf.store.data.local.RatingEntity
import cl.samf.store.data.local.StoreEntity
import cl.samf.store.data.remote.StoreList

fun StoreList.transformed(): StoreEntity =
    StoreEntity(
        this.id,
        this.titulo,
        this.price,
        this.description,
        this.category,
        this.image,
        RatingEntity(this.rating.rate, this.rating.count)
    )

