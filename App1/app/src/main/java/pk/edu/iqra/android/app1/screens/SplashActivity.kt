package pk.edu.iqra.android.app1.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import pk.edu.iqra.android.app1.R

class SplashActivity : AppCompatActivity() {
    private val handler = Handler()
    private lateinit var runnable: Runnable

    //private var sampleObj : Sample? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        runnable = Runnable {
            Intent(this@SplashActivity, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        //System.out.println(sampleObj?.method1())

        /*try {
            System.out.println(sampleObj!!.method1())
        }
        catch (exp:java.lang.Exception){
            Log.e("Exception","Null Pointer Exception")
        }*/


        handler.postDelayed(runnable,2000)
    }

    override fun onDestroy() {
        super.onDestroy()

        handler.removeCallbacks(runnable)
    }

   /* class Sample(val a:String, val b:String){
        fun method1() = "hello world"
    }*/
}