package com.example.oneheart.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.oneheart.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun alreadyHaveAccOnClick(view: View) {
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        finish()
    }
}