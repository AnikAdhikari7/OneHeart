package com.example.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.oneheart.MainActivity
import com.example.oneheart.R
import com.example.oneheart.auth.SignUpActivity
import com.example.oneheart.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var progressDialog: ProgressDialog? = null
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()

        binding.loginBtn.setOnClickListener {
//            if (email.isEmpty()) {
//                binding.loginEmail.error = "This field can't be empty!"
//            } else if (password.isEmpty()) {
//                binding.loginPassword.error = "This field can't be empty!"
//            } else {
//                signInUser(binding.loginEmail.text.toString(), binding.loginPassword.text.toString())
//            }

            signInUser(binding.loginEmail.text.toString(), binding.loginPassword.text.toString())

        }

        binding.btnLoginAsNGO.setOnClickListener {
            Toast.makeText(this, "Yet to implement", Toast.LENGTH_SHORT).show()
        }
    }

    fun createAnAccOnClick(view: View) {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        finish()
    }


    private fun signInUser(email: String, password: String) {

        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Loading")
        progressDialog!!.setMessage("Please Wait...")

        progressDialog!!.show()
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    progressDialog!!.dismiss()
                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                    finish()
                } else {
                    progressDialog!!.dismiss()
                    Log.d("signUp", task.exception.toString())
                    Toast.makeText(
                        this@LoginActivity,
                        task.exception.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            } .addOnCanceledListener {
            Toast.makeText(this, "Failed! Please try again.", Toast.LENGTH_SHORT).show()
        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        if (firebaseAuth.currentUser != null) {
//            intent = Intent(this@LoginActivity, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
}