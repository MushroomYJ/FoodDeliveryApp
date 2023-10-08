package com.example.fooddeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var logInButton: Button
    lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.email_editText)
        passwordEditText = findViewById(R.id.password_editText)
        logInButton = findViewById(R.id.logIn_button)
        signUpButton = findViewById(R.id.signUp_button)

        logInButton.setOnClickListener {
            logIn()
        }
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun logIn() {

        auth.signInWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    val user = auth.currentUser
                    goToHomeActivity()
                } else {
                    Toast.makeText(baseContext, "Authentication failed: "+task.exception,
                        Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun goToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}