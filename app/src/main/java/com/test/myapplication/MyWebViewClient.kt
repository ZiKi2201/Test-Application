package com.test.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MyWebViewClient(context: Context) : WebViewClient() {
    private val PREFS_URL = "URL"

    var sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_URL, Context.MODE_PRIVATE)

    fun save(KEY_URL: String, text: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_URL, text)
        editor!!.commit()

    }
    fun getValueString(KEY_URL: String): String? {

        return sharedPref.getString(KEY_URL, null)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return true
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        view.loadUrl(url)
        save("URL",url.toString())
        return true
    }

}
