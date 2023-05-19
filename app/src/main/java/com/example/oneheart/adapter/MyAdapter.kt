package com.example.oneheart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oneheart.R
import com.example.oneheart.models.ListData
import com.example.oneheart.screens.HomeNavFragment
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context: HomeNavFragment, private val listData: List<ListData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profileImage: CircleImageView
        val title: TextView
        val postText: TextView
        var postImage: ImageView

        init {
            profileImage = itemView.findViewById(R.id.ivProfile)
            title = itemView.findViewById(R.id.tvTitle)
            postText = itemView.findViewById(R.id.tvPostText)
            postImage = itemView.findViewById(R.id.ivPostImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.home_each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listData[position]

        holder.profileImage = currentItem.profileImage as CircleImageView
        holder.title.text = currentItem.title
        holder.postText.text = currentItem.postText
        holder.postImage = currentItem.postImage as ImageView
    }
}
