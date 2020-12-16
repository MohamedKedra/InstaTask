package com.example.instatask.view.task.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.instatask.R
import com.example.instatask.data.Word
import com.example.instatask.utils.AppState
import com.example.instatask.view.task.presenter.TaskContract
import com.example.instatask.view.task.presenter.TaskPresenter
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() , TaskContract.View{

    private lateinit var presenter : TaskPresenter
    lateinit var adapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        presenter = TaskPresenter(this,this)
        presenter.requestData()
        adapter = WordAdapter()
        rv_words.adapter = adapter
    }

    override fun receiveData(words:ArrayList<Word>, appState: AppState) {
        when(appState){
            AppState.SUCCESS -> {
                pb_progress.visibility = View.GONE
                tv_data.visibility = View.GONE
                rv_words.visibility = View.VISIBLE
                adapter.setWords(words)
                adapter.notifyDataSetChanged()
            }
            AppState.ERROR -> {
                pb_progress.visibility = View.GONE
                tv_data.visibility = View.VISIBLE
                tv_data.text = resources.getString(R.string.error)
                rv_words.visibility = View.GONE
            }
            AppState.NO_INTERNET -> {
                pb_progress.visibility = View.GONE
                tv_data.visibility = View.VISIBLE
                tv_data.text = resources.getString(R.string.no_internet)
                rv_words.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.mi_refresh){
            presenter.requestData()
            pb_progress.visibility = View.VISIBLE
            tv_data.visibility = View.GONE
            rv_words.visibility = View.GONE
        }
        return super.onOptionsItemSelected(item)
    }
}