package com.example.baitap05

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("http://app.iotstar.vn:8081/appfoods/categories.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}