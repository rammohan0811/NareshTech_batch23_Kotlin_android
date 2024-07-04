package com.nareshit.chuknorrisjokes

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import org.json.JSONObject
import java.io.InputStream
import java.net.URL
import java.util.Scanner
import javax.net.ssl.HttpsURLConnection

class FetchJoke(val context:Context, val tv:TextView, val pg:ProgressBar):AsyncTask<String,Void,String>() {

    override fun doInBackground(vararg params: String?): String {
        val url = URL(params[0])
        val urlConnection:HttpsURLConnection = url.openConnection() as HttpsURLConnection
        // from the connection that is created, read the data
        val ips:InputStream = urlConnection.inputStream
        Log.v("MAIN",ips.toString())
        val s:Scanner = Scanner(ips)
        val sb:StringBuilder = StringBuilder()
        while(s.hasNextLine()){
            sb.append(s.nextLine())
        }
        return sb.toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        val jo:JSONObject = JSONObject(result)
        val value:String = jo.getString("value")
        tv.text = value
        pg.visibility = View.INVISIBLE
    }
}