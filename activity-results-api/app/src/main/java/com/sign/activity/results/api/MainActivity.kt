package com.sign.activity.results.api

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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
        // Simple Activity Result API
        val simpleResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            mBinding.tvContent.text = result.data?.getStringExtra(ResultSimpleActivity.RESULT_SIMPLE_RESULT) ?: "simple result api empty"
        }
        mBinding.btnSimpleActivityResultsApi.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultSimpleActivity::class.java).apply {
                putExtra(ResultSimpleActivity.RESULT_SIMPLE_REQUEST, ResultSimpleActivity.RESULT_SIMPLE_REQUEST)
            }
            simpleResultLauncher.launch(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            mBinding.tvContent.text = data?.getStringExtra(NormalActivity.NORMAL_RESULT) ?: "normal empty"
        }
    }
}