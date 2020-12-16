package com.sign.roomwordsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by CaoYongSheng
 * on 12/14/20
 *
 */
class WordListAdapter : ListAdapter<Word, WordListAdapter.WordListViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        return WordListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    class WordListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): WordListViewHolder {
                return WordListViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)
                )
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Word>() {

        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }
    }
}