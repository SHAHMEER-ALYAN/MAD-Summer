package pk.edu.iqra.android.app1.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import pk.edu.iqra.android.app1.R
import pk.edu.iqra.android.app1.models.UserProfile
import pk.edu.iqra.android.app1.utils.PrefManager

class HomeActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var edWelcome:TextView
    lateinit var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        prefManager = PrefManager(this)
        edWelcome = findViewById(R.id.txWelcome)

        //val email = intent.extras?.getString("email")
        //edWelcome.text = "Welcome ${email?.split("@")?.get(0)}"

//        val userProfile = intent.extras?.getSerializable("profile") as UserProfile
        val userProfile = intent.extras?.getParcelable<UserProfile>("profile")

        edWelcome.text = "Welcome ${userProfile?.name}"

        /*findViewById<Button>(R.id.btnLogout).setOnClickListener {
            logout()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener(View.OnClickListener {

        })*/

        //findViewById<Button>(R.id.btnLogout).setOnClickListener(this)

        findViewById<Button>(R.id.btnLogout).setOnClickListener(this)
        findViewById<Button>(R.id.btnProducts).setOnClickListener(this)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnLogout->logout()
            R.id.btnProducts-> goToProductScreen()
        }
    }
    public fun logout(){
        AlertDialog
            .Builder(this)
            .setTitle(resources.getString(R.string.tx_logout))
            .setMessage(resources.getString(R.string.tx_mesg))
            .setCancelable(false)
            .setPositiveButton(resources.getString(R.string.tx_yes)) { dialog, i ->
                prefManager.clearData()

                Intent(this@HomeActivity, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }
            .setNegativeButton(resources.getString(R.string.tx_no)) { dialog, i ->
                dialog.dismiss()
            }
            .show()

    }

    /*fun onLogoutClicked(view: View) {
        logout()
    }*/
    private fun goToProductScreen(){
        Intent(this@HomeActivity,ProductsActivity::class.java).apply {
            startActivity(this)
        }
    }

    class ClickHandler(var homeActivity: HomeActivity):View.OnClickListener {
        override fun onClick(p0: View?) {
            homeActivity.logout()
        }
    }
}