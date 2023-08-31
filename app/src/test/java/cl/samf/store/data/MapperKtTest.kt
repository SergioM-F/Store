package cl.samf.store.data

import cl.samf.store.data.remote.Rating
import cl.samf.store.data.remote.StoreList
import org.hamcrest.Matchers.closeTo
import org.junit.Assert.*
import org.junit.Test


class MapperKtTest {

    @Test
    fun transformed(){
        //given
        val store = StoreList(1,"Hola", 2.0,"Bye","Mejor Producto","example.com", Rating(3.0,1))

        //when
        val result = store.transformed()

        //then
        assertEquals(result.id, store.id)
        assertEquals(result.title, store.title)
        assertThat(store.price, closeTo(result.price, 0.001))
        assertThat(store.rating.rate, closeTo(result.rating.rate, 0.001))

    }


}