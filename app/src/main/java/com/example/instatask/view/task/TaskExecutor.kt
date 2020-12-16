package com.example.instatask.view.task

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.example.instatask.data.Word
import com.example.instatask.utils.AppState
import com.example.instatask.view.task.presenter.TaskContract
import org.jsoup.Jsoup
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class TaskExecutor(private val activity: Activity, private val viewListener: TaskContract.View) : Thread() {

    private var httpURLConnection: HttpURLConnection? = null
    lateinit var url: URL

    override fun run() {
        super.run()

            try {
                url = URL("https://instabug.com")
                httpURLConnection = url.openConnection() as HttpURLConnection?
                httpURLConnection?.defaultUseCaches = false
                httpURLConnection?.addRequestProperty("Accept", "application/json")
                httpURLConnection?.addRequestProperty("Cache-Control", "max-age=0")
                val text = httpURLConnection?.inputStream?.bufferedReader()?.readText()
                val data = Jsoup.parse(text).text()
                Log.d("UrlTest", data.toString())
                activity.runOnUiThread { viewListener.receiveData(
                    getAllItems(data.toString()),
                    AppState.SUCCESS
                ) }
            } catch (exception: Exception) {
                exception.printStackTrace()
                viewListener.receiveData(ArrayList(), AppState.ERROR)
            } finally {
                httpURLConnection?.disconnect()
            }
    }

    private fun getAllItems(data: String) : ArrayList<Word>{
        val array = data.split(" ")
        val map = HashMap<String, Int>()
        for (i in array.indices){
            val key = array[i].toLowerCase()
            if(map.containsKey(key)){
                val counter : Int? = map[key]!! + 1
                map[key] = counter!!
            }else{
                val counter = 1
                map[key] = counter
            }
        }
        val list = ArrayList<Word>()
        for ((title, count) in map) {
            list.add(Word(title, count))
        }
        return list
    }

    private fun hasInternet() : Boolean{

        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}