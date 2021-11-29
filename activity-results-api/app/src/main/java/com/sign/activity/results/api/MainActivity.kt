package com.sign.activity.results.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import com.sign.activity.results.api.databinding.ActivityMainBinding

const val REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        // startActivityForResult
        mBinding.btnStartActivityForResult.setOnClickListener {
            val intent = Intent(this@MainActivity, NormalActivity::class.java)
                .apply {
                    putExtra(NormalActivity.NORMAL_REQUEST, NormalActivity.NORMAL_REQUEST)
                }
            startActivityForResult(intent, REQUEST_CODE)
        }
        // Activity Result API
        val resultLauncher = registerForActivityResult(MyActivityResultContract()) { result -> mBinding.tvContent.text = result ?: "result api empty" }
        mBinding.btnActivityResultsApi.setOnClickListener {
            resultLauncher.launch("result api input")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            mBinding.tvContent.text = data?.getStringExtra(NormalActivity.NORMAL_RESULT) ?: "normal empty"
        }
    }
}