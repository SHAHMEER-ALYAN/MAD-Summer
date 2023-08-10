package pk.edu.iqra.android.app1.database.entites

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Collate
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PRODUCT")
data class Product(
       @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID") val id:Int=0,
       @ColumnInfo(name = "NAME")  val name:String,
       @ColumnInfo(name = "CATEGORY") val category:String,
       @ColumnInfo(name = "PRICE") val price: Double,
       @ColumnInfo(name = "QUANTITY") val quantity:Int
)
