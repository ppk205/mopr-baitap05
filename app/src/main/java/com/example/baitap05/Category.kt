package com.example.baitap05

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("images")
    var images: String,

    @SerializedName("description")
    var description: String
) : Serializable
