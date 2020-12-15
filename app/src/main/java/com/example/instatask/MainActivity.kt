package com.example.instatask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instatask.view.WordAdapter
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        rv_words.adapter = WordAdapter()
    }
}