package com.example.instatask.view.task.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instatask.R
import com.example.instatask.data.Word
import kotlinx.android.synthetic.main.item_word.view.*

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordHolder>() {

    var allWords: ArrayList<Word> = ArrayList()

    inner class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setWords(allWords:ArrayList<Word>){
        this.allWords = allWords
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word,parent,false)
        return  WordHolder(view)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val word = allWords[position]
        word.let {
            holder.itemView.tv_title.text = it.title
            holder.itemView.tv_count.text = it.count.toString()
        }
    }

    override fun getItemCount(): Int = allWords.size
}