package com.sign.activity.results.api

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sign.activity.results.api.databinding.ActivityResultSimpleBinding

class ResultSimpleActivity : AppCompatActivity() {

    companion object {
        const val RESULT_SIMPLE_REQUEST = "simple result api request"
        const val RESULT_SIMPLE_RESULT = "simple result api result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultSimpleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvContent.text = intent.getStringExtra(RESULT_SIMPLE_REQUEST)
        binding.btnReturn.setOnClickListener {
            val intent = Intent().apply {
                putExtra(RESULT_SIMPLE_RESULT, RESULT_SIMPLE_RESULT)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}