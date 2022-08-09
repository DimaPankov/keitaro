package com.example2.testproject

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example2.testproject.model.dataImpl.Repository
import com.example2.testproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.webViewClient = WebViewClient()
        settingsAPI("UKR","RU")

    }






    private fun settingsAPI(vararg countries:String){
        var isApiCountrie = false
        var cansel = false
        CoroutineScope(Dispatchers.IO).launch {

            val result = Repository.getData()

            for(country in countries){

            val text = "${result?.log?.last()}"
            val pattern: Pattern = Pattern.compile("\\\"Country\\\":\\\"$country\\\"")
            val matcher: Matcher = pattern.matcher(text)
                if(!cansel) {
                    isApiCountrie = matcher.find()
                    if(isApiCountrie){
                        cansel = true
                    }
                }
            }
            if(isApiCountrie){
                runOnUiThread {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.webview.loadUrl("https://www.google.com")
                }
            }else{
                runOnUiThread {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.textView.visibility = View.VISIBLE

                }
            }

    }}

}