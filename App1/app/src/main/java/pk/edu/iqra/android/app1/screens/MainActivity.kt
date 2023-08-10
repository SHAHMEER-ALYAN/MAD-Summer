package pk.edu.iqra.android.app1.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import pk.edu.iqra.android.app1.databinding.ActivityMainBinding
import pk.edu.iqra.android.app1.models.UserProfile
import pk.edu.iqra.android.app1.utils.PrefManager
import pk.edu.iqra.android.app1.utils.isEmail

class MainActivity : AppCompatActivity(),View.OnClickListener {
    /*lateinit var edEmailAddress:EditText
    lateinit var edPassword:EditText
    lateinit var btnSignIn:Button*/

    private lateinit var prefManager:PrefManager

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        prefManager = PrefManager(this)
        supportActionBar?.hide()

        /*edEmailAddress = findViewById(R.id.edEmailAddress)
        edPassword = findViewById(R.id.edPassword)
        btnSignIn = findViewById(R.id.btnSignIn)*/

        if(prefManager.containKey("is_user_logged_in")){
            /*val name = prefManager.getData("user_name")
            val email = prefManager.getData("user_email")
            val contact = prefManager.getData("user_contact")

            val userProfile = UserProfile(name,email,contact)*/

            val gson = Gson();
            val userProfile = gson.fromJson(prefManager.getData("user_data"),UserProfile::class.java)
            goToHomeScreen(userProfile)
        }

        binding.btnSignIn.setOnClickListener {

            val email = binding.edEmailAddress.text.trim().toString()
            val password = binding.edPassword.text.trim().toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                /*if(isEmail(email)){
                    email.toUpperCase()
                }*/

               /* if(email.isEmail()){

                }*/
                if(email.contentEquals("abc@iqra.edu.pk") && password.contentEquals("123456")){
                    /*val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()*/

                    val userProfile = UserProfile("Mr. Ahmed",email,"0333-9090990")

                    if(binding.cbRemember.isChecked){
                        //User data save to storage
                        /*prefManager.saveData("is_user_logged_in", "1")
                        prefManager.saveData("user_contact", userProfile.contact)
                        prefManager.saveData("user_email", userProfile.email)
                        prefManager.saveData("user_name", userProfile.name)*/

                        val gson = Gson()
                        val userData = gson.toJson(userProfile)
                        prefManager.saveData("is_user_logged_in", "1")
                        prefManager.saveData("user_data",userData)
                    }

                    goToHomeScreen(userProfile)
                    /*Intent(this@MainActivity, HomeActivity::class.java).apply {
                        //putExtra("email",email)
                        putExtra("profile",userProfile)
                        startActivity(this)
                        finish()
                    }*/
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

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    fun goToHomeScreen(userProfile:UserProfile){
        Intent(this@MainActivity, HomeActivity::class.java).apply {
            //putExtra("email",email)
            putExtra("profile",userProfile)
            startActivity(this)
            finish()
        }
    }
}