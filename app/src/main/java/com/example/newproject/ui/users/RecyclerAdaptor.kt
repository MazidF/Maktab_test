package com.example.newproject.ui.users

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newproject.R
import com.example.newproject.databinding.CustomViewBinding

class RecyclerAdaptor(val items: List<String>) :
    RecyclerView.Adapter<RecyclerAdaptor.MyViewHolder>() {

    lateinit var binding: CustomViewBinding

    inner class MyViewHolder(private var binding: CustomViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pos:Int) {
            binding.customTv.text = items[pos]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdaptor.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = CustomViewBinding.inflate(inflater, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdaptor.MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
       return items.size
    }
}