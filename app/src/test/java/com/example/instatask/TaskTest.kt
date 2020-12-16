package com.example.instatask

import android.app.Activity
import com.example.instatask.data.Word
import com.example.instatask.utils.AppState
import com.example.instatask.view.task.presenter.TaskContract
import com.example.instatask.view.task.presenter.TaskPresenter
import com.example.instatask.view.task.ui.MainActivity
import org.junit.Test

class TaskTest : TaskContract.View {

    private val presenter = TaskPresenter(Activity() as MainActivity, this)
    private lateinit var list : ArrayList<Word>

    @Test
    fun sendData(){
        presenter.requestData()
//        assertEquals()
    }
//
//    @Test
//    fun receive(words: ArrayList<Word>){
//
//    }

    override fun receiveData(words: ArrayList<Word>, appState: AppState) {
        list = words

    }
}