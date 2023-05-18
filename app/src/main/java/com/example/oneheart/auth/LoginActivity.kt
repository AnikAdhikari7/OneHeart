package com.example.oneheart.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.oneheart.MainActivity
import com.example.oneheart.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun createAnAccOnClick(view: View) {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        finish()
    }

    fun loginBtnOnClick(view: View) {
        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
    }

}