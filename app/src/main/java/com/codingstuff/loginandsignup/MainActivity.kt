package com.codingstuff.loginandsignup


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


private lateinit var mAuth: FirebaseAuth
class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var btnLogout: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         mAuth = FirebaseAuth.getInstance()
        btnLogout = findViewById<View>(R.id.btnLogout) as Button?

        btnLogout?.setOnClickListener(View.OnClickListener {
            mAuth!!.signOut()
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this@MainActivity, "Logout Successful!", Toast.LENGTH_SHORT).show()
        })
    }
}