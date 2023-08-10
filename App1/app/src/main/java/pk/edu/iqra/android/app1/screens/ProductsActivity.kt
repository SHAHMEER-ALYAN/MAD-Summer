package pk.edu.iqra.android.app1.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pk.edu.iqra.android.app1.ProductDataAdapter
import pk.edu.iqra.android.app1.database.entites.Product
import pk.edu.iqra.android.app1.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvProducts.adapter = ProductDataAdapter(getData())
    }

    fun getData():List<Product>{
        val products = ArrayList<Product>()

        products.add(Product(1,"Lenevo ThinkPad T450s","Laptop",1260.00, 10))
        products.add(Product(1,"Lenevo ThinkPad T14","Laptop",2260.00, 20))
        products.add(Product(1,"HP Laptop H450s","Laptop",3260.00, 10))
        products.add(Product(1,"Dell Laptop D450s","Laptop",4260.00, 10))
        products.add(Product(1,"Lenevo ThinkPad T50s","Laptop",260.00, 10))

        return products
    }
}