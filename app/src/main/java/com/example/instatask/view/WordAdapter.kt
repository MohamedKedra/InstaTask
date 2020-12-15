package com.example.instatask.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instatask.R

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordHolder>() {

    inner class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word,parent,false)
        return  WordHolder(view)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {

    }

    override fun getItemCount(): Int = 12
}