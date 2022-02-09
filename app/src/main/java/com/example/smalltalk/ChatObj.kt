package com.example.smalltalk

import java.util.*

data class ChatObj(
    val message: String,
    val username: String,
    val isMe: Boolean,
    val time: Date
)
