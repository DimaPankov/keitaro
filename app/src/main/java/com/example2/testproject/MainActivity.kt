package com.example2.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example2.testProject.model.dataImpl.Repository
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
        binding.textView.visibility = View.INVISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val result = Repository.getData()


            val text = "${result?.log?.last()}"
            val pattern: Pattern = Pattern.compile("\\\"Country\\\":\\\"RU\\\"")
            val matcher: Matcher = pattern.matcher(text)

            if(!matcher.find()){
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
        }

    }
}