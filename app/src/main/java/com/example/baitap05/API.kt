package com.example.baitap05

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("categories.php")
    fun getCategories(): Call<List<Category>>
}