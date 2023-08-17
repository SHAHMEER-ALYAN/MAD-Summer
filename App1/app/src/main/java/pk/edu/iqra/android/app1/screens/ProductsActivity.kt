package pk.edu.iqra.android.app1.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Orientation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pk.edu.iqra.android.app1.adapters.ProductDataAdapter
import pk.edu.iqra.android.app1.database.AppDatabase
import pk.edu.iqra.android.app1.database.entites.Product
import pk.edu.iqra.android.app1.databinding.ActivityProductsBinding
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class ProductsActivity : AppCompatActivity(), CoroutineScope {
    private var job = Job()

    override val coroutineContext : CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter:ProductDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = ProductDataAdapter(ArrayList())
        binding.rvProducts.adapter = adapter
        fetchData()

        binding.btnAddProd.setOnClickListener {
            addProduct()
        }
    }

    private fun addProduct(){

        val product = Product(name="Product ${Random.nextInt(1, 5000)}",  category = "Laptops", price = Random.nextDouble(50000.00, 250000.00), quantity = Random.nextInt(5, 50))

        launch {
            val id = AppDatabase.getAppDatabaseContext(this@ProductsActivity).ProductDAO().insert(product)
            showMessage("Product inserted ID : $id")
            fetchData()
        }
    }

    /*fun getData():List<Product>{
        val products = ArrayList<Product>()

        products.add(Product(1,"Lenevo ThinkPad T450s","Laptop",1260.00, 10))
        products.add(Product(1,"Lenevo ThinkPad T14","Laptop",2260.00, 20))
        products.add(Product(1,"HP Laptop H450s","Laptop",3260.00, 10))
        products.add(Product(1,"Dell Laptop D450s","Laptop",4260.00, 10))
        products.add(Product(1,"Lenevo ThinkPad T50s","Laptop",260.00, 10))

        return products
    }*/

    private fun fetchData(){
        launch{
            val products = AppDatabase.getAppDatabaseContext(this@ProductsActivity).ProductDAO().select()
            renderList(products)
        }
    }

    private fun renderList(products:List<Product>){
        adapter.setUpdatedList(products)
        adapter.notifyDataSetChanged()
    }

    private fun showMessage(message:String) = Toast.makeText(this@ProductsActivity,message,Toast.LENGTH_SHORT).show()
}