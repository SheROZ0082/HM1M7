package com.example.hm1m7.domain.model

class Note (

    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String
        ){

    companion object{
        const val DEFAULT_ID=0
    }
}