package com.sign.roomwordsample

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


/**
 * Created by CaoYongSheng
 * on 12/13/20
 *
 */
class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}