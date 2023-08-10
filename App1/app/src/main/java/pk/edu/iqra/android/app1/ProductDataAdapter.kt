package pk.edu.iqra.android.app1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pk.edu.iqra.android.app1.database.entites.Product

class ProductDataAdapter(var products:List<Product>):RecyclerView.Adapter<ProductDataAdapter.ProductDataVH>() {

    class ProductDataVH(view:View):RecyclerView.ViewHolder(view){
        val txProdName = view.findViewById<TextView>(R.id.txProdName)
        val txProdCategory = view.findViewById<TextView>(R.id.txProdCategory)
        val txProdPrice = view.findViewById<TextView>(R.id.txProdPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDataVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductDataVH(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductDataVH, position: Int) {
        val product = products[position]

        holder.txProdName.text = product.name
        holder.txProdCategory.text = product.category
        holder.txProdPrice.text = "$${product.price}"
    }
}