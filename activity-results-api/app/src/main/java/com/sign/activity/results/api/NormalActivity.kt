package com.sign.activity.results.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sign.activity.results.api.databinding.ActivityNormalBinding


class NormalActivity : AppCompatActivity() {

    companion object {
        const val NORMAL_RESULT = "normal result"
        const val NORMAL_REQUEST = "normal request"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvContent.text = intent.getStringExtra(NORMAL_REQUEST)
        binding.btnReturn.setOnClickListener {
            val intent = Intent().apply {
                putExtra(NORMAL_RESULT, NORMAL_RESULT)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}