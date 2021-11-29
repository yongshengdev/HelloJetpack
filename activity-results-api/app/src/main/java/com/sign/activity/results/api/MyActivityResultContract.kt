package com.sign.activity.results.api

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * @author: yongshengdev@163.com
 * @created on 2021/11/24
 * @description:
 */
class MyActivityResultContract : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, ResultActivity::class.java).apply {
            putExtra(ResultActivity.RESULT_API_REQUEST, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        val data = intent?.getStringExtra(ResultActivity.RESULT_API_RESULT)
        return if (resultCode == Activity.RESULT_OK) {
            data
        } else {
            null
        }
    }
}
