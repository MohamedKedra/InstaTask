package com.example.instatask.view.task.presenter

import com.example.instatask.data.Word
import com.example.instatask.utils.AppState

interface TaskContract {

    interface Presenter{
        fun requestData()
    }

    interface View{
        fun receiveData(words : ArrayList<Word>, appState: AppState)
    }
}