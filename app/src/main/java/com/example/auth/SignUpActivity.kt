package com.example.auth

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.oneheart.MainActivity
import com.example.oneheart.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.Exception

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Loading")
        progressDialog!!.setMessage("Please Wait...")

        binding.signUpBtn.setOnClickListener {

            progressDialog!!.show()
            if (binding.signUpFullName.text!!.isNotEmpty() && binding.signUpEmail.text!!.isNotEmpty() && binding.signUpPassword.text!!.isNotEmpty() && binding.signUpConfirmPassword.text!!.isNotEmpty()) {
                if (binding.signUpPassword.text.toString() == binding.signUpConfirmPassword.text.toString()) {

                    val service: ExecutorService = Executors.newSingleThreadExecutor()
                    var i = false
                    service.execute {
                        try {
                            createUser(binding.signUpEmail.text.toString().trim(),binding.signUpPassword.text.toString())
                            i = true
                        }catch (e: Exception){
                            Log.d("SignUp","Unable to create user")
                            Log.d("SignUp",e.message.toString())
                        }
                        runOnUiThread {
                            if (i){
                                progressDialog!!.dismiss()
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("Account Created")
                                builder.setMessage("A verification link has been sent on your email, Please verify to login. \n" +
                                        "If link is not found in the inbox check your spam folder.")
                                builder.setPositiveButton("Ok") { _, _ ->
                                    startActivity(
                                        Intent(this, LoginActivity::class.java).setFlags(
                                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                                        )
                                    )
                                }
                                builder.setOnCancelListener(DialogInterface.OnCancelListener {
                                    startActivity(Intent(this, MainActivity::class.java))
                                })
                                val alertDialog = builder.create()
                                alertDialog.show()
                            }else{
                                Toast.makeText(
                                    this, "Unable to connect, Please check your Internet Connection",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }

                } else {
                    Toast.makeText(
                        this,
                        "Password and Confirm password is not same",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(this, "All fields are  mandatory to fill!", Toast.LENGTH_LONG).show()
                progressDialog!!.dismiss()
            }
        }

    }

    fun alreadyHaveAccOnClick(view: View) {
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        finish()
    }

    private fun createUser(email: String, password: String) {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    firebaseAuth.currentUser?.sendEmailVerification()
                        ?.addOnCompleteListener(this) { task1 ->
                            if (task1.isSuccessful) {

                                Log.d("signUp", "verification link sent to user")
                                Toast.makeText(
                                    this@SignUpActivity,
                                    "A verification link has been sent on your email",
                                    Toast.LENGTH_LONG
                                ).show()

                            } else {
                                Log.d("signUp", "unable to send verification link to user")
                                Toast.makeText(
                                    this@SignUpActivity,
                                    "Unable to send verification link, Please try again later",
                                    Toast.LENGTH_LONG
                                ).show()

                            }
                        }
                } else {
                    Log.d("signUp", "unable to create user in firebase")
                    Log.d("signUp", task.exception.toString())
                    Toast.makeText(
                        this@SignUpActivity,
                        task.exception.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
}