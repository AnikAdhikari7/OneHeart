package com.example.oneheart.models

data class User(val uId: String = "",
                val uName: String = "",
                val uProfileImageLink: String? = "",
                val uBio: String? = "",
                val uFollower: MutableList<User>,
//                val uPost: MutableList<Post>
)
