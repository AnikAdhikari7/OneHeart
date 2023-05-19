package com.example.oneheart.daos

import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    val db = FirebaseFirestore.getInstance()
    val userCollection = db.collection("users")

    @SuppressLint("RestrictedApi")
    fun addUser(user: com.example.oneheart.models.User) {
        user.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.uId).set(it)
            }
        }
    }
}