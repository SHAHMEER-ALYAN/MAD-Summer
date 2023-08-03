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

class HomeActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var edWelcome:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edWelcome = findViewById(R.id.txWelcome)

        //val email = intent.extras?.getString("email")
        //edWelcome.text = "Welcome ${email?.split("@")?.get(0)}"

        val userProfile = intent.extras?.getSerializable("profile") as UserProfile

        edWelcome.text = "Welcome ${userProfile.name}"

        /*findViewById<Button>(R.id.btnLogout).setOnClickListener {
            logout()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener(View.OnClickListener {

        })*/

        //findViewById<Button>(R.id.btnLogout).setOnClickListener(this)

        findViewById<Button>(R.id.btnLogout).setOnClickListener(ClickHandler(this))
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

    override fun onClick(p0: View?) {
        logout()
    }
    public fun logout(){
        AlertDialog
            .Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure? you want to logout?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, i ->
                Intent(this@HomeActivity, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }
            .setNegativeButton("No") { dialog, i ->
                dialog.dismiss()
            }
            .show()

    }

    /*fun onLogoutClicked(view: View) {
        logout()
    }*/

    class ClickHandler(var homeActivity: HomeActivity):View.OnClickListener {
        override fun onClick(p0: View?) {
            homeActivity.logout()
        }
    }
}