package com.example.retobasicroom.database

import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey


//TODO add TABLE_USERS constant
@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uuid: Int,
    val name: String
)

fun UserEntity.toUser() = User(
    uuid,
    name
)

