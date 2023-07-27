package pk.edu.iqra.android.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edEmailAddress:EditText
    lateinit var edPassword:EditText
    lateinit var btnSignIn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edEmailAddress = findViewById(R.id.edEmailAddress)
        edPassword = findViewById(R.id.edPassword)
        btnSignIn = findViewById(R.id.btnSignIn)

        btnSignIn.setOnClickListener {

            val email = edEmailAddress.text.trim().toString()
            val password = edPassword.text.trim().toString()

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