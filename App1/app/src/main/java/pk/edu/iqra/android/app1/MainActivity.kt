package pk.edu.iqra.android.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import pk.edu.iqra.android.app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*lateinit var edEmailAddress:EditText
    lateinit var edPassword:EditText
    lateinit var btnSignIn:Button*/

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        /*edEmailAddress = findViewById(R.id.edEmailAddress)
        edPassword = findViewById(R.id.edPassword)
        btnSignIn = findViewById(R.id.btnSignIn)*/

        binding.btnSignIn.setOnClickListener {

            val email = binding.edEmailAddress.text.trim().toString()
            val password = binding.edPassword.text.trim().toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                if(email.contentEquals("abc@iqra.edu.pk") && password.contentEquals("123456")){
                    /*val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()*/

                    Intent(this@MainActivity, HomeActivity::class.java).apply {
                        putExtra("email",email)
                        startActivity(this)
                        finish()
                    }
                }
                else{
                    Toast.makeText(this@MainActivity,"invalid credentials",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this@MainActivity,"please enter your credentials",Toast.LENGTH_SHORT).show()
            }

        }
    }
}