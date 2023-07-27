package pk.edu.iqra.android.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var edWelcome:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edWelcome = findViewById(R.id.txWelcome)

        val email = intent.extras?.getString("email")
        edWelcome.text = "Welcome ${email?.split("@")?.get(0)}"

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            Intent(this@HomeActivity,MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }
}