package pk.edu.iqra.android.app1.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import pk.edu.iqra.android.app1.R
import pk.edu.iqra.android.app1.databinding.ActivityMainBinding
import pk.edu.iqra.android.app1.databinding.ActivityMultiModeBinding

class MultiModeActivity : AppCompatActivity(), View.OnClickListener {
    private var counter = 0
    private lateinit var binding: ActivityMultiModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiModeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        if(savedInstanceState?.containsKey("counter") == true){
            counter = savedInstanceState.getInt("counter") ?:0
        }

        updateCounter()

        binding.btnDecrement.setOnClickListener(this)
        binding.btnIncrement.setOnClickListener(this)
    }

    private fun decrement(){
        if(counter>0)
            counter--
        else return

        updateCounter()
    }

    private fun increment(){
        if(counter<10)
            counter++
        else return

        updateCounter()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnDecrement -> decrement()
            R.id.btnIncrement -> increment()
        }
    }

    private fun updateCounter(){
        binding.txCounter.text = "$counter"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counter",counter)
    }
}