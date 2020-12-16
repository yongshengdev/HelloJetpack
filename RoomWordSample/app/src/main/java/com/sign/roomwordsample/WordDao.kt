package com.sign.roomwordsample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by CaoYongSheng
 * on 12/13/20
 *
 */
@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}