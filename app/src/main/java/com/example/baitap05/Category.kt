package com.example.baitap05

import java.io.Serializable

data class Category(
    var id : Int,
    var name : String,
    var image : String,
    var description : String
) : Serializable