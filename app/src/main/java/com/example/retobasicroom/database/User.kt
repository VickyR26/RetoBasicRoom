package com.example.retobasicroom.database

import android.text.Editable

class User(
    user_id: Int,
    user_name: String
) {
    val user_id: Int = user_id
    val user_name: String = user_name

}

fun User.toEntity() = UserEntity(
    user_id,
    user_name
)