package com.sign.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Created by CaoYongSheng
 * on 12/14/20
 *
 */
class WordsApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database: WordRoomDatabase by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository: WordRepository by lazy { WordRepository(database.wordDao()) }
}