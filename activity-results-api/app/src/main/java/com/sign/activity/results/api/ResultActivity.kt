package com.sign.activity.results.api

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sign.activity.results.api.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    companion object {
        const val RESULT_API_RESULT = "result api result"
        const val RESULT_API_REQUEST = "request api request"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvContent.text = intent.getStringExtra(RESULT_API_REQUEST)
        binding.btnReturn.setOnClickListener {
            val intent = Intent().apply {
                putExtra(RESULT_API_RESULT, RESULT_API_RESULT)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}