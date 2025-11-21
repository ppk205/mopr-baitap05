package com.example.baitap05

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CategoryAdapter(
    private val context: Context,
    private val array: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_category, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = array[position]

        val imageUrl = item.images
        Log.d("logg", "Glide loading url = $imageUrl")

        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.images)

        holder.tenSp.text = item.name
    }

    override fun getItemCount(): Int = array.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val images: ImageView = itemView.findViewById(R.id.image_cate)
        val tenSp: TextView = itemView.findViewById(R.id.tvNameCategory)

        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    context,
                    "Bạn đã chọn category: ${tenSp.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    }