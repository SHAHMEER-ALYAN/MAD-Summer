package pk.edu.iqra.android.app1.database.doa

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import pk.edu.iqra.android.app1.database.entites.Product

@Dao
interface ProductDAO {
    @Insert
    suspend fun insert(product: Product):Long

    @Update
    suspend fun update(product: Product)

    @Query("Select * from PRODUCT")
    suspend fun select():List<Product>

    @Query("Select * from PRODUCT WHERE ID=:id")
    suspend fun selectByID(id:Int):Product

    @Delete
    suspend fun delete(product: Product)

    @Query("Delete from PRODUCT")
    suspend fun deleteAll()
}