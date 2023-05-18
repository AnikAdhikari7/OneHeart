package com.example.oneheart.models

data class Post (
    val text: String = "",
    val createdBy: User = User(),
    val createdAt: Long = 0L,
    val likedBy: ArrayList<String> = ArrayList())

//data class Post(
//    val profileImage: String,
//    val pName: String,
//    val pTime:String,
//    val pText: String,
//    val postImage: String
//)
