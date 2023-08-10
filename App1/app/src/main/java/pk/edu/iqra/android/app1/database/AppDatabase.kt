package pk.edu.iqra.android.app1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pk.edu.iqra.android.app1.database.doa.ProductDAO
import pk.edu.iqra.android.app1.database.entites.Product

@Database(entities = arrayOf(Product::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun ProductDAO():ProductDAO

    companion object {
        @Volatile
        private var DatabaseInstance:AppDatabase? = null

        fun getAppDatabaseContext(context: Context):AppDatabase{
            return DatabaseInstance?: synchronized(this){
                val tempInstance= Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    "my_app_db").build()
                DatabaseInstance = tempInstance
                tempInstance
            }
        }
    }
}