package com.example.instatask.view.task.presenter

import android.app.Activity
import com.example.instatask.view.task.TaskExecutor
import java.util.concurrent.Executors

class TaskPresenter(private val activity: Activity, private val viewListener: TaskContract.View) :
    TaskContract.Presenter {
    override fun requestData() {
        val executor = Executors.newScheduledThreadPool(2)
        val taskExecutor = TaskExecutor(activity,viewListener)
        executor.execute(taskExecutor)
    }
}