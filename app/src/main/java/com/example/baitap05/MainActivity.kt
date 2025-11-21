package com.example.baitap05

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rcCate: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var apiService: API

    private var categoryList: List<Category> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anhXa()

        categoryAdapter = CategoryAdapter(this, categoryList)
        rcCate.setHasFixedSize(true)
        rcCate.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rcCate.adapter = categoryAdapter

        getCategory()
    }

    private fun anhXa() {
        rcCate = findViewById(R.id.rc_category)
    }

    private fun getCategory() {
        apiService = RetroClient.getRetrofit().create(API::class.java)
        apiService.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                Log.d("logg", "onResponse - code: ${response.code()}")
                if (response.isSuccessful) {
                    val list = response.body()
                    Log.d("logg", "body: $list")

                    if (list.isNullOrEmpty()) {
                        Log.d("logg", "Danh sách category rỗng")
                        return
                    }

                    categoryList = list
                    categoryAdapter = CategoryAdapter(this@MainActivity, categoryList)
                    rcCate.adapter = categoryAdapter
                    categoryAdapter.notifyDataSetChanged()
                    Log.d("logg", "Gán adapter với size = ${categoryList.size}")
                } else {
                    val statusCode = response.code()
                    Log.d("logg", "Response error code: $statusCode")
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.d("logg", "onFailure: ${t.message}")
            }
        })
    }
}