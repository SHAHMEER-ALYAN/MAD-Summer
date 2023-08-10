package pk.edu.iqra.android.app1.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import pk.edu.iqra.android.app1.R
import pk.edu.iqra.android.app1.utils.DataProvider
import pk.edu.iqra.android.app1.utils.JDataProvider
import pk.edu.iqra.android.app1.utils.KDataProvider

class SplashActivity : AppCompatActivity() {
    private val handler = Handler()
    private lateinit var runnable: Runnable
    private var isPKTheme = true
    //private var sampleObj : Sample? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*if(savedInstanceState?.containsKey("isPKTheme") == true)
            isPKTheme = savedInstanceState.getBoolean("isPKTheme")?:true*/
        /*if(intent?.extras?.containsKey("isPKTheme") == true)
            isPKTheme =intent?.extras?.getBoolean("isPKTheme")?:true*/
        isPKTheme = DataProvider.isPKTheme
        if(isPKTheme) setTheme(R.style.PKRegionTheme) else setTheme(R.style.FRRegionTheme)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isPKTheme",isPKTheme)
    }

    override fun onDestroy() {
        super.onDestroy()

        //handler.removeCallbacks(runnable)
    }

    fun onThemeChanged(view: View) {
        /*isPKTheme = !isPKTheme
        DataProvider.isPKTheme = isPKTheme
        Intent(this@SplashActivity,SplashActivity::class.java).apply {
            //putExtra("isPKTheme", isPKTheme)
            startActivity(this)
            finish()
        }*/
    }

    /* class Sample(val a:String, val b:String){
         fun method1() = "hello world"
     }*/
}